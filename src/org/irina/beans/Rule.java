package org.irina.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.irina.util.HandBook;

@XmlRootElement(name="rule")
public class Rule {
	private String id;
//	private String lotId;
	private String name;
	private String description;
	private String smsnote;
	private String emailnote;
	private String type;
	public Rule(String id, String name, String description, String smsnote, String emailnote, String type)
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.smsnote = smsnote;
		this.emailnote = emailnote;
		this.type = type;
	}
	public Rule()
	{
		this(null, null, null, null, null, null);
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
	@XmlElement(name="smsnote", required=true)
	public String getSmsnote()
	{
		return smsnote;
	}
	public void setSmsnote(String smsnote)
	{
		this.smsnote = smsnote;
	}
	@XmlElement(name="emailnote", required=true)
	public String getEmailnote()
	{
		return emailnote;
	}
	public void setEmailnote(String emailnote)
	{
		this.emailnote = emailnote;
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
	public String getTypeText()
	{
		return HandBook.getRuleType(type);
	}
	public String getSmsnoteText()
	{
		return HandBook.getSmsType(smsnote);
	}
	public String getEmailnoteText()
	{
		return HandBook.getEmailType(emailnote);
	}
}
