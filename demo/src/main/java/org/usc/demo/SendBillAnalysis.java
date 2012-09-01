package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 *
 * @author Shunli
 */
public class SendBillAnalysis {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Shunli\\Downloads\\sendbill.txt");
        List<String> lines = FileUtils.readLines(file);

        List<String> phones = new ArrayList<String>();
        for (String line : lines) {
            String[] records = line.split(",");
            // System.out.println(records[8]);
            phones.add(records[8]);
        }

        /**
         * 移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）
         *
         * 联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）
         *
         * 电信的号段：133、153、180（未启用）、189
         */
        // Mobile
        // China Unicom
        // Telecom
        // List<String> mobilePrefix = Arrays.asList("134", "", "", "", "", "", "", "", "", "", "", "");
        List<String> chinaUnicomPrefix = Arrays.asList("130", "131", "132", "155", "156", "185", "186");
        List<String> telecomPrefix = Arrays.asList("133", "153", "180", "189");

        for (String phone : phones) {
            CharSequence phonePrefix = phone.subSequence(0, 3);
            if (chinaUnicomPrefix.contains(phonePrefix) || telecomPrefix.contains(phonePrefix)) {
                System.out.println(phone);
            }
        }

    }
}
