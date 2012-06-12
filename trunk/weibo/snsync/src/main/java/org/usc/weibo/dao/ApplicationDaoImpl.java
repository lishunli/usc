package org.usc.weibo.dao;

import java.util.ArrayList;
import java.util.List;

import org.usc.weibo.util.AppUtil;
import org.usc.weibo.vo.Application;
import org.usc.weibo.vo.Provider;

public class ApplicationDaoImpl extends BaseDao implements ApplicationDao {
    @Override
    public Application findAppById(String appId) {
        String provider = AppUtil.getProvider(appId).name();

        return super.querySinglObj(Application.class, "select * from application where appid = ? and provider = ?", new Object[] { appId, provider });
    }

    @Override
    public List<Application> findAppsByProvider(Provider provider) {
        List<Application> results = super.queryListSQL(Application.class, "select * from application where provider = ? order by appid", new Object[] { provider.name() });
        if (results == null) {
            results = new ArrayList<Application>();
        }
        return results;
    }

}
