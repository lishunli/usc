package org.usc.jms.request;

import java.io.Serializable;

public class BatchJobRequest implements Serializable {

    private static final long serialVersionUID = -2654846189073357489L;

    private Long requestId;
    private String targetServerId;
    private String userId;

    public Long getRequestId() {
        return requestId;
    }
    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }
    public String getTargetServerId() {
        return targetServerId;
    }
    public void setTargetServerId(String targetServerId) {
        this.targetServerId = targetServerId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
