package weibo4j.http;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import weibo4j.model.Configuration;
import weibo4j.model.Paging;
import weibo4j.model.PostParameter;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONException;

import com.sina.sae.fetchurl.BinaryData;
import com.sina.sae.fetchurl.SaeFetchurl;

/**
 * @author sinaWeibo
 *
 */
public class HttpClient implements java.io.Serializable {

	private static final long serialVersionUID = -176092625883595547L;
	private static final int OK = 200; // OK: Success!
	private static final int NOT_MODIFIED = 304; // Not Modified: There was no new data to return.
	private static final int BAD_REQUEST = 400; // Bad Request: The request was invalid. An accompanying error message will explain why. This is the status code
												// will be returned during rate limiting.
	private static final int NOT_AUTHORIZED = 401; // Not Authorized: Authentication credentials were missing or incorrect.
	private static final int FORBIDDEN = 403; // Forbidden: The request is understood, but it has been refused. An accompanying error message will explain why.
	private static final int NOT_FOUND = 404; // Not Found: The URI requested is invalid or the resource requested, such as a user, does not exists.
	private static final int NOT_ACCEPTABLE = 406; // Not Acceptable: Returned by the Search API when an invalid format is specified in the request.
	private static final int INTERNAL_SERVER_ERROR = 500;// Internal Server Error: Something is broken. Please post to the group so the Weibo team can
															// investigate.
	private static final int BAD_GATEWAY = 502;// Bad Gateway: Weibo is down or being upgraded.
	private static final int SERVICE_UNAVAILABLE = 503;// Service Unavailable: The Weibo servers are up, but overloaded with requests. Try again later. The
														// search and trend methods use this to indicate when you are being rate limited.

	private String proxyHost = Configuration.getProxyHost();
	private int proxyPort = Configuration.getProxyPort();
	private String proxyAuthUser = Configuration.getProxyUser();
	private String proxyAuthPassword = Configuration.getProxyPassword();
	private String token;

	public String getProxyHost() {
		return proxyHost;
	}

	/**
	 * Sets proxy host. System property -Dsinat4j.http.proxyHost or http.proxyHost overrides this attribute.
	 *
	 * @param proxyHost
	 */
	public void setProxyHost(String proxyHost) {
		this.proxyHost = Configuration.getProxyHost(proxyHost);
	}

	public int getProxyPort() {
		return proxyPort;
	}

	/**
	 * Sets proxy port. System property -Dsinat4j.http.proxyPort or -Dhttp.proxyPort overrides this attribute.
	 *
	 * @param proxyPort
	 */
	public void setProxyPort(int proxyPort) {
		this.proxyPort = Configuration.getProxyPort(proxyPort);
	}

	public String getProxyAuthUser() {
		return proxyAuthUser;
	}

	/**
	 * Sets proxy authentication user. System property -Dsinat4j.http.proxyUser overrides this attribute.
	 *
	 * @param proxyAuthUser
	 */
	public void setProxyAuthUser(String proxyAuthUser) {
		this.proxyAuthUser = Configuration.getProxyUser(proxyAuthUser);
	}

	public String getProxyAuthPassword() {
		return proxyAuthPassword;
	}

	/**
	 * Sets proxy authentication password. System property -Dsinat4j.http.proxyPassword overrides this attribute.
	 *
	 * @param proxyAuthPassword
	 */
	public void setProxyAuthPassword(String proxyAuthPassword) {
		this.proxyAuthPassword = Configuration.getProxyPassword(proxyAuthPassword);
	}

	public String setToken(String token) {
		this.token = token;
		return this.token;
	}

	private final static boolean DEBUG = Configuration.getDebug();
	static Logger log = Logger.getLogger(HttpClient.class.getName());

	public HttpClient() {
	}

	/**
	 * log调试
	 *
	 */
	private static void log(String message) {
		if (DEBUG) {
			log.debug(message);
		}
	}

	/**
	 * 处理http getmethod 请求
	 *
	 */

