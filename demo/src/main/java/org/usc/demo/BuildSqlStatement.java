package org.usc.demo;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement {

	public static void main(String[] args) {

		// String templte =
		// "INSERT INTO `bellepics` VALUES ('%s', '%s', '1151286370656333122.jpg', '1151286370656332993.jpg', null, null, '2012-04-13 11:22:56', 'jasonzhang');";
		//
		// for (int i = 0; i <= 499; i++) {
		// System.out.println(String.format(templte, i + 1, i / 5 + 1));
		// }
		// String templte =
		// "INSERT INTO `belleinfo` VALUES ('%s', '%s', '赵康婕%s', '170', '83', '58', '87', '20', '舞蹈、唱歌', '只要你确信自己正确就去做', '通往梦想的路已踩在脚下，请支持我', 'http://weibo.com/2033364664', 'http://f1.flv.kankan.xunlei.com/data/xunlei_up_sflv/35/c71f6c8cc37202e26f43603b3697c54bc95a27e1_1.flv', '1151286370656332993.jpg', '1151286370656333122.jpg', '1151286370656332993.jpg', '', '', '2012-04-13 11:22:56', 'jasonzhang', '2012-04-13 12:35:45', 'jasonzhang');";
		//
		// for (int i = 1; i <= 40; i++) {
		// System.out.println(String.format(templte, i, i, i));
		// System.out.println();
		// }

		String pic1 = "INSERT INTO `bellepics` VALUES ('%s', '%s', '1151286372573796214.JPG', '1151286372573796149.JPG', '', '', '2012-04-13 18:32:02', 'jasonzhang');";
		String pic2 = "INSERT INTO `bellepics` VALUES ('%s', '%s', '1151286372571714932.JPG', '1151286372571714803.JPG', '', '', '2012-04-13 18:31:34', 'jasonzhang');";
		String pic3 = "INSERT INTO `bellepics` VALUES ('%s', '%s', '1151286372571714162.JPG', '1151286372571714097.JPG', '', '', '2012-04-13 18:31:34', 'jasonzhang');";
		String pic4 = "INSERT INTO `bellepics` VALUES ('%s', '%s', '1151286372570216496.JPG', '1151286372570216431.JPG', '', '', '2012-04-13 18:31:11', 'jasonzhang');";
		String pic5 = "INSERT INTO `bellepics` VALUES ('%s', '%s', '1151286372570215918.JPG', '1151286372570215853.JPG', '', '', '2012-04-13 18:31:11', 'jasonzhang');";
		String pic6 = "INSERT INTO `bellepics` VALUES ('%s', '%s', '1151286372573798456.jpg', '1151286372573797879.jpg', '', '', '2012-04-13 18:32:02', 'jasonzhang');";

//        INSERT INTO `loginnotice` VALUES ('5', 'test', 'test', 'test', '20120507', '16:04:13');
		int seq = 1;
		for (int i = 1; i <= 40; i++) {
			System.out.println(String.format(pic1, seq++, i));
			System.out.println(String.format(pic2, seq++, i));
			System.out.println(String.format(pic3, seq++, i));
			System.out.println(String.format(pic4, seq++, i));
			System.out.println(String.format(pic5, seq++, i));
			System.out.println(String.format(pic6, seq++, i));
		}

	}
}
