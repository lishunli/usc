package org.usc.demo.allocation;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author ShunLi
 */
public class GroupTradeRefInfo {
    BigDecimal allocQty;
    BigDecimal realExec;
    BigDecimal remainQty;

    Map<String, BigDecimal> allocation = new TreeMap<String, BigDecimal>();

    public GroupTradeRefInfo() {
        super();
    }

    public GroupTradeRefInfo(BigDecimal allocQty, BigDecimal realExec) {
        this.allocQty = allocQty;
        this.realExec = realExec;
        this.remainQty = allocQty;
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

    public BigDecimal getRemainQty() {
        return remainQty;
    }

    public void setRemainQty(BigDecimal remainQty) {
        this.remainQty = remainQty;
    }

    public Map<String, BigDecimal> getAllocation() {
        return allocation;
    }

    public void setAllocation(Map<String, BigDecimal> allocation) {
        this.allocation = allocation;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
