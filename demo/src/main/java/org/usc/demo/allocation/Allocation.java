package org.usc.demo.allocation;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author ShunLi
 */
public class Allocation {

    public static void main(String[] args) throws IOException {
        @SuppressWarnings("unchecked")
        List<String> contents = FileUtils.readLines(new File("F:/OMS1_20110826.txt"), "utf-8");

        List<TradeInfo> tradeInfos = new ArrayList<TradeInfo>();

        for (String str : contents) {
            tradeInfos.add(new TradeInfo(
                     str.substring(16, 46).trim(),
                     str.substring(47, 48),
                     str.substring(49, 69).trim(),
                     str.substring(70, 90).trim(),
                     str.substring(91, 111).trim(),
                     new BigDecimal(str.substring(112, 122).trim()),
                     new BigDecimal(str.substring(296, 306).trim())));
        }

        // maybe grouping by sql. group by instrument, tradeType.
        List<SecPlusTradeTypePair> secPlusTradeTypePairs = new ArrayList<SecPlusTradeTypePair>();

        for (TradeInfo trade : tradeInfos) {
            SecPlusTradeTypePair secPlusTradeTypePair = new SecPlusTradeTypePair(trade.getInstrumentCode(), trade.getBuySell());
            if (!secPlusTradeTypePairs.contains(secPlusTradeTypePair)) {
                secPlusTradeTypePairs.add(secPlusTradeTypePair);
            }
        }

        List<TradeInfo> subTradeInfos = new ArrayList<TradeInfo>(); // handle per instrument + trade type.
        for (SecPlusTradeTypePair secPlusTradeTypePair : secPlusTradeTypePairs) {
            subTradeInfos.clear();
            String instrumentCode = secPlusTradeTypePair.getInstrumentCode();
            String tradeType = secPlusTradeTypePair.getTradeType();
            System.out.println(StringUtils.center(" Handle Instrument " + instrumentCode + ", and tradetype " + tradeType + " ", 60, "="));

            for (TradeInfo trade : tradeInfos) {
                if (trade.getInstrumentCode().equals(instrumentCode)
                         && trade.getBuySell().equals(tradeType)) {
                    subTradeInfos.add(trade);
                }
            }

            Map<String, GroupAcInfo> acGrouping = new TreeMap<String, GroupAcInfo>();

            // grouping by ac code.
            for (TradeInfo subTrade : subTradeInfos) {
                String accoutCode = subTrade.getAllocAc();
                if (acGrouping.containsKey(accoutCode)) {
                    GroupAcInfo acInfo = acGrouping.get(accoutCode);
                    acInfo.setTotalQty(acInfo.getTotalQty().add(subTrade.getAllocQty()));
                    acInfo.setUnAllocQty(acInfo.getTotalQty());
                } else {
                    acGrouping.put(accoutCode, new GroupAcInfo(accoutCode, subTrade.getAllocQty()));
                }
            }

            // cal summary qty.
            BigDecimal summary = BigDecimal.ZERO;
            for (GroupAcInfo acInfo : acGrouping.values()) {
                summary = summary.add(acInfo.getTotalQty());
            }

            // grouping by trade ref no.
            Map<String, GroupTradeRefInfo> tradeRefGrouping = new TreeMap<String, GroupTradeRefInfo>();

            for (TradeInfo subTrade : subTradeInfos) {
                String exchgTradeRef = subTrade.getExchgTradeRef();

                if (tradeRefGrouping.containsKey(exchgTradeRef)) {
                    GroupTradeRefInfo detail = tradeRefGrouping.get(exchgTradeRef);
                    detail.setAllocQty(detail.getAllocQty().add(subTrade.getAllocQty()));
                    detail.setRemainQty(detail.getAllocQty());
                } else {
                    tradeRefGrouping.put(exchgTradeRef, new GroupTradeRefInfo(subTrade.getAllocQty(), subTrade.getRealExec()));
                }
            }

            // all account set for this instrument + trade type.
            List<String> keys = new ArrayList<String>(acGrouping.keySet());

            // 1st allocation
            for (GroupTradeRefInfo detail : tradeRefGrouping.values()) {
                Map<String, BigDecimal> allocation = detail.getAllocation();
                for (String key : keys) {
                    GroupAcInfo acInfo = acGrouping.get(key);
                    BigDecimal firstAllocation = acInfo.getTotalQty().multiply(detail.getAllocQty()).divide(summary, 0, BigDecimal.ROUND_DOWN);

                    allocation.put(key, firstAllocation);

                    detail.setRemainQty(detail.getRemainQty().subtract(firstAllocation));
                    acInfo.setUnAllocQty(acInfo.getUnAllocQty().subtract(firstAllocation));
                }

            }

            // 2nd allocation
            int index = 0;

            for (GroupTradeRefInfo detail : tradeRefGrouping.values()) {
                while (detail.getRemainQty().signum() > 0) {
                    String key = keys.get(index);
                    GroupAcInfo acInfo = acGrouping.get(key);
                    BigDecimal secondAllocation = BigDecimal.ONE;

                    Map<String, BigDecimal> allocation = detail.getAllocation();
                    allocation.put(key, allocation.get(key).add(secondAllocation));

                    detail.setRemainQty(detail.getRemainQty().subtract(secondAllocation));
                    acInfo.setUnAllocQty(acInfo.getUnAllocQty().subtract(secondAllocation));

                    index++;

                    if (acInfo.getUnAllocQty().signum() == 0) {
                        keys.remove(key);
                        index--;
                        if (keys.isEmpty()) {
                            break;
                        }
                    }

                    index = index % keys.size();
                }

                if (keys.isEmpty()) {
                    // normal flow never invoke here.
                    break;
                }
            }

            System.out.println(tradeRefGrouping);
            System.out.println("=========================================");
            System.out.println(acGrouping);

            // TODO-Shunli - to calc avg price.

            // break; // TODO
        }

    }
}
