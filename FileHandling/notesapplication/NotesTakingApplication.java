import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class NotesTakingApplication
{
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
                    AddNotes.addNote();
                    break;
                case 2:
                    ViewNotes.viewNote();
                    break;
                case 3:
                    DeleteNotes.deleteNote();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}