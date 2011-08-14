package org.usc.beans;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.usc.beans.base.Physical;

/**
 * Injection
 *
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2011-8-14<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
@Entity
@Table(name = "injection")
@AttributeOverride(name = "id", column = @Column(name = "injection_id"))
public class Injection extends Physical {
	@Column(name = "standard_length")
	private BigDecimal standardLength;

	@Column(name = "up_error_range")
	private BigDecimal upErrorRange;

	@Column(name = "down_error_range")
	private BigDecimal downErrorRange;

	public Injection() {
	}

	public BigDecimal getStandardLength() {
		return standardLength;
	}

	public void setStandardLength(BigDecimal standardLength) {
		this.standardLength = standardLength;
	}

	public BigDecimal getUpErrorRange() {
		return upErrorRange;
	}

	public void setUpErrorRange(BigDecimal upErrorRange) {
		this.upErrorRange = upErrorRange;
	}

	public BigDecimal getDownErrorRange() {
		return downErrorRange;
	}

	public void setDownErrorRange(BigDecimal downErrorRange) {
		this.downErrorRange = downErrorRange;
	}
}