	public Response get(String url) throws WeiboException {
		return get(url, new PostParameter[0]);
	}

	public Response get(String url, PostParameter[] params) throws WeiboException {
		log("Request:");
		log("GET:" + url);
		if (null != params && params.length > 0) {
			String encodedParams = HttpClient.encodeParameters(params);
			if (-1 == url.indexOf("?")) {
				url += "?" + encodedParams;
			} else {
				url += "&" + encodedParams;
			}
		}
		return httpRequest(new SaeFetchurl(), url);

	}

	public Response get(String url, PostParameter[] params, Paging paging) throws WeiboException {
		if (null != paging) {
			List<PostParameter> pagingParams = new ArrayList<PostParameter>(4);
			if (-1 != paging.getMaxId()) {
				pagingParams.add(new PostParameter("max_id", String.valueOf(paging.getMaxId())));
			}
			if (-1 != paging.getSinceId()) {
				pagingParams.add(new PostParameter("since_id", String.valueOf(paging.getSinceId())));
			}
			if (-1 != paging.getPage()) {
				pagingParams.add(new PostParameter("page", String.valueOf(paging.getPage())));
			}
			if (-1 != paging.getCount()) {
				if (-1 != url.indexOf("search")) {
					// search api takes "rpp"
					pagingParams.add(new PostParameter("rpp", String.valueOf(paging.getCount())));
				} else {
					pagingParams.add(new PostParameter("count", String.valueOf(paging.getCount())));
				}
			}
			PostParameter[] newparams = null;
			PostParameter[] arrayPagingParams = pagingParams.toArray(new PostParameter[pagingParams.size()]);
			if (null != params) {
				newparams = new PostParameter[params.length + pagingParams.size()];
				System.arraycopy(params, 0, newparams, 0, params.length);
				System.arraycopy(arrayPagingParams, 0, newparams, params.length, pagingParams.size());
			} else {
				if (0 != arrayPagingParams.length) {
					String encodedParams = HttpClient.encodeParameters(arrayPagingParams);
					if (-1 != url.indexOf("?")) {
						url += "&" + encodedParams;
					} else {
						url += "?" + encodedParams;
					}
				}
			}
			return get(url, newparams);
		} else {
			return get(url, params);
		}
	}

	/**
	 * 处理http deletemethod请求
	 */

	public Response delete(String url, PostParameter[] params) throws WeiboException {
		if (0 != params.length) {
			String encodedParams = HttpClient.encodeParameters(params);
			if (-1 == url.indexOf("?")) {
				url += "?" + encodedParams;
			} else {
				url += "&" + encodedParams;
			}
		}
		return httpRequest(new SaeFetchurl(), url);

	}

	/**
	 * 处理http post请求
	 *
	 */

	public Response post(String url, PostParameter[] params) throws WeiboException {
		return post(url, params, true);

	}

	public Response post(String url, PostParameter[] params, Boolean WithTokenHeader) throws WeiboException {
		log("Request:");
		log("POST" + url);
		Map<String, String> maps = new HashMap<String, String>();
		for (PostParameter postParameter : params) {
			maps.put(postParameter.getName(), postParameter.getValue());
		}

		SaeFetchurl fetchUrl = new SaeFetchurl();
		fetchUrl.setMethod("post");
		fetchUrl.setPostData(maps);

		return httpRequest(fetchUrl, url, WithTokenHeader);
	}

	/**
	 * 支持multipart方式上传图片
	 *
	 */
	public Response multPartURL(String url, PostParameter[] params, ImageItem item) throws WeiboException {
		Map<String, String> maps = new HashMap<String, String>();
		for (PostParameter postParameter : params) {
			maps.put(postParameter.getName(), postParameter.getValue());
		}

		SaeFetchurl fetchUrl = new SaeFetchurl();
		fetchUrl.setMethod("post");
		fetchUrl.setPostData(maps);

		BinaryData data = new BinaryData();
		data.setInputParameterName(item.getName());
		data.setFileName(item.getName());
		data.setPostData(item.getContent());

		fetchUrl.setPostData(data);

		return httpRequest(fetchUrl, url);
	}

