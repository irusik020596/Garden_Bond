package org.irina.model;

import java.io.Serializable;
import java.rmi.server.UID;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

import org.irina.beans.Item;
import org.irina.beans.Problem;
import org.irina.beans.SessionBean;
import org.irina.beans.Statistic;
import org.irina.dao.LotDAO;
import org.irina.dao.ProblemDAO;
import org.irina.dao.StatisticDAO;

@ManagedBean
@ViewScoped
public class Statistics implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	private List<Statistic> listStatistics;
	private List<Problem> prevProblems;
	private String lot;
	private String sensorName;

	@PostConstruct
	public void init() {
		listStatistics = StatisticDAO.getStatistics();
		Statistic stat = listStatistics.get(0);
		prevProblems = StatisticDAO.getPrevProblems(stat.getSensorId());
		this.lot = stat.getLotDescription();
		this.sensorName = stat.getSensorName();
	}

	public void renew(String sensorId,String lot, String sensorName) {
		prevProblems = StatisticDAO.getPrevProblems(sensorId);
		this.lot = lot;
		this.sensorName = sensorName;
	}

	private static String getPrimaryKey() {
		return new UID().toString();
	}

	public String statistics() {
		return "statistics";
	}

	public String prevProblems() {
		return "prevProblems";
	}

	public List<Statistic> getListStatistics() {
		return listStatistics;
	}

	public List<Problem> getprevProblems() {
		return prevProblems;
	}

	public String getLot() {
		return lot;
	}

	public String getSensorName() {
		return sensorName;
	}
}
