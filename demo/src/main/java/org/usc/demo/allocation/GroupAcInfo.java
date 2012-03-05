package org.usc.demo.allocation;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author ShunLi
 */
public class GroupAcInfo {
    String accountCode;
    BigDecimal totalQty;
    BigDecimal unAllocQty;

    public GroupAcInfo() {
        super();
    }

    public GroupAcInfo(String accountCode, BigDecimal totalQty) {
        this.accountCode = accountCode;
        this.totalQty = totalQty;
        this.unAllocQty = totalQty;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public BigDecimal getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(BigDecimal totalQty) {
        this.totalQty = totalQty;
    }

    public BigDecimal getUnAllocQty() {
        return unAllocQty;
    }

    public void setUnAllocQty(BigDecimal unAllocQty) {
        this.unAllocQty = unAllocQty;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
