package org.usc.demo.i18n;

import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 *
 * @author Shunli
 */
public class I18NTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ResourceBundle messages = ResourceBundle.getBundle("config");
        Enumeration<String> keys = messages.getKeys();
        while (keys.hasMoreElements()) {
            System.out.println(keys.nextElement());
        }
        // String title = messages.getString("title");
    }

}
