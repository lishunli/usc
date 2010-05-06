package com.taifook.mtss.mss.currency.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.taifook.mtss.framework.app.model.BaseModel;
import com.taifook.mtss.mss.common.model.Language;
import com.taifook.mtss.mss.common.model.ModelConstants;

/**
 * @author slli
 *
 */
@Entity
@Table(name = "MC_CCY_NAM")
@GenericGenerator(name = "seqCurrencyNameID", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
        @Parameter(name = "sequence_name", value = "CCY_NAM_SEQ"),// don't know seq
        @Parameter(name = "increment_size", value = ModelConstants.SEQUENCE_INCREMENT_SIZE) })
public class CurrencyName extends BaseModel<Long> {

    private static final long serialVersionUID = -4865648743683104904L;

    @Id
    @GeneratedValue(generator = "seqCurrencyNameID", strategy = GenerationType.SEQUENCE)
    @Column(name = "CCY_NAM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CCY_CDE")
    private Currency currency;

    @Enumerated(value=EnumType.STRING)
    @Column(name = "LANG_TYP")
    private Language langCode;

    @Column(name = "CCY_NAM")
    private String name;

    @Column(name = "UNIT_NAM")
    private String unitName;

    @Column(name = "IS_PRIMY")
    private Boolean isPrimary = false;

    public CurrencyName() {
    }

    public CurrencyName(Long id, Currency currency, Language langCode,
            String name, String unitName, Boolean isPrimary) {
        this.id = id;
        this.currency = currency;
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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

    @Override
    public BaseModel<?> getParent() {
        return this.currency;
    }

    @Override
    public Long getPk() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CurrencyName [currency=" + currency + ", id=" + id
                + ", isPrimary=" + isPrimary + ", langCode=" + langCode
                + ", name=" + name + ", unitName=" + unitName + "]";
    }

}
