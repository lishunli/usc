package org.usc.demo.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TestSqlInjection {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DriverManagerDataSource local = new DriverManagerDataSource();
        local.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        local.setDriverClassName("com.mysql.jdbc.Driver");
        local.setUsername("root");
        local.setPassword("lishunli");

        NamedParameterJdbcTemplate jdbcTemplateFrom = new NamedParameterJdbcTemplate(local);
        // SimpleJdbcTemplate jdbcTemplateFrom = new SimpleJdbcTemplate(local);

        Map<String, Object> paramMap = new HashMap<String, Object>();
        // paramMap.put("name", "lishunli");
        paramMap.put("name", "lishunli' or '1 = 1");

        String sql = "select * from order_t where name = :name";
        // List<String> queryForList = jdbcTemplateFrom.queryForList(sql, paramMap, String.class);
        List<Map<String, Object>> result = jdbcTemplateFrom.queryForList(sql, paramMap);
        System.out.println(result);
    }

}
