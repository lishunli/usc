package org.usc.demo.time;


/**
 *
 * @author ShunLi
 */
public class T7 {
//    private static final HttpRequester httpReq = new HttpRequester("utf-8", 6000, 6000);
//    private static final Calendar cal = Calendar.getInstance();
//
//    public static void main(String[] args) throws Exception {
//        System.out.println(isHoliday());
//    }
//
//    private static boolean isHoliday() {
//        try {
//            HttpRespons respon = httpReq.sendGet("http://act.game.xunlei.com:85/xlgame_youxi/servertime");
//            String jsonRtn = respon.getContent();
//
//            long now = new JSONObject(jsonRtn).getLong("result");
//            cal.setTimeInMillis(now);
//
//            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
//
//            if (dayOfWeek == 7 || dayOfWeek == 1) {
//                return true;
//            }
//
//        } catch (Exception e) {
//            // no-op, return defalult false
//        }
//
//        return false;
//    }
}
