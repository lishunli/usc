package org.usc.demo;


/**
 *
 * @author ShunLi
 */
public class T0 {
    public static void main(String[] args) {

        // List<String> locationCodes = new ArrayList<String>();
        // locationCodes.add("DSB");
        // locationCodes.add("CCASS");
        // System.out.println(ViewTradeBalanceReconciliationReportDaoImplOracleTest.join(locationCodes, ","));

        // String[] split = StringUtils.split(temps.toString(), ",\\S*");

        // List<Long> brokerAccountList = new ArrayList<Long>();
        // brokerAccountList.add(1L);
        // brokerAccountList.add(2L);
        //
        // System.out.println(brokerAccountList);
        // String tempBrokerAccountIds = brokerAccountList.toString();
        // System.out.println(tempBrokerAccountIds.substring(1, tempBrokerAccountIds.length() - 1));
        // String[] split = tempBrokerAccountIds.substring(1, tempBrokerAccountIds.length() - 1).split(","); // remove array '[' and ']';
        //
        // for(int i=0; i< split.length; i++){
        // System.out.println(Long.parseLong(split[i].trim()));
        // }

    }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// // 0.1
// System.out.println("00001".replaceAll("^0+", ""));
// System.out.println("100001000".replaceAll("^0+", ""));
// System.out.println("010001".replaceAll("^0+", ""));

// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 0.2 CSVParser
// CSVParser parser = new CSVParser();
// String[] parseLine = parser.parseLine("\"02-0002156-30\",\"B\",\"C\",\"A\",\"505\",\"09/14/2010\"");
// System.out.println(parseLine.length);
// System.out.println(Arrays.asList(parseLine));

// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// // 0.3 List to String then spilt to String[]
// List<String> temps = new ArrayList<String>();
// temps.add("dd");
// temps.add("dd232");
//
// String[] split1 = temps.toString().split(",");
//
// System.out.println(Arrays.toString(split1));
// System.out.println(Arrays.asList(split1));
//
// for (int i = 0; i < split1.length; i++) {
// System.out.println(split1[i].trim());
// }
//
// System.out.println("--------------------------------");
//
// String[] split2 = temps.toString().split(",\\s");
//
// System.out.println(Arrays.toString(split2));
// System.out.println(Arrays.asList(split2));
//
// for (int i = 0; i < split2.length; i++) {
// System.out.println(split2[i]);
// }

