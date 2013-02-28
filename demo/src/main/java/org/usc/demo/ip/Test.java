package org.usc.demo.ip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Shunli
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        long ip = 36;/* IPUtil.convertIP("124.162.191.8"); */
        System.out.println(ip);

        List<IPRange> ipRanges = getIPRangesFromMC();
        if (ipRanges == null || ipRanges.isEmpty()) {
            // ipRanges = dao.getIpRanges();
            // put ipRanges into mc.
        }

        // get from mc.
        System.out.println(ipRanges);

        System.out.println(isIpAllow(ipRanges, ip));
    }

    private static List<IPRange> getIPRangesFromMC() {
        List<IPRange> ipRanges = new ArrayList<IPRange>();
        ipRanges.add(new IPRange(1, 10));
        ipRanges.add(new IPRange(11, 20));
        ipRanges.add(new IPRange(41, 50));
        ipRanges.add(new IPRange(51, 60));
        ipRanges.add(new IPRange(21, 30));
        ipRanges.add(new IPRange(31, 40));

        Collections.sort(ipRanges);

        return ipRanges;
    }

    private static boolean isIpAllow(List<IPRange> ipRanges, long ip) {
        for (IPRange ipRange : ipRanges) {
            if (ip >= ipRange.startip) {
                if (ip <= ipRange.endip) {
                    return true;
                }
            } else {
                break;
            }
        }

        return false;
    }

}
