package com.sist.exam04;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product = new Product("���������̱�",300000);
		System.out.println(product);
		System.out.println(product.getPrice());
		System.out.println("======================");
		
		DiscountProduct discountProduct = new DiscountProduct("���������̱�",300000,0.2);
		System.out.println(discountProduct.getPrice());
		System.out.println(discountProduct);
	}

}
