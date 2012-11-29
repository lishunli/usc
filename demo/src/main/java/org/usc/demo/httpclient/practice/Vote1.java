package org.usc.demo.httpclient.practice;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.usc.demo.httpclient.ProxyUtil;
import org.usc.demo.util.ListUtil;

/**
 *
 * @author Shunli
 */
public class Vote1 {

    public static void main(String[] args) {
        int threadSize = 20;
        List<List<String>> doSubList = ListUtil.doSubList(ProxyUtil.getProxyUrls(), threadSize);
        ExecutorService exec = Executors.newFixedThreadPool(threadSize);
        //
        String urlFormat = "http://vote.yzz.cn/votePost.php?jsonp=voteGlobalAjaxCommentBack&do=post&vid=482939&op=0&%s";
        for (List<String> proxyUrls : doSubList) {
            exec.execute(new GetThread2(urlFormat, proxyUrls));
        }
        exec.shutdown();
    }
}
