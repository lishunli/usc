package org.usc.demo;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ShunLi
 */
public class T0 {

    public static void main(String[] args) {
        Map<Long, Map<Date, Boolean>> typhoonDateCache = new HashMap<Long, Map<Date, Boolean>>();

        // Map<Date, Boolean> value1 = new HashMap<Date, Boolean>();
        // Calendar cal1 = new GregorianCalendar(2010, 6, 7);// 2010-07-07
        // value1.put(cal1.getTime(), true);
        //
        // Map<Date, Boolean> value2 = new HashMap<Date, Boolean>();
        // Calendar cal2 = new GregorianCalendar(2010, 6, 8);// 2010-07-07
        // value1.put(cal2.getTime(), false);
        //
        // useCache.put(4L, value1);
        // useCache.put(5L, value2);

        Long marketId = 4L;
        Date businessDate = new GregorianCalendar(2010, 6, 7).getTime();

        // 1
        if (typhoonDateCache.containsKey(marketId)) {
            Map<Date, Boolean> result = typhoonDateCache.get(marketId);

            if (result.containsKey(businessDate)) {
                if (result.get(businessDate)) {
                    System.out.println("find it");
                    // override
                } else {
                    // no-op
                }
            } else {
                System.out.println("no businessDate...");

                Boolean isTyphoonDate = true;// true from call method..
                result.put(businessDate, isTyphoonDate);

                typhoonDateCache.put(marketId, result);

                if (isTyphoonDate) {
                    // override
                }
            }
        } else {
            System.out.println("no market...");

            Boolean isTyphoonDate = true;// true from call method..

            Map<Date, Boolean> value = new HashMap<Date, Boolean>();
            value.put(businessDate, isTyphoonDate);

            typhoonDateCache.put(marketId, value);

            if (isTyphoonDate) {
                // override
            }
        }

        System.out.println(typhoonDateCache);

        // 2
        if (typhoonDateCache.containsKey(marketId)) {
            Map<Date, Boolean> result = typhoonDateCache.get(marketId);

            if (result.containsKey(businessDate)) {
                if (result.get(businessDate)) {
                    System.out.println("find it");
                    // override
                } else {
                    // no-op
                }
            } else {
                System.out.println("no businessDate...");

                Boolean isTyphoonDate = true;// true from call method..
                result.put(businessDate, isTyphoonDate);

                typhoonDateCache.put(marketId, result);

                if (isTyphoonDate) {
                    // override
                }
            }
        } else {
            System.out.println("no market...");

            Boolean isTyphoonDate = true;// true from call method..

            Map<Date, Boolean> value = new HashMap<Date, Boolean>();
            value.put(businessDate, isTyphoonDate);

            typhoonDateCache.put(marketId, value);

            if (isTyphoonDate) {
                // override
            }
        }

        // 3
        businessDate = new GregorianCalendar(2010, 6, 8).getTime();
        if (typhoonDateCache.containsKey(marketId)) {
            Map<Date, Boolean> result = typhoonDateCache.get(marketId);

            if (result.containsKey(businessDate)) {
                if (result.get(businessDate)) {
                    System.out.println("find it");
                    // override
                } else {
                    // no-op
                }
            } else {
                System.out.println("no businessDate...");

                Boolean isTyphoonDate = true;// true from call method..
                result.put(businessDate, isTyphoonDate);

                typhoonDateCache.put(marketId, result);

                if (isTyphoonDate) {
                    // override
                }
            }
        } else {
            System.out.println("no market...");

            Boolean isTyphoonDate = true;// true from call method..

            Map<Date, Boolean> value = new HashMap<Date, Boolean>();
            value.put(businessDate, isTyphoonDate);

            typhoonDateCache.put(marketId, value);

            if (isTyphoonDate) {
                // override
            }
        }

        System.out.println(typhoonDateCache);

        marketId = 5L;
        if (typhoonDateCache.containsKey(marketId)) {
            Map<Date, Boolean> result = typhoonDateCache.get(marketId);

            if (result.containsKey(businessDate)) {
                if (result.get(businessDate)) {
                    System.out.println("find it");
                    // override
                } else {
                    // no-op
                }
            } else {
                System.out.println("no businessDate...");

                Boolean isTyphoonDate = true;// true from call method..
                result.put(businessDate, isTyphoonDate);

                typhoonDateCache.put(marketId, result);

                if (isTyphoonDate) {
                    // override
                }
            }
        } else {
            System.out.println("no market...");

            Boolean isTyphoonDate = true;// true from call method..

            Map<Date, Boolean> value = new HashMap<Date, Boolean>();
            value.put(businessDate, isTyphoonDate);

            typhoonDateCache.put(marketId, value);

            if (isTyphoonDate) {
                // override
            }
        }

        System.out.println(typhoonDateCache);

        // // Map<Long, Date> useCache = new HashMap<Long, Date>(); // <marketId, businessDate>
        // // useCache.put(4L, new Date());
        // // useCache.put(1L, new Date());
        //
        // Calendar cal = new GregorianCalendar(2010, 6, 7);// 2010-07-07
        // System.out.println(cal.getTime());
        //
        // Long marketId = 4L;
        //
        // Multimap<Long, Date> useCache = HashMultimap.create();
        //
        // useCache.put(4L, cal.getTime());
        // useCache.put(4L, new GregorianCalendar(2010, 6, 8).getTime());
        // useCache.put(1L, new Date());
        //
        // // 注意,MultiMap取得的数据不是String类型,而是Collection类型
        // Collection<Date> collection = useCache.get(marketId);
        //
        // System.out.println(collection.contains(new GregorianCalendar(2010, 6, 9).getTime()));

        // String line ="100082CNE1000003V0SI 20100915P63715615CC00010PB       100000005000 0000000295976-HKD 0001172954              0000000000000                 0000002042013510.30.57.144729     /";
        // System.out.println(line.substring(55, 66).trim());

        // String fileName1 = "eod_pos_HTICASH_01042012.csv";
        // String fileName2 = "_";
        // // String fileName2 = "eod_pos_HTIMARGIN_01042012.csv";
        //
        // System.out.println(fileName1.lastIndexOf("_"));
        // System.out.println(fileName2.lastIndexOf("_"));
        // System.out.println(fileName2.substring(0,0));
        // System.out.println(fileName2.substring(1));
        //
        // if(fileName1.lastIndexOf("_") > 0){
        // System.out.println(fileName1.substring(0, fileName1.lastIndexOf("_")).equalsIgnoreCase("EOD_POS_HTICASH"));
        // System.out.println(fileName1.substring(fileName1.lastIndexOf("_") + 1));
        //
        //
        // } else{
        // System.out.println(false);
        // }

        // System.out.println(FilenameUtils.removeExtension(fileName1));

        // String pattern = "";// "eod_pos_HTICASH_" + "{0}";
        // SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        // System.out.println(MessageFormat.format(pattern, dateFormat.format(new Date())));

        // String str= "1x";
        // System.out.println(new BigDecimal(str));
        // BigDecimal b1 = BigDecimal.ONE;
        // BigDecimal b2 = BigDecimal.TEN;
        //
        // System.out.println(b1 == null ? b2 == null : b2 != null && b1.compareTo(b2) == 0);

        // System.out.println(new BigDecimal("1200.353").divide(new BigDecimal("33"), 4));
        // System.out.println(new BigDecimal("1200.353").divide(new BigDecimal("33"), BigDecimal.ROUND_HALF_UP));
        // System.out.println(new BigDecimal("1200.353").divide(new BigDecimal("33"), 4, 4));
        // System.out.println(new BigDecimal("1200.353").divide(new BigDecimal("33"), 4, BigDecimal.ROUND_HALF_UP));

        // System.out.println(removeTheHeadAndTail(null));
        // System.out.println(removeTheHeadAndTail(""));
        // System.out.println(removeTheHeadAndTail(" "));
        // System.out.println(removeTheHeadAndTail("1"));
        // System.out.println(removeTheHeadAndTail("[]"));
        // System.out.println(removeTheHeadAndTail("[1]"));

        // List<String> testStr= new ArrayList<String>();
        // testStr.add("1");
        // testStr.add(null);
        //
        // System.out.println(testStr.size());
        // System.out.println(testStr);

        // String excludedWords =".svn | target | .classpath | .project | .settings";
        //
        // List<String> excludedKeys = new ArrayList<String>();
        //
        // if (StringUtils.isNotBlank(excludedWords)) {
        // excludedKeys.addAll(Arrays.asList(excludedWords.split("\\s" + SPILT_CHAR.trim() + "\\s")));
        // }
        //
        // System.out.println(excludedKeys.size());

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
// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

// private static String removeTheHeadAndTail(String string){
// if(string == null || string.length() < 2){
// return null;
// }
// return string.substring(1, string.length() - 1);
// }
//
// private final static String SPILT_CHAR = " | ";
