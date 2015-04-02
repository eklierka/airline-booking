package com.airline.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.inject.Named;
import javax.persistence.*;

import org.springframework.context.annotation.Scope;

@Named
@Scope("request")
@Entity
public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "flightId")
	private Flight flight;

	private String surname;
	private String name;
	private String sex;
	private Date birthDate;
	private String citizenship;
	private String document;
	private Date docValidity;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Date getDocValidity() {
		return docValidity;
	}

	public void setDocValidity(Date docValidity) {
		this.docValidity = docValidity;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", flight=" + flight + ", surname=" + surname + ", name=" + name + ", sex=" + sex
				+ ", birthDate=" + birthDate + ", citizenship=" + citizenship + ", document=" + document
				+ ", docValidity=" + docValidity + ", customer=" + customer + "]";
	}
}
