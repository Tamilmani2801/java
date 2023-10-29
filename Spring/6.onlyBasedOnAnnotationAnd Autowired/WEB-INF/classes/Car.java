package classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle
{
    @Autowired
    //creating object of tyre
    private Tyre tyre;


    public void drive()
    {
        System.out.println("we will drive car.." + tyre);
    }


    public Tyre getTyre() 
    {
        return tyre;
    }


    public void setTyre(Tyre tyre) 
    {
        this.tyre = tyre;
    }   
}
