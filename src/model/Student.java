package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the STUDENT database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STUDENT_STUDENTID_GENERATOR", sequenceName="STUDENT_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STUDENT_STUDENTID_GENERATOR")
	private long studentid;

	private String major;

	private BigDecimal yearofentry;

	//bi-directional many-to-one association to Grade
	@OneToMany(mappedBy="student")
	private List<Grade> grades;

	//bi-directional many-to-one association to Huuser
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private Huuser huuser;

	public Student() {
	}

	public long getStudentid() {
		return this.studentid;
	}

	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public BigDecimal getYearofentry() {
		return this.yearofentry;
	}

	public void setYearofentry(BigDecimal yearofentry) {
		this.yearofentry = yearofentry;
	}

	public List<Grade> getGrades() {
		return this.grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public Grade addGrade(Grade grade) {
		getGrades().add(grade);
		grade.setStudent(this);

		return grade;
	}

	public Grade removeGrade(Grade grade) {
		getGrades().remove(grade);
		grade.setStudent(null);

		return grade;
	}

	public Huuser getHuuser() {
		return this.huuser;
	}

	public void setHuuser(Huuser huuser) {
		this.huuser = huuser;
	}

}