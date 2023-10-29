package classes;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
public class App 
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("web.xml");

        Tyre t = (Tyre) context.getBean("tyre");
        System.out.println(t);
    }
}
