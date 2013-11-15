package org.usc.demo;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class CdkeyGenerator {
    public static String genCdkey(int len, String keyIndex, String keyConst) {
        if (len < 6 || keyConst.length() < 2) {
            // throw new IllegalArgumentException("cdkey or key constant too short");
            return "";
        }

        String cdkey = RandomStringUtils.randomAlphanumeric(len);

        char[] charArray = cdkey.toCharArray();
        charArray[cdkey.length() - 6] = keyConst.charAt(0);
        charArray[cdkey.length() - 3] = keyConst.charAt(1);

        cdkey = String.valueOf(charArray);

        if (StringUtils.isNotEmpty(keyIndex)) {
            cdkey = keyIndex + cdkey;
        }

        return StringUtils.upperCase(cdkey);
    }
}
