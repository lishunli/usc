package org.usc.beans;


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
	private String standardLength;
	private String errorRange;
	private int injectionAmt;
	private String draw;

	public ProductDto() {
	}

	public ProductDto(Long productId, String model, String name, String samplingRatio, String standardLength, String errorRange,  int injectionAmt, String draw) {
		super();
		this.productId = productId;
		this.model = model;
		this.name = name;
		this.samplingRatio = samplingRatio;
		this.standardLength = standardLength;
		this.errorRange = errorRange;
		this.injectionAmt = injectionAmt;
		this.draw = draw;
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

	public String getStandardLength() {
		return standardLength;
	}

	public void setStandardLength(String standardLength) {
		this.standardLength = standardLength;
	}

	public String getErrorRange() {
		return errorRange;
	}

	public void setErrorRange(String errorRange) {
		this.errorRange = errorRange;
	}

	public int getInjectionAmt() {
		return injectionAmt;
	}

	public void setInjectionAmt(int injectionAmt) {
		this.injectionAmt = injectionAmt;
	}

	public String getDraw() {
		return draw;
	}

	public void setDraw(String draw) {
		this.draw = draw;
	}

}
