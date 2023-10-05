import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class AddNotes
{
    private static final String FILENAME = "filename.txt";

    public static void addNote() throws IOException
    {
        FileWriter mywrite = new FileWriter(FILENAME,true);

        //here without true will leads delete the exisitng data so we are trying to append the data.

        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the note to add : ");
        String note = scn.nextLine();
        mywrite.write(note+"\n");
        mywrite.close();
    }
}