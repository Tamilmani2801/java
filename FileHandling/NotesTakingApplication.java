import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class NotesTakingApplication
{
    private static final String FILENAME = "filename.txt";

    public static void main(String[] args) throws IOException
    {
        Scanner scn = new Scanner(System.in);
        while(true)
        {
            System.out.println("1)add\n2)view\n3)Delete\n4)Exit");
            System.out.println("Enter the choice :");
            int choice = scn.nextInt();
            switch(choice)
            {
                case 1:
                    addNote();
                    break;
                case 2:
                    viewNote();
                    break;
                case 3:
                    deleteNote();
                    break;
                case 4:
                    System.exit(0);
                    break;

            }
        }
    }

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

    public static void viewNote() throws IOException
    {
        File f1 = new File(FILENAME);
        Scanner reader = new Scanner(f1);
            
        while(reader.hasNextLine())
        {
            String data = reader.nextLine();
            System.out.println(data);
        }
        reader.close();
    }

    public static void deleteNote() throws IOException 
    {
        File f1 = new File(FILENAME);
        Scanner scanner = new Scanner(f1);

    // Display the existing notes with their indexes
        int index = 1;
        while (scanner.hasNextLine()) 
        {
            String data = scanner.nextLine();
            System.out.println(index + ") " + data);
            index++;
        }
        scanner.close();

    // Ask the user for the index of the note to delete
        System.out.println("Enter the index of the note to delete:");
        Scanner scn = new Scanner(System.in);
        int noteIndex = scn.nextInt();
        scn.nextLine(); // Consume the newline character

    // Create a temporary file to store the notes
        File tempFile = new File("temp.txt");
        FileWriter writer = new FileWriter(tempFile);

        scanner = new Scanner(f1);

        index = 1;
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            if (index != noteIndex) 
            {
                writer.write(data + "\n");
            }
            index++;
        }

        writer.close();
        scanner.close();

    // Replace the original file with the temporary file
        if (f1.delete()) 
        {
            if (tempFile.renameTo(f1))
            {
                System.out.println("Note deleted successfully.");
            }
            else 
            {   
                System.out.println("Error replacing the original file.");
            }
        }
        else 
        {
            System.out.println("Error deleting the note.");
        }
    }
}