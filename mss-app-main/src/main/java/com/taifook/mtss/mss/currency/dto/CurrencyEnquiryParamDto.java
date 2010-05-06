package com.taifook.mtss.mss.currency.dto;

import java.io.Serializable;

import com.taifook.mtss.framework.dto.annotation.Dto;
import com.taifook.mtss.framework.dto.annotation.DtoField;
import com.taifook.mtss.mss.common.dto.BaseModelDto;
import com.taifook.mtss.mss.currency.model.CurrencyEnquiryParam;

/**
 * @author slli
 *
 */
@Dto(sourceModelClass=CurrencyEnquiryParam.class)
public class CurrencyEnquiryParamDto extends BaseModelDto implements Serializable{

    private static final long serialVersionUID = 2406220899667698771L;

    @DtoField
    private String code;

    @DtoField
    private String isoAlpha;

    @DtoField
    private Long isoNumeric;

    @DtoField
    private Boolean isRestricted;

    @DtoField
    private String name;

    public CurrencyEnquiryParamDto() {
        super();
    }

    public CurrencyEnquiryParamDto(String code, String isoAlpha, Long isoNumeric, Boolean isRestricted, String name) {
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
