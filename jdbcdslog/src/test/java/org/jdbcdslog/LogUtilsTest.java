package org.jdbcdslog;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
//		System.out.println( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Timestamp(12000000000000L)) );
//
//		System.out.println(new Timestamp(12000) instanceof Timestamp);

//		int maxParamNumber = 0;
//		int questionMarkCount = 0;
//
//		if (parameters.size() > 0) {
//			maxParamNumber = ((Integer) parameters.lastKey()).intValue();
//		}
//
//		Pattern p = Pattern.compile("\\?");
//		Matcher m = p.matcher(sql);
//		StringBuffer stringBuffer = new StringBuffer();
//		while (m.find()) {
//			m.appendReplacement(stringBuffer, "Test");
//			questionMarkCount++;
//		}
//
//		sql = String.valueOf(m.appendTail(stringBuffer));
//
//		System.out.println(maxParamNumber);
//		System.out.println(questionMarkCount);
//
//		// for (int i = 0; i < maxParamNumber && i < questionMarkCount; i++) {
//		// sql.replaceFirst("\\?", "Test");
//		// }
//
//		System.out.println(sql);

		 System.out.println(utils.createLogEntry(sql, parameters));

	}

}
