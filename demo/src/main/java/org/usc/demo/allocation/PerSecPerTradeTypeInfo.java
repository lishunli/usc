package org.usc.demo.allocation;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author ShunLi
 */
public class PerSecPerTradeTypeInfo {
    String instrumentCode;
    String tradeType;

    public PerSecPerTradeTypeInfo() {
        super();
    }

    public PerSecPerTradeTypeInfo(String instrumentCode, String tradeType) {
        this.instrumentCode = instrumentCode;
        this.tradeType = tradeType;
    }

    public String getInstrumentCode() {
        return instrumentCode;
    }

    public void setInstrumentCode(String instrumentCode) {
        this.instrumentCode = instrumentCode;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((instrumentCode == null) ? 0 : instrumentCode.hashCode());
        result = prime * result + ((tradeType == null) ? 0 : tradeType.hashCode());
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
        PerSecPerTradeTypeInfo other = (PerSecPerTradeTypeInfo) obj;
        if (instrumentCode == null) {
            if (other.instrumentCode != null)
                return false;
        } else if (!instrumentCode.equals(other.instrumentCode))
            return false;
        if (tradeType == null) {
            if (other.tradeType != null)
                return false;
        } else if (!tradeType.equals(other.tradeType))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
