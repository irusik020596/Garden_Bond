package org.irina.util;

public class Measurement {
	private String sensorId;
	private String type;
	private double value;
	public Measurement(String sensorId, String type)
	{
		this.sensorId = sensorId;
		this.type = type;
	}
	public Measurement()
	{
		this(null,  null);
	}
	public String getSensorId()
	{
		return sensorId;
	}
	public void setSensorId(String sensorId)
	{
		this.sensorId = sensorId;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public double getValue()
	{
		return value;
	}
	public void setValue(double value)
	{
		this.value = value;
	}
	public void getting()
	{
		value = 0;
	}
}
