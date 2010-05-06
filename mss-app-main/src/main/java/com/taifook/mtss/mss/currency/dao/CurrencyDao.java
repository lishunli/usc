 package com.taifook.mtss.mss.currency.dao;

import java.util.List;

import com.taifook.mtss.framework.dao.GenericDao;
import com.taifook.mtss.framework.dao.annotation.Param;
import com.taifook.mtss.framework.dao.annotation.Query;
import com.taifook.mtss.mss.currency.model.Currency;
import com.taifook.mtss.mss.currency.model.CurrencyEnquiryParam;

/**
 * @author slli
 *
 */
public interface CurrencyDao extends GenericDao<Currency, String>{

    @Query(query="FROM Currency WHERE code = :code ")
    Currency findByCurrencyCode(@Param("code")String code);

/*    @Query(query="SELECT distinct ccy " +
            "FROM Currency ccy INNER JOIN ccy.names ccyName " +
            " WHERE ccyName.isPrimary =  'Y' " +
            " {AND:code ccy.code = :code } " +
            " {AND:isoAlpha ccy.isoAlpha = :isoAlpha } " +
            " {AND:isoNumeric ccy.isoNumeric = :isoNumeric } " +
            " {AND:isRestricted ccy.isRestricted = :isRestricted } " +
            " {AND:name ccyName.name = :name } " ,
            dynamicQuery=true)
    List<Currency> findByCriteria(@Param("code")String code,
                                  @Param("isoAlpha")String isoAlpha,
                                  @Param("isoNumeric")Long isoNumeric,
                                  @Param("isRestricted")Boolean isRestricted,
                                  @Param("name")String name);*/


    @Query(query="SELECT distinct ccy " +
            "FROM Currency ccy INNER JOIN ccy.names ccyName " +
            " WHERE ccyName.isPrimary =  'Y' " +
            " {AND:code ccy.code = :code } " +
            " {AND:isoAlpha ccy.isoAlpha = :isoAlpha } " +
            " {AND:isoNumeric ccy.isoNumeric = :isoNumeric } " +
            " {AND:isRestricted ccy.isRestricted = :isRestricted } " +
            " {AND:name ccyName.name = :name } " ,
            dynamicQuery=true)
    List<Currency> findByCriteria(CurrencyEnquiryParam ccyEnquiryParam);

}
