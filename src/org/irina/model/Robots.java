package org.irina.model;

import java.io.Serializable;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
//import java.util.UUID;
//import java.util.Arrays;
//import java.util.LinkedHashMap;
//import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

//import org.irina.dao.LotDAO;
import org.irina.beans.Robot;
import org.irina.beans.Rule;
import org.irina.beans.SessionBean;
import org.irina.dao.RobotDAO;
import org.irina.dao.RuleDAO;
import org.irina.util.HandBook;


@ManagedBean
@ViewScoped
public class Robots implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;
     
    private List<Robot> list;
    private Robot robot = new Robot();
    private boolean edit;
    private String lotId;
    private List<Rule> rules;
    private String[] ruleData;
    //private SelectItem condimentItems[];
    private Map<String, Object> ruleValues; 
    private String lotName;

    @PostConstruct
    public void init() {
        // list = dao.list();
        // Actually, you should retrieve the list from DAO. This is just for demo.
		HttpSession session = SessionBean.getSession();
		lotId = (String)session.getAttribute("lotid");
		lotName = (String)session.getAttribute("lotname");
        list = RobotDAO.getRobots(lotId);
        rules = RuleDAO.getRules(lotId);
        ruleValues = present(rules);
    }
    private Map<String, Object> present(List<Rule> rules)
    {
    	LinkedHashMap<String, Object> l = new LinkedHashMap<String, Object>();
    	//l.put("1","111");
    	//l.put("2","222");
    	//l.put("3","333");
    	for(int i = 0; i < rules.size(); i++)
    	{
    		
    		l.put(rules.get(i).getName(), rules.get(i).getId());
    	}
    	return l;
    }
    public Map<String, Object> getRuleValues()
    {
    	return ruleValues;
    }
     //public SelectItem[] getCondimentItems() {
     //   return condimentItems;
     //}
    
    public List<Rule> getRules()
    {
    	return rules;
    }
    public String getLotId()
    {
    	return lotId;
    }
    public String getLotName()
    {
    	return lotName;
    }
    public void add() {
        String key = getPrimaryKey();
        robot.setId(key);
        RobotDAO.addRobot(lotId, robot.getId(), robot.getName(), robot.getDescription(), robot.getType(), robot.getStatus(), robot.getState());
    	RobotDAO.setRules(robot.getId(),ruleData);
        list.add(robot);
        robot = new Robot(); // Reset placeholder.
    }

    public void editM(Robot robot) {
        this.robot = robot;
        ruleData = RobotDAO.getRules(robot.getId());
        edit = true;
    }
    public String[] getRuleData()
    {
    	return ruleData;
    }
    public void setRuleData(String[] s)
    {
    	ruleData = s;
    }

    public void save() {
    	RobotDAO.editRobot(robot.getId(), robot.getName(), robot.getDescription(), robot.getType(), robot.getStatus(), robot.getState());
    	RobotDAO.setRules(robot.getId(),ruleData);
for(int i = 0; i < ruleData.length; i++)
	System.out.println("ruleData[" + i + "]=" + ruleData[i]);
    	robot = new Robot(); // Reset placeholder.
        edit = false;
    }

    public void delete(Robot robot) {
    	RobotDAO.deleteRobot(robot.getId());
        list.remove(robot);
    }

    public List<Robot> getList() {
        return list;
    }

    public Robot getRobot() {
        return robot;
    }

    public boolean isEdit() {
        return edit;
    }
    private static String getPrimaryKey()
    {
    	return new UID().toString();
    }
	public Map<String,Object> getRobotTypeValue()
	{
		return HandBook.getRobotTypeValue();
	}
	public Map<String,Object> getRobotStatusValue()
	{
		return HandBook.getRobotStatusValue();
	}
	public Map<String,Object> getRobotStateValue()
	{
		return HandBook.getRobotStateValue();
	}

}
