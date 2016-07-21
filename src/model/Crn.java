package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CRN database table.
 * 
 */
@Entity
@NamedQuery(name="Crn.findAll", query="SELECT c FROM Crn c")
public class Crn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CRN_CRNID_GENERATOR", sequenceName="CRN_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CRN_CRNID_GENERATOR")
	private long crnid;

	@Column(name="\"DAYS\"")
	private String days;

	private BigDecimal semester;

	private String timeofclass;

	@Column(name="\"YEAR\"")
	private BigDecimal year;

	//bi-directional many-to-one association to Classroom
	@ManyToOne
	@JoinColumn(name="CLASSROOMID")
	private Classroom classroom;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name="COURSEID")
	private Course course;

	//bi-directional many-to-one association to Instructor
	@ManyToOne
	@JoinColumn(name="INSTRUCTORID")
	private Instructor instructor;

	//bi-directional many-to-one association to Grade
	@OneToMany(mappedBy="crn")
	private List<Grade> grades;

	public Crn() {
	}

	public long getCrnid() {
		return this.crnid;
	}

	public void setCrnid(long crnid) {
		this.crnid = crnid;
	}

	public String getDays() {
		return this.days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public BigDecimal getSemester() {
		return this.semester;
	}

	public void setSemester(BigDecimal semester) {
		this.semester = semester;
	}

	public String getTimeofclass() {
		return this.timeofclass;
	}

	public void setTimeofclass(String timeofclass) {
		this.timeofclass = timeofclass;
	}

	public BigDecimal getYear() {
		return this.year;
	}

	public void setYear(BigDecimal year) {
		this.year = year;
	}

	public Classroom getClassroom() {
		return this.classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Instructor getInstructor() {
		return this.instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Grade> getGrades() {
		return this.grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public Grade addGrade(Grade grade) {
		getGrades().add(grade);
		grade.setCrn(this);

		return grade;
	}

	public Grade removeGrade(Grade grade) {
		getGrades().remove(grade);
		grade.setCrn(null);

		return grade;
	}

}