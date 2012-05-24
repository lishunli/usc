package org.usc.demo;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author ShunLi
 */
public class T0 {

	// private static final String SYSTEM_SEPARATOR = "/";
	//
	// private static String buildExcludeBrokerIds(String excludeBrokerIds,
	// String excludeSpecificallyBrokerId) {
	// if (StringUtils.isBlank(excludeBrokerIds)) {
	// return excludeSpecificallyBrokerId;
	// } else if (StringUtils.isBlank(excludeSpecificallyBrokerId)) {
	// return excludeBrokerIds;
	// }
	//
	// return excludeBrokerIds + "," + excludeSpecificallyBrokerId;
	// }
	//
	// private static String buildExcludeBrokerIds2(String... excludeBrokerIds)
	// {
	// return StringUtils. join (excludeBrokerIds, ",");
	// }

	// public static <T> List<T> gather(T... args) {
	// // EnumSet set;
	// return Arrays.asList(args);
	// }
	//
	// public static void sum(int... args) {
	// int sum = 0;
	// for (int arg : args) {
	// sum += arg;
	// }
	// System.out.println(sum);
	// }

	private static boolean checkIsOverLengthLimit(String text, int limit) {
		Pattern p = Pattern.compile("[^\\x00-\\xff]");
		Matcher m = p.matcher(text);

		// double-byte
		int doubleByteNumber = 0;
		while (m.find()) {
			doubleByteNumber++;
		}
		int singleByteNumber = text.length() - doubleByteNumber;

		if (doubleByteNumber + singleByteNumber / 2 + singleByteNumber % 2 > limit) {
			return true;
		}

		return false;
	}

	private String buildStringRtn(Map<String, Object> map) {
		StringBuffer sb = new StringBuffer("<?xml version=\"1.0\"?>\n");
		sb.append("<data>\n");
		if (map != null) {
			for (Entry<String, Object> entry : map.entrySet()) {
				sb.append("    <").append(entry.getKey()).append(">")
						.append(entry.getValue())
						.append("</").append(entry.getKey()).append(">\n");
			}
		}
		sb.append("</data>");
		return sb.toString();
	}

