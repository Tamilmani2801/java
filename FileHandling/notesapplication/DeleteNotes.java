import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class DeleteNotes
{
    private static final String FILENAME = "filename.txt";
    public static void deleteNote() throws IOException 
    {
        System.out.println("\n");
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
        System.out.println("\nEnter the index of the note to delete:");
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