package org.usc.demo;

import java.math.BigInteger;
import java.util.Date;
import java.util.IllegalFormatException;

public class StringformatTest {
    protected static final String NEWLINE = String.format("%n");

    protected static String formatMessage(String message, Object... args) {
        String result;

        try {
            if (args != null && args.length > 0) {
                result = String.format(message, args);
            } else {
                result = message;
            }
        } catch (IllegalFormatException e) {
            result = formatFailedMessage(e, message, args);

        } catch (Exception e) {
            // workaround for JDK bug in formatting BigDecimal
            result = formatFailedMessage(e, message, args);
        }

        return result;
    }

    protected static String formatFailedMessage(Throwable e, String message, Object... args) {
        StringBuilder sb = new StringBuilder();
        sb.append("(Error in formatting message: ")
                .append(e.getMessage())
                .append(".  Dumping original message)\n")
                .append(message);
        if (args != null && args.length > 0) {
            sb.append(NEWLINE).append("Arguments {").append(NEWLINE);
            for (int i = 0; i < args.length; i++) {
                sb.append(i).append(": ").append(args[i].toString()).append(NEWLINE);
            }
            sb.append("}");
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String result = StringformatTest.formatMessage("hello %d %s %s in %s", 1L, "x", BigInteger.valueOf(5),new Date());
        System.out.println(result);
        System.out.println(String.format("Now is %1$tY/%1$tm/%1$td  ", new Date()));
    }

}
