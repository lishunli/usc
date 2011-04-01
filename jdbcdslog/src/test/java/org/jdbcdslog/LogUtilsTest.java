package org.jdbcdslog;

import java.sql.Timestamp;
import java.util.Date;
import java.util.TreeMap;

import org.junit.Test;

public class LogUtilsTest {

    @Test
    public void testCreateLogEntry() {
        LogUtils utils = new LogUtils();
        String sql = "select * from mc_instr where instr_cde = ? and instcl_id = ? instrumentBusinessDate = ? and last_updat_time = ?";
        TreeMap<Integer, Object> parameters = new TreeMap<Integer, Object>();
        parameters.put(1, "INSTR03011");
        parameters.put(2, 1);
        parameters.put(3, new Date());
        parameters.put(4, new Timestamp(12000));

        utils.createLogEntry(sql, parameters);

    }

}
