package com.taifook.mtss.mss.currency.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.taifook.mtss.framework.app.service.AbstractService;
import com.taifook.mtss.mss.currency.dao.CurrencyDao;
import com.taifook.mtss.mss.currency.model.Currency;
import com.taifook.mtss.mss.currency.model.CurrencyEnquiryParam;
import com.taifook.mtss.mss.currency.service.CurrencyService;

/**
 * @author slli
 *
 */
@Component("currency.service.CurrencyService")
public class CurrencyServiceImpl extends AbstractService implements CurrencyService {

    //@Resource(name = "currency.dao.CurrencyDao")
    private CurrencyDao ccyDao;

    public void addCurrency(Currency currency) {
        ccyDao.create(currency);
    }

    public void updateCurrency(Currency currency) {
        ccyDao.update(currency);
    }

    public Currency getCurrencyDetail(String ccyCode) {
//        return ccyDao.read(ccyCode);
        return ccyDao.findByCurrencyCode(ccyCode);
    }

    public List<Currency> getcurrencyListByCriteria(CurrencyEnquiryParam ccyEnquiryParam) {
        return ccyDao.findByCriteria(ccyEnquiryParam);
    }

    public void setCcyDao(CurrencyDao ccyDao) {
        this.ccyDao = ccyDao;
    }

}
