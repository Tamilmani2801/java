// class A 
// {
//     public void show()
//     {
//         for(int i=0;i<100;i++)
//         {
//             System.out.println("HI");
//         }
//     }
// }

// class B 
// {
//     public void show()
//     {
//         for(int i=0;i<100;i++)
//         {
//             System.out.println("HELLO");
//         }
//     }
// }

// class UsingThreads
// {
//     public static void main(String[] args)
//     {
//         A a1 = new A();
//         B b1 = new B();
//         a1.show();
//         b1.show();
//     }
// }


// using threads

class A extends Thread 
{
    public void run()
    {
        for(int i=0;i<100;i++)
        {
            System.out.println("HI");
            try
            {
                Thread.sleep(2000);
            }
            catch(Exception e)
            {

            }
        }
    }
}

class B extends Thread 
{
    public void run()
    {
        for(int i=0;i<100;i++)
        {
            System.out.println("HELLO");
            try
            {
                Thread.sleep(2000);
            }
            catch(Exception e)
            {

            }
        }
    }
}

class UsingThreads
{
    public static void main(String[] args)
    {
        A a1 = new A();
        B b1 = new B();
        a1.start();
        b1.start();
    }
}