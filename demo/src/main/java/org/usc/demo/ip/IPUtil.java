package org.usc.demo.ip;

public class IPUtil
{

    public static long convertIP(final String ip)
    {
        String[] ids = ip.split("\\.");
        long result = Long.parseLong(ids[3]);
        result += Long.parseLong(ids[2]) << 8;
        result += Long.parseLong(ids[1]) << 16;
        result += Long.parseLong(ids[0]) << 24;
        return result;
    }

    public static long convertIP(final byte[] ip)
    {

        long result = (long) (ip[3] & 255);
        result += (long) (ip[2] & 255) << 8;
        result += (long) (ip[1] & 255) << 16;
        result += (long) (ip[0] & 255) << 24;
        return result;
    }

    public static String convertIP(final long ip)
    {
        long s1 = ip >> 24;
        long s2 = ip >> 16 & 0x00ff;
        long s3 = ip >> 8 & 0x0000ff;
        long s4 = ip & 0x000000ff;
        return new StringBuilder(15).append(s1).append('.').append(s2).append('.').append(s3).append('.').append(s4).toString();
    }
}
