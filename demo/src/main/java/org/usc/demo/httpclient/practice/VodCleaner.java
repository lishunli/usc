package org.usc.demo.httpclient.practice;

import java.net.URISyntaxException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Shunli
 */
public class VodCleaner {

    /**
     * @param args
     * @throws URISyntaxException
     */
    public static void main(String[] args) throws Exception {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);

        String sId = "AB9B19BC724D1B6789779D01C7B13C5CE50452AB0E743AAC229625F5BDF72CDF6DB0D0090AFFA117A8FD87828C1FD50239AAEC6EEED5E9DA41A9E03C6EDD7068";
        BasicClientCookie cookie1 = new BasicClientCookie("sessionid", sId);
        cookie1.setDomain(".xunlei.com");
        cookie1.setPath("/");
        httpclient.getCookieStore().addCookie(cookie1);

        BasicClientCookie cookie2 = new BasicClientCookie("userid", "29254610");
        cookie2.setDomain(".xunlei.com");
        cookie2.setPath("/");
        httpclient.getCookieStore().addCookie(cookie2);

        for (int page = 0; page < 50; page++) {
            String url = "http://i.vod.xunlei.com/req_history_play_list/req_num/30/req_offset/0?type=folder&order=create&folder_id=0"; // 全部任务
            // String url = "http://i.vod.xunlei.com/req_history_play_list/req_num/30/req_offset/0?type=yincang&order=create&folder_id=0";// 隐藏任务
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpget);

            StringBuffer url_hashs = new StringBuffer();
            JSONArray jsonArray = JSON.parseObject(EntityUtils.toString(response.getEntity())).getJSONObject("resp").getJSONArray("history_play_list");
            for (int i = 0; i < jsonArray.size(); i++) {
                if (i > 0) {
                    url_hashs.append("%2F");
                }

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                url_hashs.append(jsonObject.getString("url_hash"));
            }

            httpget.releaseConnection();

            if (StringUtils.isEmpty(url_hashs)) {
                break;
            }

            String delUrl = "http://i.vod.xunlei.com/req_del_list?flag=0&sessionid=" + sId + "&url_hash=" + url_hashs;
            System.out.println(delUrl);

            httpget = new HttpGet(delUrl);
            response = httpclient.execute(httpget);
            System.out.println(EntityUtils.toString(response.getEntity()));
            httpget.releaseConnection();
        }

    }
}
