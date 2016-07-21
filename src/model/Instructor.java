package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the INSTRUCTOR database table.
 * 
 */
@Entity
@NamedQuery(name="Instructor.findAll", query="SELECT i FROM Instructor i")
public class Instructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INSTRUCTOR_INSTRUCTORID_GENERATOR", sequenceName="INSTRUCTOR_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSTRUCTOR_INSTRUCTORID_GENERATOR")
	private long instructorid;

	private String dept;

	private BigDecimal officenum;

	//bi-directional many-to-one association to Crn
	@OneToMany(mappedBy="instructor")
	private List<Crn> crns;

	//bi-directional many-to-one association to Huuser
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private Huuser huuser;

	public Instructor() {
	}

	public long getInstructorid() {
		return this.instructorid;
	}

	public void setInstructorid(long instructorid) {
		this.instructorid = instructorid;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public BigDecimal getOfficenum() {
		return this.officenum;
	}

	public void setOfficenum(BigDecimal officenum) {
		this.officenum = officenum;
	}

	public List<Crn> getCrns() {
		return this.crns;
	}

	public void setCrns(List<Crn> crns) {
		this.crns = crns;
	}

	public Crn addCrn(Crn crn) {
		getCrns().add(crn);
		crn.setInstructor(this);

		return crn;
	}

	public Crn removeCrn(Crn crn) {
		getCrns().remove(crn);
		crn.setInstructor(null);

		return crn;
	}

	public Huuser getHuuser() {
		return this.huuser;
	}

	public void setHuuser(Huuser huuser) {
		this.huuser = huuser;
	}

}