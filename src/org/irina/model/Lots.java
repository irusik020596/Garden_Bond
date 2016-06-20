package org.irina.model;

import java.io.Serializable;
import java.rmi.server.UID;
//import java.util.ArrayList;
import java.util.List;
//import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

import org.irina.beans.Item;
import org.irina.beans.Problem;
import org.irina.beans.SessionBean;
import org.irina.beans.Statistic;
import org.irina.dao.LotDAO;
import org.irina.dao.ProblemDAO;
import org.irina.util.Subscriber;


@ManagedBean
@ViewScoped
public class Lots implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

    private List<Item> list;
    private Item item = new Item();
    private boolean edit;
    private String user;
    private List<Problem> listProblems;
    
    @PostConstruct
    public void init() {
		HttpSession session = SessionBean.getSession();
		user = (String)session.getAttribute("username");
        list = LotDAO.getLots(user);
        listProblems = ProblemDAO.getActiveProblems(user);
    }
    
    public void add() {
        String key = getPrimaryKey();
        // Actually, the DAO should already have set the ID from DB. This is just for demo.
        item.setId(key);
        LotDAO.addLot(user, item.getId(), item.getDescription(), item.getDomain(),item.getBroker_url(),item.getBroker_login(),item.getBroker_password());
        list.add(item);
        item = new Item(); // Reset placeholder.
    }

    public void editM(Item item) {
        this.item = item;
        edit = true;
    }

    public void save() {
        // dao.update(item);
    	LotDAO.editLot(item.getId(), item.getDescription(),item.getDomain(),item.getBroker_url(),item.getBroker_login(),item.getBroker_password());
    	item = new Item(); // Reset placeholder.
        edit = false;
    }

    public void delete(Item item) {
        // dao.delete(item);
    	LotDAO.deleteLot(item.getId());
        list.remove(item);
    }

    public List<Item> getList() {
        return list;
    }
    public List<Problem> getListProblems()
    {
    	return listProblems;
    }
    public void checked(Problem problem)
    {
    	ProblemDAO.checkProblem(problem.getId());
    	listProblems.remove(problem);
    }
    public Item getItem() {
        return item;
    }

    public boolean isEdit() {
        return edit;
    }
    private static String getPrimaryKey()
    {
	return new UID().toString();
    }
    public String sensors()
    {
    	return "sensors";
    }
    public String rules()
    {
    	return "rules";
    }
    public String robots()
    {
    	return "robots";
    }
    public String problems()
    {
    	return "problems";
    }
    public String lots()
    {
    	return "lots";
    }
   
    public String gotolot(Item item)
    {
		HttpSession session = SessionBean.getSession();
		session.setAttribute("lotid", item.getId());
		session.setAttribute("lotname", item.getDescription());
		session.setAttribute("lotdomain", item.getDomain());
		session.setAttribute("lotbroker_url", item.getBroker_url());
		session.setAttribute("lotbroker_login", item.getBroker_login());
		session.setAttribute("lotbroker_password", item.getBroker_password());
		return sensors();
    }

}