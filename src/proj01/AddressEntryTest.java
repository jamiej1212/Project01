package proj01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**************************************************************
 * AddressEntryTest
 * Test individual methods in AddressEntry class
 *************************************************************/

class AddressEntryTest
{

    AddressEntry ae = new AddressEntry();

    /**
     * Testing for constructor
     */
    @Test
    public void testAddressEntry()
    {
        AddressEntry test = new AddressEntry("Jane", "Doe", "123 ABC St",
                "San Jose", "CA", 95117, "111-111-1111", "janed@gmail.com");
        String comp = "First Name: Jane\n" + "Last Name: Doe\n" + "Street: 123 ABC st\n" + "City: San Jose\n" +
                "State: CA\n" + "Zip: 95117\n" + "Email: janed@gmail.com\n" + "Phone Number: 111-111-1111";
        assertEquals(comp, test.toString());
    }

    /**
     * Testing positive case for setFirstName() and getFirstName()
     */
    @Test
    public void testFirstName()
    {
        String firstName = "Jane";
        ae.setFirstName("Jane");
        assertEquals(firstName, ae.getFirstName());
    }

    /**
     * Testing negative case for setFirstName() and getFirstName()
     */
    @Test
    public void testFirstName_Fail()
    {
        String firstName2 = "Jane";
        ae.setFirstName("John");
        assertNotEquals(firstName2, ae.getFirstName());
    }

    /**
     * Testing positive case for setLastName() and getLastName()
     */
    @Test
    public void testLastName()
    {
        String lastName = "Doe";
        ae.setLastName("Doe");
        assertEquals(lastName, ae.getLastName());
    }

    /**
     * Testing negative case for setLastName() and getLastName()
     */
    @Test
    public void testLastName_Fail()
    {
        String lastName2 = "Doe";
        ae.setLastName("Do");
        assertNotEquals(lastName2, ae.getLastName());
    }

    /**
     * Testing positive case for setStreet() and getStreet()
     */
    @Test
    public void testStreet()
    {
        String street = "123 ABC st";
        ae.setStreet("123 ABC st");
        assertEquals(street, ae.getStreet());
    }

    /**
     * Testing negative case for setStreet() and getStreet()
     */
    @Test
    public void testStreet_Fail()
    {
        String street2 = "456 DEF av";
        ae.setStreet("456 DEF st");
        assertNotEquals(street2, ae.getStreet());
    }

    /**
     * Testing positive case for setCity() and getCity()
     */
    @Test
    public void testCity()
    {
        String city = "San Jose";
        ae.setCity("San Jose");
        assertEquals(city, ae.getCity());
    }

    /**
     * Testing negative case for setCity() and getCity()
     */
    @Test
    public void testCity_Fail()
    {
        String city2 = "Santa Cruz";
        ae.setCity("LA");
        assertNotEquals(city2, ae.getCity());
    }

    /**
     * Testing positive case for setState() and getState()
     */
    @Test
    public void testState()
    {
        String state = "CA";
        ae.setState("CA");
        assertEquals(state, ae.getState());
    }

    /**
     * Testing negative case for setState() and getState()
     */
    @Test
    public void testState_Fail()
    {
        String state2 = "CA";
        ae.setState("WA");
        assertNotEquals(state2, ae.getState());
    }

    /**
     * Testing positive case for setZip() and getZip()
     */
    @Test
    public void testZip()
    {
        int zip = 95123;
        ae.setZip(95123);
        assertEquals(zip, ae.getZip());
    }

    /**
     * Testing negative case for setZip() and getZip()
     */
    @Test
    public void testZip_Fail()
    {
        int zip2 = 95123;
        ae.setZip(98003);
        assertNotEquals(zip2, ae.getZip());
    }

    /**
     * Testing positive case for setPhone() and getPhone()
     */
    @Test
    public void testPhone()
    {
        String phone = "111-111-1111";
        ae.setPhone("111-111-1111");
        assertEquals(phone, ae.getPhone());
    }

    /**
     * Testing negative case for setPhone() and getPhone()
     */
    @Test
    public void testPhone_Fail()
    {
        String phone2 = "111-111-1111";
        ae.setPhone("222-222-2222");
        assertNotEquals(phone2, ae.getPhone());
    }

    /**
     * Testing positive case for setEmail() and getEmail()
     */
    @Test
    public void testEmail()
    {
        String email = "janed@gmail.com";
        ae.setEmail("janed@gmail.com");
        assertEquals(email, ae.getEmail());
    }

    /**
     * Testing negative case for setEmail() and getEmail()
     */
    @Test
    public void testEmail_Fail()
    {
        String email2 = "janed@gmail.com";
        ae.setEmail("johnd@gmail.com");
        assertNotEquals(email2, ae.getEmail());
    }
}