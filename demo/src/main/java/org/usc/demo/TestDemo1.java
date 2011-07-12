package org.usc.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * 
 * @author ShunLi
 */
public class TestDemo1 {

	@Test
	public void test7() {
		String str = "{}dd{dadj12{1232{3jlk{da2}3}}";

		// /\\{[^\\}]+\\}/");
		// Pattern p = Pattern.compile("\\{[^\\{]+}");
		// Matcher m = p.matcher(str);
		// StringBuffer stringBuffer = new StringBuffer();

		Pattern p2 = Pattern.compile("\\{");
		Matcher m2 = p2.matcher(str);

		System.out.println(m2.groupCount());

		while (m2.find()) {
			// m.appendReplacement(stringBuffer, "");
			System.out.println("hello");
		}
		// while(m2.lookingAt()){
		// System.out.println("Hello");
		// }

		// System.out.println(stringBuffer.toString());
	}

	// more used
	@Test
	public void test1() {
		String str = "{}dd{dadj12{1232{3jlk{da2}3}}";
		List<String> heap = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			if ("{".equals(String.valueOf(str.charAt(i)))) {
				heap.add("{");
			}
			if ("}".equals(String.valueOf(str.charAt(i)))) {
				try {
					heap.remove(0);
				} catch (Exception e) {
					System.out.println("} must be before {");
					System.exit(0);
				}
			}
		}

		if (!heap.isEmpty()) {
			System.out.println("not matching");
		} else {
			System.out.println("match");
		}

	}

	@Test
	public void test5() {

	}

	@Test
	public void test4() {
		String sql = "SELECT COUNT(p)  from Person p  join   FetCH  p.emails email WHERE 1 = 1  AND p.id LIKE :id  ";

		System.out.println(sql.replaceAll("(?i)JOIN\\s+FETCH", "JOIN"));

	}

	@Test
	public void test3() {

		List<String> names = new ArrayList<String>();
		names.addAll(Arrays.asList("li", "shunli"));

		Foo foo1 = new Foo(1, names);

		// Foo foo2 = (Foo) foo1.clone();
		Foo foo2 = new Foo();// (Foo) BeanUtils.cloneBean(foo1);
		// Foo foo2 = (Foo) BeanUtils.cloneBean(foo1);

		System.out.println(foo1);
		System.out.println(foo2);
		//
		BeanUtils.copyProperties(foo1, null);
		System.out.println(foo1.getName() == foo2.getName());
		// System.out.println(foo1);
		// System.out.println(foo2);
		//
		// foo1.setI(2);
		// foo1.getName().add("lishunli");
		//
		// System.out.println(foo1);
		// System.out.println(foo2);
		//
		System.out.println(foo1);
		System.out.println(foo2);

		foo2.setI(2);
		foo2.getName().add("lishunli");

		System.out.println(foo1);
		System.out.println(foo2);

		BeanUtils.copyProperties(foo2, foo1);

		System.out.println(foo1);
		System.out.println(foo2);
		//
		// foo2.setI(3);
		//
		// System.out.println(foo1);
		// System.out.println(foo2);

		// DozerBeanMapper mapper = new DozerBeanMapper();
		// mapper.map(foo1, foo2);
		//
		// System.out.println(foo1.getName() == foo2.getName());
		//
		// System.out.println(foo1);
		// System.out.println(foo2);
		//
		// foo1.setI(2);
		// foo1.getName().add("lishunli");
		//
		// System.out.println(foo1);
		// System.out.println(foo2);
		//
		// mapper.map(foo1, foo2);
		// System.out.println(foo1);
		// System.out.println(foo2);
		//
		// foo2.setI(3);
		//
		// System.out.println(foo1);
		// System.out.println(foo2);
	}

	@Test
	public void test2() {
		BigDecimal b1 = new BigDecimal("1.23456");
		BigDecimal b2 = new BigDecimal(1.2345635165446);
		System.out.println(b1.add(b2.setScale(8, RoundingMode.HALF_UP)));

		System.out.println(new Date(System.currentTimeMillis()));
		System.out.println(new Date());

		System.out.println("EO000000005".substring(2, 3));

		DecimalFormat myFormatter = new DecimalFormat("00000000");

		System.out.println(myFormatter.format(10L));
		System.out.println(myFormatter.format(100000002L));

		Date date = new Date();

		System.out.println(date);

		System.out.println(DateUtils.addDays(date, 1));
		System.out.println(DateUtils.addDays(date, -1));

		System.out.println(DateUtils.truncate(date, Calendar.MONTH));

		System.out.println(DateUtils.RANGE_MONTH_MONDAY);
	}

	@Test
	public void test8() {
		Pattern patt = Pattern.compile("(\\w+)[\\s]*(\\d+)");
		Matcher matcher = patt.matcher("Bananas123");
		matcher.lookingAt();
		System.out.println("Name: " + matcher.group(1));
		System.out.println("Number: " + matcher.group(2));
	}

	public static class Foo {
		private int i;
		private List<String> name;

		public Foo() {
		}

		public Foo(int i, List<String> name) {
			this.i = i;
			this.name = name;
		}

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		public List<String> getName() {
			return name;
		}

		public void setName(List<String> name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Foo [i=" + i + "," + (name != null ? "name=" + name : "") + "]";
		}

	}

}
