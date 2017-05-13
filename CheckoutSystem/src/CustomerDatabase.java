import java.util.HashMap;

public class CustomerDatabase {
	
	private HashMap <String, Customer> customerDatabase;
	
	public CustomerDatabase(){
		customerDatabase = new HashMap<String, Customer>();
		testCustomers();
	}
	
	public void addCustomer(Customer customer){
		String customerNumber = customer.getCustomeNumber();
		customerDatabase.put(customerNumber, customer);
	}
	
	public void removeCustomer(String customerNumber){
		customerDatabase.remove(customerNumber);
	}
	
	public Customer getCustomer(String customerNumber){
		Customer custom1 = customerDatabase.get(customerNumber);
		return custom1;
	}
	
	public void listAllCustomers(){
		for (String customer: customerDatabase.keySet()){

            String value = customerDatabase.get(customer).toString();  
            System.out.println(value);  
        } 
	}
	
	public void testCustomers(){
		Customer c1 = new Customer("123456", "Bill", "Bill@fake.com");
		Customer c2 = new Customer("654321", "Jeff", "Jeff@fake.com");
		Customer c3 = new Customer("112233", "Jill", "Jill@fake.com");
		
		addCustomer(c1);
		addCustomer(c2);
		addCustomer(c3);
	}
	
	public int databaseSize(){
		return customerDatabase.size();
	}
}
