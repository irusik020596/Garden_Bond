package org.irina.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class HandBook {
	
	private static String getKeyFromValue(Map<String, Object> hm, Object value) {
	    for (String o : hm.keySet()) {
	      if (hm.get(o).equals(value)) {
	        return o;
	      }
	    }
	    return null;
// sensors	    
	  }	private static Map<String,Object> sensorTypeValue;
	static{
		sensorTypeValue = new LinkedHashMap<String,Object>();
		sensorTypeValue.put("temperature of air", "1"); //label, value
		sensorTypeValue.put("temperature of soil", "2");
		sensorTypeValue.put("humidity of air", "3");
		sensorTypeValue.put("humidity of soil", "4");
		sensorTypeValue.put("illumination", "5");
	}
	public static Map<String,Object> getSensorTypeValue() {
		return sensorTypeValue;
	}
	public static String getSensorType(Object value)
	{
		return getKeyFromValue(sensorTypeValue, value);
	}
	private static Map<String,Object> sensorStatusValue;
	static{
		sensorStatusValue = new LinkedHashMap<String,Object>();
		sensorStatusValue.put("active", "a"); //label, value
		sensorStatusValue.put("passive", "p");
	}
	public static Map<String,Object> getSensorStatusValue() {
		return sensorStatusValue;
	}
	public static String getSensorStatus(Object value)
	{
		return getKeyFromValue(sensorStatusValue, value);
	}
// operations	
	private static Map<String,Object> operationValue;
	static{
		operationValue = new LinkedHashMap<String,Object>();
		operationValue.put("less", "<"); //label, value
		operationValue.put("great", ">");
	}
	public static Map<String,Object> getOperationValue() {
		return operationValue;
	}
	public static String getOperation(Object value)
	{
		return getKeyFromValue(operationValue, value);
	}
// rules	
	private static Map<String,Object> ruleTypeValue;
	static{
		ruleTypeValue = new LinkedHashMap<String,Object>();
		ruleTypeValue.put("all conditions", "and"); //label, value
		ruleTypeValue.put("any condition", "or");
	}
	public static Map<String,Object> getRuleTypeValue() {
		return ruleTypeValue;
	}
	public static String getRuleType(Object value)
	{
		return getKeyFromValue(ruleTypeValue, value);
	}
	private static Map<String,Object> smsTypeValue;
	static{
		smsTypeValue = new LinkedHashMap<String,Object>();
		smsTypeValue.put("not send", "n"); //label, value
		smsTypeValue.put("send once", "o");
		smsTypeValue.put("send always", "a");
	}
	public static Map<String,Object> getSmsTypeValue() {
		return smsTypeValue;
	}
	public static String getSmsType(Object value)
	{
		return getKeyFromValue(smsTypeValue, value);
	}
	private static Map<String,Object> emailTypeValue;
	static{
		emailTypeValue = new LinkedHashMap<String,Object>();
		emailTypeValue.put("not send", "n"); //label, value
		emailTypeValue.put("send once", "o");
		emailTypeValue.put("send always", "a");
	}
	public static Map<String,Object> getEmailTypeValue() {
		return emailTypeValue;
	}
	public static String getEmailType(Object value)
	{
		return getKeyFromValue(emailTypeValue, value);
	}
// robots	
	private static Map<String,Object> robotTypeValue;
	static{
		robotTypeValue = new LinkedHashMap<String,Object>();
		robotTypeValue.put("heater", "1"); //label, value
		robotTypeValue.put("watering", "2");
		robotTypeValue.put("illumination", "3");
	}
	public static Map<String,Object> getRobotTypeValue() {
		return robotTypeValue;
	}
	public static String getRobotType(Object value)
	{
		return getKeyFromValue(robotTypeValue, value);
	}
	private static Map<String,Object> robotStatusValue;
	static{
		robotStatusValue = new LinkedHashMap<String,Object>();
		robotStatusValue.put("active", "a"); //label, value
		robotStatusValue.put("passive", "p");
	}
	public static Map<String,Object> getRobotStatusValue() {
		return robotStatusValue;
	}
	public static String getRobotStatus(Object value)
	{
		return getKeyFromValue(robotStatusValue, value);
	}
	private static Map<String,Object> robotStateValue;
	static{
		robotStateValue = new LinkedHashMap<String,Object>();
		robotStateValue.put("on", "o"); //label, value
		robotStateValue.put("off", "f");
	}
	public static Map<String,Object> getRobotStateValue() {
		return robotStateValue;
	}
	public static String getRobotState(Object value)
	{
		return getKeyFromValue(robotStateValue, value);
	}
}
