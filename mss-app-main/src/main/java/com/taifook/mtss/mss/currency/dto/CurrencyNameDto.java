package com.taifook.mtss.mss.currency.dto;

import java.io.Serializable;

import com.taifook.mtss.framework.dto.annotation.Dto;
import com.taifook.mtss.framework.dto.annotation.DtoField;
import com.taifook.mtss.mss.common.dto.BaseModelDto;
import com.taifook.mtss.mss.common.model.Language;
import com.taifook.mtss.mss.currency.model.CurrencyName;

/**
 * @author slli
 *
 */
@Dto(sourceModelClass = CurrencyName.class,idField="langCode")
public class CurrencyNameDto extends BaseModelDto implements Serializable {

    private static final long serialVersionUID = -5684529182395603157L;

    @DtoField
    private Long id;

//    @DtoField(field = "currency.code")
//    private String ccyCode;

    @DtoField
    private Language langCode;

    @DtoField
    private String name;

    @DtoField
    private String unitName;

    @DtoField
    private Boolean isPrimary;

    public CurrencyNameDto() {
    }

    public CurrencyNameDto(Long id, Language langCode, String name, String unitName, Boolean isPrimary) {
        super();
        this.id = id;
        this.langCode = langCode;
        this.name = name;
        this.unitName = unitName;
        this.isPrimary = isPrimary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Language getLangCode() {
        return langCode;
    }

    public void setLangCode(Language langCode) {
        this.langCode = langCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

}
