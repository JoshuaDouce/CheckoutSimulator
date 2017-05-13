
public class SupermarketSystem {
	
	private CheckoutSystem checkoutSystem;
	private ProductDatabase productDatabase;
	private CustomerDatabase customerDatabase;
	private StaffDatabase staffDatabase;
	
	public SupermarketSystem(){
		checkoutSystem = new CheckoutSystem();
		productDatabase = new ProductDatabase();
		customerDatabase = new CustomerDatabase();
		staffDatabase = new StaffDatabase();
	}

	public CheckoutSystem getCheckoutSystem() {
		return checkoutSystem;
	}

	public void setCheckoutSystem(CheckoutSystem checkoutSystem) {
		this.checkoutSystem = checkoutSystem;
	}

	public ProductDatabase getProductDatabase() {
		return productDatabase;
	}

	public void setProductDatabase(ProductDatabase productDatabase) {
		this.productDatabase = productDatabase;
	}

	public CustomerDatabase getCustomerDatabase() {
		return customerDatabase;
	}

	public void setCustomerDatabase(CustomerDatabase customerDatabase) {
		this.customerDatabase = customerDatabase;
	}

	public StaffDatabase getStaffDatabase() {
		return staffDatabase;
	}

	public void setStaffDatabase(StaffDatabase staffDatabase) {
		this.staffDatabase = staffDatabase;
	}
	
	public void addLoyaltyPoints(String customerNumber, int checkNum){
		Checkout checkout = checkoutSystem.getCheckout(checkNum);
		Customer c1 = customerDatabase.getCustomer(customerNumber);
		double loyaltyPoints = c1.getLoyaltyPoints();
		double cost = checkout.totalCost();
		double pointsToAdd = cost / 100;
		loyaltyPoints = loyaltyPoints + pointsToAdd;
		c1.setLoyaltyPoints(loyaltyPoints);
	}

}
