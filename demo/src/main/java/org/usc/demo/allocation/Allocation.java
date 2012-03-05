package org.usc.demo.allocation;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author ShunLi
 */
public class Allocation {

    public static void main(String[] args) throws IOException {
        @SuppressWarnings("unchecked")
        List<String> contents = FileUtils.readLines(new File("D:/OMS1_20110826.txt"), "utf-8");

        List<TradeInfo> tradeInfos = new ArrayList<TradeInfo>();

        for (String str : contents) {
            tradeInfos.add(new TradeInfo(
                     str.substring(45, 46),
                     str.substring(47, 48),
                     str.substring(49, 69).trim(),
                     str.substring(70, 90).trim(),
                     str.substring(91, 111).trim(),
                     new BigDecimal(str.substring(112, 122).trim()),
                     new BigDecimal(str.substring(296, 306).trim())));
        }

        // System.out.println(tradeInfos);

        List<PerSecPerTradeTypeInfo> perSecPerTradeTypeInfos = new ArrayList<PerSecPerTradeTypeInfo>();

        for (TradeInfo trade : tradeInfos) {
            PerSecPerTradeTypeInfo perSecPerTradeTypeInfo = new PerSecPerTradeTypeInfo(trade.getInstrumentCode(), trade.getBuySell());
            if (!perSecPerTradeTypeInfos.contains(perSecPerTradeTypeInfo)) {
                perSecPerTradeTypeInfos.add(perSecPerTradeTypeInfo);
            }
        }




        // System.out.println(perSecPerTradeTypeInfos);

        List<TradeInfo> subTradeInfos = new ArrayList<TradeInfo>();
        for (PerSecPerTradeTypeInfo perSecPerTradeTypeInfo : perSecPerTradeTypeInfos) {
            subTradeInfos.clear();
            String instrumentCode = perSecPerTradeTypeInfo.getInstrumentCode();
            String tradeType = perSecPerTradeTypeInfo.getTradeType();
            System.out.println(StringUtils.center(" Handle Instrument " + instrumentCode + ", and tradetype " + tradeType + " ", 60, "="));

            for (TradeInfo trade : tradeInfos) {
                if (trade.getInstrumentCode().equals(instrumentCode)
                         && trade.getBuySell().equals(tradeType)) {
                    subTradeInfos.add(trade);
                }
            }

            Map<String, AcInfo> acGrouping = new HashMap<String, AcInfo>();

            for (TradeInfo subTrade : subTradeInfos) {
                String accoutCode = subTrade.getAllocAc();
                if (acGrouping.containsKey(accoutCode)) {
                    AcInfo acInfo = acGrouping.get(accoutCode);
                    acInfo.setTotalQty(acInfo.getTotalQty().add(subTrade.getAllocQty()));
                    acInfo.setUnAllocQty(acInfo.getTotalQty());
                } else {
                    acGrouping.put(accoutCode, new AcInfo(accoutCode, subTrade.getAllocQty()));
                }

            }
//            System.out.println(subTradeInfos);
//            System.out.println(acGrouping);

            break; // TODO
        }

    }
}
