package org.usc.demo;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.StopWatch;

/**
 * 
 * @author ShunLi
 */
public class GetReportSharesUser {
	private static final String ALL_Users_DATE_SQL = "select user_id from co_user";

	// private static final String USERS_SELECT_SQL = "SELECT * FROM mc_rm_ac_mcalst where rownum <=10000";

	static BigDecimal sum = BigDecimal.ZERO;

	public static void main(String[] args) throws Exception {
		// SIT
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setUrl("jdbc:oracle:thin:@10.100.53.85:1521:cmn");
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUsername("mssapp");
		dataSource.setPassword("commission");

		final SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(dataSource);

		HashMap<String, Object> paramMap = new HashMap<String, Object>();

		RowMapper<Map<String, ?>> rowMapper = new RowMapper<Map<String, ?>>() {
			public Map<String, ?> mapRow(ResultSet rs, int paramInt) throws SQLException {
				Map<String, BigDecimal> param = new HashMap<String, BigDecimal>();
				BigDecimal b = rs.getBigDecimal("LEDG_BAL");
				sum = sum.add(b);

				System.out.println(String.format("%04d", paramInt) + " : " + b + ":" + sum);

				return param;
			}
		};

		StopWatch stopWatch = new StopWatch();
		stopWatch.start("batch select");
		jdbcTemplate.query(ALL_Users_DATE_SQL, rowMapper, paramMap);
		stopWatch.stop();

	}
}
