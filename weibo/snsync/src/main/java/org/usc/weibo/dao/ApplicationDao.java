package org.usc.weibo.dao;

import org.usc.weibo.vo.Application;
import org.usc.weibo.vo.Provider;

public interface ApplicationDao {
	Application findAppById(String appId);
	Application findAppByProvider(Provider provider);
	Application randGetOneApp(Provider provider);
}
