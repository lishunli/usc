package org.usc.weibo.dao;

import org.usc.weibo.util.AppUtil;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Application;
import org.usc.weibo.vo.Provider;

import com.xunlei.game.activity.annotation.DataSourceType;
import com.xunlei.game.activity.dao.BaseDao;

@DataSourceType(Constants.JDBC_JNDI_YOUXI_WEIBO)
public class ApplicationDaoImpl extends BaseDao implements ApplicationDao {
	@Override
	public Application findAppById(String appId) {
		String provider = AppUtil.getProvider(appId).name();

		return super.querySinglObj(Application.class, "select * from application where appid = ? and provider = ?", new Object[] { appId, provider });
	}

	@Override
	public Application findAppByProvider(Provider provider) {
		return super.querySinglObj(Application.class, "select * from application where provider = ? order by appid", new Object[] { provider.name() });
	}
	@Override
	public Application randGetOneApp(Provider provider) {
		return super.querySinglObj(Application.class, "select * from application where provider = ? order by rand() limit 1", new Object[] { provider.name() });
	}

}
