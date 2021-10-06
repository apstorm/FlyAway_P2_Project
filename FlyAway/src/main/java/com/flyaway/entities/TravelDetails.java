package com.flyaway.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Travel_Details")
public class TravelDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int travelId;
	private String travelDate;
	@Column(name = "destination")
	private String to;
	@Column(name = "origin_city")
	private String from;
	private int totalPassengers;
	
	public TravelDetails() {
		
	}

	
	
	public TravelDetails(String travelDate, String to, String from) {
		super();
		this.travelDate = travelDate;
		this.to = to;
		this.from = from;
	}



	public TravelDetails(String travelDate, String to, String from, int totalPassengers) {
		this.travelDate = travelDate;
		this.to = to;
		this.from = from;
		this.totalPassengers = totalPassengers;
	}

	public int getTravelId() {
		return travelId;
	}

	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public long getTotalPassengers() {
		return totalPassengers;
	}

	public void setTotalPassengers(int totalPassengers) {
		this.totalPassengers = totalPassengers;
	}

	@Override
	public String toString() {
		return "TravelDetails [travelId=" + travelId + ", travelDate=" + travelDate + ", to=" + to + ", from=" + from
				+ ", totalPassengers=" + totalPassengers + "]";
	}
	
}
