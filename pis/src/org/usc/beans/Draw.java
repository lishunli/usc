package org.usc.beans;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.usc.beans.base.Physical;

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
@AttributeOverride(name = "id", column = @Column(name = "draw_id"))
public class Draw extends Physical {
	public Draw() {
	}
}