	public static String buildJobNames(List<String> jobNameList) {
		StringBuffer sb = new StringBuffer();

		boolean isFirst = true;
		for (String jobName : jobNameList) {
			if (!isFirst) {
				sb.append(",");
			}
			sb.append(StringUtils.uncapitalize(jobName));
			isFirst = false;
		}

		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		// String url = "http://t2.qpic.cn/mblogpic/89e43514893fe5b7359e/2000";
		// File file = new File(url);
		// System.out.println(file);

		String context = "【中,.，。：”“:\"\"南财大毕业x生抢帽子 4年狂骗7000万】过事先建仓、黑嘴荐股、拉抬股价后抢先卖出，通过这一\"抢帽子\"手法，年仅30岁出头的中南财大一名毕业生，在短短4年时间里，将拼凑来的30万元，炒到7000多万元。5月17日，天门法院一审判决：被告人余凯犯操纵证券市场罪，判处有期徒刑三年。";
		// System.out.println(context);
		//
		// String pattern = "\\[\\u4e00-\\u9fa5\\]";
		//
		// System.out.println(context.matches(pattern));
		//
		// // for(int i = 0; i< context.length(); i++){
		// // System.out.println(context.indexOf(i));
		// // }
		//
		// Pattern p = Pattern.compile("[^\\x00-\\xff]");
		// Matcher m = p.matcher(context);
		//
		// // System.out.println(m.find());
		//
		// // 双字节文字
		// int questionMarkCount = 0;
		// while (m.find()) {
		// questionMarkCount++;
		// }
		//
		// System.out.println(context.length() - questionMarkCount);
		// System.out.println((context.length() - questionMarkCount) / 2 + (context.length() - questionMarkCount) % 2);
		//
		// System.out.println(questionMarkCount);

		String text = context;
		int limit = 140 - 10 - " //来自微博@李顺利 ".length();// shorturl lenght = 20 /2 = 10

		if (checkIsOverLengthLimit(text, limit)) {
			text = StringUtils.abbreviate(text, limit); // substring
		}

		text = text + " //来自微博@李顺利 " + "http://url.cn/1OFbY4";

		System.out.println(text);

		// for (char c : context.toCharArray()) {
		// // System.out.println(c + ":" + String.valueOf(c).matches("[\\u4e00-\\u9fa5]"));
		// System.out.println(c + ":" + String.valueOf(c).matches("[^\\x00-\\xff]"));
		// // System.out.println(c /* + ":" + String.valueOf(c).matches(pattern) */ + ":"+ Character.isLetter(c));
		// }

		// System.out.println("7000".length());
		// System.out.println("【".length());
		// System.out.println("中".length());
		// System.out.println(context.contains("，"));
		// System.out.println(context.replaceFirst("，", ","));

		// String url = "http://api.t.sina.com.cn/%s/statuses/%s";
		// System.out.println(String.format(url, "1771925961", "3445888074596137"));
		//
		// String text = "hello world";
		// System.out.println(text.substring(0, 10));
		//
		// System.out.println(StringUtils.abbreviate(text, 10));
		// System.out.println(text);

		// String url =
		// "http%3A%2F%2Fyouxi.xunlei.com%2Fbar%2Fbarmng.shtml%3Fticker%3Dv8ton8vNmwpo6iZp1QN88fpfqH0aGP%2BQzBE447rwwjHuHaqUqvsLYvpgXbbBpfIB%2BQFNX5lebH6y%0AF5Gy0r9u5%2B4yyFk2h5KG%2BuYQM4sAM%2BiArFQKP5%2FGAyHK9rEcGBA6";
		// System.out.println(URLDecoder.decode(url, "utf8"));
		// System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));// .substring(0, 20)
		//
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
		//
		// System.out.println(format.format(new Date()));
		//
		// List<String> names = Arrays.asList("Lishunli", "Hi");
		// System.out.println(StringUtils.join(names, ","));
		// System.out.println(buildJobNames(names));
		//
		// String jobName = "xmLoginNoticeArchive";
		// System.out.println(StringUtils.removeEndIgnoreCase(jobName, "job"));
		//
		// String anObject = null;
		// System.out.println("1".equals(anObject ));

		// System.gc();
		// Date now = new Date();
		// Calendar c = Calendar.getInstance();
		// c.setTime(now);
		// c.add(Calendar.DATE, -2);
		//
		// Date previousDay = c.getTime();
		// System.out.println(previousDay);

		// Map<String, String> map = new TreeMap<String, String>();
		// map.put("o_1151286465941365189_1151286465941365190", "2");
		// map.put("o_1151286465940603969_1151286465940606276", "6");
		// map.put("o_1151286465941365189_1151286465941366088", "5");
		// map.put("sum", "10");
		// map.put("o_1151286465941365189_1151286465941365639", "8");
		// map.put("o_1151286465940603969_1151286465940603970", "1");
		// map.put("o_1151286465940603969_1151286465940605763", "2");
		//
		// System.out.println(map);

		// List<String> list = Arrays.asList("1","2","3","4");
		//
		// for(String str : list){
		// System.out.println(str);
		// list.remove("2");
		// }
		//
		// for(String str : list){
		// System.out.println(str);
		// }

		// Map<String, Object> map = new HashMap<String, Object>();
		// map.put("code", 0);
		// map.put("msg", "suce");
		// map.put("giftId", 12);
		// map.put("gitfname", "xxxxx");
		// map.put("leftCout", 1);
		// System.out.println(new T0().buildStringRtn(map));

		// System.out.println(String.valueOf(false));
		// System.out.println(Arrays.toString("Connectionoracle.jdbc.driver.LogicalConnection".split("\\.")));
		//
		// System.out.println("sqldb.jdbc.jdbcconnection".indexOf("hsqldb"));
		// System.out.println("sqldb.jdbc.jdbcconnection".matches("\\.*" +
		// "hsqldb"));
		// System.out.println(new BigDecimal("1").divide(new BigDecimal("3"), 0,
		// BigDecimal.ROUND_DOWN));

		// Map<String, BigDecimal> map = new TreeMap<String, BigDecimal>();
		// map.put("1", BigDecimal.ONE);
		// map.put("2", BigDecimal.ONE);
		//
		// map.put("1", map.get("1").add(BigDecimal.TEN));
		//
		// System.out.println(map);

		// System.out.println("connectionoracle".m);

		// sum();
		// System.out.println(Arrays.asList(null));;

		// String regex = "^\\d{2}-\\d{6}[0-4]-\\d{2}$";
		// String testString = "02-0000000-22";
		//
		// System.out.println( testString.matches(regex));

		// int j = 0;
		// while((j++) < 10){
		// System.out.println("Case " + j);
		// int i = 0, count = 10000000;
		// long startTime = System.nanoTime();
		//
		// while ((i++) < count){
		// testString.matches(regex);
		// }
		//
		// System.out.println("Methos 1 cost " + (System.nanoTime() -
		// startTime));
		//
		// i = 0;
		// startTime = System.nanoTime();
		// while ((i++) < count){
		// Pattern p = Pattern.compile(regex);
		// p.matcher(testString).find();
		// }
		//
		// System.out.println("Methos 2 cost " + (System.nanoTime() -
		// startTime));
		// }

		// System.out.println(System.nanoTime() - startTime);

		// Map<String, String> testMap = new HashMap<String, String>();
		// testMap.put("1", "1");
		//
		// System.out.println(testMap.remove("1"));
		// System.out.println(testMap.remove("1"));
		// System.out.println(testMap.remove("1"));

		// System.out.println(buildExcludeBrokerIds2(null, null));
		// System.out.println(buildExcludeBrokerIds2(null, "3,4"));
		// System.out.println(buildExcludeBrokerIds2("1,2", null));
		// System.out.println(buildExcludeBrokerIds2("1,2", "3,4"));
		// System.out.println(buildExcludeBrokerIds2(buildExcludeBrokerIds(null,
		// "3,4"), "3,4"));

		// String line =
		// "Index |SLE|     Return_Type|Trading_Code   |UTI_Number        |Stock_Code          |ISIN_Code           |           Side|       Quantity|               Unit_Price|         Customer_Account|dd_Lot_Broker_Number|       Internal_Reference|          Exchange_Number|      Confirmation_Flag|ade_Class_Origin|arket_Code|      Trade_Class_Short_Sell|           Trade_Class_Hedge|ddlot_Boardlot_Order|outing_Ref|r_Status|     Order_Time|      Remain_Qty|Number_Of_Trade|                Avg_Price| Order_Status|_Order_User_Ref|Cumulative_Qte|rade_Phase|                Exe_Price|        Exe_Qty|                Trade_Num|                 Exe_Time|revious_Exch_No|                 Ack_Type|          Time_Trade_Book|Type_Ack|        Old_Qty|                Old_Price|               Rejet_Code|               Rejet_Time|            Rejet_Command|    Broker_Comment|                  Free_Txt_Order|            Trade_Num_Ref|      Broker_ID|      Server_ID|   Counter_Part|  Sub_Status|    POrdID|dType|    ETFQty|     HOUSE_AC_ID|";
		// String glFileHeaderEnd = "SUB_STATUS|";
		// if (!line.toUpperCase().startsWith("INDEX") ||
		// !line.toUpperCase().endsWith(glFileHeaderEnd)){
		//
		// System.out.println("error");
		// }

		// String primaryFolder = "/";
		// int length = primaryFolder.length();
		// if (length > 1
		// && SYSTEM_SEPARATOR.equals(primaryFolder.substring(length - 1))) {
		// System.out.print(primaryFolder.substring(0, length - 1));
		// } else {
		// System.out.print(primaryFolder);
		// }

		// FileInputStream fis = new FileInputStream("D:/Serveur_20110826.txt");
		//
		// LineNumberReader reader = new LineNumberReader(new
		// InputStreamReader(fis));
		//
		// reader.getLineNumber();
		//
		// String content = null;
		// try {
		// while ((content = reader.readLine()) != null) {
		// System.out.println(content);
		// }
		// } catch (IOException e) {
		// }

		// Date date = new Date();
		// System.out.println(date);
		// System.out.println(new Date(date.getTime()));

		// Set<Integer> s = new TreeSet<Integer>();
		// List<Integer> l = new ArrayList<Integer>();
		// for (int i = -3; i < 3; ++i) {
		// s.add(i);
		// l.add(i);
		// }
		// for (int i = 0; i < 3; ++i) {
		// s.remove(i);
		// l.remove(i);
		// }
		// System.out.println(s + " " + l);

		// Map<Long, Map<Date, Boolean>> typhoonDateCache = new HashMap<Long,
		// Map<Date, Boolean>>();
		//
		// // Map<Date, Boolean> value1 = new HashMap<Date, Boolean>();
		// // Calendar cal1 = new GregorianCalendar(2010, 6, 7);// 2010-07-07
		// // value1.put(cal1.getTime(), true);
		// //
		// // Map<Date, Boolean> value2 = new HashMap<Date, Boolean>();
		// // Calendar cal2 = new GregorianCalendar(2010, 6, 8);// 2010-07-07
		// // value1.put(cal2.getTime(), false);
		// //
		// // useCache.put(4L, value1);
		// // useCache.put(5L, value2);
		//
		// Long marketId = 4L;
		// Date businessDate = new GregorianCalendar(2010, 6, 7).getTime();
		//
		// // 1
		// if (typhoonDateCache.containsKey(marketId)) {
		// Map<Date, Boolean> result = typhoonDateCache.get(marketId);
		//
		// if (result.containsKey(businessDate)) {
		// if (result.get(businessDate)) {
		// System.out.println("find it");
		// // override
		// } else {
		// // no-op
		// }
		// } else {
		// System.out.println("no businessDate...");
		//
		// Boolean isTyphoonDate = true;// true from call method..
		// result.put(businessDate, isTyphoonDate);
		//
		// typhoonDateCache.put(marketId, result);
		//
		// if (isTyphoonDate) {
		// // override
		// }
		// }
		// } else {
		// System.out.println("no market...");
		//
		// Boolean isTyphoonDate = true;// true from call method..
		//
		// Map<Date, Boolean> value = new HashMap<Date, Boolean>();
		// value.put(businessDate, isTyphoonDate);
		//
		// typhoonDateCache.put(marketId, value);
		//
		// if (isTyphoonDate) {
		// // override
		// }
		// }
		//
		// System.out.println(typhoonDateCache);
		//
		// // 2
		// if (typhoonDateCache.containsKey(marketId)) {
		// Map<Date, Boolean> result = typhoonDateCache.get(marketId);
		//
		// if (result.containsKey(businessDate)) {
		// if (result.get(businessDate)) {
		// System.out.println("find it");
		// // override
		// } else {
		// // no-op
		// }
		// } else {
		// System.out.println("no businessDate...");
		//
		// Boolean isTyphoonDate = true;// true from call method..
		// result.put(businessDate, isTyphoonDate);
		//
		// typhoonDateCache.put(marketId, result);
		//
		// if (isTyphoonDate) {
		// // override
		// }
		// }
		// } else {
		// System.out.println("no market...");
		//
		// Boolean isTyphoonDate = true;// true from call method..
		//
		// Map<Date, Boolean> value = new HashMap<Date, Boolean>();
		// value.put(businessDate, isTyphoonDate);
		//
		// typhoonDateCache.put(marketId, value);
		//
		// if (isTyphoonDate) {
		// // override
		// }
		// }
		//
		// // 3
		// businessDate = new GregorianCalendar(2010, 6, 8).getTime();
		// if (typhoonDateCache.containsKey(marketId)) {
		// Map<Date, Boolean> result = typhoonDateCache.get(marketId);
		//
		// if (result.containsKey(businessDate)) {
		// if (result.get(businessDate)) {
		// System.out.println("find it");
		// // override
		// } else {
		// // no-op
		// }
		// } else {
		// System.out.println("no businessDate...");
		//
		// Boolean isTyphoonDate = true;// true from call method..
		// result.put(businessDate, isTyphoonDate);
		//
		// typhoonDateCache.put(marketId, result);
		//
		// if (isTyphoonDate) {
		// // override
		// }
		// }
		// } else {
		// System.out.println("no market...");
		//
		// Boolean isTyphoonDate = true;// true from call method..
		//
		// Map<Date, Boolean> value = new HashMap<Date, Boolean>();
		// value.put(businessDate, isTyphoonDate);
		//
		// typhoonDateCache.put(marketId, value);
		//
		// if (isTyphoonDate) {
		// // override
		// }
		// }
		//
		// System.out.println(typhoonDateCache);
		//
		// marketId = 5L;
		// if (typhoonDateCache.containsKey(marketId)) {
		// Map<Date, Boolean> result = typhoonDateCache.get(marketId);
		//
		// if (result.containsKey(businessDate)) {
		// if (result.get(businessDate)) {
		// System.out.println("find it");
		// // override
		// } else {
		// // no-op
		// }
		// } else {
		// System.out.println("no businessDate...");
		//
		// Boolean isTyphoonDate = true;// true from call method..
		// result.put(businessDate, isTyphoonDate);
		//
		// typhoonDateCache.put(marketId, result);
		//
		// if (isTyphoonDate) {
		// // override
		// }
		// }
		// } else {
		// System.out.println("no market...");
		//
		// Boolean isTyphoonDate = true;// true from call method..
		//
		// Map<Date, Boolean> value = new HashMap<Date, Boolean>();
		// value.put(businessDate, isTyphoonDate);
		//
		// typhoonDateCache.put(marketId, value);
		//
		// if (isTyphoonDate) {
		// // override
		// }
		// }
		//
		// System.out.println(typhoonDateCache);

		// // Map<Long, Date> useCache = new HashMap<Long, Date>(); //
		// <marketId, businessDate>
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
		// System.out.println(collection.contains(new GregorianCalendar(2010, 6,
		// 9).getTime()));

		// String line
		// ="100082CNE1000003V0SI 20100915P63715615CC00010PB       100000005000 0000000295976-HKD 0001172954              0000000000000                 0000002042013510.30.57.144729     /";
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
		// System.out.println(fileName1.substring(0,
		// fileName1.lastIndexOf("_")).equalsIgnoreCase("EOD_POS_HTICASH"));
		// System.out.println(fileName1.substring(fileName1.lastIndexOf("_") +
		// 1));
		//
		//
		// } else{
		// System.out.println(false);
		// }

		// System.out.println(FilenameUtils.removeExtension(fileName1));

		// String pattern = "";// "eod_pos_HTICASH_" + "{0}";
		// SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		// System.out.println(MessageFormat.format(pattern,
		// dateFormat.format(new Date())));

		// String str= "1x";
		// System.out.println(new BigDecimal(str));
		// BigDecimal b1 = BigDecimal.ONE;
		// BigDecimal b2 = BigDecimal.TEN;
		//
		// System.out.println(b1 == null ? b2 == null : b2 != null &&
		// b1.compareTo(b2) == 0);

		// System.out.println(new BigDecimal("1200.353").divide(new
		// BigDecimal("33"), 4));
		// System.out.println(new BigDecimal("1200.353").divide(new
		// BigDecimal("33"), BigDecimal.ROUND_HALF_UP));
		// System.out.println(new BigDecimal("1200.353").divide(new
		// BigDecimal("33"), 4, 4));
		// System.out.println(new BigDecimal("1200.353").divide(new
		// BigDecimal("33"), 4, BigDecimal.ROUND_HALF_UP));

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

		// String excludedWords
		// =".svn | target | .classpath | .project | .settings";
		//
		// List<String> excludedKeys = new ArrayList<String>();
		//
		// if (StringUtils.isNotBlank(excludedWords)) {
		// excludedKeys.addAll(Arrays.asList(excludedWords.split("\\s" +
		// SPILT_CHAR.trim() + "\\s")));
		// }
		//
		// System.out.println(excludedKeys.size());

		// List<String> locationCodes = new ArrayList<String>();
		// locationCodes.add("DSB");
		// locationCodes.add("CCASS");
		// System.out.println(ViewTradeBalanceReconciliationReportDaoImplOracleTest.join(locationCodes,
		// ","));

		// String[] split = StringUtils.split(temps.toString(), ",\\S*");

		// List<Long> brokerAccountList = new ArrayList<Long>();
		// brokerAccountList.add(1L);
		// brokerAccountList.add(2L);
		//
		// System.out.println(brokerAccountList);
		// String tempBrokerAccountIds = brokerAccountList.toString();
		// System.out.println(tempBrokerAccountIds.substring(1,
		// tempBrokerAccountIds.length() - 1));
		// String[] split = tempBrokerAccountIds.substring(1,
		// tempBrokerAccountIds.length() - 1).split(","); // remove array '['
		// and ']';
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
// String[] parseLine =
// parser.parseLine("\"02-0002156-30\",\"B\",\"C\",\"A\",\"505\",\"09/14/2010\"");
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

