package org.irina.util;

public class Measurement {
	private String sensorId;
	private String type;
	private String host;
	private String port;
	private double value;
	public Measurement(String sensorId, String type, String host, String port)
	{
		this.sensorId = sensorId;
		this.type = type;
		this.host = host;
		this.port = port;
	}
	public Measurement()
	{
		this(null,  null, null, null);
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
	public String getHost()
	{
		return host;
	}
	public void setHost(String host)
	{
		this.host = host;
	}
	public String getPortId()
	{
		return port;
	}
	public void setPort(String port)
	{
		this.port = port;
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
