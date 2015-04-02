package com.airline.entity;

public class TicketsTotalByPlace {

	private String country;
	private String city;
	private long sum;
	private long count;

	public TicketsTotalByPlace(String country, String city, long sum, long count) {
		super();
		this.country = country;
		this.city = city;
		this.sum = sum;
		this.count = count;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
		return "TicketsTotalByPlace [country=" + country + ", city=" + city + ", sum=" + sum + ", count=" + count + "]";
	}

}
