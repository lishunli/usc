package org.usc.demo.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author ShunLi
 */
public class SITTest2 {
    public static void main(String[] args) throws Exception {
        // Local SZ
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@10.100.53.85:1521:cmn");
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUsername("mssapp");
        dataSource.setPassword("commission");

        SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(dataSource);

        String baseSql = " SELECT DISTINCT user0_.user_id " +
                " FROM CO_USER user0_ " +
                " WHERE (EXISTS " +
                "   (SELECT account1_.AC_ID, " +
                "     accountexe4_.AE_CDE " +
                "   FROM CC_AC account1_ " +
                "   INNER JOIN cc_ae_aces_grp aeaccessgr2_     ON account1_.ae_aces_grp_cde    =aeaccessgr2_.ae_aces_grp_cde " +
                "   INNER JOIN CC_AE_ACES_GRP_MBR accountexe3_ ON aeaccessgr2_.AE_ACES_GRP_CDE = accountexe3_.AE_ACES_GRP_CDE " +
                "   INNER JOIN CC_AE accountexe4_              ON accountexe3_.AE_CDE          =accountexe4_.AE_CDE " +
                "   WHERE accountexe4_.AE_CDE                                                  =user0_.AE_CDE " +
                "   AND account1_.BUSIN_ACTY_CDE                                               ='STOCK_OPTIONS' " +
                "   )) " +
                " AND (user0_.USER_STAT    IN ('ACTIVE' , 'ISSUE' , 'LOCKED')) " +
                " AND (user0_.UNIT_CDE NOT IN ('0014' , '0016' , '0045' , '0046')) " +
                " ORDER BY user0_.USER_ID ";

        String searchSql = " SELECT count(*) " +
                " FROM cc_ac ac " +
                " inner join cc_ae_aces_grp grp on grp.ae_aces_grp_cde=ac.ae_aces_grp_cde " +
                " where grp.ae_aces_grp_cde                          in(SELECT ae_aces_grp_cde " +
                "     FROM CC_AE_ACES_GRP_MBR MBR " +
                "     WHERE MBR.AE_CDE IN " +
                "       ( SELECT :userId AS AE_CDE FROM dual " +
                "       UNION ALL " +
                "       SELECT ACT_AE_CDE AS AE_CDE " +
                "       FROM CC_ACT_AE AAE " +
                "       WHERE AAE.AE_CDE                        = :userId " +
                "       AND TO_CHAR(AAE.EFF_DATE,'YYYY-MM-DD') <= " +
                "         (SELECT VAL " +
                "         FROM MC_SYS_PARAM " +
                "         WHERE PARAM_KEY = 'SYS_BUS_DATE' " +
                "         ) " +
                "       AND ( AAE.EXPR_DATE                   IS NULL " +
                "       OR TO_CHAR(AAE.EXPR_DATE,'YYYY-MM-DD') > " +
                "         (SELECT VAL FROM MC_SYS_PARAM WHERE PARAM_KEY = 'SYS_BUS_DATE' " +
                "         )) " +
                "       ) " +
                "     UNION " +
                "     SELECT DISTINCT GRP.AE_ACES_GRP_CDE " +
                "     FROM CC_AE_TEAM_HEAD HEAD, " +
                "       CC_AE_TEAM_MBR MBR, " +
                "       CC_AE_ACES_GRP_MBR GRP " +
                "     WHERE HEAD.ENTRP_CDE = MBR.ENTRP_CDE " +
                "     AND HEAD.AE_TEAM_CDE = MBR.AE_TEAM_CDE " +
                "     AND MBR.ENTRP_CDE    = GRP.ENTRP_CDE " +
                "     AND MBR.AE_CDE       = GRP.AE_CDE " +
                "     AND HEAD.AE_CDE     IN " +
                "       ( SELECT :userId AS AE_CDE FROM dual " +
                "       UNION ALL " +
                "       SELECT ACT_AE_CDE AS AE_CDE " +
                "       FROM CC_ACT_AE AAE " +
                "       WHERE AAE.AE_CDE                        = :userId " +
                "       AND TO_CHAR(AAE.EFF_DATE,'YYYY-MM-DD') <= " +
                "         (SELECT VAL " +
                "         FROM MC_SYS_PARAM " +
                "         WHERE PARAM_KEY = 'SYS_BUS_DATE' " +
                "         ) " +
                "       AND ( AAE.EXPR_DATE                   IS NULL " +
                "       OR TO_CHAR(AAE.EXPR_DATE,'YYYY-MM-DD') > " +
                "         (SELECT VAL FROM MC_SYS_PARAM WHERE PARAM_KEY = 'SYS_BUS_DATE' " +
                "         )) " +
                "       )) " +
                " AND ac.BUSIN_ACTY_CDE                               = 'STOCK_OPTIONS' ";

        HashMap<String, Object> paramMap = new HashMap<String, Object>();

        List<String> userListForMethod1 = jdbcTemplate.query(baseSql, new RowMapper<String>() {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString(1);
            }
        }, paramMap);

        List<Map<String, Object>> userListForMethod2 = jdbcTemplate.queryForList(baseSql, paramMap);

        calcMethod1(jdbcTemplate, searchSql, paramMap, userListForMethod1);
        calcMethod2(jdbcTemplate, searchSql, paramMap, userListForMethod2);
    }

    /**
     * @param jdbcTemplate
     * @param searchSql
     * @param paramMap
     * @param userList
     */
    private static void calcMethod1(SimpleJdbcTemplate jdbcTemplate, String searchSql, HashMap<String, Object> paramMap, List<String> userList) {
        for (String userId : userList) {
            System.out.println(userId);
            paramMap.put("userId", userId);

            long queryForLong = jdbcTemplate.queryForLong(searchSql, paramMap);

            if (queryForLong > 1) {
                System.out.println(queryForLong + ":" + userId);
            }
        }
    }

    /**
     * @param jdbcTemplate
     * @param searchSql
     * @param paramMap
     * @param userList
     */
    private static void calcMethod2(SimpleJdbcTemplate jdbcTemplate, String searchSql, HashMap<String, Object> paramMap, List<Map<String, Object>> userList) {
        for (int i = 0; i < userList.size(); i++) {
            String userId = userList.get(i).get("user_id").toString();

            paramMap.put("userId", userId);

            long queryForLong = jdbcTemplate.queryForLong(searchSql, paramMap);

            if (queryForLong > 1) {
                System.out.println(queryForLong + ":" + userId);
            }
        }
    }

}
