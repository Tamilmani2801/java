import java.time.LocalDate;
import java.time.Month;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.Instant;
import java.time.LocalDateTime;

class UsingDateTime
{
    public static void main(String[] args)
    {
        //printing current date 
        LocalDate d = LocalDate.now();
        System.out.println(d);

        //printing the given date

        LocalDate d1 = LocalDate.of(2001,8,2);
        System.out.println(d1);

        //Month.August ----represents enum
        LocalDate d2 = LocalDate.of(2001,Month.AUGUST,2);
        System.out.println(d2);

        //printing local time
        

        LocalTime t = LocalTime.now();
        System.out.println(t);

        //The above will print our time zone if we need to need specific zone we need to know the zone
        //To find the zone we use "ZoneID"

        for(String s : ZoneId.getAvailableZoneIds())
        {
            System.out.println(s);
        }

        //The above code will give all the zone id based on that print the time

        LocalTime t1 = LocalTime.now(ZoneId.of("Asia/Kuwait"));
        System.out.println(t1);

        //both date and time

        //human readable
        
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);

        //Machine redable
        Instant i = Instant.now();
        System.out.println(i);
    }
}