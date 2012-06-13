package org.usc.weibo.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.usc.weibo.config.Config;

import com.sina.sae.util.SaeUserInfo;
import com.xunlei.game.activity.annotation.ExtendField;
import com.xunlei.game.activity.utils.RegUtil;

/**
 *
 * @author ShunLi
 */
public class BaseDao {
	protected static final String WHERE = " where ";
	protected static final String SEQID = "seqId";

	private static SimpleJdbcTemplate readJdbcTemplate;
	private static SimpleJdbcTemplate writeJdbcTemplate;

	static {
		// Slave datasource for read
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(Config.getProperty("read_url"));

		String username = Config.getProperty("username");
		String password = Config.getProperty("password");
		username = StringUtils.isBlank(username) ? SaeUserInfo.getAccessKey() : username;
		password = StringUtils.isBlank(password) ? SaeUserInfo.getSecretKey() : password;
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		readJdbcTemplate = new SimpleJdbcTemplate(dataSource);

		// master datasource for wirte
		dataSource.setUrl(Config.getProperty("write_url"));
		writeJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}

	protected SimpleJdbcTemplate getReadJdbcTemplate() {
		return readJdbcTemplate;
	}

	protected SimpleJdbcTemplate getWriteJdbcTemplate() {
		return writeJdbcTemplate;
	}

	protected <T> void addObj(String tableName, T obj) {
		StringBuilder sbField = new StringBuilder();
		StringBuilder sbArgs = new StringBuilder();
		List<Object> args = new ArrayList<Object>();

		sbField.append(" ( ");
		sbArgs.append(" ( ");
		Field[] fields = obj.getClass().getDeclaredFields();
		if (fields != null && fields.length > 0) {
			String name = "";
			Object value = null;
			for (int i = 0; i < fields.length; i++) {
				if (isExtendField(fields[i]))
					continue;
				name = fields[i].getName();
				if (name.toLowerCase().equals("serialversionuid"))
					continue;
				value = RegUtil.getProperty(obj, name);

				if (value == null)
					continue;

				if (!SEQID.equalsIgnoreCase(name)) {
					sbField.append(name);
					if (i < fields.length - 1)
						sbField.append(", ");

					sbArgs.append("? ");
					if (i < fields.length - 1)
						sbArgs.append(", ");
					args.add(value);
				}
			}
		}
		if (sbField.toString().trim().endsWith(",")) {
			sbField = new StringBuilder(sbField.substring(0, sbField.lastIndexOf(",")));
		}
		if (sbArgs.toString().trim().endsWith(",")) {
			sbArgs = new StringBuilder(sbArgs.substring(0, sbArgs.lastIndexOf(",")));
		}
		sbField.append(" ) ");
		sbArgs.append(" ) ");
		StringBuilder sql = new StringBuilder();
		sql.append("insert into ").append(tableName).append(" ");
		sql.append(sbField).append(" values ").append(sbArgs);

		this.getWriteJdbcTemplate().update(sql.toString(), args.toArray());
	}

	protected <T> void updateObj(String tableName, T obj) {
		Long seqid = null;
		Object seqObj = RegUtil.getProperty(obj, SEQID);
		seqid = seqObj == null ? null : (Long) seqObj;
		if (seqid == null)
			return;

		StringBuilder sbField = new StringBuilder();
		List<Object> args = new ArrayList<Object>();
		Field[] fields = obj.getClass().getDeclaredFields();
		if (fields != null && fields.length > 0) {
			String name = "";
			Object value = null;
			for (int i = 0; i < fields.length; i++) {
				if (isExtendField(fields[i]))
					continue;
				name = fields[i].getName();
				if (name.toLowerCase().equals("serialversionuid"))
					continue;
				value = RegUtil.getProperty(obj, name);
				if (!SEQID.equalsIgnoreCase(name)) {
					sbField.append(name).append("=").append("?");
					if (i < fields.length - 1)
						sbField.append(", ");
					args.add(value);
				}
			}
		}
		if (sbField.toString().trim().endsWith(",")) {
			sbField = new StringBuilder(sbField.substring(0, sbField.lastIndexOf(",")));
		}
		StringBuilder sql = new StringBuilder();
		sql.append("update ").append(tableName).append(" set ");
		sql.append(sbField);
		sql.append(WHERE).append(SEQID).append(" = ").append(seqid);

		this.getWriteJdbcTemplate().update(sql.toString(), args.toArray());
	}

	protected <T> T findById(String tableName, Class<T> clazz, Serializable id) {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from ");
		sb.append(tableName).append(" ");
		sb.append("where seqid=").append(id);

		List<T> list = this.queryListSQL(clazz, sb.toString(), null);

		T obj = null;
		if (list != null && list.size() == 1) {
			obj = list.get(0);
		}
		return obj;
	}

	protected <T> List<T> queryListSQL(Class<T> clazz, String sql, Object[] args) {
		List<T> rs = new ArrayList<T>();
		List<Map<String, Object>> mapList = null;
		if (args != null && args.length > 0) {
			mapList = getReadJdbcTemplate().queryForList(sql, args);
		} else {
			mapList = getReadJdbcTemplate().queryForList(sql);
		}
		rs = convertColToObj(mapList, clazz);
		return rs;
	}

	protected <T> T querySinglObj(Class<T> clazz, String sql, Object args[]) {
		List<T> list = queryListSQL(clazz, sql, args);
		if (list != null && list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	/**
	 * 统计记录数
	 *
	 * @param sql
	 *            查询语句
	 * @param args
	 *            参数列表
	 * @return 统计结果
	 * @author chenzhenkun created at Nov 9, 2010
	 */
	protected Integer queryCountSQL(String sql, Object[] args) {
		return Long.valueOf(getReadJdbcTemplate().queryForLong(sql, args)).intValue();
	}

	/**
	 * 执行一段sql语句
	 *
	 * @param sql
	 * @author chenzhenkun created at Nov 30, 2010
	 */
	protected int executeSQL(String sql) {
		if (sql != null && !"".equals(sql)) {
			return getWriteJdbcTemplate().update(sql);
		}
		return 0;
	}

	/**
	 * 执行一段sql语句
	 *
	 * @param sql
	 * @param args
	 * @author chenzhenkun created at Nov 30, 2010
	 */
	protected int executeSQL(String sql, Object[] args) {
		if (sql != null && !"".equals(sql)) {
			return getWriteJdbcTemplate().update(sql, args);
		}
		return 0;
	}

	// /////////////////////////////////////////
	//
	// ////////////////////////////////////////

	private <T> List<T> convertColToObj(List<Map<String, Object>> mapList, Class<T> clazz) {
		List<T> rs = null;
		if (mapList != null && !mapList.isEmpty()) {
			try {
				rs = new ArrayList<T>();
				Object value;
				for (Map<String, Object> map : mapList) {

					T obj = clazz.newInstance();
					Set<String> keys = map.keySet();
					for (String key : keys) {
						value = map.get(key);
						if (value != null) {
							RegUtil.setProperty(obj, String.valueOf(key), value);
						}
					}
					rs.add(obj);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

	private boolean isExtendField(Field field) {
		boolean flag = false;
		if (field != null) {
			ExtendField extendField = field.getAnnotation(ExtendField.class);
			if (extendField != null)
				flag = true;
		}
		return flag;
	}

}
