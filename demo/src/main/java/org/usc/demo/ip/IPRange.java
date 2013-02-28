package org.usc.demo.ip;

public class IPRange implements java.io.Serializable, Comparable<IPRange>
{

    /**
     *
     */
    private static final long serialVersionUID = 2669520059499527965L;

    public final long startip;

    public final long endip;

    public IPRange(long startip, long endip)
    {
        super();
        this.startip = startip;
        this.endip = endip;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof IPRange))
            return false;
        return equals((IPRange) obj);
    }

    public boolean equals(IPRange other)
    {
        return this.startip <= other.startip && this.endip >= other.endip;
    }

    @Override
    public int hashCode()
    {
        return ((int) (startip ^ (startip >>> 32)) ^ (int) (endip ^ (endip >>> 32)));
    }

    public int compareTo(IPRange o)
    {
        long s = this.startip - o.startip;
        if (s > 0)
            return 1;
        if (s < 0)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "IPRange [startip=" + startip + ", endip=" + endip + "]";
    }


}
