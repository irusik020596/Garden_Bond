package org.irina.filter;

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
import org.irina.dao.ConditionDAO;
import org.irina.dao.SensorDAO;
import org.irina.dao.SubscriberDAO;
import org.irina.util.DataConnect;
import org.json.JSONArray;
import org.json.JSONObject;

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
			// System.out.println("Message: " + new
			// String(message.getPayload()));
			convert(new String(message.getPayload()));
			// TODO Auto-generated method stub
			/*
			 * System.out.println(
			 * "-------------------------------------------------");
			 * 
			 * System.out.println("| Message: " + new
			 * String(message.getPayload())); System.out.println(
			 * "-------------------------------------------------");
			 */} catch (Exception e) {
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
				// System.out.println("uid:" + getPrimaryKey());
				// System.out.println("name:" + map.get("name"));
				// System.out.println("datavalue:" + map.get("datavalue"));

				maps.add(i, map);
				String sensorId = SubscriberDAO.getSensorId(domain, map.get("name"));
				System.out.println("Sensorid : " + sensorId);
				System.out.println("datavalue : " + map.get("datavalue"));
				List<Problem> listProblems = checkProblems(sensorId, Integer.parseInt(map.get("datavalue")));
				// for(Problem p:listProblems){
				// System.out.println(p.toString());
				// System.out.println("--------------");
				// }
				SubscriberDAO.toInfosDatabase(map, domain, sensorId);
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

	private List<Problem> checkProblems(String sensorId, int dataValue) {
		List<Condition> list = ConditionDAO.getConditionsBySensor(sensorId);
		List<Problem> problems = new ArrayList<Problem>();
		try {
			for (Condition c : list) {
				if (c.getOperationText().equals("great")) {
					if (dataValue < Double.parseDouble(c.getLimit())) {
						Problem p = makeProblem(c, sensorId,dataValue);
						problems.add(p);
					}
				}
				if (c.getOperationText().equals("less")) {
					if (dataValue > Double.parseDouble(c.getLimit())) {
						// System.out.println("make");
						Problem p = makeProblem(c, sensorId,dataValue);
						problems.add(p);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("checkProblems: " + e.getMessage());
		}
		return problems;
	}

	private Problem makeProblem(Condition c, String sensorId, int dataValue) {

		String id = SubscriberDAO.getPrimaryKey();
		String rule = ConditionDAO.getRuleByCoditionId(c.getId());
		String lot = ConditionDAO.getLotByCoditionId(c.getId());
		String notes = SensorDAO.getSensorName(c.getSensorId()) + "=" + dataValue + " not " + c.getOperationText() + " "
				+ c.getLimit();
		System.out.println("-----------------");
		System.out.println("id " + id);
		System.out.println("rule " + rule);
		System.out.println("lot " + lot);
		System.out.println("notes " + notes);
		System.out.println("-----------------");
		Problem p = new Problem(id, lot, rule, notes, new Date().toString());
		return p;
	}

	/*
	 * private String modelValue(String op, String limit) { String s = "";
	 * double d = Double.parseDouble(limit); if (op.equals("<")) s += (d + 1);
	 * else s += (d - 1); return s; }
	 * 
	 * public String getClientID() { return clientID; }
	 */

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
