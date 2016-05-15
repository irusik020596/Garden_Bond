package org.irina.beans;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//import org.irina.model.User;

@XmlRootElement(name="problem")
public class Problem {
	private String id;
	private String lot;
	private String rule;
	private String notes;
	private String attime;
	public Problem()
	{
		this(null, null, null, null, null);
	}
	public Problem(String id, String lot, String rule, String attime, String notes) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.lot = lot;
		this.rule = rule;
		this.attime = attime;
		this.notes = notes;
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
    @XmlElement(name="lot", required=true)
	public String getLot()
	{
		return lot;
	}
    public void setLot(String lot)
	{
		this.lot = lot;
	}
    @XmlElement(name="rule", required=true)
	public String getRule()
	{
		return rule;
	}
    public void setRule(String rule)
	{
		this.rule = rule;
	}
    @XmlElement(name="attime", required=true)
	public String getAttime()
	{
		return attime;
	}
    public void setAttime(String attime)
	{
		this.attime = attime;
	}
    @XmlElement(name="notes", required=true)
	public String getNotes()
	{
		return notes;
	}
    public void setNotes(String notes)
	{
		this.notes = notes;
	}
}