	public Response multPartURL(String fileParamName, String url, PostParameter[] params, File file, boolean authenticated) throws WeiboException {
		Map<String, String> maps = new HashMap<String, String>();
		for (PostParameter postParameter : params) {
			maps.put(postParameter.getName(), postParameter.getValue());
		}

		SaeFetchurl fetchUrl = new SaeFetchurl();
		fetchUrl.setMethod("post");
		fetchUrl.setPostData(maps);

		BinaryData data = new BinaryData();

		FileInputStream stream = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
		byte[] b = new byte[1000];
		try {
			stream = new FileInputStream(file);

			for (int n; (n = stream.read(b)) != -1;) {
				out.write(b, 0, n);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
				out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		data.setInputParameterName(file.getName());
		data.setFileName(file.getName());
		data.setPostData(out.toByteArray());

		fetchUrl.setPostData(data);

		return httpRequest(fetchUrl, url);

	}

	public Response httpRequest(SaeFetchurl fetchurl, String url) throws WeiboException {
		return httpRequest(fetchurl, url, true);
	}

	public Response httpRequest(SaeFetchurl fetchurl, String url, Boolean WithTokenHeader) throws WeiboException {
		int responseCode = -1;
		if (WithTokenHeader) {
			if (token == null) {
				throw new IllegalStateException("Oauth2 token is not set!");
			}
			fetchurl.setHeader("Authorization", "OAuth2 " + token);
		}

		String fetchResult = fetchurl.fetch(url);

		responseCode = fetchurl.getHttpCode();
		log("https StatusCode:" + String.valueOf(responseCode));

		Response response = new Response();
		response.setResponseAsString(fetchResult);
		log(response.toString() + "\n");

		if (responseCode != OK) {
			try {
				throw new WeiboException(getCause(responseCode), response.asJSONObject(), responseCode);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return response;
	}
	/*
	 * 对parameters进行encode处理
	 */
	public static String encodeParameters(PostParameter[] postParams) {
		StringBuffer buf = new StringBuffer();
		for (int j = 0; j < postParams.length; j++) {
			if (j != 0) {
				buf.append("&");
			}
			try {
				buf.append(URLEncoder.encode(postParams[j].getName(), "UTF-8")).append("=").append(URLEncoder.encode(postParams[j].getValue(), "UTF-8"));
			} catch (java.io.UnsupportedEncodingException neverHappen) {
			}
		}
		return buf.toString();
	}

	private static String getCause(int statusCode) {
		String cause = null;
		switch (statusCode) {
		case NOT_MODIFIED:
			break;
		case BAD_REQUEST:
			cause = "The request was invalid.  An accompanying error message will explain why. This is the status code will be returned during rate limiting.";
			break;
		case NOT_AUTHORIZED:
			cause = "Authentication credentials were missing or incorrect.";
			break;
		case FORBIDDEN:
			cause = "The request is understood, but it has been refused.  An accompanying error message will explain why.";
			break;
		case NOT_FOUND:
			cause = "The URI requested is invalid or the resource requested, such as a user, does not exists.";
			break;
		case NOT_ACCEPTABLE:
			cause = "Returned by the Search API when an invalid format is specified in the request.";
			break;
		case INTERNAL_SERVER_ERROR:
			cause = "Something is broken.  Please post to the group so the Weibo team can investigate.";
			break;
		case BAD_GATEWAY:
			cause = "Weibo is down or being upgraded.";
			break;
		case SERVICE_UNAVAILABLE:
			cause = "Service Unavailable: The Weibo servers are up, but overloaded with requests. Try again later. The search and trend methods use this to indicate when you are being rate limited.";
			break;
		default:
			cause = "";
		}
		return statusCode + ":" + cause;
	}
}
