package org.usc.demo.ip;

public interface IPInfo extends java.io.Serializable
{
    public static final IPInfo EMPTY = new IPInfo()
    {

        private static final long serialVersionUID = -4579716116367336839L;

        @Override
        public String getAreaId()
        {
            return "35";//
        }

        @Override
        public String getProvince()
        {
            return "NA";
        }

    };

    public String getProvince();

    public String getAreaId();

}
