import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class Details
{
    private String name;
    private double amt;

    public Details(String name, double amt)
    {
        this.name = name;
        this.amt = amt;
    }

    public String getName()
    {
        return name;
    }

    public double getAmt()
    {
        return amt;
    }
}


class AmtSpendByEachCustomer
{
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);

        List<Details> list = new ArrayList<>();

        while(true)
        {
            System.out.println("Enter the name (or) exit to break:");
            String name = scn.nextLine();

            if(name.equalsIgnoreCase("exit"))
            {
                break;
            }

            System.out.println("Enter the amount :");
            double amt = scn.nextDouble();
            scn.nextLine();

            list.add(new Details(name,amt));
        }

        // METHOD 1: CONVERTING LIST TO MAP:

        // Map<String,Double> map = new HashMap<>();

        // for(int i=0;i<list.size();i++)
        // {
        //     Details detail = list.get(i);
        //     String name = detail.getName();
        //     double amt = detail.getAmt();

        //     Double j = map.get(name);

        //     map.put(name,(j==null)?amt:amt+j);
        // }


       // System.out.println(map);

        //  METHOD II: USING STREAMS

        Map<String,Double> resultmap = list.stream()
                    .collect(Collectors.groupingBy(Details::getName,Collectors.averagingDouble(Details::getAmt)));

        resultmap.forEach((name,amt)->System.out.println(name + " " + amt));

       
    }
}