package org.irina.util;

import java.rmi.server.UID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.irina.beans.Condition;
import org.irina.beans.Item;
import org.irina.beans.Problem;
import org.irina.beans.SessionBean;
import org.irina.dao.ConditionDAO;
import org.irina.dao.LoginDAO;
import org.irina.dao.ProblemDAO;
import org.irina.dao.SensorDAO;
import org.irina.dao.SubscriberDAO;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.HttpSession;
import javax.activation.*;

public class Subscriber implements MqttCallback {

	MqttClient myClient;
	MqttConnectOptions connOpt;

	private String clientID = "client";
	private String broker_url;
	private String domain;
	List<Map<String, String>> maps;

	public Subscriber(String broker_url, String domain) {
		this.broker_url = broker_url;
		this.domain = domain;
		maps = new ArrayList<Map<String, String>>();

	}

	/**
	 * 
	 * connectionLost This callback is invoked upon losing the MQTT connection.
	 * 
	 */
	@Override
	public void connectionLost(Throwable t) {
		System.out.println("Connection lost!" + "    T:" + t.toString());
	}

	/**
	 * 
	 * deliveryComplete This callback is invoked when a message published by
	 * this client is successfully received by the broker.
	 * 
	 */

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		// System.out.println("Pub complete" + new
		// String(token.getMessage().getPayload()));

	}

	/**
	 * 
	 * messageArrived This callback is invoked when a message is received on a
	 * subscribed topic.
	 * 
	 */

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		try {
			System.out.println("Topic:" + topic);
			convert(new String(message.getPayload()));
		} catch (Exception e) {
			System.out.println("subscriber messageArrived: " + e.getMessage());
		}

	}

	public void convert(String jsonString) {
		try {
			JSONArray jsonarray = new JSONArray(jsonString);
			System.out.println(jsonarray.toString());
			int n = jsonarray.length();
			for (int i = 0; i < n; ++i) {
				Map<String, String> map = new HashMap<String, String>();
				JSONObject infos = jsonarray.getJSONObject(i);
				map.put("name", infos.getString("name"));
				map.put("datavalue", infos.getString("datavalue"));
				maps.add(i, map);
				String sensorId = SubscriberDAO.getSensorId(domain, map.get("name"));
				System.out.println("Sensorid : " + sensorId);
				System.out.println("datavalue : " + map.get("datavalue"));
				List<String> listSensors = checkProblems(sensorId, Integer.parseInt(map.get("datavalue")));
				SubscriberDAO.toInfosDatabase(map, domain, sensorId);
				send(listSensors);
			}
		} catch (Exception e) {
			System.out.println("subscriber convert:" + e.toString());
		}

	}

	public void runClient() {
		try {
			myClient = new MqttClient(broker_url, clientID);
			myClient.setCallback(this);
			myClient.connect(/* connOpt */);
		} catch (MqttException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		System.out.println("Connected to " + broker_url);

		String myTopic = domain;
		System.out.println(myTopic);
		try {
			int subQoS = 1;
			myClient.subscribe(myTopic, subQoS);
		} catch (Exception e) {
			System.out.println("try subQoS:" + e.getMessage());
		}
	}

	private List<String> checkProblems(String sensorId, int dataValue) {
		List<Condition> list = ConditionDAO.getConditionsBySensor(sensorId);
		List<String> sensorsId = new ArrayList<String>();
		try {
			for (Condition c : list) {
				if (c.getOperationText().equals("great")) {
					if (dataValue < Double.parseDouble(c.getLimit())) {
						String s = makeProblem(c, sensorId, dataValue);
						sensorsId.add(s);
					}
				}
				if (c.getOperationText().equals("less")) {
					if (dataValue > Double.parseDouble(c.getLimit())) {
						String s = makeProblem(c, sensorId, dataValue);
						sensorsId.add(s);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("checkProblems: " + e.getMessage());
		}
		return sensorsId;
	}

	private String makeProblem(Condition c, String sensorId, int dataValue) {
		String id = SubscriberDAO.getPrimaryKey();
		String ruleId = ConditionDAO.getRuleByCoditionId(c.getId());
		String notes = SensorDAO.getSensorName(c.getSensorId()) + "=" + dataValue + " not " + c.getOperationText() + " "
				+ c.getLimit();
		String sensorsId = ProblemDAO.newProblem(id, ruleId, notes, sensorId);
		return sensorsId;
	}

	public void sendEmail(String email, String messageText) {
		String from = "irusik020596@gmail.com";
		// final String username = "irusik020596";//change accordingly
		// final String password = "dctrjpks";//change accordingly
		String host = "localhost";

		Properties props = new Properties();
		// props.put("mail.smtp.auth", "true");
		// props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "2525");
		// Session session = Session.getInstance(props, new
		// GMailAuthenticator(username, password));
		Session session = Session.getDefaultInstance(props);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("This is the Subject Line!");
			message.setText(messageText);
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	public void send(List<String> listSensors) {
		try {
			// for (String sensor : listSensors) {

			System.out.println(listSensors.get(0));
			List<String> values = LoginDAO.getUserEmail(listSensors.get(0));
			if (values.size() < 2)
				return;
			String email = values.get(1);
			System.out.println("email:" + email);
			List<Problem> problems = ProblemDAO.getActiveProblems(values.get(0));
			String text = "Garden Bond notification:\"\n\n\"";
			for (Problem p : problems) {
				text += p.toString() + "\n";
				// System.out.println("sendEmail:" + text);
			}
			sendEmail(email, text);
			// }
		} catch (Exception e) {
			System.out.println("send " + e.toString());
		}
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getBroker_url() {
		return broker_url;
	}

	public void setBroker_url(String broker_url) {
		this.broker_url = broker_url;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}
