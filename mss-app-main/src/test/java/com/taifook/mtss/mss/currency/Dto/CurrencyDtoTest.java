package com.taifook.mtss.mss.currency.Dto;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import com.taifook.mtss.framework.dto.DtoBuilder;
import com.taifook.mtss.mss.currency.dto.CurrencyDto;
import com.taifook.mtss.mss.currency.model.Currency;

/**
 * @author slli
 *
 */
public class CurrencyDtoTest {

    @Test
    public void testMergeModel() throws Exception {

        // Input data
        CurrencyDto dto = new CurrencyDto("c1", "s1", "p1", "a1", 11L, 2, true, false, null);
        Currency model = new Currency();

        // Run test
        DtoBuilder.mergeModel(dto, model);

        // Verify
        assertEquals("currency code", "c1", model.getCode());
        assertEquals("currency c1's PrimaryName is not p1", "p1", model.getPrimaryName());

    }
}
