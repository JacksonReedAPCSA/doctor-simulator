import java.util.Scanner;

public class EmailSorter{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int version = 0;
        Storage storage = new Storage();
        String letter = "";
        String date = "";
        System.out.println("Email Sorter version: 1." + version + "\nEnter your first email:");
        letter = scan.nextLine();
        System.out.println("Enter date, has to be mm/dd/yyyy format");
        date = scan.nextLine();
        storage.addLetter(letter);
    }
}