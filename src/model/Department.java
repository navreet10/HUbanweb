package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DEPARTMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEPARTMENT_DEPTID_GENERATOR", sequenceName="DEPARTMENT_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPARTMENT_DEPTID_GENERATOR")
	private long deptid;

	private String dept;

	public Department() {
	}

	public long getDeptid() {
		return this.deptid;
	}

	public void setDeptid(long deptid) {
		this.deptid = deptid;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}