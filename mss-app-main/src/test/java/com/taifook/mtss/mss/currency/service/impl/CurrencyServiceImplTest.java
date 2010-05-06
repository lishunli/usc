package com.taifook.mtss.mss.currency.service.impl;

import static org.easymock.EasyMock.createControl;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Test;

import com.taifook.mtss.mss.currency.dao.CurrencyDao;
import com.taifook.mtss.mss.currency.model.Currency;

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
        // Setup expectation

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

}
