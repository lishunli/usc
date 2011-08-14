package org.usc.dto;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 *
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2011-8-14<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public class InjectionDto {
	private String name;
	private String standardLength;
	private String upErrorRange;
	private String downErrorRange;

	public InjectionDto(String name, String standardLength, String upErrorRange, String downErrorRange) {
		this.name = name;
		this.standardLength = standardLength;
		this.upErrorRange = upErrorRange;
		this.downErrorRange = downErrorRange;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStandardLength() {
		return standardLength;
	}

	public void setStandardLength(String standardLength) {
		this.standardLength = standardLength;
	}

	public String getUpErrorRange() {
		return upErrorRange;
	}

	public void setUpErrorRange(String upErrorRange) {
		this.upErrorRange = upErrorRange;
	}

	public String getDownErrorRange() {
		return downErrorRange;
	}

	public void setDownErrorRange(String downErrorRange) {
		this.downErrorRange = downErrorRange;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
