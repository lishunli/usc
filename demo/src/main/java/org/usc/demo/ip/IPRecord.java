package org.usc.demo.ip;

public class IPRecord
{

    public final IPRange range;

    public final IPRegion region;

    public IPRecord(long startip, long endip, String province, String areaId)
    {
        this.range = new IPRange(startip, endip);
        this.region = new IPRegion(province, areaId);
    }
}
