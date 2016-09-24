package mum.cs544.project.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date pickupdate;
	private String pickuplocation;
	@Temporal(TemporalType.TIMESTAMP)
	public Date dropoffdate;
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "carId")
	private Car car;
	public String dropofflocation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Date getPickupdate() {
		return pickupdate;
	}

	public void setPickupdate(Date pickupdate) {
		this.pickupdate = pickupdate;
	}
	public String getPickuplocation() {
		return pickuplocation;
	}
	public void setPickuplocation(String pickuplocation) {
		this.pickuplocation = pickuplocation;
	}

	public Date getDropoffdate() {
		return dropoffdate;
	}

	public void setDropoffdate(Date dropoffdate) {
		this.dropoffdate = dropoffdate;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getDropofflocation() {
		return dropofflocation;
	}
	public void setDropofflocation(String dropofflocation) {
		this.dropofflocation = dropofflocation;
	}

}
