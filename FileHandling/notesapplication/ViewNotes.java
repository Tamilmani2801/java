import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class ViewNotes
{
    private static final String FILENAME = "filename.txt";
    public static void viewNote() throws IOException
    {
        File f1 = new File(FILENAME);
        Scanner reader = new Scanner(f1);

        System.out.println("\n");
        while(reader.hasNextLine())
        {
            String data = reader.nextLine();
            
            System.out.println(data);
        }
        System.out.println("\n");
        
        reader.close();
    }
}