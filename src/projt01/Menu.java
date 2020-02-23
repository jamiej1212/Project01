package proj01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**************************************************************
 * Menu
 * Prompts a menu selection and which gets user input
 *************************************************************/
class Menu
{
    static Scanner scan = new Scanner(System.in).useDelimiter("\n");

    /**
     * Prompts user input of first name and stores the input
     * @return first name
     */
    public static String prompt_FirstName() {
        System.out.println("First Name:");
        String firstName = scan.next();
        return firstName;
    }

    /**
     * Prompts user input of last name and stores the input
     * @return last name
     */
    public static String prompt_LastName() {
        System.out.println("Last Name:");
        String lastName = scan.next();
        return lastName;
    }

    /**
     * Prompts user input of street and stores the input
     * @return street
     */
    public static String prompt_Street() {
        System.out.println("Street:");
        String street = scan.next();
        return street;
    }

    /**
     * Prompts user input of city and stores the input
     * @return city
     */
    public static String prompt_City() {
        System.out.println("City:");
        String city = scan.next();
        return city;
    }

    /**
     * Prompts user input of state and stores the input
     * @return state
     */
    public static String prompt_State() {
        System.out.println("State:");
        String state = scan.next();
        return state;

    }

    /**
     * Prompts user input of zip and stores the input
     * @return zip
     */
    public static int prompt_Zip() {
        System.out.println("Zip:");
        int zip = Integer.parseInt(scan.next());
        return zip;
    }

    /**
     * Prompts user input of phone number and stores the input
     * @return phone number
     */
    public static String prompt_Telephone() {
        System.out.println("Telephone(xxx-xxx-xxxx):");
        String phone = scan.next();
        return phone;
    }

    /**
     * Prompts user input of email and stores the input
     * @return email
     */
    public static String prompt_Email() {
        System.out.println("Email:");
        String email = scan.next();
        return email;
    }


    /**
     * Displays menu for user selection and directs to particular methods by the selection
     * @throws IOException
     */

    public static void menu(AddressBook ab) throws IOException, FileNotFoundException {
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
                    ab.readFromFile(file);
                    break;
                case 'b':
                    ab.add(entry);
                    break;
                case 'c':
                    System.out.println("Enter last name you want to remove");
                    System.out.println("You don't have to enter whole last name");
                    String removeName = scan.next();
                    ab.remove(removeName + ".*");
                    break;
                case 'd':
                    System.out.println("Enter last name you want to find");
                    System.out.println("You don't have to enter whole last name");
                    String lastName = scan.next();
                    ab.find(lastName + ".*");
                    break;
                case 'e':
                    ab.list();
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
