package org.usc.weibo.service;

import org.usc.weibo.vo.Application;
import org.usc.weibo.vo.Provider;

public interface ApplicationService {
	Application findAppById(String appId);
	Application findAppByProvider(Provider provider);
	Application randGetOneApp(Provider provider);

}
