class Increament
{
    int count;

    public synchronized void increament()
    {
        count++;
    }
}

class UsingSynchronized
{
    public static void main(String[] args) throws Exception
    {
        Increament a = new Increament();

        Thread t1 = new Thread(new Runnable()
        {
            public void run()
            {
                for(int i=0;i<1000;i++)
                {
                    a.increament();
                    try{
                        Thread.sleep(10);
                    }
                    catch(Exception e)
                    {

                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable()
        {
            public void run()
            {
                for(int i=0;i<1000;i++)
                {
                    a.increament();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(a.count);
    }
}