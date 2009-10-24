package org.usc.javautils.string;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

/**
 * StringUtil, �ַ���������, һЩ������ַ������߷���.
 * 
 * Dependencies: Servlet/JSP API.
 * 
 * @author ������
 * @version 1.3 2009-03-8
 */
public class StringUtil
{

	/**
	 * ��ʽ��С���������ٺ����С����.
	 * 
	 * @param num
	 * @param minFractionDigits
	 * @param maxFractionDigits
	 * @return
	 */
	public static String formatFraction(double num, int minFractionDigits,
			int maxFractionDigits)
	{
		// ����̶�С����λ��
		java.text.NumberFormat nb = java.text.NumberFormat.getInstance();
		nb.setMaximumFractionDigits(maxFractionDigits);
		nb.setMinimumFractionDigits(minFractionDigits);
		nb.setGroupingUsed(false);
		String rate = nb.format(num);

		return rate;
	}

	/**
	 * �������л�ȡ��ǰҳ����.
	 * 
	 * @param request
	 * @return ҳ����, ��С��1
	 */
	public static int getCurrentPage(HttpServletRequest request)
	{
		String pname = "cp";
		// ��ȡҳ����
		if (request.getParameter(pname) != null
				&& !"".equals(request.getParameter(pname)))
		{
			return Integer.parseInt(request.getParameter(pname));
		} else
		{
			return 1;
		}
	}

	/**
	 * ������ʱ���ƶ�����·�.
	 * 
	 * @param beginDate
	 *            ��ʼ����
	 * @param amount
	 *            ����
	 * @return �������
	 */
	public static Date moveMonth(Date beginDate, int amount)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(beginDate);

		cal.add(Calendar.MONTH, amount);

