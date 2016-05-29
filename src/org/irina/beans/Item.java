package org.irina.beans;
//import java.util.List;

//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class Item {
	private String id;
	private String description;
	private String domain;
	private String broker_url;
	private String broker_login;
	private String broker_password;

	public Item() {
		this(null, null, null, null, null, null);
	}

	public Item(int i, String s) {
		this(s, null, null, null, null, null);
	}

	// public Item(String id, String description)
	// {
	// this.id = id;
	// this.description = description;
	// }
	public Item(String string, String string2, String dom, String brURL, String brLogin, String brPassword) {
		// TODO Auto-generated constructor stub
		id = string;
		description = string2;
		domain = dom;
		broker_url = brURL;
		broker_login = brLogin;
		broker_password = brPassword;
	}

	@XmlElement(name = "id", required = true)
	public String getId() {
		return id;
	}

	// @XmlElement(name="id", required=true)
	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "description", required = true)
	public String getDescription() {
		return description;
	}

	// @XmlElement(name="description", required=true)
	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name = "domain", required = true)
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@XmlElement(name = "broker_url", required = true)
	public String getBroker_url() {
		return broker_url;
	}

	public void setBroker_url(String broker_url) {
		this.broker_url = broker_url;
	}

	@XmlElement(name = "broker_login", required = true)
	public String getBroker_login() {
		return broker_login;
	}

	public void setBroker_login(String broker_login) {
		this.broker_login = broker_login;
	}

	@XmlElement(name = "broker_password", required = true)
	public String getBroker_password() {
		return broker_password;
	}

	public void setBroker_password(String broker_password) {
		this.broker_password = broker_password;
	}
}
