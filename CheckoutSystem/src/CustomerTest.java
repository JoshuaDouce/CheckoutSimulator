import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CustomerTest
{
    private Customer customer1;
    
    /**
     * Default constructor for test class CustomerTest
     */
    public CustomerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        customer1 = new Customer("000001", "Jeffrey", "Jeffrey@fake.com");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testGetCustomerName()
    {
        assertEquals("Jeffrey", customer1.getCustomerName());
    }
    
    @Test
    public void testSetCustomerName()
    {
        customer1.setCustomerName("Jeff");
        assertEquals("Jeff", customer1.getCustomerName());
    }
    
    @Test
    public void testGetCustomerEmail() {
        assertEquals("Jeffrey@fake.com", customer1.getCustomerEmail());
    }

    @Test
    public void testSetCustomerEmail() {
        customer1.setCustomerEmail("Jeff@fake.com");
        assertEquals("Jeff@fake.com", customer1.getCustomerEmail());
    }

    @Test
    public void testGetLoyaltyPoints()
    {
        assertEquals(0.0, customer1.getLoyaltyPoints(), 0.1);
    }

    @Test
    public void testSetLoyaltyPoints()
    {
        customer1.setLoyaltyPoints(100);
        assertEquals(100, customer1.getLoyaltyPoints(), 0.1);
    }

    @Test
    public void testToString()
    {
        assertEquals("No: 000001 Name: Jeffrey Email: Jeffrey@fake.com Points 0.0", customer1.toString());
    }

    @Test
    public void testGetCustomerNumber()
    {
        assertEquals("000001", customer1.getCustomeNumber());
        customer1.setCustomeNumber("000002");
        assertEquals("000002", customer1.getCustomeNumber());
    }
    
    public void testSetCustomerNumber(){
        assertEquals("000001", customer1.getCustomeNumber());
        customer1.setCustomeNumber("000002");
        assertEquals("000002", customer1.getCustomeNumber());
    }
}