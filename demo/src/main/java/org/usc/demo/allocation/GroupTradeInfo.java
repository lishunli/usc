package org.usc.demo.allocation;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author ShunLi
 */
public class GroupTradeInfo {
    String exchgTradeRef;
    BigDecimal realExec;
    BigDecimal allocQty;

    public GroupTradeInfo() {
        super();
    }

    public GroupTradeInfo(String exchgTradeRef, BigDecimal realExec) {
        super();
        this.exchgTradeRef = exchgTradeRef;
        this.realExec = realExec;
    }

    public String getExchgTradeRef() {
        return exchgTradeRef;
    }

    public void setExchgTradeRef(String exchgTradeRef) {
        this.exchgTradeRef = exchgTradeRef;
    }

    public BigDecimal getRealExec() {
        return realExec;
    }

    public void setRealExec(BigDecimal realExec) {
        this.realExec = realExec;
    }

    public BigDecimal getAllocQty() {
        return allocQty;
    }

    public void setAllocQty(BigDecimal allocQty) {
        this.allocQty = allocQty;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((exchgTradeRef == null) ? 0 : exchgTradeRef.hashCode());
        result = prime * result + ((realExec == null) ? 0 : realExec.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GroupTradeInfo other = (GroupTradeInfo) obj;
        if (exchgTradeRef == null) {
            if (other.exchgTradeRef != null)
                return false;
        } else if (!exchgTradeRef.equals(other.exchgTradeRef))
            return false;
        if (realExec == null) {
            if (other.realExec != null)
                return false;
        } else if (!realExec.equals(other.realExec))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
