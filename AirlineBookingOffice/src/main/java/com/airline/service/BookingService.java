package com.airline.service;

import java.util.List;

import com.airline.entity.Customer;
import com.airline.entity.Ticket;

public interface BookingService {

	public void book(Customer customer, List<Ticket> tickets);
}
