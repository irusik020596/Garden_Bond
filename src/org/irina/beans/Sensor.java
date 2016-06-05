package org.irina.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.irina.util.HandBook;

@XmlRootElement(name = "sensor")
public class Sensor implements Serializable {
	private String id;
	// private String lotId;
	private String name;
	private String description;
	// private String host;
	// private String port;
	private String type;
	private String status;

	public Sensor(String id, /* String lotId, */ String name, String description, String type, String status) {
		this.id = id;
		// this.lotId =lotId;
		this.name = name;
		this.description = description;
		this.type = type;
		this.status = status;
	}

	public Sensor() {
		this(null, null, null, null, null);
	}

	@XmlElement(name = "id", required = true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/*
	 * public String getLotId() { return lotId; } public void setLotId(String
	 * lotId) { this.lotId = lotId; }
	 */
	@XmlElement(name = "name", required = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "description", required = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * @XmlElement(name="host", required=true) public String getHost() { return
	 * host; } public void setHost(String host) { this.host = host; }
	 * 
	 * @XmlElement(name="port", required=true) public String getPort() { return
	 * port; } public void setPort(String port) { this.port = port; }
	 */
	@XmlElement(name = "type", required = true)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlElement(name = "status", required = true)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTypeText() {
		return HandBook.getSensorType(type);
	}

	public String getStatusText() {
		return HandBook.getSensorStatus(status);
	}
}
