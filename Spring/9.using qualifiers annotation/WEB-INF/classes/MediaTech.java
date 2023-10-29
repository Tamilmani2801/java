package classes;

import org.springframework.stereotype.Component;

@Component
public class MediaTech implements MobileProcessor
{
    @Override
    public void processor() 
    {
        System.out.println("2nd best");
    }
}
