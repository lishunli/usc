package org.usc.demo.allocation;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author ShunLi
 */
public class TradeInfo {
    String instrumentCode;
    String buySell;
    String exchgOrderRef;
    String exchgTradeRef;
    String allocAc;
    BigDecimal allocQty;
    BigDecimal realExec;

    public TradeInfo() {
    }

    public TradeInfo(String instrumentCode, String buySell, String exchgOrderRef, String exchgTradeRef, String allocAc, BigDecimal allocQty, BigDecimal realExec) {
        this.instrumentCode = instrumentCode;
        this.buySell = buySell;
        this.exchgOrderRef = exchgOrderRef;
        this.exchgTradeRef = exchgTradeRef;
        this.allocAc = allocAc;
        this.allocQty = allocQty;
        this.realExec = realExec;
    }

    public String getInstrumentCode() {
        return instrumentCode;
    }

    public void setInstrumentCode(String instrumentCode) {
        this.instrumentCode = instrumentCode;
    }

    public String getBuySell() {
        return buySell;
    }

    public void setBuySell(String buySell) {
        this.buySell = buySell;
    }

    public String getExchgOrderRef() {
        return exchgOrderRef;
    }

    public void setExchgOrderRef(String exchgOrderRef) {
        this.exchgOrderRef = exchgOrderRef;
    }

    public String getExchgTradeRef() {
        return exchgTradeRef;
    }

    public void setExchgTradeRef(String exchgTradeRef) {
        this.exchgTradeRef = exchgTradeRef;
    }

    public String getAllocAc() {
        return allocAc;
    }

    public void setAllocAc(String allocAc) {
        this.allocAc = allocAc;
    }

    public BigDecimal getAllocQty() {
        return allocQty;
    }

    public void setAllocQty(BigDecimal allocQty) {
        this.allocQty = allocQty;
    }

    public BigDecimal getRealExec() {
        return realExec;
    }

    public void setRealExec(BigDecimal realExec) {
        this.realExec = realExec;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
