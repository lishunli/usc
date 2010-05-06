package com.taifook.mtss.mss.currency.service.impl;

import static org.easymock.EasyMock.createControl;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Test;

import com.taifook.mtss.mss.common.exception.DataDuplicatedException;
import com.taifook.mtss.mss.currency.dao.CurrencyDao;
import com.taifook.mtss.mss.currency.model.Currency;
import com.taifook.mtss.mss.currency.model.CurrencyEnquiryParam;

/**
 * @author slli
 *
 */
public class CurrencyServiceImplTest {
    private CurrencyServiceImpl ccyService;
    private CurrencyDao mockCcyDao;
    private IMocksControl mockControl;

    @Before
    public void initialize() throws Exception {
        ccyService = new CurrencyServiceImpl();
        mockControl = createControl();

        mockCcyDao = mockControl.createMock(CurrencyDao.class);

        ccyService.setCcyDao(mockCcyDao);
    }

    @Test
    public void testGetCurrencyDetail(){

        //Setup expectation
        expect(mockCcyDao.findByCurrencyCode("c1")).andReturn(new Currency("s1", "p1", "a1", 11L, 2, true, false, null));
        replay(mockCcyDao);

        //Run test
        Currency ccy = ccyService.getCurrencyDetail("c1");

        //Verify
        verify(mockCcyDao);
        assertNotNull("Currency ccy is null",ccy);
        assertEquals("currency c1's PrimaryName is not p1", "p1", ccy.getPrimaryName());
    }

    @Test
    public void testAddCurrency() throws DataDuplicatedException{

        //init para
        Currency currency = new Currency("c1","s1", "p1", "a1", 11L, 2, true, false, null);

        //Setup expectation
        expect(mockCcyDao.read("c1")).andReturn(null);
        mockCcyDao.create(currency);
        replay(mockCcyDao);

        //Run test
        ccyService.addCurrency(currency);

        //Verify
        verify(mockCcyDao);
    }

    @Test
    public void testUpdateCurrency(){
      Currency currency = new Currency("c1","s11", "p1", "a1", 11L, 2, true, false, null);

      expect(mockCcyDao.update(currency)).andReturn(currency);
      replay(mockCcyDao);

      //Run test
      ccyService.updateCurrency(currency);

      //Verify
      verify(mockCcyDao);
    }

    @Test
    public void testGetcurrencyListByCriteria(){

        //init para
        CurrencyEnquiryParam ccyEnquiryParam = new CurrencyEnquiryParam();
        ccyEnquiryParam.setCode("c1");
        List<Currency> currency = new ArrayList<Currency>();
        currency.add(new Currency("c1","s11", "p1", "a1", 11L, 2, true, false, null));

        //Setup expectation
        expect(mockCcyDao.findByCriteria(ccyEnquiryParam)).andReturn(currency);
        replay(mockCcyDao);

        //start test
        ccyService.getcurrencyListByCriteria(ccyEnquiryParam);

        //verify
        verify(mockCcyDao);

    }
}
