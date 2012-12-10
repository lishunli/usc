package org.usc.demo.httpclient.practice;

import java.net.URI;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.utils.URIBuilder;

/**
 *
 * @author Shunli
 */
public class RealTest2 {
    public static void main(String[] args) throws Exception {
        // local-test-env:lishunli3-51980070405198
        String uin = "123611";
        String setid = "20";
        String roleId = "10485761";

        String timeStamp = String.valueOf(new Date().getTime());
        String signStr = uin + setid + roleId + timeStamp + "df756bb5706846418138a1cee5d82b84";
        System.out.println(signStr);
        String sign = DigestUtils.md5Hex(signStr);

        URIBuilder uriBuilder = new URIBuilder("http://act.game.xunlei.com:85/xlgame_xiumo/xmphoneverification");
        uriBuilder.addParameter("action", "getStateAndSendGift");
        uriBuilder.addParameter("uin", uin);
        uriBuilder.addParameter("setid", setid);
        uriBuilder.addParameter("roleid", roleId);
        uriBuilder.addParameter("stamp", timeStamp);
        uriBuilder.addParameter("sign", sign);
        URI uri = uriBuilder.build();
        System.out.println(uri);

        int threadSize = 100;
        ExecutorService exec = Executors.newFixedThreadPool(threadSize);
        for (int i = 0; i < threadSize; i++) {
            exec.execute(new GetThread4(uri));
        }
        exec.shutdown();
    }
}
