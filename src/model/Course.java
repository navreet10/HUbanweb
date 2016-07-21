package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the COURSE database table.
 * 
 */
@Entity
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COURSE_COURSEID_GENERATOR", sequenceName="COURSE_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COURSE_COURSEID_GENERATOR")
	private long courseid;

	private String coursedesc;

	private BigDecimal credits;

	private String major;

	private String name;

	//bi-directional many-to-one association to Crn
	@OneToMany(mappedBy="course")
	private List<Crn> crns;

	public Course() {
	}

	public long getCourseid() {
		return this.courseid;
	}

	public void setCourseid(long courseid) {
		this.courseid = courseid;
	}

	public String getCoursedesc() {
		return this.coursedesc;
	}

	public void setCoursedesc(String coursedesc) {
		this.coursedesc = coursedesc;
	}

	public BigDecimal getCredits() {
		return this.credits;
	}

	public void setCredits(BigDecimal credits) {
		this.credits = credits;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Crn> getCrns() {
		return this.crns;
	}

	public void setCrns(List<Crn> crns) {
		this.crns = crns;
	}

	public Crn addCrn(Crn crn) {
		getCrns().add(crn);
		crn.setCourse(this);

		return crn;
	}

	public Crn removeCrn(Crn crn) {
		getCrns().remove(crn);
		crn.setCourse(null);

		return crn;
	}

}