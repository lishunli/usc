package cn.itcast.bean.privilege;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ���֤
 */
@Entity
public class IDCard {
	private Integer id;
	/* 18 ,����Ϊnull */
	private String cardno;
	/* 80 ����Ϊnull */
	private String address;
	/* �������� */
	private Date birthday;//����ֻ�������ڲ��ֵ����ͱ�ʾ
	private Employee employee;
	
	public IDCard(){}
	               
	public IDCard(String cardno, String address, Date birthday) {
		this.cardno = cardno;
		this.address = address;
		this.birthday = birthday;
	}
	
	@Id @GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(nullable=false,length=18)
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	@Column(nullable=false,length=80)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Temporal(TemporalType.DATE) @Column(nullable=false)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@OneToOne(mappedBy="idCard", cascade=CascadeType.REFRESH)
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final IDCard other = (IDCard) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
