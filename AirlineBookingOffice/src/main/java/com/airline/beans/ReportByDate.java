package com.airline.beans;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.context.annotation.Scope;

import com.airline.entity.TicketsTotal;
import com.airline.entity.TicketsTotalByDate;
import com.airline.service.TicketService;

@Named
@Scope("request")
public class ReportByDate implements Serializable {

	private static final long serialVersionUID = 1L;
	private LineChartModel model;
	private Date firstDate;
	private Date lastDate;
	private TicketsTotal ticketsTotal;

	@Inject
	private TicketService service;

	@PostConstruct
	public void init() {
		if (firstDate != null && lastDate != null) {
			createLineModels();
			ticketsTotal = service.selectTotalSumCount(firstDate, lastDate);
		}
	}
	
	public String getTotal() {
		ticketsTotal = service.selectTotalSumCount(firstDate, lastDate);
		return "reportByDate";
	}

	private void createLineModels() {
		model = initLinearModel();
		model.setTitle("Report By Dates");
		// model.setLegendPosition("e");
		// model.setZoom(true);
		// Axis yAxis = model.getAxis(AxisType.Y);
		// yAxis.setMin(0);
		// yAxis.setMax(10);
	}

	private LineChartModel initLinearModel() {
		LineChartModel model = new LineChartModel();

		LineChartSeries series = new LineChartSeries();
		series.setLabel("Series 1");

		List<TicketsTotalByDate> dataSet = service.selectTotalByDate(firstDate, lastDate);

		for (TicketsTotalByDate t : dataSet) {
			series.set(t.getDate(), t.getCount());
		}
		// series.set(1, 2);
		// series.set(2, 1);
		// series.set(3, 3);
		// series.set(4, 6);
		// series.set(5, 8);

		// LineChartSeries series2 = new LineChartSeries();
		// series2.setLabel("Series 2");
		//
		// series2.set(1, 6);
		// series2.set(2, 3);
		// series2.set(3, 2);
		// series2.set(4, 7);
		// series2.set(5, 9);

		model.addSeries(series);
		// model.addSeries(series2);

		return model;
	}

	public Date getMaxDate() {
		return Calendar.getInstance().getTime();
	}

	public TicketsTotal getTicketsTotal() {
		return ticketsTotal;
	}

	public void setTicketsTotal(TicketsTotal ticketsTotal) {
		this.ticketsTotal = ticketsTotal;
	}

	public LineChartModel getModel() {
		return model;
	}

	public void setModel(LineChartModel model) {
		this.model = model;
	}

	public Date getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

}
