package org.usc.demo.db;

/**
 *
 * @author Shunli
 */
public class Vote {
    private long seqId;
    private String belleId;
    private int num;

    public Vote() {
    }

    public Vote(String belleId, int num) {
        this.belleId = belleId;
        this.num = num;
    }

    public long getSeqId() {
        return seqId;
    }

    public void setSeqId(long seqId) {
        this.seqId = seqId;
    }

    public String getBelleId() {
        return belleId;
    }

    public void setBelleId(String belleId) {
        this.belleId = belleId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
