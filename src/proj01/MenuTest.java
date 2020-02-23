package proj01;
import static org.junit.Assert.*;

import java.io.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MenuTest
{

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
     * Testing positive case for prompt_FirstName()
     */
    @Test
    public void testPromptFirstName() {
        final String input = "Jane";
        inputSetup(input);
        String output = obj.prompt_FirstName();
        assertEquals(input, output);
    }

    /**
     * Testing negative case for prompt_FirstName()
     */
    @Test
    public void testPromptFirstName_Fail() {
        final String input = "Jane";
        inputSetup(input);
        String output = obj.prompt_FirstName();
        assertNotEquals(input, output+"no");
    }

    /**
     * Testing positive case for prompt_LastName()
     */
    @Test
    public void testPromptLastName() {
        final String input = "Doe";
        inputSetup(input);
        String output = obj.prompt_LastName();
        assertEquals(input, output);
    }

    /**
     * Testing negative case for prompt_LastName()
     */
    @Test
    public void testPromptLastName_Fail() {
        final String input = "Doe";
        inputSetup(input);
        String output = obj.prompt_LastName();
        assertNotEquals(input, output+"no");
    }

    /**
     * Testing positive case for prompt_Street()
     */
    @Test
    public void testPromptStreet() {
        final String input = "123 ABC St";
        inputSetup(input);
        String output = obj.prompt_Street();
        assertEquals(input, output);
    }

    /**
     * Testing negative case for prompt_Street()
     */
    @Test
    public void testPromptStreet_Fail() {
        final String input = "123 ABC St";
        inputSetup(input);
        String output = obj.prompt_Street();
        assertNotEquals(input, output+"no");
    }

    /**
     * Testing positive case for prompt_City()
     */
    @Test
    public void testPromptCity() {
        final String input = "San Jose";
        inputSetup(input);
        String output = obj.prompt_City();
        assertEquals(input, output);
    }

    /**
     * Testing negative case for prompt_City()
     */
    @Test
    public void testPromptCity_Fail() {
        final String input = "San Jose";
        inputSetup(input);
        String output = obj.prompt_City();
        assertNotEquals(input, output + 123);
    }

    /**
     * Testing positive case for prompt_State()
     */
    @Test
    public void testPromptState() {
        final String input = "CA";
        inputSetup(input);
        String output = obj.prompt_State();
        assertEquals(input, output);
    }

    /**
     * Testing negative case for prompt_State()
     */
    @Test
    public void testPromptState_Fail() {
        final String input = "CA";
        inputSetup(input);
        String output = obj.prompt_State();
        assertNotEquals(input, output+"no");
    }


    /**
     * Testing positive case for prompt_Zip()
     */
    @Test
    public void testPromptZip() {
        final String input = "12345";
        inputSetup(input);
        int output = obj.prompt_Zip();
        assertEquals(Integer.parseInt(input), output);
    }

    /**
     * Testing negative case for prompt_Zip()
     */
    @Test
    public void testPromptZip_Fail() {
        final String input = "12345";
        inputSetup(input);
        int output = obj.prompt_Zip();
        assertNotEquals(Integer.parseInt(input), output + 15);
    }

    /**
     * Testing positive case for prompt_Telephone()
     */
    @Test
    public void testPromptTelephone() {
        final String input = "123-456-7890";
        inputSetup(input);
        String output = obj.prompt_Telephone();
        assertEquals(input, output);
    }

    /**
     * Testing negative case for prompt_Telephone()
     */
    @Test
    public void testPromptTelephone_Fail() {
        final String input = "123-456-7890";
        inputSetup(input);
        String output = obj.prompt_Telephone();
        assertNotEquals(input, output + 7);
    }

    /**
     * Testing positive case for prompt_Email()
     */
    @Test
    public void testPromptEmail() {
        final String input = "janed@gmail.com";
        inputSetup(input);
        String output = obj.prompt_Email();
        assertEquals(input, output);
    }

    /**
     * Testing negative case for prompt_Email()
     */
    @Test
    public void testPromptEmail_Fail() {
        final String input = "janed@gmail.com";
        inputSetup(input);
        String output = obj.prompt_Email();
        assertNotEquals(input, output + "no");
    }

}