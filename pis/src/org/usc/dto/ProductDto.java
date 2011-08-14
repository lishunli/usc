package org.usc.dto;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Product Dto
 *
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2011-8-8<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public class ProductDto {
	private Long productId;
	private String model;
	private String name;
	private String samplingRatio;
	private int injectionAmt;

	private List<PartDto> parts;

	public ProductDto() {
	}

	public ProductDto(Long productId, String model, String name, String samplingRatio, int injectionAmt, List<PartDto> parts) {
		super();
		this.productId = productId;
		this.model = model;
		this.name = name;
		this.samplingRatio = samplingRatio;
		this.injectionAmt = injectionAmt;
		this.parts = parts;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSamplingRatio() {
		return samplingRatio;
	}

	public void setSamplingRatio(String samplingRatio) {
		this.samplingRatio = samplingRatio;
	}

	public int getInjectionAmt() {
		return injectionAmt;
	}

	public void setInjectionAmt(int injectionAmt) {
		this.injectionAmt = injectionAmt;
	}

	public List<PartDto> getParts() {
		return parts;
	}

	public void setParts(List<PartDto> parts) {
		this.parts = parts;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}


}
