package com.taifook.mtss.mss.currency.dto;

import java.io.Serializable;
import java.util.List;


import com.taifook.mtss.framework.dto.annotation.Dto;
import com.taifook.mtss.framework.dto.annotation.DtoField;
import com.taifook.mtss.mss.common.dto.BaseModelDto;
import com.taifook.mtss.mss.currency.model.Currency;
import com.taifook.mtss.mss.currency.model.CurrencyName;

/**
 * @author slli
 *
 */
@Dto(sourceModelClass=Currency.class)
public class CurrencyDto extends BaseModelDto implements Serializable{

    private static final long serialVersionUID = 5253095344572280093L;

    @DtoField
    private String code;

    @DtoField
    private String prefixSymbol;

    @DtoField
    private String primaryName;

    @DtoField
    private String isoAlpha;

    @DtoField
    private Long isoNumeric;

    @DtoField
    private Integer decimalPlace;

    @DtoField
    private Boolean isValid;

    @DtoField
    private Boolean isRestricted ;

    @DtoField
    private List<CurrencyName> names;

    public CurrencyDto() {
    }

    public CurrencyDto(String code, String prefixSymbol, String primaryName,
            String isoAlpha, Long isoNumeric, Integer decimalPlace,
            Boolean isValid, Boolean isRestricted, List<CurrencyName> names) {
        this.code = code;
        this.prefixSymbol = prefixSymbol;
        this.primaryName = primaryName;
        this.isoAlpha = isoAlpha;
        this.isoNumeric = isoNumeric;
        this.decimalPlace = decimalPlace;
        this.isValid = isValid;
        this.isRestricted = isRestricted;
        this.names = names;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrefixSymbol() {
        return prefixSymbol;
    }

    public void setPrefixSymbol(String prefixSymbol) {
        this.prefixSymbol = prefixSymbol;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
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

    public Integer getDecimalPlace() {
        return decimalPlace;
    }

    public void setDecimalPlace(Integer decimalPlace) {
        this.decimalPlace = decimalPlace;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public Boolean getIsRestricted() {
        return isRestricted;
    }

    public void setIsRestricted(Boolean isRestricted) {
        this.isRestricted = isRestricted;
    }

    public List<CurrencyName> getNames() {
        return names;
    }

    public void setNames(List<CurrencyName> names) {
        this.names = names;
    }
}
