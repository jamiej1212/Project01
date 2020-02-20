package projt01;

import java.io.File;
import java.util.*;
import java.io.*;


/**
 * Holds objects getting from AddressEntry class.
 */
public class AddressBook
{
    static ArrayList<AddressEntry> table = new ArrayList<>();
    static AddressEntry user;
    static Scanner scan = new Scanner(System.in);





    /**
     * Add information to the collection
     *
     * @param entry information that we are going to add in the collection
     */
    public static void add(AddressEntry entry)
    {
        entry.setFirstName(Menu.prompt_FirstName());
        entry.setLastName(Menu.prompt_LastName());
        entry.setStreet(Menu.prompt_Street());
        entry.setCity(Menu.prompt_City());
        entry.setState(Menu.prompt_State());
        entry.setZip(Menu.prompt_Zip());
        entry.setPhone(Menu.prompt_Telephone());
        entry.setEmail(Menu.prompt_Email());


        user = new AddressEntry(entry.getFirstName(), entry.getLastName(), entry.getStreet(),
                entry.getCity(), entry.getState(), entry.getZip(), entry.getPhone(), entry.getEmail());

        table.add(user);
        System.out.println(user.toString());
        System.out.println("\nAdded Successfully!");

    }

    /**
     Hashtable<String, AddressEntry> hash = new Hashtable<>();
     AddressEntry value;
     String lastName;

     for(Map.Entry<Integer, AddressEntry> element : table.entrySet())
     {
     value = element.getValue();
     lastName = value.getLastName();

     hash.put(lastName, value);
     }
     Vector v = new Vector(hash.keySet());
     Collections.sort(v);

     for(Enumeration e = v.elements(); e.hasMoreElements())
     {
     String key = (String)e.nextElement();
     AddressEntry ad = hash.get(key);

     }
     */




    /**
     * Iterates through the collection and prints out info
     */
    public static void list()
    {
        Collections.sort(table, new Comparator<AddressEntry>()
        {
            @Override
            public int compare(AddressEntry first, AddressEntry second)
            {
                if(first.getLastName().equals(second.getLastName()))
                    return first.getFirstName().compareTo(second.getFirstName());
                else
                    return first.getLastName().compareTo(second.getLastName());
            }
        });


        for(AddressEntry element : table)
        {
            System.out.println(element.toString());
        }

        //for (Map.Entry<Integer, AddressEntry> element : table.entrySet())
        //{
        //System.out.println(element.getValue().toString());
        //}
    }

    public static void readFromFile(File file) throws IOException
    {
        Scanner scanFile = new Scanner(new FileReader(file));
        ArrayList<AddressEntry> read = new ArrayList<>();
        while(scanFile.hasNextLine())
        {
            String firstName = scanFile.nextLine();
            String lastName = scanFile.nextLine();
            String street = scanFile.nextLine();
            String city = scanFile.nextLine();
            String state = scanFile.nextLine();
            int zip = Integer.parseInt(scanFile.nextLine());
            String phone = scanFile.nextLine();
            String email = scanFile.nextLine();

            user = new AddressEntry(firstName, lastName, street, city, state, zip, phone, email);
            table.add(user);
            read.add(user);
        }

        for(AddressEntry print : read)
        {
            System.out.println(print.toString());
        }

        System.out.println("Read File Successfully!");
    }

    public static void remove(String startOf_lastName)
    {
        ArrayList<AddressEntry> match = new ArrayList<>();
        for(int i = 0; i < table.size(); i++)
        {
            if(table.get(i).getLastName().toLowerCase().matches(startOf_lastName.toLowerCase()))
            {
                match.add(table.get(i));
            }
        }
        for(int i = 0; i < match.size(); i++)
        {
            System.out.println(i + "\n" + match.get(i).toString());
        }
        System.out.println("Please select a number");
        int select = Integer.parseInt(scan.next());



        for(int i = 0; i < match.size(); i++)
        {
            if(select == i)
            {
                for(AddressEntry element : table)
                {
                    if(match.get(select).getPhone().equals(element.getPhone()))
                    {
                        System.out.println("Are you sure? (Y/N)");
                        String answer = scan.next();
                        if(answer.toLowerCase().equals("y"))
                        {
                            table.remove(element);
                            break;
                        }

                        else
                            System.out.println("Canceled");
                    }
                }
            }
        }
        System.out.println("Removed Successfully!");



    }


    public static void find(String startOf_lastName)
    {
        ArrayList<AddressEntry> match = new ArrayList<>();
        for(int i = 0; i < table.size(); i++)
        {
            if(table.get(i).getLastName().toLowerCase().matches(startOf_lastName.toLowerCase()))
            {
                match.add(table.get(i));
            }
        }
        System.out.println(match.size() + " contact(s) found");

        for(int i = 0; i < match.size(); i++)
        {
            System.out.println(i + "\n" + match.get(i).toString());
        }

    }


}