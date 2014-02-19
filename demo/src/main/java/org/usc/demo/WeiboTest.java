package org.usc.demo;

import org.json.JSONException;

/**
 *
 * @author Shunli
 */
public class WeiboTest {

    /**
     * @param args
     * @throws JSONException
     */
    public static void main(String[] args) throws JSONException {
        String text = "【中,.，。：”“:\"\"南财大毕业x生抢帽子 4年狂骗7000万】过事先建仓、1234231613黑嘴荐股、拉抬股价后抢先卖出，通过这一\"抢帽子\"手法，年仅30岁出头的中南财大一名毕业生，在短短4年时间里，将拼凑来的30万元，炒到7000多万元。5月17日，天门法院一审判决.";
        // String suffix = " //来自微博@" + retweetedStatus.getUser().getName() + " " + ShortUrlUtil.shortUrlShorten(String.format(SINA_FROM_ID_TO_URL,
        // retweetedStatus.getUser().getId(), retweetedId));
        // String suffix = " //来自微博@李顺利Me ";

        // int maxWidth = Constants.WEIBO_CONTENT_MAX_LENGTH - WeiboUtil.length(suffix) - 10;
        //
        // text = WeiboUtil.abbreviate(text, maxWidth) + suffix + String.format("http://api.t.sina.com.cn/%s/statuses/%s", "123456", "654321");

        System.out.println(text);
    }

}
