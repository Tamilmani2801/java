@FunctionalInterface
interface a
{
    void show();
}

class UsingFuctionalInterface
{
    public static void main(String[] args)
    {
        a a1 = new a()
        {
            public void show()
            {
                System.out.println("show in");
            }
        };
        a1.show();
    }
}



//using general implements 

// interface a
// {
//     void show();
// }

// class b implements a
// {
//     public void show()
//     {
//         System.out.println("in show");
//     }
// }

// class UsingFuctionalInterface
// {
//     public static void main(String[] args)
//     {
//         a a1 = new b();
//         a1.show();
//     }
// }