package org.usc.demo.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TestInsertOnDuplicateKeyUpdate {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DriverManagerDataSource local = new DriverManagerDataSource();
        local.setUrl("jdbc:mysql://10.11.9.27:3306/xlgame_xiumo");
        local.setDriverClassName("com.mysql.jdbc.Driver");
        local.setUsername("root");
        local.setPassword("sd-9898w");

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(local);

        int count = 1000;
        Random random = new Random();

        // test 1, normal
        // clear table first
        jdbcTemplate.update("delete from vote", new HashMap<String, Object>());

        long start = System.currentTimeMillis();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        for (int i = 0; i < count; i++) {
            String belleid = random.nextInt(count / 100) + "";
            paramMap.put("belleid", belleid);
            int exist = jdbcTemplate.queryForInt("select count(*) from vote where belleid = :belleid", paramMap);

            if (exist == 0) {
                jdbcTemplate.update("insert into vote values(null, :belleid, 1)", paramMap);
            } else {
                jdbcTemplate.update("update vote set num = num + 1 where belleid = :belleid", paramMap);
            }
        }

        System.out.println("normal test escaped time " + (System.currentTimeMillis() - start));

        // test 2, InsertOnDuplicateKeyUpdate
        // clear table first
        jdbcTemplate.update("delete from vote", new HashMap<String, Object>());

        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            String belleid = random.nextInt(count / 100) + "";
            paramMap.put("belleid", belleid);

            jdbcTemplate.update("insert into vote values (null, :belleid, 1) ON DUPLICATE KEY UPDATE num=num+1", paramMap);
        }

        System.out.println("InsertOnDuplicateKeyUpdate test escaped time " + (System.currentTimeMillis() - start));

    }

}
