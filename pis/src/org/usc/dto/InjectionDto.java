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
	private String upSize;
	private String downSize;

	public InjectionDto(String name, String upSize, String downSize) {
		this.name = name;
		this.upSize = upSize;
		this.downSize = downSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpSize() {
		return upSize;
	}

	public void setUpSize(String upSize) {
		this.upSize = upSize;
	}

	public String getDownSize() {
		return downSize;
	}

	public void setDownSize(String downSize) {
		this.downSize = downSize;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
