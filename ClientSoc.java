import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.Scanner;

class ClientSoc 
{
    public static void main(String[] args) throws Exception
    {
        Socket s = new Socket("localhost",9999);

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the your name : ");
        String name = scn.next();

        while(true)
        {
            BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(name + ":");
            String str = userinput.readLine();

            if(str.equalsIgnoreCase("exit"))
            {
                break;
            }

            PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            out.println(name);
            out.println(str);

            BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String sendername = bf.readLine();
            String result = bf.readLine();

            System.out.print(sendername + ":");
            System.out.println(result);
        }
        
    }
}