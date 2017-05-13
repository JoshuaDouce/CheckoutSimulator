
public class Customer {
	
	private String customerNumber;
	private String customerName;
	private String customerEmail;
	private double loyaltyPoints;
	
	
	public Customer(String newCustomerNumber, String newCustomerName, String newCustomerEmail){
		customerNumber = newCustomerNumber;
		customerName = newCustomerName;
		customerEmail = newCustomerEmail;
		loyaltyPoints = 0;
	}


	public String getCustomeNumber() {
		return customerNumber;
	}


	public void setCustomeNumber(String customeNumber) {
		this.customerNumber = customeNumber;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public double getLoyaltyPoints(){
		return loyaltyPoints;
	}
	
	public void setLoyaltyPoints(double points){
		loyaltyPoints = points;
	}
	
	public String toString(){
		return "No: " + customerNumber + "Name: " + customerName + "Email: " + customerEmail +
				"Points: " + loyaltyPoints;
	}

}
