package com.tencent.weibo.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.Scanner;

import com.tencent.weibo.api.Statuses_API;
import com.tencent.weibo.api.T_API;
import com.tencent.weibo.beans.OAuth;
import com.tencent.weibo.utils.OAuthClient;
import com.tencent.weibo.utils.WeiBoConst;

public class Test_API {

	private static String verify = null;

	private static Integer count = new Random().nextInt(10000);

	public static void main(String[] args) {
		try {
			test_list_t();
			// for(int i = 0;i< 10; i++){
			// Thread.sleep(1000);
			// test_list_t2();
			// }
		} catch (Exception e) {
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
			verify = in.nextLine().trim();

			// 获取access token
			System.out.println("GetAccessToken......");
			oauth.setOauth_verifier(verify);
			System.out.println(oauth);
			oauth = auth.accessToken(oauth);
			System.out.println("Response from server：");

			if (oauth.getStatus() == 2) {
				System.out.println("Get Access Token failed!");
				return;
			} else {
				// User_API uAPi = new User_API();

				// System.out.println(uAPi.info(oauth,WeiBoConst.ResultType.ResultType_Json));
				// Fav_API tAPI = new Fav_API();
				// // String response=tAPI.list_t(oauth, WeiBoConst.ResultType.ResultType_Json, "20", "0", "0");
				// // String response=tAPI.delt(oauth, WeiBoConst.ResultType.ResultType_Json, "104502055372919");
				// // String response=tAPI.addt(oauth, WeiBoConst.ResultType.ResultType_Json, "104502055372919");
				// Private_API private_API = new Private_API();
				//
				// String response = private_API.add(oauth, WeiBoConst.ResultType.ResultType_Json, "hello", "127.0.0.1", "", "", "BlueX_Chan");
				// System.out.println("response:" + response);

				// T_API sendApi = new T_API();
				// String response = sendApi.add(oauth, WeiBoConst.ResultType.ResultType_Json, "hello world" + count, "127.0.0.1");
				// System.out.println("response:" + response);

				System.out.println(oauth);
				Statuses_API sApi = new Statuses_API();
				// String response = sApi.broadcast_timeline(oauth, WeiBoConst.ResultType.ResultType_Json, "2", "1337837587", "100", "74246130382428", "0", "0",
				// "1");
				String response =  new T_API().comment(oauth, WeiBoConst.ResultType.ResultType_Json, "Good", "127.0.0.1", "65297129576904");
				System.out.println(response);

				// String response = sApi.home_timeline(oauth, WeiBoConst.ResultType.ResultType_Json, "0", "0", "70");
				// List<Status> status = sApi.broadcast_timeline(oauth, "0");

				// System.out.println(response);
			}
			in.close();
		}
	}

	private static void test_list_t2() throws Exception {
		OAuth oauth = new OAuth("801063781", "64f5dfe15a3fa65ffe153cff7609922b", "null");
		oauth.setOauth_token("bdde0644f4c54d578cc446571490185b");
		oauth.setOauth_token_secret("bdce26ab881e41c1e50c83c66a33ffac");
		// oauth.setOauth_verifier("984267");
		// oauth.setOauth_token("b321274ec2cc4033ab1c1748517ae113");
		// oauth.setOauth_token_secret("4ec1c75edf09828c4326a6f79f2e45f9");
		// oauth.setOauth_verifier("963401");

		// oauth_token=&oauth_verifier=
		OAuthClient auth = new OAuthClient();
		oauth = auth.requestToken(oauth);

		// 获取access token
		System.out.println("GetAccessToken......");
		// oauth = auth.accessToken(oauth);
		System.out.println("Response from server：");

		System.out.println(oauth);

		if (oauth.getStatus() == 2) {
			System.out.println("Get Access Token failed!");
			return;
		} else {
			// T_API tApi = new T_API();
			// String response = tApi.add(oauth, WeiBoConst.ResultType.ResultType_Json, "hello world " + count, "127.0.0.1");
			// // String response = tApi.show(oauth, WeiBoConst.ResultType.ResultType_Json, "103735038173797");
			// System.out.println("response:" + response);

			Statuses_API sApi = new Statuses_API();
			String response = sApi.home_timeline(oauth, WeiBoConst.ResultType.ResultType_Json, "0", "0", "70");
			// String response = sApi.broadcast_timeline(oauth, WeiBoConst.ResultType.ResultType_Json, "0", "0", "70", "0", "0", "0", "1");
			System.out.println(response);
		}
	}

}
