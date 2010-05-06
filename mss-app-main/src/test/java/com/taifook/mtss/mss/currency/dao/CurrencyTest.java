package com.taifook.mtss.mss.currency.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.taifook.mtss.framework.test.AbstractHibernateJpaTest;
import com.taifook.mtss.mss.currency.model.Currency;
import com.taifook.mtss.mss.currency.model.CurrencyEnquiryParam;

/**
 * @author slli
 *
 */
@ContextConfiguration
public class CurrencyTest extends AbstractHibernateJpaTest {

    @Resource(name = "currency.dao.CurrencyDao")
    private CurrencyDao ccyDao;

    @Before
    public void initialize() throws Exception {
        getJdbcTemplate().update("insert into MC_CCY(CCY_CDE,PRFX_SYM,PRIMY_CCY_NAM,ISO_ALPHA,ISO_NUM,DEC,IS_VLD,IS_RESTRICT) "
                                + " values('c1','s1','p1','a1',11,2,'Y','N')");

        getJdbcTemplate().update("insert into MC_CCY(CCY_CDE,PRFX_SYM,PRIMY_CCY_NAM,ISO_ALPHA,ISO_NUM,DEC,IS_VLD,IS_RESTRICT) "
                + " values('c2','s2','p2','a2',21,2,'Y','N')");

        getJdbcTemplate().update("insert into MC_CCY_NAM(CCY_NAM_ID,CCY_CDE,LANG_TYP,CCY_NAM,UNIT_NAM,IS_PRIMY) "
                + " values(1,'c1','ZH_CN','人民币','元','Y')");

        getJdbcTemplate().update("insert into MC_CCY_NAM(CCY_NAM_ID,CCY_CDE,LANG_TYP,CCY_NAM,UNIT_NAM,IS_PRIMY) "
                + " values(2,'c1','ZH_TW','港币','港元','N')");

        getJdbcTemplate().update("insert into MC_CCY_NAM(CCY_NAM_ID,CCY_CDE,LANG_TYP,CCY_NAM,UNIT_NAM,IS_PRIMY) "
                + " values(3,'c1','EN','美元','美元','N')");

        getJdbcTemplate().update("insert into MC_CCY_NAM(CCY_NAM_ID,CCY_CDE,LANG_TYP,CCY_NAM,UNIT_NAM,IS_PRIMY) "
                + " values(4,'c2','ZH_CN','人民币','元','Y')");

        getJdbcTemplate().update("insert into MC_CCY_NAM(CCY_NAM_ID,CCY_CDE,LANG_TYP,CCY_NAM,UNIT_NAM,IS_PRIMY) "
                + " values(5,'c2','EN','美元','美元','N')");


    }

    @Test
    public void testFindByCurrencyCode() {

        Currency currency = ccyDao.findByCurrencyCode("c1");

        assertNotNull("currency null", currency);
        assertEquals("c1 prefixSymbol not s1", "s1", currency.getPrefixSymbol());
        assertEquals("size is not 3", 3, currency.getNames().size());

    }

/*    @Test
    public void testFindByCriteria()
    {
       List<Currency> currency = ccyDao.findByCriteria("c1", null, null, null, null);

       assertNotNull("currency is not null", currency);
       assertEquals("size is not 1 ",1,currency.size() );
       assertEquals("currency c1's PrimaryName is not p1", "p1", currency.get(0).getPrimaryName());
    }*/

    @Test
    public void testFindByCriteriaByEP()
    {
       CurrencyEnquiryParam ccyEnquiryParam = new CurrencyEnquiryParam();
       ccyEnquiryParam.setCode("c1");
       List<Currency> currency = ccyDao.findByCriteria(ccyEnquiryParam);

       assertNotNull("currency is not null", currency);
       assertEquals("size is not 1 ",1,currency.size() );
       assertEquals("currency c1's PrimaryName is not p1", "p1", currency.get(0).getPrimaryName());
    }




}
