package com.taifook.mtss.mss.currency.Dto;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import org.junit.Test;

import com.taifook.mtss.framework.dto.DtoBuilder;
import com.taifook.mtss.mss.common.model.Language;
import com.taifook.mtss.mss.currency.dto.CurrencyNameDto;
import com.taifook.mtss.mss.currency.model.CurrencyName;

/**
 * @author slli
 *
 */
public class CurrencyNameDtoTest {

    @Test
    public void testMergeModel() throws Exception {

        Long id = new Long(1L);

        // Input data
        CurrencyNameDto dto= new CurrencyNameDto(id,Language.ZH_CN,"ÈËÃñ±Ò","Ôª",true);
        CurrencyName model= new CurrencyName();

        // Run test
        DtoBuilder.mergeModel(dto,model);

        // Verify
        assertEquals("CurrencyName Id", id, model.getId());
        assertEquals("CurrencyName's Language",Language.ZH_CN, model.getLangCode());
//        assertNotNull("CurrencyName's Parent Currency",model.getCurrency());
//        assertEquals("CurrencyName's Parent Currency code","c1" ,model.getCurrency().getCode());
    }
}
