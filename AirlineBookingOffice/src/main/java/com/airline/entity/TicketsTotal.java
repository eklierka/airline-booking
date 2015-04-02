package com.airline.entity;

public class TicketsTotal {

	private long totalCount;
	private long totalCost;

	public TicketsTotal(long totalCount, long totalSum) {
		super();
		this.totalCount = totalCount;
		this.totalCost = totalSum;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(long totalSum) {
		this.totalCost = totalSum;
	}

	@Override
	public String toString() {
		return "TicketsTotal [totalCount=" + totalCount + ", totalCost=" + totalCost + "]";
	}

}
