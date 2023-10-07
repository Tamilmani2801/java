import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class People
{
    private String name;
    private int age;

    public People(String name,int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }
}

class GroupingByAge
{
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        List<People> list = new ArrayList<>();
        
        while(true)
        {
            System.out.println("Enter the name (or) exit to break: ");
            String name = scn.nextLine();
            if(name.equalsIgnoreCase("exit"))
            {
                break;
            }
            System.out.println("Enter the age : ");
            int age = Integer.parseInt(scn.next());
            scn.nextLine();

            list.add(new People(name,age));
        }

         Map<Integer,List<String>> result = list.stream()
                                .collect(Collectors.groupingBy(People::getAge,Collectors.mapping(People::getName,Collectors.toList())));

        result.forEach((age,name) -> System.out.println(age + " : " +name));
        
    }
}