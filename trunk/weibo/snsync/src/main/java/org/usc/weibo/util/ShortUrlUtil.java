package org.usc.weibo.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;

import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.URLEncodeUtils;

/**
 *
 * @author Shunli
 */
public class ShortUrlUtil {
	// private static Logger log = LogFactory.getLogger(Constants.LOG_DIR, Constants.ACT_DIR, "sendWeiboJob");

	public static String shortUrlShorten(String longUrl) throws JSONException {
		if (!StringUtils.isBlank(longUrl)) {
			String responseData = null;

			HttpClient httpClient = new HttpClient();
			GetMethod httpGet = new GetMethod("http://api.t.sina.com.cn/short_url/shorten.json?source=3310547613&url_long=" + URLEncodeUtils.encodeURL(longUrl));
			httpGet.getParams().setParameter("http.socket.timeout", new Integer(30000));
			try {
				int statusCode = httpClient.executeMethod(httpGet);
				if (statusCode != HttpStatus.SC_OK) {
					// log.info("httpGet not success/statusCode:" + statusCode);
				}
				httpGet.getParams().setContentCharset("GBK");
				responseData = httpGet.getResponseBodyAsString();
			} catch (Exception e) {
				// log.info("httpGet error/catch exception:", e);
			} finally {
				httpGet.releaseConnection();
				httpClient = null;
			}

			if (responseData != null) {
				String shortUrl = new JSONObject(StringUtils.removeEnd(StringUtils.removeStart(responseData, "["), "]")).get("url_short").toString();
				return shortUrl;
			}
		}

		return "";
	}

	public static void main(String[] args) throws JSONException {
		System.out.println(shortUrlShorten(String.format("http://api.t.sina.com.cn/%s/statuses/%s", "1771925961", "3445888074596137")));
	}
}
