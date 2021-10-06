package com.flyaway.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class AirFlights {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightId;
	
	@Column(length = 100)
	private String flightName;
	
	@ManyToOne
	private Airlines flightAirlines;
	
	@Column(length = 150)
	private String flightOrigin;


	@Column(length = 150)
	private String flightDestination;
	
	@Column(length = 10)
	private int ticketPrice;
	
//	@OneToOne
//	private Passengers passengers;

	public AirFlights() {
		
	}

	public AirFlights(String flightName,Airlines flightAirlines,String flightOrigin,
			String flightDestination, int ticketPrice) {
		this.flightName = flightName;
		this.flightAirlines = flightAirlines;
		this.flightOrigin = flightOrigin;
		this.flightDestination = flightDestination;
		this.ticketPrice= ticketPrice;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public Airlines getFlightAirlines() {
		return flightAirlines;
	}

	public void setFlightAirlines(Airlines flightAirlines) {
		this.flightAirlines = flightAirlines;
	}

	public String getFlightOrigin() {
		return flightOrigin;
	}

	public void setFlightOrigin(String flightOrigin) {
		this.flightOrigin = flightOrigin;
	}

	public String getFlightDestination() {
		return flightDestination;
	}

	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
//	public Passengers getPassengers() {
//		return passengers;
//	}
//
//	public void setPassengers(Passengers passengers) {
//		this.passengers = passengers;
//	}

	@Override
	public String toString() {
		return "AirFlights [flightId=" + flightId + ", flightName=" + flightName + ", flightAirlines=" + flightAirlines
				+ ", flightOrigin=" + flightOrigin + ", flightDestination=" + flightDestination + ", ticketPrice="
				+ ticketPrice + ", passengers=" + "]";
	}

}
