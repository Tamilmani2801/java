package classes;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
public class App 
{
    public static void main(String[] args)
    {
        //Vehicle obj = new Car();
        //getBean() is found in both BeanFactory (or) ApplicationContext
        //use ApplicationContext because it includes BeanFactory also

        ApplicationContext context = new ClassPathXmlApplicationContext("web.xml");
        Vehicle obj = (Vehicle) context.getBean("vehicle");
        obj.drive();
    }
}
