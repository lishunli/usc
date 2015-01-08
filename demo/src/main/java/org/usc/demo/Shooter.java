package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.collect.Lists;

/**
 *
 * @author Shunli
 */
public class Shooter {
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36";

    public static void main(String[] args) throws Exception {
        String search = "美国恐怖故事 第二季";
        String path = "D:\\电影\\" + search;

        FileUtils.forceMkdir(new File(path));

        for (String downloadUrlSuffix : fetchDownloadUrls(search)) {
            download(path, downloadUrlSuffix);
        }

    }

    private static void download(String path, String downloadUrlSuffix) throws IOException, ClientProtocolException {
        String dowanloadFileName = StringUtils.substringAfterLast(downloadUrlSuffix, "/");

        File downloadFile = new File(path, dowanloadFileName);
        Request.Get("http://sub2.makedie.me" + downloadUrlSuffix)
                .execute()
                .saveContent(downloadFile);

        System.out.println("download-success:" + downloadFile);
    }

    private static List<String> fetchDownloadUrls(String search) throws IOException, InterruptedException {
        List<String> urls = Lists.newArrayList();

        Connection connection = Jsoup.connect("http://sub.makedie.me/sub/").header("User-Agent", USER_AGENT);

        // first search
        Document doc = connection.data("searchword", search).get();
        urls.addAll(parseUrls(doc));

        int page = doc.getElementsByAttributeValueContaining("href", "javascript:shtg_subpage2").size();
        for (int i = 2; i <= page; i++) {
            // sleep for avoid service exception
            TimeUnit.SECONDS.sleep(4);

            urls.addAll(parseUrls(connection.data("searchword", search, "page", i + "").get()));
        }

        return urls;
    }

    private static List<String> parseUrls(Document doc) {
        List<String> urls = Lists.newArrayList();

        Elements elements = doc.getElementsByAttributeValue("id", "downsubbtn");
        for (Element element : elements) {
            String downloadUrlSuffix = StringUtils.substringBetween(element.attr("onclick"), "'", "'");

            urls.add(downloadUrlSuffix);
        }

        return urls;
    }
}
