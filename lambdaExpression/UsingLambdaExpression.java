@FunctionalInterface
interface a
{
    int show(int i,int j);
}

class UsingLambdaExpression
{
    public static void main(String[] args)
    {
        a a1 = (i,j) -> i+j;
        System.out.println(a1.show(5,10));
    }
}

