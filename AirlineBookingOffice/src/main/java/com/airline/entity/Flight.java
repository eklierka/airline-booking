package com.airline.entity;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.inject.Named;
import javax.persistence.*;

import org.springframework.context.annotation.Scope;

@Named
@Scope("request")
@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String flightNumber;

	@ManyToOne
	@JoinColumn(name = "departAirport")
	private Airport departAirport;

	private Timestamp departTime;

	@ManyToOne
	@JoinColumn(name = "destAirport")
	private Airport destAirport;

	private Timestamp destTime;

	private int numbOfTickets;

	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Airport getDepartAirport() {
		return departAirport;
	}

	public void setDepartAirport(Airport departAirport) {
		this.departAirport = departAirport;
	}

	public Timestamp getDepartTime() {
		return departTime;
	}

	public void setDepartTime(Timestamp departTime) {
		this.departTime = departTime;
	}

	public Airport getDestAirport() {
		return destAirport;
	}

	public void setDestAirport(Airport destAirport) {
		this.destAirport = destAirport;
	}

	public Timestamp getDestTime() {
		return destTime;
	}

	public void setDestTime(Timestamp destTime) {
		this.destTime = destTime;
	}

	public int getNumbOfTickets() {
		return numbOfTickets;
	}

	public void setNumbOfTickets(int numbOfTickets) {
		this.numbOfTickets = numbOfTickets;
	}

	@Override
	public String toString() {
		return "id=              " + id + "\nflightNumber  " + flightNumber
				+ "\ndepartAirport " + departAirport + "\ndepartTime    "
				+ departTime + "\ndestAirport   " + destAirport
				+ "\ndestTime=     " + destTime + "\nnumbOfTickets "
				+ numbOfTickets + "\nprice         " + price;
	}

}
