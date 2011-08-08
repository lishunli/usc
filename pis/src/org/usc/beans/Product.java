package org.usc.beans;

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
	private Double samplingRatio;

	@Column(name = "standard_length")
	private Double standardLength;

	@Column(name = "error_range")
	private Double errorRange;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "draw_id")
	private Draw draw;

	public Product() {
	}

	public Product(String model, String name, Double samplingRatio, Double standardLength, Double errorRange) {
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

	public Double getSamplingRatio() {
		return samplingRatio;
	}

	public void setSamplingRatio(Double samplingRatio) {
		this.samplingRatio = samplingRatio;
	}

	public Double getStandardLength() {
		return standardLength;
	}

	public void setStandardLength(Double standardLength) {
		this.standardLength = standardLength;
	}

	public Double getErrorRange() {
		return errorRange;
	}

	public void setErrorRange(Double errorRange) {
		this.errorRange = errorRange;
	}

	public Draw getDraw() {
		return draw;
	}

	public void setDraw(Draw draw) {
		this.draw = draw;
	}

}
