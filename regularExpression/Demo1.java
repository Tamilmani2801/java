import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Demo1
{
    public static void main(String[] args)
    {
        //step 1: create the pattern object
        //step 2: create the matcher object
        
        //compile() , matcher() method are present in Pattern class
        //find(),start(),end(),group() methods are present in Matcher class

        Pattern p = Pattern.compile("ab");
        Matcher m = p.matcher("abababbaab");

        while(m.find())
        {
            System.out.println(m.start() + " " + m.end() + " " + m.group());
        }
    }
}