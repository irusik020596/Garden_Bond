package org.irina.model;

import java.io.Serializable;
//import java.rmi.server.UID;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

import org.irina.beans.SessionBean;

//import org.irina.util.Item;
//import org.irina.dao.LotDAO;


@ManagedBean
@ViewScoped
public class Problems implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

    private String lotId;

    @PostConstruct
    public void init() {
        // list = dao.list();
        // Actually, you should retrieve the list from DAO. This is just for demo.
		HttpSession session = SessionBean.getSession();
		lotId = (String)session.getAttribute("lotid");
    }
    public String getLotId()
    {
    	return lotId;
    }
}
