package org.usc.demo;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Client1024 {

    public static void main(String[] args) throws Exception {
        // 记录扫过的url,不在进入.
        fout = new FileOutputStream("d:/abc.txt", true);
        pw = new PrintWriter(fout);

        // 草榴有根据cookie来验证刷新时间不能小于两秒的规则,屏蔽cookie.
        httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.IGNORE_COOKIES);

        // 一次性验证某邀请码
        // 处理邀请码
        List<String> list1 = createInvcode("0529eb#9a#6a342e");
        // 注册账号
        regis(list1);

        // 注掉下述3行即技术区逐个帖子扫
        if (1 == 1) {
            System.exit(0);
        }

        // 获取所有url
        Set<String> urlSet = queryUrls();
        HttpGet contentHttpGet = new HttpGet();
        while (!urlSet.isEmpty()) {

            for (Iterator<String> i = urlSet.iterator(); i.hasNext();) {
                String str = i.next();
                if (urlsSet.contains(str)) {
                    continue;
                }
                witerAddress(str);
                contentHttpGet.setURI(new URI("http://cl.arlew.com/" + str));
                HttpResponse httpResponse = null;
                try {
                    httpResponse = httpClient.execute(contentHttpGet);
                } catch (Exception e) {
                    Thread.sleep(1000 * 60);
                    httpResponse = httpClient.execute(contentHttpGet);
                }
                System.out.println("connection-->http://cl.arlew.com/" + str);
                HttpEntity entity = httpResponse.getEntity();
                // String source = new String(EntityUtils.toString(entity).getBytes("iso-8859-1"), "gbk");
                String source = "";
                try {
                    Thread.sleep(500);
                    source = EntityUtils.toString(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
                Pattern pattern = Pattern.compile("[a-f0-9]{16}");
                Matcher matcher = pattern.matcher(source);
                while (matcher.find()) {
                    String strTmp = matcher.group();
                    if (!codeSet.contains(strTmp)) {
                        codeSet.add(strTmp);
                        List<String> list = createInvcode(strTmp);
                        // 注册账号
                        regis(list);
                    }

                }
            }
            urlsSet.addAll(urlSet);
            urlSet = queryUrls();
        }

    }

    /**
     * @author mengfanyu
     * @data Nov 2, 2014
     * @param args
     * @throws IOException
     * @throws ClientProtocolException
     *
     */

    static HttpClient httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager());
    static HttpPost httpPost = new HttpPost("http://cl.arlew.com/register.php");
    static HttpGet urlHttpGet = new HttpGet("http://cl.arlew.com/thread0806.php?fid=7&search=1");
    static Set codeSet = new HashSet();
    static Set urlsSet = new HashSet();
    static FileOutputStream fout = null;
    static PrintWriter pw = null;
    static Map shzMap = new HashMap();
    static Map xhzMap = new HashMap();
    static {
        try {
            FileReader fr = new FileReader("d:/abc.txt");
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            while (null != str) {

                urlsSet.add(str);
                str = br.readLine();

            }
            fr.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void witerAddress(String str) throws FileNotFoundException {
        pw.println(str);
        pw.flush();
    }

    private static Set queryUrls() throws ClientProtocolException, IOException, InterruptedException {
        Set set = new HashSet();
        HttpResponse httpResponse = httpClient.execute(urlHttpGet);
        HttpEntity entity = httpResponse.getEntity();
        // String source = new String(EntityUtils.toString(entity).getBytes("iso-8859-1"), "gbk");
        String source = "";
        Thread.sleep(1000);
        try {
            source = EntityUtils.toString(entity);
        } catch (Exception e) {

        }
        Pattern pattern = Pattern.compile("htm_data/.+html");
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            set.add(matcher.group());
        }
        return set;
    }
    private static void regis(List<String> list) throws ClientProtocolException, IOException {
        for (int i = 0; i < list.size(); i++) {
            String invcode = list.get(i); // 邀请码
            System.out.println(invcode);
            httpPost.setEntity(setPatams(invcode.toLowerCase()));
            HttpResponse httpResponse = null;
            try {
                httpResponse = httpClient.execute(httpPost);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            HttpEntity entity = httpResponse.getEntity();
            String source = new String(EntityUtils.toString(entity).getBytes("iso-8859-1"), "gbk");
            if (source.contains("邀請碼錯誤") == false) {
                System.out.println(source);
                System.err.println("成功:" + invcode);
                System.exit(0);
            }
        }
    }

    private static UrlEncodedFormEntity setPatams(String invcode) throws ClientProtocolException, IOException {

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        nvps.add(new BasicNameValuePair("regname", "这里写你的用户名"));
        nvps.add(new BasicNameValuePair("regpwd", "这里写密码"));
        nvps.add(new BasicNameValuePair("regpwdrepeat", "这里写密码"));
        nvps.add(new BasicNameValuePair("regemail", "这里写邮箱"));
        nvps.add(new BasicNameValuePair("invcode", invcode)); // 邀请码
        nvps.add(new BasicNameValuePair("forward", "")); // 不变
        nvps.add(new BasicNameValuePair("step", "2")); // 不变

        return new UrlEncodedFormEntity(nvps);

    }
    /**
     * #为数字,@为字母
     *
     * @author mengfanyu
     * @data Nov 2, 2014
     * @param str
     * @return
     *
     */
    private static List createInvcode(String... strs) {
        List list = new ArrayList();

        for (int i = 0; i < strs.length; i++) {
            String str = strs;

            if (str.indexOf("#") >= 0 && str.indexOf("#") == str.lastIndexOf("#") && str.indexOf("@") == -1) { // 只存在一个#并且不存在@

                for (int j = 0; j < 10; j++) {
                    list.add(str.replace("#", j + ""));
                }

            } else if (str.indexOf("#") >= 0 && str.indexOf("#") != str.lastIndexOf("#") && str.indexOf("@") == -1) {// 存在两个#并且不存在@

                for (int j = 0; j < 10; j++) {
                    String newStr = str.replaceFirst("\\#", j + "");
                    for (int k = 0; k < 10; k++) {
                        list.add(newStr.replaceFirst("\\#", k + ""));

                    }
                }

            } else if (str.indexOf("#") >= 0 && str.indexOf("#") == str.lastIndexOf("#") && str.indexOf("@") >= 0 && str.indexOf("@") == str.lastIndexOf("@")) { // 存在一个#和一个@

                for (int j = 0; j < 10; j++) {
                    String newStr = str.replaceFirst("\\#", j + "");
                    for (char a = 'a'; a <= 'z'; a++) {
                        list.add(newStr.replaceFirst("\\@", a + ""));

                    }
                }

            } else if (str.indexOf("@") >= 0 && str.indexOf("@") == str.lastIndexOf("@") && str.indexOf("#") == -1) { // 存在一个@并且不存在#
                for (char a = 'a'; a <= 'z'; a++) {
                    list.add(str.replaceFirst("\\@", a + ""));

                }
            } else if (str.indexOf("@") >= 0 && str.indexOf("@") != str.lastIndexOf("@") && str.indexOf("#") == -1) { // 存在两个@并且不存在#
                for (char a = 'a'; a <= 'z'; a++) {
                    String newStr = str.replaceFirst("\\@", a + "");
                    for (char b = 'a'; b <= 'z'; b++) {
                        list.add(newStr.replaceFirst("\\@", b + ""));

                    }
                }
            } else if (str.indexOf("#") == -1 && str.indexOf("@") == -1 && str.indexOf(" ") >= 0) { // 既不存在#也不存@,使用排列组合
                String strings[] = str.split("\\s");
                int l = strings.length;
                pai(strings, 0, strings.length, list);
            } else if (str.matches("[u4e00-u9fa5]")) { // 明码
                list.add(str);
            } else {
                list.add(str);
            }

        }

        return list;

    }
    private static void pai(String[] str, int m, int n, List list) {

        if (m < n) {
            for (int i = 0; i <= m; i++) {
                pai(str, m + 1, n, list);
                chang(str, m);
            }
        } else {
            list.add(printArray(str));
        }
    }

    // 移位
    private static void chang(String[] str, int m) {

        String temp = str[0];
        for (int i = 0; i < m; i++) {
            str = str[i + 1];
        }
        str[m] = temp;
    }

    private static String printArray(String strs[]) {
        String str = "";
        for (int i = 0; i < strs.length; i++) {
            str += strs;
        }
        return str;
    }

}
