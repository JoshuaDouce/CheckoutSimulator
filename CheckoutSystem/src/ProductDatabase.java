import java.util.HashMap;

import javax.swing.JOptionPane;


public class ProductDatabase {
	
	private HashMap<String, Product> productDatabase;
	
	public ProductDatabase(){
		productDatabase = new HashMap <String, Product>();
		generateProducts();
	}
	
	public void addProduct(Product product ){
		String barcode = product.getBarcode();
		if(productDatabase.containsKey(barcode)){
			JOptionPane.showMessageDialog(null, "Product not added, barcode in use");
		}
		else{
			productDatabase.put(barcode, product);
		}
	}
	
	public void removeProduct(String barcode){
		if(productDatabase.containsKey(barcode)){
			productDatabase.remove(barcode);
		}
		else{
			JOptionPane.showMessageDialog(null, "No barcode found");
		}
	}
	
	public Product getProduct(String barcode){
		if(productDatabase.containsKey(barcode)){
			Product prod1 = productDatabase.get(barcode);
			return prod1;
			}
		else{
			JOptionPane.showMessageDialog(null, "No barcode found");
			return null;
			}
		}
	
	public void generateProducts(){
		Product oranges = new Product("001","Oranges",0.55);
		Product apples = new Product("002","Apples",0.50);
		Product pears = new Product("003","Pears",0.65);
		Product chocolate = new Product("004","Chocolate",0.65);
		Product crisps = new Product("005","Crisps",0.55);
		Product juice = new Product("006","Juice",1.00);
		Product gum = new Product("007","Gum",0.35);
		AgeRestrictedProduct beer = new AgeRestrictedProduct("008","Beer",4.00);
		Product bread = new Product("009","Bread",1.45);
		Product milk = new Product("010","Milk",1.45);
		
		addProduct(oranges);
		addProduct(apples);
		addProduct(pears);
		addProduct(chocolate);
		addProduct(crisps);
		addProduct(juice);
		addProduct(gum);
		addProduct(beer);
		addProduct(bread);
		addProduct(milk);
	}
	
	public void listAllProducts(){
		for (String product: productDatabase.keySet()){

            String value = productDatabase.get(product).toString();  
            System.out.println(value);  

        } 
	}
	
	public int databaseSize(){
		return productDatabase.size();
	}
}
