package org.usc.demo.ip;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shunli
 */
public class LocationTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        long ip = IPUtil.convertIP("123.162.191.8");
        System.out.println(ip);

        // | 20726 | 2074083328 | 2074345471 | 河南省 | NULL | 电信 | 123.160.0.0 | 123.163.255.255 |
        // | 27644 | 2074255360 | 2074263551 | 河南省 | 洛阳市 | 电信 | 123.162.160.0 | 123.162.191.255 |
        List<IPRange> ipRanges = new ArrayList<IPRange>();
        ipRanges.add(new IPRange(2074255360, 2074263551));
        ipRanges.add(new IPRange(2074083328, 2074345471));

        System.out.println(findLocation(ipRanges, ip));
    }

    private static IPRange findLocation(List<IPRange> ipRanges, long ip)
    {
        int mid = 0;
        int min = 0;
        int max = ipRanges.size() - 1;
        int eval = compareIp(ip, ipRanges.get(0).startip);
        if (eval == 0)
            return ipRanges.get(0);
        if (eval < 0)
            return null;

        while (min < max)
        {
            mid = getMid(min, max);
            eval = compareIp(ip, ipRanges.get(mid).startip);
            if (eval > 0)
                min = mid;
            else if (eval < 0)
            {
                if (mid == max)
                {
                    max--;
                    mid = max;
                }
                else
                    max = mid;
            }
            else
                return ipRanges.get(mid);
        }
        eval = compareIp(ip, ipRanges.get(mid).endip);
        if (eval <= 0)
            return ipRanges.get(mid);
        return null;
    }

    private static int getMid(int begin, int end)
    {
        int records = (end - begin);
        records >>= 1;
        if (records == 0L)
            records = 1;
        return begin + records;
    }

    private static int compareIp(long ip1, long ip2)
    {
        if (ip1 > ip2)
            return 1;
        else if (ip1 < ip2)
            return -1;
        else
            return 0;
    }
}
