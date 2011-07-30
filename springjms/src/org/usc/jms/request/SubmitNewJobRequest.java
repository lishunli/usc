package org.usc.jms.request;


public class SubmitNewJobRequest extends BatchJobRequest {
	private static final long serialVersionUID = 2342101555809817396L;

	private String jobName;
	private Long jobRunId;
	private Long parentJobId;

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Long getJobRunId() {
		return jobRunId;
	}

	public void setJobRunId(Long jobRunId) {
		this.jobRunId = jobRunId;
	}

	public Long getParentJobId() {
		return parentJobId;
	}

	public void setParentJobId(Long parentJobId) {
		this.parentJobId = parentJobId;
	}
}
