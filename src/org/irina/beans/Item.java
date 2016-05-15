package org.irina.beans;
//import java.util.List;

//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="item")
public class Item {
	private String id;
	private String description;
	public Item()
	{
		this(null, null);
	}
	public Item(int i, String s)
	{
		this(s,null);
	}
	//public Item(String id, String description)
	//{
	//	this.id = id;
	//	this.description = description;
	//}
	public Item(String string, String string2) {
		// TODO Auto-generated constructor stub
		id = string;
		description = string2;
	}
    @XmlElement(name="id", required=true)
	public String getId()
	{
		return id;
	}
 //   @XmlElement(name="id", required=true)
	public void setId(String id)
	{
		this.id = id;
	}
    @XmlElement(name="description", required=true)
	public String getDescription()
	{
		return description;
	}
 //   @XmlElement(name="description", required=true)
    public void setDescription(String description)
	{
		this.description = description;
	}
}
