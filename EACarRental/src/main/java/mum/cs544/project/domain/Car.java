package mum.cs544.project.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Car {
	//@Transient
	//private MultipartFile carImage;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "carTypeId")
	private CarType carType;
	private String name;
	private String imageLink;
	private int numberOfMiles;
	private int pricePerDay;
	private int year;
	private Date lastInpsected;
	
	public Car() {
	}

	public Car(CarType carType, String name, String imageLink, int numberOfMiles, int pricePerDay, int year,
			Date lastInpsected) {
		super();
		this.carType = carType;
		this.name = name;
		this.imageLink = imageLink;
		this.numberOfMiles = numberOfMiles;
		this.pricePerDay = pricePerDay;
		this.year = year;
		this.lastInpsected = lastInpsected;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public Date getLastInpsected() {
		return lastInpsected;
	}
	public void setLastInpsected(Date lastInpsected) {
		this.lastInpsected = lastInpsected;
	}

	public CarType getCarType() {
		return carType;
	}
	public void setCarType(CarType carType) {
		this.carType = carType;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfMiles() {
		return numberOfMiles;
	}
	public void setNumberOfMiles(int numberOfMiles) {
		this.numberOfMiles = numberOfMiles;
	}
	public int getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
