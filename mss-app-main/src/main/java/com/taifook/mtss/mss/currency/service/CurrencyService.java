package com.taifook.mtss.mss.currency.service;

import java.util.List;

import com.taifook.mtss.mss.currency.model.Currency;
import com.taifook.mtss.mss.currency.model.CurrencyEnquiryParam;

/**
 * servcie for currency
 * @author slli
 *
 */
public interface CurrencyService {

    /**
     * Create a new Currency
     * @param currency
     */
    void addCurrency(Currency currency);

    /**
     * Modify a new Currency
     * @param currency
     */
    void updateCurrency(Currency currency);

    /**
     * Get Currency Detail
     * @param ccyCode
     * @return Currency
     */
    Currency getCurrencyDetail(String ccyCode);

    /**
     * Get Currency List
     * @param ccyEnquiryParam
     * @return List<Currency>
     */
    List<Currency>  getcurrencyListByCriteria(CurrencyEnquiryParam ccyEnquiryParam);
}
