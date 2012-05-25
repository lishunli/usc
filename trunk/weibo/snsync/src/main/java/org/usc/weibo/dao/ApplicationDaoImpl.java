package org.usc.weibo.dao;

import java.util.List;

import com.xunlei.game.activity.annotation.DataSourceType;
import com.xunlei.game.activity.dao.BaseDao;
import org.usc.weibo.util.AppUtil;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Application;
import org.usc.weibo.vo.Provider;

@DataSourceType(Constants.JDBC_JNDI_YOUXI_WEIBO)
public class ApplicationDaoImpl extends BaseDao implements ApplicationDao {
	@Override
	public Application findAppById(String appId) {
		String provider = AppUtil.getProvider(appId).name();
		List<Application> apps = super.queryListSQL(Application.class, "select * from application where appid = ? and provider = ?", new Object[] { appId, provider });
		if (apps != null) {
			return apps.get(0);
		}

		return null;
	}

	@Override
	public Application findAppByProvider(Provider provider) {
		List<Application> apps = super.queryListSQL(Application.class, "select * from application where provider = ? order by appid", new Object[] { provider.name() });
		if (apps != null) {
			return apps.get(0);
		}

		return null;
	}

}
