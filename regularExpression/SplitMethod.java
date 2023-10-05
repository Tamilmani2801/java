import java.util.regex.Pattern;

class SplitMethod
{
    public static void main(String[] args)
    {
        Pattern p = Pattern.compile("i");

        String[] s = p.split("tamilmani is in zoho");

        for(String s1:s)
        {
            System.out.println(s1);
        }


//important case
//separate based on "." then we cannot get any output so use "\\." or use "[.]"


       // Pattern p1 = Pattern.compile("\\.");
        Pattern p1 = Pattern.compile("[.]");

        String[] s1 = p1.split("www.google.com");

        for(String s2:s1)
        {
            System.out.println(s2);
        }
    }
}