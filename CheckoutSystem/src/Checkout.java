import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Checkout {
	
	private String checkoutNumber;
	private ArrayList<Product> basket;
	private double balance;
	
	public Checkout(String number){
		setCheckoutNumber(number);
		basket = new ArrayList<Product>();
		balance = 0;
	}

	public String getCheckoutNumber() {
		return checkoutNumber;
	}
	
	public ArrayList<Product> getBasket(){
		return basket;
	}

	public void setCheckoutNumber(String checkoutNumber) {
		this.checkoutNumber = checkoutNumber;
	}
	
	public void listBasket() {
		for(Iterator<Product> it = basket.iterator(); it.hasNext(); ){
			Product p = it.next();
			System.out.println(p.toString());	
		}
	}

	public double payCash(double amountPayed){
		double basketCost = totalCost();
		double change = 0;
		change = amountPayed - basketCost;
		double totalCost = totalCost();
		balance = balance + totalCost;
		return change;
	}
	
	public void removeProduct(int index){
		basket.remove(index);
	}

	public void scan(Product product) {
		basket.add(product);
	}

	public void clearBasket() {
		basket.clear();
	}
	
	public double totalCost(){
		double basketCost = 0;
		for(Iterator<Product> it = basket.iterator(); it.hasNext(); ){
			Product p = it.next();
			double productPrice = p.getPrice();
			basketCost = basketCost + productPrice;
		}
		return basketCost;
	}
	
	public double getBalance(){
		return balance;
	}
}
	

