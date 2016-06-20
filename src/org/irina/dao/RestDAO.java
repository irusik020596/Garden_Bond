package org.irina.dao;
import java.rmi.server.UID;
import java.util.List;

import org.irina.beans.Item;
import org.irina.beans.Problem;
import org.irina.beans.Robot;
import org.irina.beans.Sensor;
import org.irina.beans.Rule;
import org.irina.beans.Condition;

public class RestDAO
{
    private static String getKey()
    {
    	return new UID().toString();
    }
// lots    
   	public static List<Item> getLots(String user, String password)
	{
		List<Item> l = null;
		if(LoginDAO.validateLogin(user, password))
		{
			l = LotDAO.getLots(user);
		}
		return l;
	}
   	public static String addLot(String user, String password, String description, String domain, String broker_url,String broker_login, String broker_password)
   	{
   		String r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			String key = getKey();
			r = LotDAO.addLot(user, key, description, domain,  broker_url, broker_login,  broker_password);
		}
		return r;
   	}
   	public static String editLot(String user, String password, String key, String description,String domain, String broker_url,String broker_login, String broker_password)
   	{
   		String r = null;
   		if(LoginDAO.validateLogin(user, password))
		{
			r = LotDAO.editLot(key, description,domain,  broker_url, broker_login,  broker_password);
		}
		return r;
   	}   
   	public static String deleteLot(String user, String password, String key)
   	{
   		String r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			r = LotDAO.deleteLot(key);
		}
		return r;
   	}   	
// sensors
   	public static List<Sensor> getSensors(String user, String password, String lotId)
	{
		List<Sensor> l = null;
		if(LoginDAO.validateLogin(user, password))
		{
			l = SensorDAO.getSensors(lotId);
		}
		return l;
	}
   	public static String addSensor(String user, String password, String lotId, String name, String description, String type, String status)
   	{
   		String r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			String key = getKey();
			r = SensorDAO.addSensor(lotId, key, name, description, type, status);
		}
		return r;
   	}
   	public static String editSensor(String user, String password, String key, String name, String description, String type, String status)
   	{
   		String r = null;
   		if(LoginDAO.validateLogin(user, password))
		{
			r = SensorDAO.editSensor(key, name, description, type, status);
		}
		return r;
   	}   
   	public static String deleteSensor(String user, String password, String key)
   	{
   		String r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			r = SensorDAO.deleteSensor(key);
		}
		return r;
   	}   	
   	public static String setSensorActive(String user, String password, String key)
   	{
   		String r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			r = SensorDAO.setSensorActive(key);
		}
		return r;
   	}   	
   	public static String setSensorPassive(String user, String password, String key)
   	{
   		String r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			r = SensorDAO.setSensorPassive(key);
		}
		return r;
   	}   	
 // rules
   	public static List<Rule> getRules(String user, String password, String lotId)
	{
		List<Rule> l = null;
		if(LoginDAO.validateLogin(user, password))
		{
			l = RuleDAO.getRules(lotId);
		}
		return l;
	}
   	public static String addRule(String user, String password, String lotId, String name, String description, String smsnote, String emailnote, String type)
   	{
   		String r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			String key = getKey();
			r = RuleDAO.addRule(lotId, key, name, description, smsnote, emailnote, type);
		}
		return r;
   	}
   	public static String editRule(String user, String password, String key, String name, String description, String smsnote, String emailnote, String type)
   	{
   		String r = null;
   		if(LoginDAO.validateLogin(user, password))
		{
			r = RuleDAO.editRule(key, name, description, smsnote, emailnote, type);
		}
		return r;
   	}   
   	public static String deleteRule(String user, String password, String key)
   	{
   		String r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			r = RuleDAO.deleteRule(key);
		}
		return r;
   	}    	
 // conditions
   	public static List<Condition> getConditions(String user, String password, String ruleId)
	{
		List<Condition> l = null;
		if(LoginDAO.validateLogin(user, password))
		{
			l = ConditionDAO.getConditions(ruleId);
		}
		return l;
	}
   	public static String addCondition(String user, String password, String ruleId, String sensorId, String operation, String limit)
   	{
   		String r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			String key = getKey();
			r = ConditionDAO.addCondition(ruleId, key, sensorId, operation, limit);
		}
		return r;
   	}
   	public static String editCondition(String user, String password, String key, String sensorId, String operation, String limit)
   	{
   		String r = null;
   		if(LoginDAO.validateLogin(user, password))
		{
			r = ConditionDAO.editCondition(key, sensorId, operation, limit);
		}
		return r;
   	}   
   	public static String deleteCondition(String user, String password, String key)
   	{
   		String r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			r = ConditionDAO.deleteCondition(key);
		}
		return r;
   	}   
 // robots
   	public static List<Robot> getRobots(String user, String password, String lotId)
	{
		List<Robot> l = null;
		if(LoginDAO.validateLogin(user, password))
		{
			l = RobotDAO.getRobots(lotId);
		}
		return l;
	}
   	public static String addRobot(String user, String password, String lotId, String name, String description, String type, String status, String state)
   	{
   		String r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			String key = getKey();
			r = RobotDAO.addRobot(lotId, key, name, description, type, status, state);
		}
		return r;
   	}
   	public static String editRobot(String user, String password, String key, String name, String description, String type, String status, String state)
   	{
   		String r = null;
   		if(LoginDAO.validateLogin(user, password))
		{
			r = RobotDAO.editRobot(key, name, description, type, status, state);
		}
		return r;
   	}   
   	public static String deleteRobot(String user, String password, String key)
   	{
   		String r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			r = RobotDAO.deleteRobot(key);
		}
		return r;
   	}   
   	public static String setRobotActive(String user, String password, String key)
   	{
   		String r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			r = RobotDAO.setRobotActive(key);
		}
		return r;
   	}   	
   	public static String setRobotPassive(String user, String password, String key)
   	{
   		String r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			r = RobotDAO.setRobotPassive(key);
		}
		return r;
   	}   	
   	public static String setRobotOn(String user, String password, String key)
   	{
   		String r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			r = RobotDAO.setRobotOn(key);
		}
		return r;
   	}   	
   	public static String setRobotOff(String user, String password, String key)
   	{
   		String r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			r = RobotDAO.setRobotOff(key);
		}
		return r;
   	}   	
// problems
   	public static String checkProblem(String user, String password, String key)
   	{
   		String r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			r = ProblemDAO.checkProblem(key);
		}
		return r;
   	}   	
	public static List<Problem> getActiveProblems(String user, String password)
	{
   		List<Problem> r = null;
		if(LoginDAO.validateLogin(user, password))
		{
			r = ProblemDAO.getActiveProblems(user);
		}
		return r;
		
	}
}
