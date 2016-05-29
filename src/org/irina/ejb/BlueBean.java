package org.irina.ejb;

/*import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

//START SNIPPET: code
@Stateless
@EJB(beanInterface = Friend.class, beanName = "RedBean", name = "myFriend")
public class BlueBean implements Friend {

    public String sayHello() {
        return "Blue says, Hello!";
    }

    public String helloFromFriend() {
        try {
            Friend friend = (Friend) new InitialContext().lookup("java:comp/env/myFriend");
            return "My friend " + friend.sayHello();
        } catch (NamingException e) {
            throw new EJBException(e);
        }
    }
}*/
//END SNIPPET: code
