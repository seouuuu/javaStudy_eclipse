package programming9;

public class Product {
	protected String name;
	protected double price;
	
	public double getPrice() {
		return price;
	}

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public Product() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "product [name=" + name + ", price=" + price + "]";
	}
	
	
}
