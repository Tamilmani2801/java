package classes;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle
{
    public void drive()
    {
        System.out.println("we will drive car..");
    }   
}
