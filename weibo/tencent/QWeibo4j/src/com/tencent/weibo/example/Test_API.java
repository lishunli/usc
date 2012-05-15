package com.tencent.weibo.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import weibo4j.Status;

import com.tencent.weibo.api.Statuses_API;
import com.tencent.weibo.beans.OAuth;
import com.tencent.weibo.utils.OAuthClient;
import com.tencent.weibo.utils.WeiBoConst;

public class Test_API {

	private static String verify = null;

	private static Integer count = new Random().nextInt(10000);

	public static void main(String[] args) {
		try {
			test_list_t();
//			for(int i = 0;i< 10; i++){
//			Thread.sleep(1000);
//			test_list_t2();
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_list_t() throws Exception {
		OAuth oauth = new OAuth("801063781", "64f5dfe15a3fa65ffe153cff7609922b", "null");
		OAuthClient auth = new OAuthClient();

		// 获取request token
		oauth = auth.requestToken(oauth);
		// oauth = auth.accessToken(oauth);

		if (oauth.getStatus() == 1) {
			System.out.println("Get Request Token failed!");
			return;
		} else {
			String oauth_token = oauth.getOauth_token();

			String url = "http://open.t.qq.com/cgi-bin/authorize?oauth_token=" + oauth_token;

			System.out.println("Get verification code......");
			if (!java.awt.Desktop.isDesktopSupported()) {

				System.err.println("Desktop is not supported (fatal)");
				System.exit(1);
			}
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
			if (desktop == null || !desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {

				System.err.println("Desktop doesn't support the browse action (fatal)");
				System.exit(1);
			}
			try {
				desktop.browse(new URI(url));
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			} catch (URISyntaxException e) {
				e.printStackTrace();
				System.exit(1);
			}

			System.out.println("haha" + url);

			System.out.println("Input your verification code：");
			Scanner in = new Scanner(System.in);
			verify = in.nextLine();

			// 获取access token
			System.out.println("GetAccessToken......");
			oauth.setOauth_verifier(verify);
			oauth = auth.accessToken(oauth);
			System.out.println("Response from server：");

			if (oauth.getStatus() == 2) {
				System.out.println("Get Access Token failed!");
				return;
			} else {
//				User_API uAPi = new User_API();

//				System.out.println(uAPi.info(oauth,WeiBoConst.ResultType.ResultType_Json));
				// Fav_API tAPI = new Fav_API();
				// // String response=tAPI.list_t(oauth, WeiBoConst.ResultType.ResultType_Json, "20", "0", "0");
				// // String response=tAPI.delt(oauth, WeiBoConst.ResultType.ResultType_Json, "104502055372919");
				// // String response=tAPI.addt(oauth, WeiBoConst.ResultType.ResultType_Json, "104502055372919");
				// Private_API private_API = new Private_API();
				//
				// String response = private_API.add(oauth, WeiBoConst.ResultType.ResultType_Json, "hello", "127.0.0.1", "", "", "BlueX_Chan");
				// System.out.println("response:" + response);

//				T_API sendApi = new T_API();
//				String response = sendApi.add(oauth, WeiBoConst.ResultType.ResultType_Json, "hello world" + count, "127.0.0.1");
//				System.out.println("response:" + response);
				Statuses_API sApi = new Statuses_API();
//				String response = sApi.home_timeline(oauth, WeiBoConst.ResultType.ResultType_Json, "0", "0", "70");
//				List<Status>  status = sApi.broadcast_timeline(oauth,  "0");

//				System.out.println(response);
			}
			in.close();
		}
	}

	private static void test_list_t2() throws Exception {
		OAuth oauth = new OAuth("801063781", "64f5dfe15a3fa65ffe153cff7609922b", "null");
		oauth.setOauth_token("36c1ad6002214bdd88a24168b0d51a35");
		oauth.setOauth_verifier("314208");

		OAuthClient auth = new OAuthClient();

		// 获取access token
		System.out.println("GetAccessToken......");
		oauth = auth.accessToken(oauth);
		System.out.println("Response from server：");

		if (oauth.getStatus() == 2) {
			System.out.println("Get Access Token failed!");
			return;
		} else {
//			T_API tApi = new T_API();
//			String response = tApi.add(oauth, WeiBoConst.ResultType.ResultType_Json, "hello world " + count, "127.0.0.1");
//			// String response = tApi.show(oauth, WeiBoConst.ResultType.ResultType_Json, "103735038173797");
//			System.out.println("response:" + response);

			Statuses_API sApi = new Statuses_API();
			String response = sApi.home_timeline(oauth, WeiBoConst.ResultType.ResultType_Json, "0", "0", "70");
			// String response = sApi.broadcast_timeline(oauth, WeiBoConst.ResultType.ResultType_Json, "0", "0", "70", "0", "0", "0", "1");
			System.out.println(response);
		}
	}

}
