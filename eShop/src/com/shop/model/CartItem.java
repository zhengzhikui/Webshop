package com.shop.model;

public class CartItem {
	
	private Product product; //购物项中商品信息
	private int count;       //购买某种商品数量
	@SuppressWarnings("unused")
	private double subtotal; //购买某种商品小计
	
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
