package org.usc.weibo.dao;

import java.util.List;

import org.usc.weibo.vo.Application;
import org.usc.weibo.vo.Provider;

public interface ApplicationDao {
	Application findAppById(String appId);
	List<Application> findAppsByProvider(Provider provider);
}
