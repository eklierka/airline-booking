package com.airline.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import com.airline.entity.Customer;
import com.airline.entity.Flight;
import com.airline.entity.Ticket;
import com.airline.service.BookingService;
import com.airline.service.FlightService;

@Named
@Scope("session")
public class Booking implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date birthDate;
	private Date docValidity;
	@Inject
	private Customer customer;
	@Inject
	private Ticket ticket;
	@Inject
	private BookingService bookingService;
	@Inject
	private FlightService flightService;
	private List<Ticket> ticketsList;
	private int totalSum;

	@PostConstruct
	public void setDefaultRadioButton() {
		if (ticket != null && ticket.getSex() == null) {
			ticket.setSex("f");
		}
	}

	public int refreshTotalSum() {
		totalSum = 0;
		if (ticketsList != null) {
			for (Ticket t : ticketsList) {
				totalSum += t.getPrice();
			}
		}
		return totalSum;
	}
	
	public String saveFlight(String id) {
		int i = Integer.parseInt(id);
		Flight f = flightService.findFlightById(i);
		ticket.setFlight(f);
		ticket.setPrice(f.getPrice());
		return "ticketBuying";
	}

	public String addToBasket() {
		ticket.setBirthDate(new java.sql.Date(birthDate.getTime()));
		ticket.setDocValidity(new java.sql.Date(docValidity.getTime()));
		if (ticketsList == null) {
			ticketsList = new ArrayList<Ticket>();
		}
		ticketsList.add(ticket);
		return "searchFlight";
	}

	public String deleteFlight(String id) {
		Iterator<Ticket> iterator = ticketsList.iterator();
		while (iterator.hasNext()) {
			Ticket t = iterator.next();
			if (String.valueOf(t.getFlight().getId()).equals(id)) {
				iterator.remove();
				break;
			}
		}
		return "basket";
	}

	public String book() {
		if (ticketsList != null && !ticketsList.isEmpty()) {
			bookingService.book(customer, ticketsList);
			ticketsList = null;       
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_INFO, "Бронювання пройшло успішно.", null));
			return "basket";
		}
		FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Бронювання не здійснено", null));
		return "basket";
	}

	
	public int getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(int totalSum) {
		this.totalSum = totalSum;
	}

	public List<Ticket> getTicketsList() {
		return ticketsList;
	}

	public void setTicketsList(List<Ticket> ticketsList) {
		this.ticketsList = ticketsList;
	}

	public Date getDocValidity() {
		return docValidity;
	}

	public void setDocValidity(Date docValidity) {
		this.docValidity = docValidity;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
}
