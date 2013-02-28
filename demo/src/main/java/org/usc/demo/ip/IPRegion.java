package org.usc.demo.ip;

public class IPRegion implements java.io.Serializable
{

    /**
	 * 
	 */
    private static final long serialVersionUID = -5984970499450063425L;

    public final String province;

    public final String areaId;

    public IPRegion(String province, String areaId)
    {
        this.province = province;
        this.areaId = areaId;
    }

}
