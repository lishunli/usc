package weibo4j.examples.oauth2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import weibo4j.Account;
import weibo4j.Oauth;
import weibo4j.Weibo;
import weibo4j.http.AccessToken;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.BareBonesBrowserLaunch;
import weibo4j.util.WeiboConfig;

public class OAuth4Code {
	public static void main(String[] args) throws WeiboException, IOException {
		Oauth oauth = new Oauth();
		BareBonesBrowserLaunch.openURL(oauth.authorize("code", WeiboConfig.getValue("client_id"), WeiboConfig.getValue("redirect_URI")));
		System.out.println(oauth.authorize("code", WeiboConfig.getValue("client_id"), WeiboConfig.getValue("redirect_URI")));
		System.out.print("Hit enter when it's done.[Enter]:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String code = br.readLine();
		Log.logInfo("code: " + code);
		try {
			AccessToken accessToken = oauth.getAccessTokenByCode(code, WeiboConfig.getValue("client_id"), WeiboConfig.getValue("client_sercret"), WeiboConfig.getValue("redirect_URI"));
			System.out.println(accessToken);
			String access_token = accessToken.getAccessToken();

			Weibo weibo = new Weibo();
			weibo.setToken(access_token);
			Account am = new Account();
			try {
				JSONObject uid = am.getUid();
				Log.logInfo(uid.toString());
			} catch (WeiboException e) {
				e.printStackTrace();
			}

		} catch (WeiboException e) {
			if (401 == e.getStatusCode()) {
				Log.logInfo("Unable to get the access token.");
			} else {
				e.printStackTrace();
			}
		}

	}
}
