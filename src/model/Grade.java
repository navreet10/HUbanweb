package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GRADES database table.
 * 
 */
@Entity
@Table(name="GRADE")
@NamedQuery(name="Grade.findAll", query="SELECT g FROM Grade g")
public class Grade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GRADE_ID_GENERATOR", sequenceName="GRADE_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRADE_ID_GENERATOR")
	private long id;

	private String grade;

	//bi-directional many-to-one association to Crn
	@ManyToOne
	@JoinColumn(name="CRNID")
	private Crn crn;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="STUDENTID")
	private Student student;

	public Grade() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Crn getCrn() {
		return this.crn;
	}

	public void setCrn(Crn crn) {
		this.crn = crn;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}