package org.usc.demo.ip;

public class IPInfoX implements IPInfo
{

    /**
	 * 
	 */

    private static final long serialVersionUID = 2961520912033218322L;

    private IPRegion region;

    public IPInfoX()
    {
    }

    public IPInfoX(IPRegion region)
    {
        this.region = region;
    }

    public String getProvince()
    {
        return getRegion().province;
    }

    public IPRegion getRegion()
    {
        return region;
    }

    public void setRegion(IPRegion region)
    {
        this.region = region;
    }

    public String getAreaId()
    {
        return getRegion().areaId;
    }
}
