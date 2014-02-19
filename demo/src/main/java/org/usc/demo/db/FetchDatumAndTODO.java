package org.usc.demo.db;

import java.util.HashMap;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.jdbcdslog.LogUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


/**
 *
 * @author ShunLi
 */
@SuppressWarnings("deprecation")
public class FetchDatumAndTODO {
    private static final String SQL = "select exit_descr from JB_JOB_RUN where job_run_id = 1013007";

    public static void main(String[] args) throws Exception {
         // Local SZ
         DriverManagerDataSource local = new DriverManagerDataSource();
         local.setUrl("jdbc:oracle:thin:@10.100.53.85:1521:cmn");
         local.setDriverClassName("oracle.jdbc.driver.OracleDriver");
         local.setUsername("mssapp");
         local.setPassword("commission");

        SimpleJdbcTemplate jdbcTemplateFrom = new SimpleJdbcTemplate(local);

        HashMap<String, Object> paramMap = new HashMap<String, Object>();

        String result = jdbcTemplateFrom.queryForObject(SQL, String.class, paramMap);//queryForList(local, paramMap);

        System.out.println(StringUtils.center(" Result ", 100, "-"));

        String sql = "?";
        TreeMap<Integer, Object> parameters = new TreeMap<Integer, Object>();
        parameters.put(1, result);


        System.out.println(LogUtils.createLogEntry(sql, parameters));


    }
}