		return cal.getTime();
	}

	/**
	 * �������ַ���ʱ���ƶ�����·�.
	 * 
	 * @param year
	 *            ���ַ���
	 * @param month
	 *            ��
	 * @param amount
	 *            ����
	 * @return int[ ��, �� ]
	 */
	public static int[] moveMonth(String year, String month, int amount)
	{
		Date d = moveMonth(parseDate(year + "/" + month, "yyyy/MM"), amount);

		Calendar cal = Calendar.getInstance();
		cal.setTime(d);

		return new int[]
		{ cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) };
	}

	/**
	 * ��������.
	 * 
	 * @param input
	 *            �����ַ���
	 * @param pattern
	 *            ����
	 * @return Date ����
	 */
	public static Date parseDate(String input, String pattern)
	{
		if (isEmpty(input))
		{
			return null;
		}

		SimpleDateFormat df = new SimpleDateFormat(pattern);

		try
		{
			return df.parse(input);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * ��ʽ������Ϊ�ַ���.
	 * 
	 * @param date
	 *            �����ַ���
	 * @param pattern
	 *            ����
	 * @return ����ַ���
	 */
	public static String formatDate(Date date, String pattern)
	{
		if (date == null || pattern == null)
		{
			return null;
		}
		return new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * Same function as javascript's escape().
	 * 
	 * @param src
	 * @return
	 */
	public static String escape(String src)
	{
		int i;
		char j;
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length() * 6);
		for (i = 0; i < src.length(); i++)
		{
			j = src.charAt(i);
			if (Character.isDigit(j) || Character.isLowerCase(j)
					|| Character.isUpperCase(j))
				tmp.append(j);
			else if (j < 256)
			{
				tmp.append("%");
				if (j < 16)
					tmp.append("0");
				tmp.append(Integer.toString(j, 16));
			} else
			{
				tmp.append("%u");
				tmp.append(Integer.toString(j, 16));
			}
		}
		return tmp.toString();
	}

	/**
	 * Same function as javascript's unsecape().
	 * 
	 * @param src
	 * @return
	 */
	public static String unescape(String src)
	{
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;
		while (lastPos < src.length())
		{
			pos = src.indexOf("%", lastPos);
			if (pos == lastPos)
			{
				if (src.charAt(pos + 1) == 'u')
				{
					ch = (char) Integer.parseInt(src
							.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				} else
				{
					ch = (char) Integer.parseInt(src
							.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			} else
			{
				if (pos == -1)
				{
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				} else
				{
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}
		return tmp.toString();
	}

	/**
	 * ��ȡ��·���е���Դ�ļ��������ļ�·��. NOTE: ���� Win32 ƽ̨�²���ͨ������.
	 * 
	 * @date 2005.10.16
	 * @param resourcePath
	 *            ��Դ·��
	 * @return �����ļ�·��
	 */
	public static String getRealFilePath(String resourcePath)
	{
		java.net.URL inputURL = StringUtil.class.getResource(resourcePath);

		String filePath = inputURL.getFile();

		// 2007-02-08 Fixed by K.D. to solve the space char problem, also with
		// some
		// other special chars in path problem
		try
		{
			filePath = java.net.URLDecoder.decode(filePath, "utf-8");
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		// For windows platform, the filePath will like this:
		// /E:/Push/web/WEB-INF/classes/studio/beansoft/smtp/MailSender.ini
		// So must remove the first /

		// if(OS.isWindows() && filePath.startsWith("/")) {
		// filePath = filePath.substring(1);
		// }

		return filePath;
	}

	/**
	 * ���ַ���ת��Ϊ int.
	 * 
	 * @param input
	 *            ������ִ�
	 * @date 2005-07-29
	 * @return �������
	 */
	public static int parseInt(String input)
	{
		try
		{
			return Integer.parseInt(input);
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		return 0;
	}

	/**
	 * ���ַ���ת��Ϊ long.
	 * 
	 * @param input
	 *            ������ִ�
	 * @return �������
	 */
	public static long parseLong(String input)
	{
		try
		{
			return Long.parseLong(input);
		} catch (Exception e)
		{
		}
		return 0;
	}

	/**
	 * ���ַ���ת��Ϊ long.
	 * 
	 * @param input
	 *            ������ִ�
	 * @return �������
	 */
	public static double parseDouble(String input)
	{
		try
		{
			return Double.parseDouble(input);
		} catch (Exception e)
		{
		}
		return 0;
	}

	/**
	 * ��ʽ�����ڵ���ʱ����ʱ���ʽ����ʾ. d�� HH:mm:ss
	 * 
	 * @return - String ��ʽ�����ʱ��
	 */
	public static String formatDateToDHMSString(java.util.Date date)
	{
		if (date == null)
		{
			return "";
		}

		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
				"d�� HH:mm:ss");

		return dateFormat.format(date);

	}

	/**
	 * ��ʽ�����ڵ�ʱ����ʱ���ʽ����ʾ.
	 * 
	 * @return - String ��ʽ�����ʱ��
	 */
	public static String formatDateToHMSString(java.util.Date date)
	{
		if (date == null)
		{
			return "";
		}

		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
				"HH:mm:ss");

		return dateFormat.format(date);

	}

	/**
	 * ��ʱ����ʱ���ʽ���ַ���ת��Ϊ����.
	 * 
	 * @param input
	 * @return
	 */
	public static Date parseHMSStringToDate(String input)
	{
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
				"HH:mm:ss");

		try
		{
			return dateFormat.parse(input);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * ��ʽ�����ڵ� Mysql ���ݿ����ڸ�ʽ�ַ�������ʾ.
	 * 
	 * @return - String ��ʽ�����ʱ��
	 */
	public static String formatDateToMysqlString(java.util.Date date)
	{
		if (date == null)
		{
			return "";
		}

		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		return dateFormat.format(date);

	}

	/**
	 * �� Mysql ���ݿ����ڸ�ʽ�ַ���ת��Ϊ����.
	 * 
	 * @param input
	 * @return
	 */
	public static Date parseStringToMysqlDate(String input)
	{
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		try
		{
			return dateFormat.parse(input);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * ����ʱ���ַ���, �ɶ���ʽ��, M��d�� HH:mm ��ʽ. 2004-09-22, LiuChangjiong
	 * 
	 * @return - String ��ʽ�����ʱ��
	 */
	public static String formatDateToMMddHHmm(java.util.Date date)
	{
		if (date == null)
		{
			return "";
		}

		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
				"M��d�� HH:mm");

		return dateFormat.format(date);
	}

	/**
	 * ����ʱ���ַ���, �ɶ���ʽ��, yy��M��d��HH:mm ��ʽ. 2004-10-04, LiuChangjiong
	 * 
	 * @return - String ��ʽ�����ʱ��
	 */
	public static String formatDateToyyMMddHHmm(java.util.Date date)
	{
		if (date == null)
		{
			return "";
		}

		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
				"yy��M��d��HH:mm");

		return dateFormat.format(date);
	}

	/**
	 * ���� HTTP ����� Referer, ���û��, �ͷ���Ĭ��ҳ��ֵ.
	 * 
	 * �������ƶ����Ϳ���ҳ���������: // Added at 2004-10-12 // ���ǰһҳ��ĵ�ַ���� _action.jsp ,
	 * Ϊ�˱������ӳ���, �ͷ���Ĭ��ҳ��
	 * 
	 * 2006-08-02 ���Ӵ� url ���� referer ���ж�
	 * 
	 * @param request
	 *            - HttpServletRequest ����
	 * @param defaultPage
	 *            - String, Ĭ��ҳ��
	 * @return String - Referfer
	 */
	public static String getReferer(HttpServletRequest request,
			String defaultPage)
	{
		String referer = request.getHeader("Referer");// ǰһҳ��ĵ�ַ, �ύ�����󷵻ش�ҳ��

		// ��ȡURL�е�referer����
		String refererParam = request.getParameter("referer");

		if (!isEmpty(refererParam))
		{
			referer = refererParam;
		}

		// Added at 2004-10-12
		// ���ǰһҳ��ĵ�ַ���� _action.jsp , Ϊ�˱������ӳ���, �ͷ���Ĭ��ҳ��
		if (isEmpty(referer) || referer.indexOf("_action.jsp") != -1)
		{
			referer = defaultPage;
		}

		return referer;
	}

	/**
	 * ����һ�� 18 λ�� yyyyMMddHHmmss.SSS ��ʽ�������ַ���.
	 * 
	 * @param date
	 *            Date
	 * @return String
	 */
	public static String genTimeStampString(Date date)
	{
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(
				"yyyyMMddHHmmss.SSS");
		return df.format(date);
	}

	/**
	 * Write the HTML base tag to support servlet forward calling relative path
	 * changed problems.
	 * 
	 * Base is used to ensure that your document's relative links are associated
	 * with the proper document path. The href specifies the document's
	 * reference URL for associating relative URLs with the proper document
	 * path. This element may only be used within the HEAD tag. Example: <BASE
	 * HREF="http://www.sample.com/hello.htm">
	 * 
	 * @param pageContext
	 *            the PageContext of the jsp page object
	 */
	public static void writeHtmlBase(PageContext pageContext)
	{
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		StringBuffer buf = new StringBuffer("<base href=\"");
		buf.append(request.getScheme());
		buf.append("://");
		buf.append(request.getServerName());
		buf.append(":");
		buf.append(request.getServerPort());
		buf.append(request.getRequestURI());
		buf.append("\">");
		JspWriter out = pageContext.getOut();
		try
		{
			out.write(buf.toString());
		} catch (java.io.IOException e)
		{

		}
	}

	/**
	 * Get the base path of this request.
	 * 
	 * @param request
	 *            - HttpServletRequest
	 * @return String - the base path, eg: http://www.abc.com:8000/someApp/
	 */
	public static String getBasePath(HttpServletRequest request)
	{
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		return basePath;
	}

	/**
	 * Get the current page's full path of this request. ��ȡ��ǰҳ���������� URL ·��.
	 * 
	 * @author BeanSoft
	 * @date 2005-08-01
	 * @param request
	 *            - HttpServletRequest
	 * @return String - the full url path, eg:
	 *         http://www.abc.com:8000/someApp/index.jsp?param=abc
	 */
	public static String getFullRequestURL(HttpServletRequest request)
	{
		StringBuffer url = request.getRequestURL();
		String qString = request.getQueryString();

		if (qString != null)
		{
			url.append('?');
			url.append(qString);
		}

		return url.toString();
	}

	/**
	 * Get the current page's full path of this request. ��ȡ��ǰҳ���������� URI ·��.
	 * 
	 * @author BeanSoft
	 * @date 2005-08-01
	 * @param request
	 *            - HttpServletRequest
	 * @return String - the full uri path, eg: /someApp/index.jsp?param=abc
	 */
	public static String getFullRequestURI(HttpServletRequest request)
	{
		StringBuffer url = new StringBuffer(request.getRequestURI());
		String qString = request.getQueryString();

		if (qString != null)
		{
			url.append('?');
			url.append(qString);
		}

		return url.toString();
	}

	// ------------------------------------ �ַ���������
	// ----------------------------------------------

	/**
	 * ���ַ��� source �е� oldStr �滻Ϊ newStr, ���Դ�Сд���з�ʽ���в���
	 * 
	 * @param source
	 *            ��Ҫ�滻��Դ�ַ���
	 * @param oldStr
	 *            ��Ҫ���滻�����ַ���
	 * @param newStr
	 *            �滻Ϊ�����ַ���
	 */
	public static String replace(String source, String oldStr, String newStr)
	{
		return replace(source, oldStr, newStr, true);
	}

	/**
	 * ���ַ��� source �е� oldStr �滻Ϊ newStr, matchCase Ϊ�Ƿ����ô�Сд���в���
	 * 
	 * @param source
	 *            ��Ҫ�滻��Դ�ַ���
	 * @param oldStr
	 *            ��Ҫ���滻�����ַ���
	 * @param newStr
	 *            �滻Ϊ�����ַ���
	 * @param matchCase
	 *            �Ƿ���Ҫ���մ�Сд���з�ʽ����
	 */
	public static String replace(String source, String oldStr, String newStr,
			boolean matchCase)
	{
		if (source == null)
		{
			return null;
		}
		// ���ȼ����ַ����Ƿ����, �����ھͲ������滻
		if (source.toLowerCase().indexOf(oldStr.toLowerCase()) == -1)
		{
			return source;
		}
		int findStartPos = 0;
		int a = 0;
		while (a > -1)
		{
			int b = 0;
			String str1, str2, str3, str4, strA, strB;
			str1 = source;
			str2 = str1.toLowerCase();
			str3 = oldStr;
			str4 = str3.toLowerCase();
			if (matchCase)
			{
				strA = str1;
				strB = str3;
			} else
			{
				strA = str2;
				strB = str4;
			}
			a = strA.indexOf(strB, findStartPos);
			if (a > -1)
			{
				b = oldStr.length();
				findStartPos = a + b;
				StringBuffer bbuf = new StringBuffer(source);
				source = bbuf.replace(a, a + b, newStr) + "";
				// �µĲ��ҿ�ʼ��λ���滻����ַ����Ľ�β
				findStartPos = findStartPos + newStr.length() - b;
			}
		}
		return source;
	}

	/**
	 * ����ַ�����β�Ŀո�.
	 * 
	 * @param input
	 *            String ������ַ���
	 * @return ת�����
	 */
	public static String trimTailSpaces(String input)
	{
		if (isEmpty(input))
		{
			return "";
		}

		String trimedString = input.trim();

		if (trimedString.length() == input.length())
		{
			return input;
		}

		return input.substring(0, input.indexOf(trimedString)
				+ trimedString.length());
	}

	/**
	 * Change the null string value to "", if not null, then return it self, use
	 * this to avoid display a null string to "null".
	 * 
	 * @param input
	 *            the string to clear
	 * @return the result
	 */
	public static String clearNull(String input)
	{
		return isEmpty(input) ? "" : input;
	}

	/**
	 * Return the limited length string of the input string (added at:April 10,
	 * 2004).
	 * 
	 * @param input
	 *            String
	 * @param maxLength
	 *            int
	 * @return String processed result
	 */
	public static String limitStringLength(String input, int maxLength)
	{
		if (isEmpty(input))
			return "";

		if (input.length() <= maxLength)
		{
			return input;
		} else
		{
			return input.substring(0, maxLength - 3) + "...";
		}

	}

	/**
	 * ���ַ���ת��Ϊһ�� JavaScript �� alert ����. eg: htmlAlert("What?"); returns
	 * &lt;SCRIPT language="JavaScript"&gt;alert("What?")&lt;/SCRIPT&gt;
	 * 
	 * @param message
	 *            ��Ҫ��ʾ����Ϣ
	 * @return ת�����
	 */
	public static String scriptAlert(String message)
	{
		return "<SCRIPT language=\"JavaScript\">alert(\"" + message
				+ "\");</SCRIPT>";
	}

	/**
	 * ���ַ���ת��Ϊһ�� JavaScript �� document.location �ı����. eg: htmlAlert("a.jsp");
	 * returns &lt;SCRIPT
	 * language="JavaScript"&gt;document.location="a.jsp";&lt;/SCRIPT&gt;
	 * 
	 * @param url
	 *            ��Ҫ��ʾ�� URL �ַ���
	 * @return ת�����
	 */
	public static String scriptRedirect(String url)
	{
		return "<SCRIPT language=\"JavaScript\">document.location=\"" + url
				+ "\";</SCRIPT>";
	}

	/**
	 * ���ؽű���� &lt;SCRIPT language="JavaScript"&gt;history.back();&lt;/SCRIPT&gt;
	 * 
	 * @return �ű����
	 */
	public static String scriptHistoryBack()
	{
		return "<SCRIPT language=\"JavaScript\">history.back();</SCRIPT>";
	}

	/**
	 * �˳������е�Σ�� HTML ����, ��Ҫ�ǽű�����, ������Ļ�����Լ��ű��¼��������
	 * 
	 * @param content
	 *            ��Ҫ�˳����ַ���
	 * @return ���˵Ľ��
	 */
	public static String replaceHtmlCode(String content)
	{
		if (isEmpty(content))
		{
			return "";
		}
		// ��Ҫ�˳��Ľű��¼��ؼ���
		String[] eventKeywords =
		{ "onmouseover", "onmouseout", "onmousedown", "onmouseup",
				"onmousemove", "onclick", "ondblclick", "onkeypress",
				"onkeydown", "onkeyup", "ondragstart", "onerrorupdate",
				"onhelp", "onreadystatechange", "onrowenter", "onrowexit",
				"onselectstart", "onload", "onunload", "onbeforeunload",
				"onblur", "onerror", "onfocus", "onresize", "onscroll",
				"oncontextmenu" };
		content = replace(content, "<script", "&ltscript", false);
		content = replace(content, "</script", "&lt/script", false);
		content = replace(content, "<marquee", "&ltmarquee", false);
		content = replace(content, "</marquee", "&lt/marquee", false);
		// FIXME ��������˻��е� BR �Ĺ��ܻ��ԭʼ HTML ������� 2006-07-30
		// content = replace(content, "\r\n", "<BR>");
		// �˳��ű��¼�����
		for (int i = 0; i < eventKeywords.length; i++)
		{
			content = replace(content, eventKeywords[i],
					"_" + eventKeywords[i], false); // ���һ��"_", ʹ�¼�������Ч
		}
		return content;
	}

	/**
	 * �˳� HTML ���� Ϊ�ı�����.
	 */
	public static String replaceHtmlToText(String input)
	{
		if (isEmpty(input))
		{
			return "";
		}
		return setBr(setTag(input));
	}

	/**
	 * �˳� HTML ���. ��Ϊ XML ��ת���ַ���Ȼ��Ч, ��˰������ַ����˳����ĵ�ȫ���ַ�.
	 * 
	 * @author beansoft
	 * @param s
	 *            ������ִ�
	 * @return ���˺���ִ�
	 */
	public static String setTag(String s)
	{
		int j = s.length();
		StringBuffer stringbuffer = new StringBuffer(j + 500);
		char ch;
		for (int i = 0; i < j; i++)
		{
			ch = s.charAt(i);
			if (ch == '<')
			{
				stringbuffer.append("&lt");
				// stringbuffer.append("��");
			} else if (ch == '>')
			{
				stringbuffer.append("&gt");
				// stringbuffer.append("��");
			} else if (ch == '&')
			{
				stringbuffer.append("&amp");
				// stringbuffer.append("��");
			} else if (ch == '%')
			{
				stringbuffer.append("%%");
				// stringbuffer.append("��");
			} else
			{
				stringbuffer.append(ch);
			}
		}

		return stringbuffer.toString();
	}

	/** �˳� BR ���� */
	public static String setBr(String s)
	{
		int j = s.length();
		StringBuffer stringbuffer = new StringBuffer(j + 500);
		for (int i = 0; i < j; i++)
		{

			if (s.charAt(i) == '\n' || s.charAt(i) == '\r')
			{
				continue;
			}
			stringbuffer.append(s.charAt(i));
		}

		return stringbuffer.toString();
	}

	/** �˳��ո� */
	public static String setNbsp(String s)
	{
		int j = s.length();
		StringBuffer stringbuffer = new StringBuffer(j + 500);
		for (int i = 0; i < j; i++)
		{
			if (s.charAt(i) == ' ')
			{
				stringbuffer.append("&nbsp;");
			} else
			{
				stringbuffer.append(s.charAt(i) + "");
			}
		}
		return stringbuffer.toString();
	}

	/**
	 * �ж��ַ����Ƿ�ȫ�������ַ����ߵ��.
	 * 
	 * @param input
	 *            ������ַ���
	 * @return �жϽ��, true Ϊȫ����, false Ϊ���з������ַ�
	 */
	public static boolean isNumeric(String input)
	{
		if (isEmpty(input))
		{
			return false;
		}

		for (int i = 0; i < input.length(); i++)
		{
			char charAt = input.charAt(i);

			if (!Character.isDigit(charAt) && (charAt != '.'))
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * ת���ɱ���ȡ�����ݵ�����(�� ISO8859 ת���� gb2312).
	 * 
	 * @param input
	 *            ������ַ���
	 * @return ת�����, ����д�����, �򷵻�ԭ����ֵ
	 */
	public static String toChi(String input)
	{
		try
		{
			byte[] bytes = input.getBytes("ISO8859-1");
			return new String(bytes, "GBK");
		} catch (Exception ex)
		{
		}
		return input;
	}

	/**
	 * ת���ɱ���ȡ�����ݵ����뵽 ISO(�� GBK ת����ISO8859-1).
	 * 
	 * @param input
	 *            ������ַ���
	 * @return ת�����, ����д�����, �򷵻�ԭ����ֵ
	 */
	public static String toISO(String input)
	{
		return changeEncoding(input, "GBK", "ISO8859-1");
	}

	/**
	 * ת���ַ���������.
	 * 
	 * @param input
	 *            ������ַ���
	 * @param sourceEncoding
	 *            Դ�ַ�������
	 * @param targetEncoding
	 *            Ŀ���ַ�������
	 * @return ת�����, ����д�����, �򷵻�ԭ����ֵ
	 */
	public static String changeEncoding(String input, String sourceEncoding,
			String targetEncoding)
	{
		if (input == null || input.equals(""))
		{
			return input;
		}

		try
		{
			byte[] bytes = input.getBytes(sourceEncoding);
			return new String(bytes, targetEncoding);
		} catch (Exception ex)
		{
		}
		return input;
	}

	/**
	 * �������� ' ���� ''; SQL ����:����������е��ַ�������һ��Ƕ�������,����ʹ�����������ű�ʾǶ��ĵ�����.
	 */

	public static String replaceSql(String input)
	{
		return replace(input, "'", "''");
	}

	/**
	 * �Ը����ַ����� URL ����
	 */
	public static String encode(String value)
	{
		if (isEmpty(value))
		{
			return "";
		}

		try
		{
			value = java.net.URLEncoder.encode(value, "GB2312");
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return value;
	}

	/**
	 * �Ը����ַ����� URL ����
	 * 
	 * @param value
	 *            ����ǰ���ַ���
	 * @return �������ַ���
	 */
	public static String decode(String value)
	{
		if (isEmpty(value))
		{
			return "";
		}

		try
		{
			return java.net.URLDecoder.decode(value, "GB2312");
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return value;
	}

	/**
	 * �ж��ַ����Ƿ�δ��, ���Ϊ null ���߳���Ϊ0, ������ true.
	 */
	public static boolean isEmpty(String input)
	{
		return (input == null || input.length() == 0);
	}

	/**
	 * ��������ַ������ֽڳ���(���������ֽ���), ���ڷ��Ͷ���ʱ�ж��Ƿ񳬳�����.
	 * 
	 * @param input
	 *            �����ַ���
	 * @return �ַ������ֽڳ���(���� Unicode ����)
	 */
	public static int getBytesLength(String input)
	{
		if (input == null)
		{
			return 0;
		}

		int bytesLength = input.getBytes().length;

		// System.out.println("bytes length is:" + bytesLength);

		return bytesLength;
	}

	/**
	 * �����ַ����Ƿ�δ��, �����, �򷵻ظ����ĳ�����Ϣ.
	 * 
	 * @param input
	 *            ������ַ���
	 * @param errorMsg
	 *            ������Ϣ
	 * @return �մ����س�����Ϣ
	 */
	public static String isEmpty(String input, String errorMsg)
	{
		if (isEmpty(input))
		{
			return errorMsg;
		}
		return "";
	}

	/**
	 * �õ��ļ�����չ��.
	 * 
	 * @param fileName
	 *            ��Ҫ������ļ�������.
	 * @return the extension portion of the file's name.
	 */
	public static String getExtension(String fileName)
	{
		if (fileName != null)
		{
			int i = fileName.lastIndexOf('.');
			if (i > 0 && i < fileName.length() - 1)
			{
				return fileName.substring(i + 1).toLowerCase();
			}
		}
		return "";
	}

	/**
	 * �õ��ļ���ǰ׺��.
	 * 
	 * @date 2005-10-18
	 * 
	 * @param fileName
	 *            ��Ҫ������ļ�������.
	 * @return the prefix portion of the file's name.
	 */
	public static String getPrefix(String fileName)
	{
		if (fileName != null)
		{
			fileName = fileName.replace('\\', '/');

			if (fileName.lastIndexOf("/") > 0)
			{
				fileName = fileName.substring(fileName.lastIndexOf("/") + 1,
						fileName.length());
			}

			int i = fileName.lastIndexOf('.');
			if (i > 0 && i < fileName.length() - 1)
			{
				return fileName.substring(0, i);
			}
		}
		return "";
	}

	/**
	 * �õ��ļ��Ķ�·��, ������Ŀ¼.
	 * 
	 * @date 2005-10-18
	 * 
	 * @param fileName
	 *            ��Ҫ������ļ�������.
	 * @return the short version of the file's name.
	 */
	public static String getShortFileName(String fileName)
	{
		if (fileName != null)
		{
			String oldFileName = new String(fileName);

			fileName = fileName.replace('\\', '/');

			// Handle dir
			if (fileName.endsWith("/"))
			{
				int idx = fileName.indexOf('/');
				if (idx == -1 || idx == fileName.length() - 1)
				{
					return oldFileName;
				} else
				{
					return oldFileName
							.substring(idx + 1, fileName.length() - 1);
				}

			}
			if (fileName.lastIndexOf("/") > 0)
			{
				fileName = fileName.substring(fileName.lastIndexOf("/") + 1,
						fileName.length());
			}

			return fileName;
		}
		return "";
	}

	/**
	 * ��ȡ����������Ĭ��ת��, �� ISO8859-1 ת���� GBK.
	 * 
	 * @author BeanSoft
	 * @date 2005-08-01
	 * 
	 * @param request
	 *            HttpServletRequest ����
	 * @param fieldName
	 *            ������
	 * @return ȡ�õı�ֵ
	 */
	public static String getParameter(HttpServletRequest request,
			String fieldName)
	{
		// // �жϱ����Ƿ��Ѿ�ָ��
		// String encoding = request.getCharacterEncoding();
		//
		// if("GBK".equalsIgnoreCase(encoding) ||
		// "GB2312".equalsIgnoreCase(encoding)) {
		// return request.getParameter(fieldName);
		// }
		//
		// return request(request, fieldName);
		// 2005-08-01 ��ʱ�޸�
		// try {
		// request.setCharacterEncoding("UTF-8");
		// } catch (UnsupportedEncodingException e) {
		// // TODO auto generated try-catch
		// e.printStackTrace();
		// }

		return request.getParameter(fieldName);
	}

	// ------------------------------------ JSP ����������

	/**
	 * ���� Cookie ���Ƶõ������е� Cookie ֵ, ��Ҫ���ȸ� _request һ����ʼֵ; ��� Cookie ֵ�� null, �򷵻�
	 * ""
	 */
	public static String getCookieValue(HttpServletRequest request, String name)
	{
		Cookie[] cookies = request.getCookies();
		if (cookies == null)
		{
			return "";
		}
		for (int i = 0; i < cookies.length; i++)
		{
			Cookie cookie = cookies[i];
			if (cookie.getName().equals(name))
			{
				// ��Ҫ�� Cookie �еĺ��ֽ��� URL ������, ���ð汾: Tomcat 4.0
				return decode(cookie.getValue());
				// ����Ҫ������, ���ð汾: JSWDK 1.0.1
				// return cookie.getValue();
			}
		}
		// A cookie may not return a null value, may return a ""
		return "";
	}

	// ����ָ������������
	public String[] getParameterValues(HttpServletRequest request, String name)
	{
		// POST �����Ĳ���û�б������
		// if (request.getMethod().equalsIgnoreCase("POST")) {
		// �ļ��ϴ�ģʽ
		// if(isUploadMode) {
		// return request.getParameterValues(name);
		// }
		// -- For Tomcat 4.0
		// return request.getParameterValues(name);
		// -- For JSWDK 1.0.1
		/*
		 * String values[] = _request.getParameterValues(name); if(values !=
		 * null) { for(int i = 0; i < values.length; i++) { values[i] =
		 * toChi(values[i]); } } return values;
		 */
		// }
		// else {
		// ��ͨ�� GET ��ʽ���͵������ַ�����(���Ǳ���ʹ�� java.net.URLEncoder ���������ַ������ı���)
		// ����ʱ��ʹ������ת��, Ҳ��ʹ�÷�����, ��: return decode(_request.getParameter(name));
		// ����: decode() �������� JDK 1.3 + Tomcat 4.0
		String encoding = request.getCharacterEncoding();

		if ("GBK".equalsIgnoreCase(encoding)
				|| "GB2312".equalsIgnoreCase(encoding))
		{
			return request.getParameterValues(name);
		}

		String values[] = request.getParameterValues(name);
		if (values != null)
		{
			for (int i = 0; i < values.length; i++)
			{
				values[i] = toChi(values[i]);
			}
		}
		return values;
		// }
	}

	/**
	 * ɾ��ָ���� Web Ӧ�ó���Ŀ¼�����ϴ����ļ�
	 * 
	 * @param application
	 *            JSP/Servlet �� ServletContext
	 * @param filePath
	 *            ����ļ�·��
	 */
	public static void deleteFile(ServletContext application, String filePath)
	{
		if (!isEmpty(filePath))
		{
			String physicalFilePath = application.getRealPath(filePath);
			if (!isEmpty(physicalFilePath))
			{
				java.io.File file = new java.io.File(physicalFilePath);
				file.delete();
			}
		}
	}

	/**
	 * ��ָ���� Web Ӧ�ó���Ŀ¼����ָ��·�������ļ�
	 * 
	 * @param application
	 *            JSP/Servlet �� ServletContext
	 * @param filePath
	 *            ����ļ�·��
	 */
	public static boolean createFile(ServletContext application, String filePath)
	{
		if (!isEmpty(filePath))
		{
			String physicalFilePath = application.getRealPath(filePath);
			if (!isEmpty(physicalFilePath))
			{
				java.io.File file = new java.io.File(physicalFilePath);

				try
				{
					// �����ļ�
					return file.createNewFile();
				} catch (IOException e)
				{
					System.err.println("Unable to create file " + filePath);
				}
			}
		}

		return false;
	}

	/**
	 * ��ָ���� Web Ӧ�ó���Ŀ¼����ָ��·������Ŀ¼.
	 * 
	 * @param application
	 *            JSP/Servlet �� ServletContext
	 * @param filePath
	 *            ����ļ�·��
	 */
	public static boolean createDir(ServletContext application, String filePath)
	{
		if (!isEmpty(filePath))
		{
			String physicalFilePath = application.getRealPath(filePath);
			if (!isEmpty(physicalFilePath))
			{
				try
				{
					// ����Ŀ¼
					java.io.File dir = new java.io.File(application
							.getRealPath(filePath));
					return dir.mkdirs();
				} catch (Exception e)
				{
					System.err
							.println("Unable to create directory " + filePath);
				}
			}
		}

		return false;
	}

	/**
	 * ���ָ���� Web Ӧ�ó���Ŀ¼�µ��ļ��Ƿ����.
	 * 
	 * @param application
	 *            JSP/Servlet �� ServletContext
	 * @param filePath
	 *            ����ļ�·��
	 * @return boolean - �ļ��Ƿ����
	 */
	public static boolean checkFileExists(ServletContext application,
			String filePath)
	{
		if (!isEmpty(filePath))
		{
			String physicalFilePath = application.getRealPath(filePath);
			if (!isEmpty(physicalFilePath))
			{
				java.io.File file = new java.io.File(physicalFilePath);
				return file.exists();
			}
		}

		return false;
	}

	/**
	 * ��ȡ�ļ�ͼ����. Date: 2005-10
	 * 
	 * @param application
	 *            JSP/Servlet �� ServletContext
	 * @param iconDirPath
	 *            ͼ���ļ��е�·��
	 * @param fileName
	 *            ��Ҫ������ļ���
	 * @return ͼ���ļ����·��
	 */
	public static String getFileIcon(ServletContext application,
			String iconDirPath, String fileName)
	{
		String ext = getExtension(fileName);
		String filePath = iconDirPath + ext + ".gif";
		// return filePath;

		if (checkFileExists(application, filePath))
		{
			return filePath;
		}
		return iconDirPath + "file.gif";
	}

	/**
	 * Gets the absolute pathname of the class or resource file containing the
	 * specified class or resource name, as prescribed by the current classpath.
	 * 
	 * @param resourceName
	 *            Name of the class or resource name.
	 * @return the absolute pathname of the given resource
	 */
	public static String getPath(String resourceName)
	{

		if (!resourceName.startsWith("/"))
		{
			resourceName = "/" + resourceName;
		}

		// resourceName = resourceName.replace('.', '/');

		java.net.URL classUrl = new StringUtil().getClass().getResource(
				resourceName);

		if (classUrl != null)
		{
			// System.out.println("\nClass '" + className +
			// "' found in \n'" + classUrl.getFile() + "'");
			// System.out.println("\n��Դ '" + resourceName +
			// "' ���ļ� \n'" + classUrl.getFile() + "' ���ҵ�.");

			return classUrl.getFile();
		}
		// System.out.println("\nClass '" + className +
		// "' not found in \n'" +
		// System.getProperty("java.class.path") + "'");
		// System.out.println("\n��Դ '" + resourceName +
		// "' û������·�� \n'" +
		// System.getProperty("java.class.path") + "' ���ҵ�");
		return null;
	}

	/**
	 * ������ת��Ϊ���ı�ʾ��ʽ���ַ���(��ʽΪ yyyy��MM��dd�� HH:mm:ss).
	 */
	public static String dateToChineseString(Date date)
	{
		if (date == null)
		{
			return "";
		}

		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
				"yyyy��MM��dd�� HH:mm:ss");

		return dateFormat.format(date);
	}

	/**
	 * ������ת��Ϊ 14 λ���ַ���(��ʽΪyyyyMMddHHmmss).
	 */
	public static String dateTo14String(Date date)
	{
		if (date == null)
		{
			return null;
		}

		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
				"yyyyMMddHHmmss");

		return dateFormat.format(date);
	}

	/**
	 * �� 14 λ���ַ���(��ʽΪyyyyMMddHHmmss)ת��Ϊ����.
	 */
	public static Date string14ToDate(String input)
	{
		if (isEmpty(input))
		{
			return null;
		}

		if (input.length() != 14)
		{
			return null;
		}

		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
				"yyyyMMddHHmmss");

		try
		{
			return dateFormat.parse(input);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return null;
	}

	// -----------------------------------------------------------
	// ---------- �ַ���������ת�����߷���, 2004.03.27 ��� --------
	// ------------------------------------------------------------
	public static byte getByte(HttpServletRequest httpservletrequest, String s)
	{
		if (httpservletrequest.getParameter(s) == null
				|| httpservletrequest.getParameter(s).equals(""))
		{
			return 0;
		}
		return Byte.parseByte(httpservletrequest.getParameter(s));
	}

	/**
	 * ��ȡ boolean ������ServletRequest��.
	 * 
	 * @param request
	 * @param name
	 * @return
	 */
	public static boolean getBoolean(HttpServletRequest request, String name)
	{
		return Boolean.valueOf(request.getParameter(name));
	}

	/**
	 *����������ж�ȡ��������Ϊ����.
	 * 
	 */
	public static int getInt(HttpServletRequest httpservletrequest, String s)
	{
		if (httpservletrequest.getParameter(s) == null
				|| httpservletrequest.getParameter(s).equals(""))
		{
			return 0;
		}
		return parseInt(httpservletrequest.getParameter(s));
	}

	public static long getLong(HttpServletRequest httpservletrequest, String s)
	{
		if (httpservletrequest.getParameter(s) == null
				|| httpservletrequest.getParameter(s).equals(""))
		{
			return 0L;
		}
		return parseLong(httpservletrequest.getParameter(s));
	}

	public static double getDouble(HttpServletRequest httpservletrequest,
			String s)
	{
		if (httpservletrequest.getParameter(s) == null
				|| httpservletrequest.getParameter(s).equals(""))
		{
			return 0;
		}
		return parseDouble(httpservletrequest.getParameter(s));
	}

	/**
	 * �� TEXT �ı�ת��Ϊ HTML ����, �ѱ�����ҳ��ȷ����ʾ����.
	 * 
	 * @param input
	 *            ������ı��ַ���
	 * @return ת����� HTML ����
	 */
	public static String textToHtml(String input)
	{
		if (isEmpty(input))
		{
			return "";
		}

		input = replace(input, "<", "&#60;");
		input = replace(input, ">", "&#62;");

		input = replace(input, "\n", "<br>\n");
		input = replace(input, "\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		input = replace(input, "  ", "&nbsp;&nbsp;");

		return input;
	}

	public static String toQuoteMark(String s)
	{
		s = replaceString(s, "'", "&#39;");
		s = replaceString(s, "\"", "&#34;");
		s = replaceString(s, "\r\n", "\n");
		return s;
	}

	public static String replaceChar(String s, char c, char c1)
	{
		if (s == null)
		{
			return "";
		}
		return s.replace(c, c1);
	}

	public static String replaceString(String s, String s1, String s2)
	{
		if (s == null || s1 == null || s2 == null)
		{
			return "";
		}
		return s.replaceAll(s1, s2);
	}

	public static String toHtml(String s)
	{
		s = replaceString(s, "<", "&#60;");
		s = replaceString(s, ">", "&#62;");
		return s;
	}

	public static String toBR(String s)
	{
		s = replaceString(s, "\n", "<br>\n");
		s = replaceString(s, "\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		s = replaceString(s, "  ", "&nbsp;&nbsp;");
		return s;
	}

	public static String toSQL(String s)
	{
		s = replaceString(s, "\r\n", "\n");
		return s;
	}

	public static String replaceEnter(String s) throws NullPointerException
	{
		return s.replaceAll("\n", "<br>");
	}

	public static String replacebr(String s) throws NullPointerException
	{
		return s.replaceAll("<br>", "\n");
	}

	public static String replaceQuote(String s) throws NullPointerException
	{
		return s.replaceAll("'", "''");
	}

	// Test only.
	public static void main(String[] args) throws Exception
	{
		System.out.println(formatFraction(0.693431014112044, 1, 3));

		System.out.println(textToHtml("1<2\r\n<b>Bold</b>"));
		System.out.println(scriptAlert("oh!"));
		System.out.println(scriptRedirect("http://localhost/"));
		System.out.println(StringUtil.getPath("/databaseconfig.properties"));
		java.io.File file = new java.io.File("e:\\Moblog\\abcd\\");

		file.mkdir();
		Date time = (parseHMSStringToDate("12:23:00"));
		System.out.println(time.toLocaleString());
		Date nowTime = parseHMSStringToDate(formatDateToHMSString(new Date()));
		System.out.println(nowTime.toLocaleString());

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		cal.add(cal.YEAR, -cal.get(cal.YEAR) + 1970);
		cal.add(cal.MONTH, -cal.get(cal.MONTH));
		cal.add(cal.DATE, -cal.get(cal.DATE) + 1);

		System.out.println(cal.getTime().toLocaleString());
	}
}