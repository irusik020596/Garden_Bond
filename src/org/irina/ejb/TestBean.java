package org.irina.ejb;
//import javax.ejb.embeddable.EJBContainer;
//import javax.naming.Context;
import javax.naming.InitialContext;

public class TestBean {
  public static void test() throws Exception
  {
//	Context context = EJBContainer.createEJBContainer().getContext();
//	 Friend red = (Friend) context.lookup("java:global/plants/RedBean");
		/* Friend red = (Friend)  new InitialContext().lookup("java:global/RedBean");
	  System.out.println("red ay: " + red.sayHello());
	System.out.println("friend say: " + red.helloFromFriend());*/
  }
}
