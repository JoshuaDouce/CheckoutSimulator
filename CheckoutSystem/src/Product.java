import java.util.Random;


public class Product {
	
	private double price;
	private String barcode;
	private String productName;
	private Boolean ageRestricted;
	
	public Product(String prodName, double newPrice){
		price = newPrice;
		productName = prodName;
		setRandomBarcode();
		setAgeRestricted(false);
	}
	
	public Product (String newBarcode, String prodName, double newPrice){
		price = newPrice;
		productName = prodName;
		barcode = newBarcode;
		setAgeRestricted(false);
	}
	
	public void setPrice(double newPrice){
		price = newPrice;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setRandomBarcode(){
		Random barcodeGenerator = new Random();
		int newBarcode = 0;
		newBarcode = barcodeGenerator.nextInt(100000);
		
		if (newBarcode < 0 ){
            newBarcode = newBarcode * -1;
        }
        else{}
		
		String aBarcode = Integer.toString(newBarcode);
        barcode = aBarcode;
	}
	
	public void setBarcode(String barcode){
		this.barcode = barcode;
	}
	
	public void setProductName(String newProdName){
		productName = newProdName;
	}
	
	public String getProductName(){
		return productName;
	}
	
	public String getBarcode(){
		return barcode;
	}
	
	public String toString(){
        return barcode + ": " + productName + ": " +price;
    }

	public Boolean getAgeRestricted() {
		return ageRestricted;
	}

	public void setAgeRestricted(Boolean ageRestricted) {
		this.ageRestricted = ageRestricted;
	}
}
