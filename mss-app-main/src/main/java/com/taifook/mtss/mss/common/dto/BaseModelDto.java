package com.taifook.mtss.mss.common.dto;

import java.io.Serializable;
import java.util.Date;

import com.taifook.mtss.framework.dto.annotation.Dto;
import com.taifook.mtss.framework.dto.annotation.DtoField;

@Dto
public abstract class BaseModelDto implements Serializable {

    private static final long serialVersionUID = -7819839467009029202L;

    @DtoField(skipMerge=true)
    protected Date createTime;

    @DtoField(skipMerge=true)
    protected Date lastUpdateTime;

    @DtoField(skipMerge=true)
    protected String lastUpdatedBy;

    @DtoField(skipMerge=true, version=true)
    protected Long recordVersion;

    @DtoField(skipMerge=true)
    protected Long tagSequence;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Long getRecordVersion() {
        return recordVersion;
    }

    public void setRecordVersion(Long recordVersion) {
        this.recordVersion = recordVersion;
    }

    public Long getTagSequence() {
        return tagSequence;
    }

    public void setTagSequence(Long tagSequence) {
        this.tagSequence = tagSequence;
    }

}
