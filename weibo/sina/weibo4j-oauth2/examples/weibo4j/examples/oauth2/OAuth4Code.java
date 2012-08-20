package weibo4j.examples.oauth2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import weibo4j.Oauth;
import weibo4j.model.WeiboException;
import weibo4j.util.BareBonesBrowserLaunch;

public class OAuth4Code {
	public static void main(String[] args) throws WeiboException, IOException {
		Oauth oauth = new Oauth();
		String clientId = "1033549550";
		String clientSecret = "464364f385111bf6d99e83e1d79ce8e3";
		String redirectUri = "http://10.11.9.27:85/snsync/sinaweibo?action=callBack";
		BareBonesBrowserLaunch.openURL(oauth.authorize(clientId, redirectUri, "code"));
		System.out.println(oauth.authorize(clientId, redirectUri, "code"));
		System.out.print("Hit enter when it's done.[Enter]:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String code = br.readLine();
		Log.logInfo("code: " + code);
		try {
			System.out.println(oauth.getAccessTokenByCode(clientId, clientSecret, redirectUri, code));
		} catch (WeiboException e) {
			if (401 == e.getStatusCode()) {
				Log.logInfo("Unable to get the access token.");
			} else {
				e.printStackTrace();
			}
		}
	}

}
