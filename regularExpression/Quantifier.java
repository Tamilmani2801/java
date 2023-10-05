import java.util.regex.Pattern;
import java.util.regex.Matcher;


class Quantifier
{
    public static void main(String[] args)
    {
        //finding each time 'a' occur
        Pattern p = Pattern.compile("a");
        Matcher m = p.matcher("abaabaaabb");

        System.out.println("Printing each time 'a' occur");
        while(m.find())
        {
            System.out.println(m.start() + " " + m.end() + " " + m.group());
        }

        //consider if a occur as group
        Pattern p1 = Pattern.compile("a+");
        Matcher m1 = p1.matcher("abaabaaabb");

        System.out.println("\nPrinting group 'a' occur");
        while(m1.find())
        {
            System.out.println(m1.start() + " " + m1.end() + " " + m1.group());
        }


        // Pattern p1 = Pattern.compile("a*");
        // Matcher m1 = p1.matcher("abaabaaabb");

        // System.out.println("\nPrinting group 'a' occur");
        // while(m1.find())
        // {
        //     System.out.println(m1.start() + " " + m1.end() + " " + m1.group());
        // }
        

    }
}