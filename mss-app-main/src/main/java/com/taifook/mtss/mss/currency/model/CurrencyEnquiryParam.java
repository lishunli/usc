package com.taifook.mtss.mss.currency.model;

import com.taifook.mtss.framework.app.enquiry.EnquiryParameter;

/**
 * @author slli
 *
 */
public class CurrencyEnquiryParam extends EnquiryParameter{

    private String code;
    private String isoAlpha;
    private Long isoNumeric;
    private Boolean isRestricted;
    private String name;

    public CurrencyEnquiryParam() {
        super();
    }

    public CurrencyEnquiryParam(String code, String isoAlpha, Long isoNumeric,
            Boolean isRestricted, String name) {
        this.code = code;
        this.isoAlpha = isoAlpha;
        this.isoNumeric = isoNumeric;
        this.isRestricted = isRestricted;
        this.name = name;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getIsoAlpha() {
        return isoAlpha;
    }
    public void setIsoAlpha(String isoAlpha) {
        this.isoAlpha = isoAlpha;
    }
    public Long getIsoNumeric() {
        return isoNumeric;
    }
    public void setIsoNumeric(Long isoNumeric) {
        this.isoNumeric = isoNumeric;
    }
    public Boolean getIsRestricted() {
        return isRestricted;
    }
    public void setIsRestricted(Boolean isRestricted) {
        this.isRestricted = isRestricted;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
