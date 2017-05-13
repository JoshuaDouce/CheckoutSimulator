import java.util.ArrayList;

public class CheckoutSystem {
	private ArrayList<Checkout> checkouts;
	
	public CheckoutSystem(){
		checkouts = new ArrayList<Checkout>();
		initialCheckouts();
	}
	
	public void addCheckout(Checkout checkout){
		checkouts.add(checkout);
	}
	
	public void removeCheckout(int index){
		checkouts.remove(index);
	}
	
	public Checkout getCheckout(int index){
		Checkout checkout = checkouts.get(index);
		return checkout;
	}
	
	public void initialCheckouts(){
	   Checkout checkout1 = new Checkout("1");
	   Checkout checkout2 = new Checkout("2");
	   
	   addCheckout(checkout1);
	   addCheckout(checkout2);
	}
	
	public int databaseSize(){
		return checkouts.size();
	}
}
