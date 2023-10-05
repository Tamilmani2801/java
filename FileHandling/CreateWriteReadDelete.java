import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class CreateWriteReadDelete
{
    public static void main(String[] args)
    {
        try
        {
            //creating a file

            File f1 = new File("filename.txt");

            //write in the file
            FileWriter mywrite = new FileWriter(f1);

            mywrite.write("tamilmani");
            mywrite.close();

            //read in the file
            Scanner reader = new Scanner(f1);
            while(reader.hasNextLine())
            {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();

            //delete a file
            f1.delete();

            //about our file
            System.out.println(f1.getAbsolutePath());
            System.out.println(f1.getName());
            System.out.println(f1.length());
            System.out.println(f1.canRead());
            System.out.println(f1.canWrite());
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}