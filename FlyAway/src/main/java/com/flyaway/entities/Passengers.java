package com.flyaway.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PassengersDb")
public class Passengers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 10,name = "p_id")
	private int pid;
	
	
	@Column(nullable = false,length = 100)
	private String pName;
	
	
	@Column(unique = true,nullable = false,length = 100)
	private String pEmail;
	

	@Column(unique=true,nullable = false,length = 10)
	private String pPhone;
	
	
	@Column(nullable = false,length = 3)
	private int pAge;

//	@OneToOne(mappedBy = "passengers")
//	private AirFlights airFlights;

	public Passengers() {
		
	}

	

	public Passengers(int pid, String pName, String pEmail, String pPhone, int pAge) {
	super();
	this.pid = pid;
	this.pName = pName;
	this.pEmail = pEmail;
	this.pPhone = pPhone;
	this.pAge = pAge;
}



	public Passengers(String pName, String pEmail, String pPhone, int pAge) {
		super();
		this.pName = pName;
		this.pEmail = pEmail;
		this.pPhone = pPhone;
		this.pAge = pAge;
	}

	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public String getpEmail() {
		return pEmail;
	}


	public void setpEmail(String pEmail) {
		this.pEmail = pEmail;
	}


	public String getpPhone() {
		return pPhone;
	}


	public void setpPhone(String pPhone) {
		this.pPhone = pPhone;
	}


	public int getpAge() {
		return pAge;
	}


	public void setpAge(int pAge) {
		this.pAge = pAge;
	}

//	public AirFlights getAirFlights() {
//		return airFlights;
//	}


//	public void setAirFlights(AirFlights airFlights) {
//		this.airFlights = airFlights;
//	}


	@Override
	public String toString() {
		return "Passengers [pid=" + pid + ", pName=" + pName + ", pEmail=" + pEmail + ", pPhone=" + pPhone + ", pAge="
				+ pAge + ", airFlights=" + "]";
	}

}
