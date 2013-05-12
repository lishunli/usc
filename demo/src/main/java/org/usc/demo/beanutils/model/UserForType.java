package org.usc.demo.beanutils.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserForType {
    private String s;
    private Boolean b;
    private Integer i;
    private Long l;
    private Double d;
    private Float f;
    private Date de;
    private String[] sa;
    private List<String> sl;
    private Map<String, String> m;

    public UserForType() {
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Boolean getB() {
        return b;
    }

    public void setB(Boolean b) {
        this.b = b;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public Long getL() {
        return l;
    }

    public void setL(Long l) {
        this.l = l;
    }

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }

    public Float getF() {
        return f;
    }

    public void setF(Float f) {
        this.f = f;
    }

    public Date getDe() {
        return de;
    }

    public void setDe(Date de) {
        this.de = de;
    }

    public String[] getSa() {
        return sa;
    }

    public void setSa(String[] sa) {
        this.sa = sa;
    }

    public List<String> getSl() {
        return sl;
    }

    public void setSl(List<String> sl) {
        this.sl = sl;
    }

    public Map<String, String> getM() {
        return m;
    }

    public void setM(Map<String, String> m) {
        this.m = m;
    }

    @Override
    public String toString() {
        return "UserForType [s=" + s + ", b=" + b + ", i=" + i + ", l=" + l + ", d=" + d + ", f=" + f + ", de=" + de + ", sa=" + Arrays.toString(sa) + ", sl=" + sl + ", m=" + m + "]";
    }

}
