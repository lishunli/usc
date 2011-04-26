package com.taifook.mtss.mss.integration.egiogImporter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.StopWatch;

/**
 *
 * @author ShunLi
 */
public class EgiogImporterM2 {
    private static int dataSyncBatchSize = 100;

    private static final String TABLE_NAME = "MC_TMP_OG_INSTR";
    private static final String EGIOG_DELETE_SQL = "Delete FROM " + TABLE_NAME;
    private static final String EGIOG_ALL_DATE_SQL = "SELECT * FROM " + TABLE_NAME;

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

        StopWatch stopWatch = new StopWatch();

        // clear temp table first
        stopWatch.start("batch delete");
        jdbcTemplateTo.update(EGIOG_DELETE_SQL, paramMap);
        stopWatch.stop();

        // select all
        stopWatch.start("batch select");
        List<Map<String, Object>> egiList = jdbcTemplateFrom.queryForList(EGIOG_ALL_DATE_SQL, paramMap);
        stopWatch.stop();

        int size = egiList.size();

        String egiOgInsertSql = null;

        for (int i = 0; i * dataSyncBatchSize < size; i++) {
            if (i == 0) {
                egiOgInsertSql = buildInsertSql(egiList.get(0).keySet());
                System.out.println("insert sql is: " + egiOgInsertSql);
            }

            int fromIndex = i * dataSyncBatchSize;
            int toIndex = size - fromIndex > dataSyncBatchSize ? fromIndex + dataSyncBatchSize : size;
            String msg = "batch insert from " + String.format("%04d", fromIndex) + " to " + String.format("%04d", toIndex);
            System.out.println(msg);

            stopWatch.start(msg);
            List<Map<String, Object>> subEgiList = egiList.subList(fromIndex, toIndex);
            jdbcTemplateTo.batchUpdate(egiOgInsertSql, subEgiList.toArray(new Map[0]));
            stopWatch.stop();
        }

        System.out.println("----------------------Result----------------------");
        for (StopWatch.TaskInfo taskInfo : stopWatch.getTaskInfo()) {
            System.out.println(taskInfo.getTaskName() + ",escaped time " + taskInfo.getTimeMillis() + " ms");
        }
        System.out.println("batch all escaped time " + stopWatch.getTotalTimeSeconds() + " s");
        System.out.println("----------------------End----------------------");
    }

    private static String buildInsertSql(Set<String> columnNames) {
        StringBuffer insertSql = new StringBuffer("INSERT INTO " + TABLE_NAME + "(");
        insertSql.append(buildParams(columnNames, ""));
        insertSql.append(") VALUES (");
        insertSql.append(buildParams(columnNames, ":"));
        insertSql.append(") ");
        return insertSql.toString();
    }

    private static String buildParams(Set<String> columnNames, String prefix) {
        StringBuffer params = new StringBuffer();

        boolean isFirstColumn = true;
        for (String columnName : columnNames) {
            if (!isFirstColumn) {
                params.append(", " + prefix + columnName);
            } else {
                params.append(prefix + columnName);
                isFirstColumn = false;
            }
        }

        return params.toString();
    }
}
