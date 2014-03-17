package org.usc.demo.el;

/**
 *
 * @author Shunli
 */
public class ELDemoObj {
    private String id;
    private String remark;
    private String giftId;
    private String giftIdExp;

    public ELDemoObj() {
    }

    public ELDemoObj(String id, String remark) {
        this.id = id;
        this.remark = remark;
    }

    public ELDemoObj(String id, String remark, String giftId, String giftIdExp) {
        this.id = id;
        this.remark = remark;
        this.giftId = giftId;
        this.giftIdExp = giftIdExp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    public String getGiftIdExp() {
        return giftIdExp;
    }

    public void setGiftIdExp(String giftIdExp) {
        this.giftIdExp = giftIdExp;
    }

}
