
public class AgeRestrictedProduct extends Product {
	
	public AgeRestrictedProduct(String prodName, double newPrice){
		super(prodName, newPrice);
		setAgeRestricted(true);
		setRandomBarcode();
	}
	
	public AgeRestrictedProduct (String newBarcode, String prodName, double newPrice){
		super(newBarcode, prodName, newPrice);
		setAgeRestricted(true);
	}
}
	