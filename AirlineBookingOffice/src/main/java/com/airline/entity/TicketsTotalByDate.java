package com.airline.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;

public class TicketsTotalByDate {

	private Date date;
	private long sum;
	private long count;
	
	public TicketsTotalByDate(Date date, long sum, long count) {
		super();
		this.date = date;
		this.sum = sum;
		this.count = count;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "TicketsTotalByDate [date=" + date + ", sum=" + sum + ", count=" + count + "]";
	}

}
