package cn.itcast.web.formbean.privilege;

import cn.itcast.web.formbean.BaseForm;

public class DepartmentForm extends BaseForm{
	private Integer departmentid;
	private String name;
	public Integer getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
