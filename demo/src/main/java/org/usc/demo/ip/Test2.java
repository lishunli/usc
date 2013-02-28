package org.usc.demo.ip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Shunli
 */
public class Test2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(IPUtil.convertIP("192.168.1.1"));
        System.out.println(IPUtil.convertIP("192.168.255.1"));
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
        ipRanges.add(new IPRange(16779264, 16781311));
        ipRanges.add(new IPRange(977010688, 977076223));

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
