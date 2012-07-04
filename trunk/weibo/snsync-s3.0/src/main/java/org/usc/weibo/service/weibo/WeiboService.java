package org.usc.weibo.service.weibo;

import java.util.List;

import org.apache.log4j.Logger;

import com.xunlei.game.activity.log.LogFactory;
import org.usc.weibo.util.Constants;
import org.usc.weibo.vo.Pair;
import org.usc.weibo.vo.WeiboContent;

/**
 *
 * @author Shunli
 */
public interface WeiboService {
	Logger log = LogFactory.getLoggerDaily(Constants.LOG_DIR, Constants.ACT_DIR, "sendWeiboJob");

	Pair<Pair<Long,Long>, List<WeiboContent>> read() throws Exception;

	void write(List<WeiboContent> weiboContents) throws Exception;

	void updateLastInfo(Long lastId, Long lastTimeStamp);
}
