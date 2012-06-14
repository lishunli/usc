package com.tencent.weibo.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sina.sae.fetchurl.BinaryData;
import com.sina.sae.fetchurl.SaeFetchurl;
import com.tencent.weibo.beans.QParameter;

public class QHttpClient {
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
        List<QParameter> listParams = QHttpUtil.getQueryParameters(queryString);

        Map<String, String> maps = new HashMap<String, String>();
        for (QParameter qParameter : listParams) {
            maps.put(qParameter.getName(), qParameter.getValue());
        }

        SaeFetchurl fetchUrl = new SaeFetchurl();
        fetchUrl.setMethod("post");
        fetchUrl.setPostData(maps);

        for (QParameter param : files) {
            BinaryData data = new BinaryData();

            String filePath = param.getValue();
            File file = new File(filePath);

            FileInputStream stream = new FileInputStream(file);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            for (int n; (n = stream.read(b)) != -1;) {
                out.write(b, 0, n);
            }
            stream.close();
            out.close();

            data.setInputParameterName(param.getName());
            data.setFileName(param.getName());
            data.setPostData(out.toByteArray());

            fetchUrl.setPostData(data);
        }

        String responseData = fetchUrl.fetch(url);

        return responseData;
    }
}
