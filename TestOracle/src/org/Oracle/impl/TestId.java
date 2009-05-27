package org.Oracle.impl;

import java.util.Date;


/**
 * TestId entity. @author MyEclipse Persistence Tools
 */

public class TestId  implements java.io.Serializable {


    // Fields    

     private Long empno;
     private String ename;
     private String job ="Œ¥∑÷≈‰";
     private Long mgr = new java.lang.Long(0);
     private Date hiredate;
     private Double sal=0.00;
     private Double comm = 0.00;
     private Long deptno= new java.lang.Long(0);


    // Constructors

    /** default constructor */
    public TestId() {
    }

    
    /** full constructor */
    public TestId(Long empno, String ename, String job, Long mgr, Date hiredate, Double sal, Double comm, Long deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
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

    public String getJob() {
        return this.job;
    }
    
    public void setJob(String job) {
        this.job = job;
    }

    public Long getMgr() {
        return this.mgr;
    }
    
    public void setMgr(Long mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return this.hiredate;
    }
    
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Double getSal() {
        return this.sal;
    }
    
    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Double getComm() {
        return this.comm;
    }
    
    public void setComm(Double comm) {
    	if(null == comm)
    	this.comm=0.00;
    	else
        this.comm = comm;
    }

    public Long getDeptno() {
        return this.deptno;
    }
    
    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TestId) ) return false;
		 TestId castOther = ( TestId ) other; 


   
		 return ( (this.getEmpno()==castOther.getEmpno()) || ( this.getEmpno()!=null && castOther.getEmpno()!=null && this.getEmpno().equals(castOther.getEmpno()) ) )
 && ( (this.getEname()==castOther.getEname()) || ( this.getEname()!=null && castOther.getEname()!=null && this.getEname().equals(castOther.getEname()) ) )
 && ( (this.getJob()==castOther.getJob()) || ( this.getJob()!=null && castOther.getJob()!=null && this.getJob().equals(castOther.getJob()) ) )
 && ( (this.getMgr()==castOther.getMgr()) || ( this.getMgr()!=null && castOther.getMgr()!=null && this.getMgr().equals(castOther.getMgr()) ) )
 && ( (this.getHiredate()==castOther.getHiredate()) || ( this.getHiredate()!=null && castOther.getHiredate()!=null && this.getHiredate().equals(castOther.getHiredate()) ) )
 && ( (this.getSal()==castOther.getSal()) || ( this.getSal()!=null && castOther.getSal()!=null && this.getSal().equals(castOther.getSal()) ) )
 && ( (this.getComm()==castOther.getComm()) || ( this.getComm()!=null && castOther.getComm()!=null && this.getComm().equals(castOther.getComm()) ) )
 && ( (this.getDeptno()==castOther.getDeptno()) || ( this.getDeptno()!=null && castOther.getDeptno()!=null && this.getDeptno().equals(castOther.getDeptno()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getEmpno() == null ? 0 : this.getEmpno().hashCode() );
         result = 37 * result + ( getEname() == null ? 0 : this.getEname().hashCode() );
         result = 37 * result + ( getJob() == null ? 0 : this.getJob().hashCode() );
         result = 37 * result + ( getMgr() == null ? 0 : this.getMgr().hashCode() );
         result = 37 * result + ( getHiredate() == null ? 0 : this.getHiredate().hashCode() );
         result = 37 * result + ( getSal() == null ? 0 : this.getSal().hashCode() );
         result = 37 * result + ( getComm() == null ? 0 : this.getComm().hashCode() );
         result = 37 * result + ( getDeptno() == null ? 0 : this.getDeptno().hashCode() );
         return result;
   }   





}