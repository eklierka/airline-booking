package com.airline.beans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.LineChartModel;
import org.springframework.context.annotation.Scope;

import com.airline.entity.TicketsTotal;
import com.airline.entity.TicketsTotalByDate;
import com.airline.entity.TicketsTotalByPlace;
import com.airline.service.StatisticsService;

@Named
@Scope("request")
public class Statistics {

	private Date from;
	private Date to;
	private TicketsTotal total;
	private List<TicketsTotalByDate> byDate;
	private List<TicketsTotalByPlace> byPlace;
	@Inject
	private StatisticsService service;
	private LineChartModel chart;

	public void analyze() {
		total = service.selectTotal(from, to);
		byDate = service.selectTotalByDate(from, to);
		byPlace = service.selecTotalByPlace(from, to);
	}
	
	@PostConstruct
    public void init() {
        createLineModels();
    }
	
	private void createLineModels() {
//        chart = initLinearModel();
//        chart.setTitle("Linear Chart");
//        chart.setLegendPosition("e");
//        Axis yAxis = chart.getAxis(AxisType.Y);
//        yAxis.setMin(0);
//        yAxis.setMax(10);
//         
//        lineModel2 = initCategoryModel();
//        lineModel2.setTitle("Category Chart");
//        lineModel2.setLegendPosition("e");
//        lineModel2.setShowPointLabels(true);
//        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Years"));
//        yAxis = lineModel2.getAxis(AxisType.Y);
//        yAxis.setLabel("Births");
//        yAxis.setMin(0);
//        yAxis.setMax(200);
    }

	public LineChartModel getChart() {
		return chart;
	}

	public void setChart(LineChartModel chart) {
		this.chart = chart;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public TicketsTotal getTotal() {
		return total;
	}

	public void setTotal(TicketsTotal total) {
		this.total = total;
	}

	public List<TicketsTotalByDate> getByDate() {
		return byDate;
	}

	public void setByDate(List<TicketsTotalByDate> byDate) {
		this.byDate = byDate;
	}

	public List<TicketsTotalByPlace> getByPlace() {
		return byPlace;
	}

	public void setByPlace(List<TicketsTotalByPlace> byPlace) {
		this.byPlace = byPlace;
	}

}
