package org.usc.dto;

import java.util.List;

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
public class PartDto {
	private String name;
	private String draw;
	private List<InjectionDto> injections;

	public PartDto() {
	}

	public PartDto(String name, String draw, List<InjectionDto> injections) {
		this.name = name;
		this.draw = draw;
		this.injections = injections;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDraw() {
		return draw;
	}

	public void setDraw(String draw) {
		this.draw = draw;
	}

	public List<InjectionDto> getInjections() {
		return injections;
	}

	public void setInjections(List<InjectionDto> injections) {
		this.injections = injections;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
