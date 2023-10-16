import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Scanner;

class ServerSoc 
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket ss = new ServerSocket(9999);
        Socket s = ss.accept();

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the your name : ");
        String name = scn.next();

        while(true)
        {
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String sendername = input.readLine();
            System.out.print(sendername + ":");
            String str = input.readLine();
            System.out.println(str);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(name + ":");
            String enterString = userInput.readLine();

            if(enterString.equalsIgnoreCase("exit"))
            {
                break;
            }

            PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            out.println(name);
            out.println(enterString);
        }
    }
}