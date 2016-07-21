package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CLASSROOM database table.
 * 
 */
@Entity
@NamedQuery(name="Classroom.findAll", query="SELECT c FROM Classroom c")
public class Classroom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLASSROOM_CLASSROOMID_GENERATOR", sequenceName="CLASSROOM_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLASSROOM_CLASSROOMID_GENERATOR")
	private long classroomid;

	private String buildingname;

	private BigDecimal maxcapacity;

	private String roomnum;

	//bi-directional many-to-one association to Crn
	@OneToMany(mappedBy="classroom")
	private List<Crn> crns;

	public Classroom() {
	}

	public long getClassroomid() {
		return this.classroomid;
	}

	public void setClassroomid(long classroomid) {
		this.classroomid = classroomid;
	}

	public String getBuildingname() {
		return this.buildingname;
	}

	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}

	public BigDecimal getMaxcapacity() {
		return this.maxcapacity;
	}

	public void setMaxcapacity(BigDecimal maxcapacity) {
		this.maxcapacity = maxcapacity;
	}

	public String getRoomnum() {
		return this.roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}

	public List<Crn> getCrns() {
		return this.crns;
	}

	public void setCrns(List<Crn> crns) {
		this.crns = crns;
	}

	public Crn addCrn(Crn crn) {
		getCrns().add(crn);
		crn.setClassroom(this);

		return crn;
	}

	public Crn removeCrn(Crn crn) {
		getCrns().remove(crn);
		crn.setClassroom(null);

		return crn;
	}

}