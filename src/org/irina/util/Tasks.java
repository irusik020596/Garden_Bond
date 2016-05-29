package org.irina.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.irina.dao.TasksDAO;

public class Tasks implements Runnable
{
    @Override public void run() {
      /*++fCount;
      Date date = new Date();   // given date
      Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
      calendar.setTime(date);   // assigns calendar to given date 
      int h = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
      //calendar.get(Calendar.HOUR);        // gets hour in 12h format
      //calendar.get(Calendar.MONTH);
      int m = calendar.get(Calendar.MINUTE);
//      System.out.println("date=" + date.toString() + ";hour=" + h + "minute=" +m);
      if(m == 0)
      {
    	  task1(h);
      }*/
    }
    /*private static void task1(int h)
    {
    	List<String> lotsIds = TasksDAO.getLots(h);
    	if(lotsIds == null)
    		return;
    	for(int i = 0; i < lotsIds.size(); i++)
    	{
    		String lotId = lotsIds.get(i);
    		List<Measurement> ml = TasksDAO.getSensors(lotId);
    		if(ml == null)
    			continue;
// get value
    		for(int j = 0; j < ml.size(); j++)
    		{
    			Measurement m = ml.get(j);
    			m.getting();
    		}
// save values
// are problems ? - clean problems + deactivate robots |+ create problems + activate robots
    	}
    
    /*private int fCount;*/
}