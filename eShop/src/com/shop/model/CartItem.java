package com.shop.model;

public class CartItem {
	
	private Product product; //����������Ʒ��Ϣ
	private int count;       //����ĳ����Ʒ����
	@SuppressWarnings("unused")
	private double subtotal; //����ĳ����ƷС��
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal(){
		if(product.getShop_price()!=null){
			return count*product.getShop_price();
		}
		return 0;
	}
}
