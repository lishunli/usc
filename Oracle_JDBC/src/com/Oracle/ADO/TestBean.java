package com.Oracle.ADO;

import java.util.Date;



public class TestBean
{
		private Long empno;
	     private String ename;
	     private Double sal=0.00;


	    // Constructors

	    /** default constructor */
	    public TestBean() {
	    }

	    
	    /** full constructor */
	    public TestBean(Long empno, String ename, String job, Long mgr, Date hiredate, Double sal, Double comm, Long deptno) {
	        this.empno = empno;
	        this.ename = ename;
	        this.sal = sal;

	    }

	   
	    // Property accessors

	    public Long getEmpno() {
	        return this.empno;
	    }
	    
	    public void setEmpno(Long empno) {
	        this.empno = empno;
	    }

	    public String getEname() {
	        return this.ename;
	    }
	    
	    public void setEname(String ename) {
	        this.ename = ename;
	    }


	    public Double getSal() {
	        return this.sal;
	    }
	    
	    public void setSal(Double sal) {
	        this.sal = sal;
	    }

	 	    


}
