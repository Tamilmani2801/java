import java.util.regex.Pattern;
import java.util.regex.Matcher;

class PhoneNumberValidation
{
    public static void main(String[] args)
    {
        Pattern p = Pattern.compile("0?[789][0-9]{9}");
        Matcher m = p.matcher("9486523589");

        System.out.println(m.matches());
        
    }
}