package com.airline.entity;

import java.sql.Timestamp;

public class BookedTicket {

	private int id;
	private String flightNumber;
	private String surname;
	private String name;
	private String document;
	private boolean isSold;
	private Timestamp bookingDate;

	public BookedTicket(int id, String flightNumber, String surname, String name, String doc, boolean isSold,
			Timestamp bookingDate) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.surname = surname;
		this.name = name;
		this.document = doc;
		this.isSold = isSold;
		this.bookingDate = bookingDate;
	}

	public int getTicketId() {
		return id;
	}

	public void setTicketId(int id) {
		this.id = id;
	}

	public String getDoc() {
		return document;
	}

	public void setDoc(String doc) {
		this.document = doc;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public boolean isSold() {
		return isSold;
	}

	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}

	public Timestamp getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Timestamp bookingDate) {
		this.bookingDate = bookingDate;
	}

	@Override
	public String toString() {
		return "BookedTicket [id=" + id + " flightNumber=" + flightNumber + ", surname=" + surname + ", name=" + name + ", document="
				+ document + ", isSold=" + isSold + ", bookingDate=" + bookingDate + "]";
	}
}
