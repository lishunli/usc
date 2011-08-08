package org.usc.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Draw
 *
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2011-8-8<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
@Entity
@Table(name = "draw")
public class Draw {

	@Id
	@GeneratedValue
	@Column(name = "draw_id", unique = true, nullable = false)
	private Long drawId;

	@Column(name = "name")
	private String name;

	public Draw() {
	}

	public Draw(String name) {
		this.name = name;
	}

	public Long getDrawId() {
		return drawId;
	}

	public void setDrawId(Long drawId) {
		this.drawId = drawId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
