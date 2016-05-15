package org.irina.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.irina.util.HandBook;

@XmlRootElement(name="rule")
public class Robot {
	private String id;
	private String name;
	private String description;
	private String type;
	private String host;
	private String port;
	private String status;
	private String state;
	//private String ruleId;
	public Robot(String id, String name, String description, String type, String host, String port, String status, String state/*, String ruleId*/)
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
		this.host = host;
		this.port = port;
		this.status = status;
		this.state = state;
	//	this.ruleId = ruleId;
	}
	public Robot()
	{
		this(null, null, null, null, null, null, null, null/*, null*/);
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
	@XmlElement(name="name", required=true)
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	@XmlElement(name="description", required=true)
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	@XmlElement(name="type", required=true)
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	@XmlElement(name="host", required=true)
	public String getHost()
	{
		return host;
	}
	public void setHost(String host)
	{
		this.host = host;
	}
	@XmlElement(name="port", required=true)
	public String getPort()
	{
		return port;
	}
	public void setPort(String port)
	{
		this.port = port;
	}
	@XmlElement(name="status", required=true)
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	@XmlElement(name="state", required=true)
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	//@XmlElement(name="ruleid", required=true)
	//public String getRuleId()
	//{
	//	return ruleId;
	//}
	//public void setRuleId(String ruleId)
	//{
	//	this.ruleId = ruleId;
	//}
	public String getTypeText()
	{
		return HandBook.getRobotType(type);
	}
	public String getStatusText()
	{
		return HandBook.getRobotStatus(status);
	}
	public String getStateText()
	{
		return HandBook.getRobotState(state);
	}
}
