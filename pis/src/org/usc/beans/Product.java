package org.usc.beans;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Product
 *
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2011-8-8<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "product_id", unique = true, nullable = false)
	private Long productId;

	@Column(name = "model")
	private String model;

	@Column(name = "name")
	private String name;

	@Column(name = "sampling_ratio")
	private BigDecimal samplingRatio;

	@Column(name = "standard_length")
	private BigDecimal standardLength;

	@Column(name = "error_range")
	private BigDecimal errorRange;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "draw_id")
	private Draw draw;

	public Product() {
	}

	public Product(String model, String name, BigDecimal samplingRatio, BigDecimal standardLength, BigDecimal errorRange) {
		this.model = model;
		this.name = name;
		this.samplingRatio = samplingRatio;
		this.standardLength = standardLength;
		this.errorRange = errorRange;
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

	public BigDecimal getSamplingRatio() {
		return samplingRatio;
	}

	public void setSamplingRatio(BigDecimal samplingRatio) {
		this.samplingRatio = samplingRatio;
	}

	public BigDecimal getStandardLength() {
		return standardLength;
	}

	public void setStandardLength(BigDecimal standardLength) {
		this.standardLength = standardLength;
	}

	public BigDecimal getErrorRange() {
		return errorRange;
	}

	public void setErrorRange(BigDecimal errorRange) {
		this.errorRange = errorRange;
	}

	public Draw getDraw() {
		return draw;
	}

	public void setDraw(Draw draw) {
		this.draw = draw;
	}

}
