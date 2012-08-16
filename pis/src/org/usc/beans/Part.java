package org.usc.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.usc.beans.base.Physical;

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
@Table(name = "part")
@AttributeOverride(name = "id", column = @Column(name = "part_id"))
public class Part extends Physical {
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "part_id")
	private Draw draw;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "part_id")
	@OrderBy
	private List<Injection> injections = new ArrayList<Injection>();

	public Part() {
	}

	public Draw getDraw() {
		return draw;
	}

	public void setDraw(Draw draw) {
		this.draw = draw;
	}

	public List<Injection> getInjections() {
		return injections;
	}

	public void setInjections(List<Injection> injections) {
		this.injections = injections;
	}
}