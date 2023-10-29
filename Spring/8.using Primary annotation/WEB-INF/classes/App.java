package classes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main(String[] args) 
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Samsung s7 = context.getBean(Samsung.class);
        s7.print();
    }   
}
