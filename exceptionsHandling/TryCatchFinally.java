class TryCatchFinally
{
    public static void main(String[] args)
    {
        int a = 10;
        int b = 0;

        try
        {
            System.out.println(a/b);
        }
        catch(ArithmeticException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("unknown exception");
        }
        finally
        {
            System.out.println("bye");
        }
    }
}