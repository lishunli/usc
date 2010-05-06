package com.taifook.mtss.mss.currency.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.taifook.mtss.framework.app.model.BaseTopModel;
import com.taifook.mtss.mss.common.model.ModelConstants;

/**
 * @author slli
 *
 */
@Entity
@Table(name = "MC_CCY")
@GenericGenerator(name = "seqCurrencyCode", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
        @Parameter(name = "sequence_name", value = "CCY_SEQ"),// don't know seq
        @Parameter(name = "increment_size", value = ModelConstants.SEQUENCE_INCREMENT_SIZE) })
public class Currency extends BaseTopModel<String> {

    private static final long serialVersionUID = -2056098313513374114L;

    @Id
    @GeneratedValue(generator = "seqCurrencyCode", strategy = GenerationType.SEQUENCE)
    @Column(name = "CCY_CDE")
    private String code;

    @Column(name = "PRFX_SYM")
    private String prefixSymbol;

    @Column(name = "PRIMY_CCY_NAM")
    private String primaryName;

    @Column(name = "ISO_ALPHA")
    private String isoAlpha;

    @Column(name = "ISO_NUM")
    private Long isoNumeric;

    @Column(name = "DEC")
    private Integer decimalPlace = 0;

    @Column(name = "IS_VLD")
    private Boolean isValid = true;

    @Column(name = "IS_RESTRICT")
    private Boolean isRestricted = false;

//    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//    @JoinColumn(name="CCY_CDE", updatable = false, insertable = false)
//    @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="currency")
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<CurrencyName> names = new ArrayList<CurrencyName>();

    public Currency() {
    }


    public Currency(String prefixSymbol) {
        this(null,prefixSymbol,null,null,null,null,null,null);
    }


    public Currency(String prefixSymbol, String primaryName, String isoAlpha,
            Long isoNumeric, Integer decimalPlace, Boolean isValid,
            Boolean isRestricted, List<CurrencyName> names) {
       this(null,prefixSymbol,primaryName,isoAlpha,isoNumeric,decimalPlace,isValid,isRestricted,names);
    }


    public Currency(String code, String prefixSymbol, String primaryName,
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

    @Override
    public String getPk() {
        return this.code;
    }

    @Override
    public String toString() {
        return "Currency [code=" + code + ", decimalPlace=" + decimalPlace
                + ", isRestricted=" + isRestricted + ", isValid=" + isValid
                + ", isoAlpha=" + isoAlpha + ", isoNumeric=" + isoNumeric
                + ", names=" + names + ", prefixSymbol=" + prefixSymbol
                + ", primaryName=" + primaryName + "]";
    }


}
