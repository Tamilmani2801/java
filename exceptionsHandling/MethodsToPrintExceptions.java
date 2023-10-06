import java.io.*;

class MethodsToPrintExceptions
{
    public static void main(String[] args)
    {
        int a = 10;
        int b = 0;

        //by using own statement
        try
        {
            System.out.println(a/b);
        }
        catch(ArithmeticException e)
        {
            System.out.println("AE handled");
        } 

        //by using printStackTrace() method
        //This method prints exception information in the format of the Name of the exception: description of the exception, stack trace.

        try
        {
            System.out.println(a/b);
        }
        catch(ArithmeticException e)
        {
            e.printStackTrace();
        }

        //by using toString() method
        //The toString() method prints exception information in the format of the Name of the exception: description of the exception.

        try
        {
            System.out.println(a/b);
        }
        catch(ArithmeticException e)
        {
            System.out.println(e.toString());
        }

        //by using getMessage() method

        try
        {
            System.out.println(a/b);
        }
        catch(ArithmeticException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
