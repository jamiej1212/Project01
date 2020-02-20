package projt01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/** Menu class currently only has static methods to prompt to standard output information about a Contact like name,etc
 **/

class Menu
{
    static Scanner scan = new Scanner(System.in).useDelimiter("\n");

    /**
     * prompt_FirstName  generates a standard output prompt for the First Name to be entered
     */

    public static String prompt_FirstName() {
        System.out.println("First Name:");
        String firstName = scan.next();
        return firstName;
    }

    public static String prompt_LastName() {
        System.out.println("Last Name:");
        String lastName = scan.next();
        return lastName;
    }

    public static String prompt_Street() {
        System.out.println("Street:");
        String street = scan.next();
        return street;
    }

    public static String prompt_City() {
        System.out.println("City:");
        String city = scan.next();
        return city;

    }

    public static String prompt_State() {
        System.out.println("State:");
        String state = scan.next();
        return state;

    }

    public static int prompt_Zip() {
        System.out.println("Zip:");
        int zip = Integer.parseInt(scan.next());
        return zip;
    }

    public static String prompt_Telephone() {
        System.out.println("Telephone(xxx-xxx-xxxx):");
        String phone = scan.next();
        return phone;
    }

    public static String prompt_Email() {
        System.out.println("Email:");
        String email = scan.next();
        return email;
    }


    /**
     * Displays menu for user selection and directs to particular methods by the selection
     * @throws IOException
     */

    public static void menu() throws IOException, FileNotFoundException {
        Character minInput = 'a';
        Character maxInput = 'f';
        AddressEntry entry = new AddressEntry();


        while(true) {
            System.out.println("***********************************");
            System.out.println("               Menu                ");
            System.out.println("a. Getting address from file");
            System.out.println("b. Add address");
            System.out.println("c. Remove address");
            System.out.println("d. Find address");
            System.out.println("e. Listing address\n");
            System.out.println("f. Quit");
            System.out.println("***********************************");

            Character info = scan.next().toLowerCase().charAt(0);

            switch (info)
            {
                case 'a':
                    System.out.println("Enter directory of your file: ");
                    System.out.println("FYI, no quotation mark or extension needed");
                    String fileName = scan.next() + ".txt";

                    File file = new File(fileName);
                    AddressBook.readFromFile(file);
                    break;
                case 'b':
                    AddressBook.add(entry);
                    break;
                case 'c':
                    System.out.println("Enter last name you want to remove");
                    System.out.println("You don't have to enter whole last name");
                    String removeName = scan.next();
                    AddressBook.remove(removeName + ".*");
                    break;
                case 'd':
                    System.out.println("Enter last name you want to find");
                    System.out.println("You don't have to enter whole last name");
                    String lastName = scan.next();
                    AddressBook.find(lastName + ".*");
                    break;
                case 'e':
                    AddressBook.list();
                    break;
                case 'f':
                    System.out.println("Exiting");
                    System.exit(0);
                default:
                    System.out.println("Please select between a through f");
                    break;
            }

        }

    }
}