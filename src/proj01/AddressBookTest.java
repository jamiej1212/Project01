package proj01;
import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {

    AddressBook ab = new AddressBook();
    AddressEntry ae = new AddressEntry("Jane", "Doe", "123 ABC st",
            "San Jose", "CA", 95117, "111-111-1111", "janed@gmail.com");

    String comp = "First Name: Jane\n" + "Last Name: Doe\n" + "Street: 123 ABC st\n" + "City: San Jose\n" +
            "State: CA\n" + "Zip: 95117\n" + "Email: janed@gmail.com\n" + "Phone Number: 111-111-1111";


    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testInputStream;
    private ByteArrayOutputStream testOutputStream;

    Menu obj = new Menu();

    /**
     * Initializes output
     */
    @Before
    public void outputSetup()
    {
        testOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutputStream));
    }

    /**
     * Getting input from user
     * @param data user input
     */
    private void inputSetup(String data)
    {
        testInputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(testInputStream);
    }

    /**
     * Restoring system with previous input and output
     */
    @After
    public void restoreSystem()
    {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }


    /**
     * Testing for constructor
     */
    @Test
    public void testAddressBook()
    {
        assertEquals(comp, ae.toString());
    }

    @Test
    public void testAddAddress()
    {
        ab.add(ae);
        final String first = "Jane";
        inputSetup(first);
        final String last = "Doe";
        inputSetup(last);
        final String street = "123 ABC st";
        inputSetup(street);
        final String city = "San Jose";
        inputSetup(city);
        final String state = "CA";
        inputSetup(state);
        final String zip = "95117";
        inputSetup(zip);
        final String phone = "111-111-1111";
        inputSetup(phone);
        final String email = "janed@gmail.com";
        inputSetup(email);

        AddressEntry aaa = new AddressEntry(first, last, street, city, state, Integer.parseInt(zip), phone, email);
        ab.table.add(aaa);

        String str = ab.table.toString();


        assertEquals(str, "["+comp+"\n]");
    }

    @Test
    public void testList()
    {
        final String first = "Jane";
        inputSetup(first);
        final String last = "Doe";
        inputSetup(last);
        final String street = "123 ABC st";
        inputSetup(street);
        final String city = "San Jose";
        inputSetup(city);
        final String state = "CA";
        inputSetup(state);
        final String zip = "95117";
        inputSetup(zip);
        final String phone = "111-111-1111";
        inputSetup(phone);
        final String email = "janed@gmail.com";
        inputSetup(email);

        ab.table.add(ae);
    }

}