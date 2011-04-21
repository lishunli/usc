package com.taifook.mtss.mss.integration.egiogImporter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.StopWatch;

/**
 *
 * @author ShunLi
 */
public class EgiogImporter {
    private static int dataSyncBatchSize = 100;

    private static final String EGIOG_DELETE_SQL = "Delete FROM MC_TMP_OG_INSTR ";

    private static final String EGIOG_ALL_DATE_SQL = "SELECT * FROM MC_TMP_OG_INSTR ";

    private static final String EGIOG_INSERT_SQL = "Insert into MC_TMP_OG_INSTR " + "(INSTR_CDE ,ISIN_CDE,LOT_SIZ,CCY_CDE,IS_SUSPD,IS_CCASS_SETL,HAS_STAMP,LST_DATE,DELIST_DATE,LST_STAT,PREV_CLOS_PRICE , "
            + "ENGLISH_INSTR_NAM ,BIG5_CHI_INSTR_NAM,GB_CHI_INSTR_NAM ,CALL_PUT_STAT ,STRK_PRICE,IS_CBBC,IS_WARRANT,CALL_PRICE,EXPR_DATE,WARRANT_UPPER_LVL_INSTR_CDE)" + " VALUES " + "(:INSTR_CDE ,:ISIN_CDE,:LOT_SIZ,:CCY_CDE,:IS_SUSPD,:IS_CCASS_SETL ,:HAS_STAMP,:LST_DATE,:DELIST_DATE,:LST_STAT,:PREV_CLOS_PRICE , "
            + ":ENGLISH_INSTR_NAM ,:BIG5_CHI_INSTR_NAM,:GB_CHI_INSTR_NAM  ,:CALL_PUT_STAT ,:STRK_PRICE,:IS_CBBC,:IS_WARRANT,:CALL_PRICE,:EXPR_DATE,:WARRANT_UPPER_LVL_INSTR_CDE)";

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        // SIT
        DriverManagerDataSource dataSourceFrom = new DriverManagerDataSource();
        dataSourceFrom.setUrl("jdbc:oracle:thin:@172.30.201.15:1521:mseub");
        dataSourceFrom.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSourceFrom.setUsername("mssqry");
        dataSourceFrom.setPassword("a0665");

        // // Local SZ
        // DriverManagerDataSource dataSourceTo = new DriverManagerDataSource();
        // dataSourceTo.setUrl("jdbc:oracle:thin:@10.100.53.85:1521:cmn");
        // dataSourceTo.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        // dataSourceTo.setUsername("mssapp");
        // dataSourceTo.setPassword("commission");

        // Local HK
        DriverManagerDataSource dataSourceTo = new DriverManagerDataSource();
        dataSourceTo.setUrl("jdbc:oracle:thin:@10.100.210.40:1521:mseda");
        dataSourceTo.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSourceTo.setUsername("mdev11");
        dataSourceTo.setPassword("mdev11");

        SimpleJdbcTemplate jdbcTemplateFrom = new SimpleJdbcTemplate(dataSourceFrom);
        final SimpleJdbcTemplate jdbcTemplateTo = new SimpleJdbcTemplate(dataSourceTo);

        HashMap<String, Object> paramMap = new HashMap<String, Object>();

        // clear temp table first
        jdbcTemplateTo.update(EGIOG_DELETE_SQL, paramMap);

        RowMapper<Map<String, ?>> rowMapper = new RowMapper<Map<String, ?>>() {
            public Map<String, ?> mapRow(ResultSet rs, int paramInt) throws SQLException {
                Map<String, Object> param = new HashMap<String, Object>();

                param.put("INSTR_CDE", rs.getString("INSTR_CDE"));
                param.put("ISIN_CDE", rs.getString("ISIN_CDE"));
                param.put("LOT_SIZ", rs.getString("LOT_SIZ"));
                param.put("CCY_CDE", rs.getString("CCY_CDE"));
                param.put("IS_SUSPD", rs.getString("IS_SUSPD"));
                param.put("IS_CCASS_SETL", rs.getString("IS_CCASS_SETL"));
                param.put("HAS_STAMP", rs.getString("HAS_STAMP"));
                param.put("LST_DATE", rs.getDate("LST_DATE"));
                param.put("DELIST_DATE", rs.getDate("DELIST_DATE"));
                param.put("LST_STAT", rs.getString("LST_STAT"));
                param.put("PREV_CLOS_PRICE", rs.getString("PREV_CLOS_PRICE"));
                param.put("ENGLISH_INSTR_NAM", rs.getString("ENGLISH_INSTR_NAM"));
                param.put("BIG5_CHI_INSTR_NAM", rs.getString("BIG5_CHI_INSTR_NAM"));
                param.put("GB_CHI_INSTR_NAM", rs.getString("GB_CHI_INSTR_NAM"));
                param.put("CALL_PUT_STAT", rs.getString("CALL_PUT_STAT"));
                param.put("STRK_PRICE", rs.getString("STRK_PRICE"));
                param.put("EXPR_DATE", rs.getDate("EXPR_DATE"));
                param.put("IS_CBBC", rs.getString("IS_CBBC"));
                param.put("IS_WARRANT", rs.getString("IS_WARRANT"));
                param.put("CALL_PRICE", rs.getString("CALL_PRICE"));
                param.put("WARRANT_UPPER_LVL_INSTR_CDE", rs.getString("WARRANT_UPPER_LVL_INSTR_CDE"));

                System.out.println(String.format("%04d", paramInt) + " : " + param.toString());

                return param;
            }
        };

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("batch select");
        List<Map<String, ?>> egiList = jdbcTemplateFrom.query(EGIOG_ALL_DATE_SQL, rowMapper, paramMap);
        stopWatch.stop();

        int size = egiList.size();

        for (int i = 0; i * dataSyncBatchSize < size; i++) {

            int fromIndex = i * dataSyncBatchSize;
            int toIndex = size - fromIndex > dataSyncBatchSize ? fromIndex + dataSyncBatchSize : size;
            String msg = "batch insert from " + String.format("%04d", fromIndex) + " to " + String.format("%04d", toIndex);
            System.out.println(msg);

            stopWatch.start(msg);
            List<Map<String, ?>> subEgiList = egiList.subList(fromIndex, toIndex);
            jdbcTemplateTo.batchUpdate(EGIOG_INSERT_SQL, subEgiList.toArray(new Map[0]));
            stopWatch.stop();
        }

        System.out.println("----------------------Result----------------------");
        for (StopWatch.TaskInfo taskInfo : stopWatch.getTaskInfo()) {
            System.out.println(taskInfo.getTaskName() + ",escaped time " + taskInfo.getTimeMillis() + " ms");
        }
        System.out.println("batch all insert escaped time " + stopWatch.getTotalTimeSeconds() + " s");
        System.out.println("----------------------End----------------------");
    }
}
