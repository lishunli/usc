package weibo4j;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import weibo4j.http.AccessToken;
import weibo4j.http.BASE64Encoder;
import weibo4j.model.PostParameter;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;

public class Oauth {
    // ----------------------------针对站内应用处理SignedRequest获取accesstoken----------------------------------------
    public String access_token;
    public String user_id;

    public String getToken() {
        return access_token;
    }

    /*
     * 解析站内应用post的SignedRequest split为part1和part2两部分
     */
    public String parseSignedRequest(String clientSecret, String signed_request) throws IOException,
            InvalidKeyException, NoSuchAlgorithmException {
        String[] t = signed_request.split("\\.", 2);
        // 为了和 url encode/decode 不冲突，base64url 编码方式会将
        // '+'，'/'转换成'-'，'_'，并且去掉结尾的'='。 因此解码之前需要还原到默认的base64编码，结尾的'='可以用以下算法还原
        int padding = (4 - t[0].length() % 4);
        for (int i = 0; i < padding; i++)
            t[0] += "=";
        String part1 = t[0].replace("-", "+").replace("_", "/");

        SecretKey key = new SecretKeySpec(clientSecret.getBytes(), "hmacSHA256");
        Mac m;
        m = Mac.getInstance("hmacSHA256");
        m.init(key);
        m.update(t[1].getBytes());
        String part1Expect = BASE64Encoder.encode(m.doFinal());

        sun.misc.BASE64Decoder decode = new sun.misc.BASE64Decoder();
        String s = new String(decode.decodeBuffer(t[1]));
        if (part1.equals(part1Expect)) {
            return ts(s);
        } else {
            return null;
        }
    }

    /*
     * 处理解析后的json解析
     */
    public String ts(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            access_token = jsonObject.getString("oauth_token");
            user_id = jsonObject.getString("user_id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return access_token;

    }

    /*----------------------------Oauth接口--------------------------------------*/

    public AccessToken getAccessTokenByCode(String clientId, String clientSecret, String redirectUri, String code) throws WeiboException {
        return new AccessToken(Weibo.client.post(
                WeiboConfig.getValue("accessTokenURL"),
                new PostParameter[] {
                        new PostParameter("client_id", clientId),
                        new PostParameter("client_secret", clientSecret),
                        new PostParameter("grant_type", "authorization_code"),
                        new PostParameter("code", code),
                        new PostParameter("redirect_uri", redirectUri) }, false));
    }

    public String authorize(String clientId, String redirectUri, String response_type) throws WeiboException {
        return WeiboConfig.getValue("authorizeURL").trim() + "?client_id=" + clientId
                + "&redirect_uri=" + redirectUri
                + "&response_type=" + response_type;
    }
}
