package programming9;

public class DiscountProduct extends Product {
	public double discount;
	
	
	public DiscountProduct() {
		super();
	}
	public DiscountProduct(String name,double price,double discount) {
		super();
		this.discount = discount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public void getPrice() {
		price = price * (1-discount);
	}
	@Override
	public String toString() {
		return "DiscountProduct [name=" + name + ", price=" + price + ", discount=" + discount + "]";
	}
	
	
	
	
	
}
