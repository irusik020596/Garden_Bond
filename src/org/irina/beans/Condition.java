package org.irina.beans;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.irina.util.HandBook;

@XmlRootElement(name="condition")
public class Condition {
	private String id;
	private String sensorId;
	private String operation;
	private String limit;
	public Condition(String id, String sensorId, String operation, String limit)
	{
		this.id = id;
		this.sensorId = sensorId;
		this.operation = operation;
		this.limit = limit;
	}
	public Condition()
	{
		this(null, null, null, null);
	}
	@XmlElement(name="id", required=true)
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	@XmlElement(name="sensorId", required=true)
	public String getSensorId()
	{
		return sensorId;
	}
	public void setSensorId(String sensorId)
	{
		this.sensorId = sensorId;
	}
	@XmlElement(name="operation", required=true)
	public String getOperation()
	{
		return operation;
	}
	public void setOperation(String operation)
	{
		this.operation = operation;
	}
	@XmlElement(name="limit", required=true)
	public String getLimit()
	{
		return limit;
	}
	public void setLimit(String limit)
	{
		this.limit = limit;
	}
	public String getOperationText()
	{
		return HandBook.getOperation(operation);
	}
}
