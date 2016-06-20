package org.irina.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Statistic implements Serializable {
	private String lotDescription;
	private String sensorId;
	private String sensorName;
	private int problemsCount;


	public Statistic(String lotDescription, String sensorId, String sensorName, int problemsCount) {
		this.lotDescription = lotDescription;
		this.sensorId = sensorId;
		this.sensorName = sensorName;
		this.problemsCount = problemsCount;
	}

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	@XmlElement(name = "sensorName", required = true)
	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	@XmlElement(name = "problemsCount", required = true)
	public int getProblemsCount() {
		return problemsCount;
	}

	public void setProblemsCount(int problemsCount) {
		this.problemsCount = problemsCount;
	}

	@XmlElement(name = "lotDescription", required = true)
	public String getLotDescription() {
		return lotDescription;
	}

	public void setLotDescription(String lotDescription) {
		this.lotDescription = lotDescription;
	}

	@Override
	public String toString() {
		return "Statistics [lotDescription=" + lotDescription + ", sensorId=" + sensorId + ", sensorName=" + sensorName
				+ ", problemsCount=" + problemsCount + "]";
	}

}
