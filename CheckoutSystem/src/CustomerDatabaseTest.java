import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CustomerDatabaseTest {
    private CustomerDatabase customer1;
    private Customer customer2;
    
	public CustomerDatabaseTest() {
	}

	@Before
	public void setUp(){
        customer1 = new CustomerDatabase();
        customer2 = new Customer("1", "1", "1");
    }

	@Test
	public void testCustomerDatabase() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddCustomer() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRemoveCustomer() {
        assertEquals(3, customer1.databaseSize());
        customer1.removeCustomer("123456");
        assertEquals(2, customer1.databaseSize());
    }

	@Test
	public void testGetCustomer() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testListAllCustomers() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testTestCustomers() {
		fail("Not yet implemented"); // TODO
	}

}