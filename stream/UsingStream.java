import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;

class UsingStream
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(3,4,5,6,7,8,9);

        int result = list.stream().filter(n->n%2==0).map(n->n*2).reduce(0,(c,e)->c+e);

        System.out.println(result);
        
    }
}