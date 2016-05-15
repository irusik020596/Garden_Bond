package org.irina.ejb;

//import javax.ejb.Local;

/**
 * This is an EJB 3 local business interface
 * A local business interface may be annotated with the @Local
 * annotation, but it's optional. A business interface which is
 * not annotated with @Local or @Remote is assumed to be Local
 * if the bean does not implement any other interfaces
 */
//START SNIPPET: code
//@Local
public interface Friend {

    public String sayHello();

    public String helloFromFriend();

}
//END SNIPPET: code
