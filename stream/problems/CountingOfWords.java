import java.util.Scanner;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Arrays;

class CountingOfWords
{
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the string :");
        String str = scn.nextLine();
        System.out.println(str);

        String[] strarr = str.split(" ");

        Map<String,Long> result = Arrays.stream(strarr)
                .collect(Collectors.groupingBy(word -> word,Collectors.counting()));

        result.forEach((word,count)->System.out.println(word + ": " + count));
                    
    }
}