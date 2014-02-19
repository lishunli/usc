package org.usc.demo.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author ShunLi
 */
@SuppressWarnings("deprecation")
public class SITTest {
    public static void main(String[] args) throws Exception {
        // Local SZ
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@10.100.53.85:1521:cmn");
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUsername("mssapp");
        dataSource.setPassword("commission");

        SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(dataSource);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        List<Map<String, Object>> acList = jdbcTemplate.queryForList("SELECT ac_id FROM cc_ac where ac_id like '%-40'", paramMap);

        String sql1 = "SELECT addr_line1 FROM (SELECT clntn.clnt_id, clntn.notf_mtd_typ, clntn.notf_item_cde, cadd.addr_line1, cadd.addr_line2, cadd.addr_line3 FROM cc_clnt_notf_optn clntn INNER JOIN cc_clnt_addr cadd ON cadd.clnt_id = clntn.notf_clnt_id AND cadd.seq_num = clntn.clnt_addr_seq ) clientNotify WHERE clientNotify.clnt_id = (SELECT cl.clnt_id FROM cc_ac ac INNER JOIN cc_clnt cl ON cl.clnt_id = ac.primy_clnt_id WHERE ac.ac_id = :acId ) AND clientNotify.notf_item_cde ='STMT' AND clientNotify.notf_mtd_typ IN ('MAIL','BY_HAND')";
        String sql2 = "SELECT addr_line1 FROM (SELECT clntn.clnt_id, clntn.notf_mtd_typ, clntn.notf_item_cde, cadd.addr_line1, cadd.addr_line2, cadd.addr_line3 FROM cc_clnt_notf_optn clntn INNER JOIN cc_clnt_addr cadd ON cadd.clnt_id = clntn.notf_clnt_id AND cadd.seq_num = clntn.clnt_addr_seq ) clientNotify WHERE clientNotify.clnt_id = (SELECT ch.clnt_id FROM cc_ac ac INNER JOIN cc_ac_hldr ch ON ch.ac_id = ac.ac_id AND ch.is_primy = 'Y' INNER JOIN cc_clnt c ON c.clnt_id = ch.clnt_id WHERE ac.ac_id = :acId ) AND clientNotify.notf_item_cde ='STMT' AND clientNotify.notf_mtd_typ IN ('MAIL','BY_HAND')";

        for (int i = 0; i < acList.size(); i++) {
            String acId = acList.get(i).get("AC_ID").toString();
            paramMap.put("acId", acId);
            String one = jdbcTemplate.queryForMap(sql1, paramMap).get("addr_line1").toString();
            String two = jdbcTemplate.queryForMap(sql2, paramMap).get("addr_line1").toString();
            if (!one.equals(two)) {
                System.out.println(acId);
            } else {
                System.out.print(".");
                if (i % 100 == 0) {
                    System.out.println();
                }
            }

        }

    }

}
