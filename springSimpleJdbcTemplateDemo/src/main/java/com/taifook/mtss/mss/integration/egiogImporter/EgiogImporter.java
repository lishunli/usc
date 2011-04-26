package com.taifook.mtss.mss.integration.egiogImporter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.ResultSetDynaClass;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.StopWatch;

/**
 *
 * @author ShunLi
 */
public class EgiogImporter {
    private static int batchSize = 100;
    private static boolean isFirstSelect = true;
    private static DynaProperty[] dynaProps = null;
    private static String EGIOG_INSERT_SQL = null;

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

        RowMapper<Map<String, ?>> rowMapper = new RowMapper<Map<String, ?>>() {
            public Map<String, ?> mapRow(ResultSet rs, int paramInt) throws SQLException {
                ResultSetDynaClass rsdc = new ResultSetDynaClass(rs);

                if (isFirstSelect) {
                    dynaProps = rsdc.getDynaProperties();

                    EGIOG_INSERT_SQL = buildInsertSql(dynaProps);

                    isFirstSelect = false;
                }

                Map<String, Object> param = new HashMap<String, Object>();

                for (DynaProperty dynaProp : dynaProps) {
                    param.put(dynaProp.getName(), rsdc.getObjectFromResultSet(dynaProp.getName()));
                }

                System.out.println(String.format("%04d", paramInt) + " : " + param.toString());

                return param;
            }
        };


        stopWatch.start("batch select");
        List<Map<String, ?>> egiList = jdbcTemplateFrom.query(EGIOG_ALL_DATE_SQL, rowMapper, paramMap);
        stopWatch.stop();

        int size = egiList.size();

        for (int i = 0; i * batchSize < size; i++) {

            int fromIndex = i * batchSize;
            int toIndex = size - fromIndex > batchSize ? fromIndex + batchSize : size;
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

    private static String buildInsertSql(DynaProperty[] properties) {
        StringBuffer insertSql = new StringBuffer("INSERT INTO " + TABLE_NAME + "(");
        insertSql.append(buildParams(properties, ""));
        insertSql.append(") VALUES (");
        insertSql.append(buildParams(properties, ":"));
        insertSql.append(") ");
        return insertSql.toString();
    }

    private static String buildParams(DynaProperty[] properties, String prefix) {
        StringBuffer params = new StringBuffer();

        boolean isFirstColumn = true;
        for (int i = 0; i < properties.length; i++) {
            if (!isFirstColumn) {
                params.append(", " + prefix + properties[i].getName());
            } else {
                params.append(prefix + properties[i].getName());
                isFirstColumn = false;
            }
        }

        return params.toString();
    }
}
