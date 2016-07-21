package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MAJOR database table.
 * 
 */
@Entity
@NamedQuery(name="Major.findAll", query="SELECT m FROM Major m")
public class Major implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MAJOR_MAJORID_GENERATOR", sequenceName="MAJOR_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MAJOR_MAJORID_GENERATOR")
	private long majorid;

	private String dept;

	private String major;

	public Major() {
	}

	public long getMajorid() {
		return this.majorid;
	}

	public void setMajorid(long majorid) {
		this.majorid = majorid;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

}