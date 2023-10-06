class UsingThrowThrows
{
    public static void main(String[] args) 
    {
        int i = 10;
        int j = 0;

        if(j == 0)
        {
            try
            {
                throw new MyException("not tamilmani");
            }
            catch(MyException e)
            {
                System.out.println(e);
            }
        }
    }
}

class MyException extends Exception
{
    public MyException(String m)
    {
        super(m);
    }
}

