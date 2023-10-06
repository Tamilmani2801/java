// // class A implements Runnable 
// // {
// //     public void run()
// //     {
// //         for(int i=0;i<10;i++)
// //         {
// //             System.out.println("HI");
// //             try
// //             {
// //                 Thread.sleep(10);
// //             }
// //             catch(Exception e)
// //             {

// //             }
// //         }
// //     }
// // }

// // class B implements Runnable
// // {
// //     public void run()
// //     {
// //         for(int i=0;i<100;i++)
// //         {
// //             System.out.println("HELLO");
// //             try
// //             {
// //                 Thread.sleep(10);
// //             }
// //             catch(Exception e)
// //             {

// //             }
// //         }
// //     }
// // }

// // class UsingRunnable
// // {
// //     public static void main(String[] args)
// //     {
// //         A a1 = new A();
// //         A b1 = new B();

// //         Thread t1 = new Thread(a1);
// //         Thread t2 = new Thread(b1);

// //         t1.start();
// //         t2.start();
// //     }
// // }


// //Hence runnable is funcitonal interface we can use lambda expression 

// class UsingRunnable
// {
//     public static void main(String[] args)
//     {
//         Thread t1 = new Thread(()->
//         {
//             for(int i=0;i<10;i++)
//             {
//                 System.out.println("HI");
//                 try
//                 {
//                     Thread.sleep(10);
//                 }
//                 catch(Exception e)
//                 {
//                 }
//                 }
//         });
//         Thread t2 = new Thread(()->
//         {
//             for(int i=0;i<100;i++)
//             {
//                 System.out.println("HELLO");
//                 try
//                 {
//                     Thread.sleep(10);
//                 }
//                 catch(Exception e)
//                 {
//                 }
//             }
//         });
//         t1.start();
//         t2.start();
//     }
// }

//using join() method

// class A implements Runnable 
// {
//     public void run()
//     {
//         for(int i=0;i<10;i++)
//         {
//             System.out.println("HI");
//             try
//             {
//                 Thread.sleep(10);
//             }
//             catch(Exception e)
//             {

//             }
//         }
//     }
// }

// class B implements Runnable
// {
//     public void run()
//     {
//         for(int i=0;i<100;i++)
//         {
//             System.out.println("HELLO");
//             try
//             {
//                 Thread.sleep(10);
//             }
//             catch(Exception e)
//             {

//             }
//         }
//     }
// }

// class UsingRunnable
// {
//     public static void main(String[] args)
//     {
//         A a1 = new A();
//         A b1 = new B();

//         Thread t1 = new Thread(a1);
//         Thread t2 = new Thread(b1);

//         t1.start();
//         t2.start();
//     }
// }


//Hence runnable is funcitonal interface we can use lambda expression 

class UsingRunnable 
{
    public static void main(String[] args) throws Exception
    {
        Thread t1 = new Thread(()->
        {
            for(int i=0;i<10;i++)
            {
                System.out.println("HI");
                try
                {
                    Thread.sleep(10);
                }
                catch(Exception e)
                {
                }
                }
        });
        Thread t2 = new Thread(()->
        {
            for(int i=0;i<10;i++)
            {
                System.out.println("HELLO" + " " + Thread.currentThread().getPriority());
                try
                {
                    Thread.sleep(10);
                }
                catch(Exception e)
                {
                }
            }
        });

    
        t1.start();
        t2.start();

        t1.join();
        t1.join();

        //isAlive() method will check whether the thread is active or not

        System.out.println(t1.isAlive());

        //setname of the thread

        t1.setName("Tamil thread");
        t2.setName("Mani thread");

        //printing thread name

        System.out.println(t1.getName());
        System.out.println(t2.getName());

        //setting priority to the thread
        t1.setPriority(1);
        t2.setPriority(10);

        t1.setPriority(Thread.MIN_PRIORITY); // represent 1
        t2.setPriority(Thread.MAX_PRIORITY); // represent 2

        //priority of the thread

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        
        System.out.println("bye");
    }
}

