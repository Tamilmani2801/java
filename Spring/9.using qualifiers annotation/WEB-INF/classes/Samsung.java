package classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Samsung 
{
    @Autowired
    @Qualifier("mediaTech")

    MobileProcessor cpu;

    public void print()
    {
        System.out.println("Welcome to samsung and have these features");
        cpu.processor();
    }


    public MobileProcessor getCpu() 
    {
        return cpu;
    }


    public void setCpu(MobileProcessor cpu) 
    {
        this.cpu = cpu;
    }   
}
