package com.tencent.weibo.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sina.sae.fetchurl.SaeFetchurl;
import com.tencent.weibo.beans.QParameter;

public class QHttpClient {

	private static final int CONNECTION_TIMEOUT = 20000;
	private static Log log = LogFactory.getLog(QHttpClient.class);

	public QHttpClient() {

	}

	/**
	 * Using GET method.
	 *
	 * @param url
	 *            The remote URL.
	 * @param queryString
	 *            The query string containing parameters
	 * @return Response string.
	 * @throws Exception
	 */
	public String httpGet(String url, String queryString) throws Exception {
		if (queryString != null && !queryString.equals("")) {
			url += "?" + queryString;
		}

		log.info("httpGet [1]. url = " + url);

		SaeFetchurl fetchUrl = new SaeFetchurl();
		String responseData = fetchUrl.fetch(url);

		return responseData;
	}

	/**
	 * Using POST method.
	 *
	 * @param url
	 *            The remote URL.
	 * @param queryString
	 *            The query string containing parameters
	 * @return Response string.
	 * @throws Exception
	 */
	public String httpPost(String url, String queryString) throws Exception {
		queryString = queryString.substring(queryString.lastIndexOf("?") + 1);
		String[] firstSplit = queryString.split("&");
		Map<String, String> maps = new HashMap<String, String>();
		for (String param : firstSplit) {
			String[] secondeSplit = param.split("=");
			maps.put(secondeSplit[0], secondeSplit[1]);
		}

		SaeFetchurl fetchUrl = new SaeFetchurl();
		fetchUrl.setMethod("post");
		fetchUrl.setPostData(maps);

		String responseData = fetchUrl.fetch(url);

		return responseData;
	}

	/**
	 * Using POST method with multiParts.
	 *
	 * @param url
	 *            The remote URL.
	 * @param queryString
	 *            The query string containing parameters
	 * @param files
	 *            The list of image files
	 * @return Response string.
	 * @throws Exception
	 */
	public String httpPostWithFile(String url, String queryString, List<QParameter> files) throws Exception {

		String responseData = null;
		url += '?' + queryString;
		HttpClient httpClient = new HttpClient();
		PostMethod httpPost = new PostMethod(url);
		try {
			List<QParameter> listParams = QHttpUtil.getQueryParameters(queryString);
			int length = listParams.size() + (files == null ? 0 : files.size());
			Part[] parts = new Part[length];
			int i = 0;
			for (QParameter param : listParams) {
				parts[i++] = new StringPart(param.getName(), QHttpUtil.formParamDecode(param.getValue()), "UTF-8");
			}

			for (QParameter param : files) {
				String filePath = param.getValue();
				File file = new File(filePath);
				String name = param.getName();
				// String fileName = file.getName();
				// String type = QHttpUtil.getContentType(file);

				// image/jpeg - image/png
				parts[i++] = new FilePart(name, file, "image/jpeg", "utf-8");
			}

			httpPost.setRequestEntity(new MultipartRequestEntity(parts, httpPost.getParams()));

			int statusCode = httpClient.executeMethod(httpPost);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("HttpPost Method failed: " + httpPost.getStatusLine());
			}
			responseData = httpPost.getResponseBodyAsString();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			httpPost.releaseConnection();
			httpClient = null;
		}

		return responseData;
	}

}
