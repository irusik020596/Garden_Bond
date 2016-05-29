package org.irina.model;

import java.io.Serializable;
import java.rmi.server.UID;
//import java.util.ArrayList;
import java.util.List;
//import java.util.UUID;
//import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

//import org.irina.dao.LotDAO;
import org.irina.util.HandBook;
import org.irina.beans.Condition;
import org.irina.beans.Rule;
import org.irina.beans.Sensor;
import org.irina.beans.SessionBean;
import org.irina.dao.RuleDAO;
import org.irina.dao.SensorDAO;
import org.irina.dao.ConditionDAO;
import org.irina.dao.ProblemDAO;


@ManagedBean
@ViewScoped
public class Rules implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

    
    private List<Rule> list;
    private Rule rule = new Rule();
    private boolean edit;
    private String lotId;
    private Condition condition = new Condition();
    private List<Condition> conditionlist;
    private boolean editcond;
    private List<Sensor> sen;
	private Map<String,Object> condValue;
    private String lotName;
	

    @PostConstruct
    public void init() {
        // list = dao.list();
        // Actually, you should retrieve the list from DAO. This is just for demo.
		HttpSession session = SessionBean.getSession();
		lotId = (String)session.getAttribute("lotid");
		lotName = (String)session.getAttribute("lotname");
        list = RuleDAO.getRules(lotId);
        sen = SensorDAO.getSensors(lotId);
        condValue = present(sen);
    }
    public String getSensorName(String sensorId)
    {
    	for(int i = 0; i < sen.size(); i ++)
    	{
    		Sensor se = sen.get(i);
    		if(se.getId().equals(sensorId))
    		{
    			return se.getName();
    		}
    	}
    	return "n/a";
    }
    private Map<String,Object> present(List<Sensor> sen)
    {
    	Map<String,Object> m = new LinkedHashMap<String,Object>();
    	for(int i = 0; i < sen.size(); i++)
    	{
    		Sensor s = sen.get(i);
    		m.put(s.getName(), s.getId());
    	}
    	return m;
    }

	public Map<String,Object> getCondValue() {
		return condValue;
	}
    
	public Map<String,Object> getRuleTypeValue()
	{
		return HandBook.getRuleTypeValue();
	}
	public Map<String,Object> getOperationValue()
	{
		return HandBook.getOperationValue();
	}
	public Map<String,Object> getSmsTypeValue()
	{
		return HandBook.getSmsTypeValue();
	}
	public Map<String,Object> getEmailTypeValue()
	{
		return HandBook.getEmailTypeValue();
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
        rule.setId(key);
        RuleDAO.addRule(lotId, rule.getId(), rule.getName(), rule.getDescription(), rule.getSmsnote(), rule.getEmailnote(), rule.getType());
        list.add(rule);
        rule = new Rule(); // Reset placeholder.
    }

    public void addcondit() {
        String key = getPrimaryKey();
        condition.setId(key);
        ConditionDAO.addCondition(rule.getId(), condition.getId(), condition.getSensorId(), condition.getOperation(), condition.getLimit());
        conditionlist.add(condition);
        condition = new Condition(); // Reset placeholder.
    }

    public void editM(Rule rule) {
        this.rule = rule;
        conditionlist = ConditionDAO.getConditions(rule.getId());
        edit = true;
    }

    public void editCond(Condition condition) {
        this.condition = condition;
        editcond = true;
    }
    
    public void save() {
    	RuleDAO.editRule(rule.getId(), rule.getName(), rule.getDescription(), rule.getSmsnote(), rule.getEmailnote(), rule.getType());
        rule = new Rule(); // Reset placeholder.
        edit = false;
    }

    public void saveCond() {
    	ConditionDAO.editCondition(condition.getId(), condition.getSensorId(), condition.getOperation(), condition.getLimit());
        condition = new Condition(); // Reset placeholder.
        editcond = false;
    }

    public void delete(Rule rule) {
    	RuleDAO.deleteRule(rule.getId());
        list.remove(rule);
    }
    private String modelValue(String op, String limit)
    {
    	String s = "";
    	double d = Double.parseDouble(limit);
    	if(op.equals("<"))
    		s += (d + 1);
    	else
    		s += (d -1);
    	return s;
    }
    private String noteConditions(List<Condition> clist)
    {
    	String s ="";
    	Condition c;
    	for(int i = 0; i < clist.size(); i ++)
    	{
    		c = clist.get(i);
    		if(i > 0)
    			s += "; ";
    		s += getSensorName(c.getSensorId()) + "=" + modelValue(c.getOperation(), c.getLimit()) 
    				+ " not " + c.getOperationText() + " " + c.getLimit();
    	}
    	return s;
    }
    public void newproblem(Rule rule) {
        String key = getPrimaryKey();
        List<Condition> clist =  ConditionDAO.getConditions(rule.getId());
        String notes = noteConditions(clist);
    	ProblemDAO.newProblem(key, rule.getId(), notes);
    }

    public void deleteCond(Condition condition) {
    	ConditionDAO.deleteCondition(condition.getId());
        conditionlist.remove(condition);
    }

    public List<Rule> getList() {
        return list;
    }
    public List<Condition> getConditionlist() {
    	if(!edit) return null;
    	return conditionlist;
    }

    public Rule getRule() {
        return rule;
    }

    public Condition getCondition() {
        return condition;
    }

    public boolean isEdit() {
        return edit;
    }
    public boolean isEditcond() {
        return edit && editcond;
    }
    public boolean isAddcond() {
    	if(!edit) return false;
    	return !editcond;
    }
    private static String getPrimaryKey()
    {
    	return new UID().toString();
    }


}
