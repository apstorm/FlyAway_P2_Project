package com.flyaway.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Airlines {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String airlinesName;
	
	@OneToMany(mappedBy = "flightAirlines")
	private List<AirFlights> airlines=new ArrayList<>();
	private String description;
	
	public Airlines() {
		
	}

	public Airlines(List<AirFlights> airlinesName, String description) {
		this.airlines = airlinesName;
		this.description = description;
	}

	public Airlines(String airlinesName, String description) {
		this.airlinesName = airlinesName;
		this.description = description;
	}

	public Airlines(int id, String airlinesName, List<AirFlights> airlines, String description) {
		super();
		this.id = id;
		this.airlinesName = airlinesName;
		this.airlines = airlines;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirlinesName() {
		return airlinesName;
	}

	public void setAirlinesName(String airlinesName) {
		this.airlinesName = airlinesName;
	}

	public List<AirFlights> getAirlines() {
		return airlines;
	}

	public void setAirlines(List<AirFlights> airlines) {
		this.airlines = airlines;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Airlines [id=" + id + ", airlinesName=" + airlinesName + ", airlines=" + airlines + ", description="
				+ description + "]";
	}

}
