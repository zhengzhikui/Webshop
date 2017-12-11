package com.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.model.Cart;
import com.shop.model.CartItem;
import com.shop.model.Product;
import com.shop.service.ProductService;

@Controller
public class CartController {
	@Resource
	private ProductService productService;
	
	//��ҳ����ת�����ﳵ
	@RequestMapping("/myCart")
	public String myCart() {
		return "cart";
	}
	
	//��չ��ﳵ
	@RequestMapping(value="/clearCart")
	public String clearCart(HttpSession session){
		Cart cart = (Cart) session.getAttribute("cart");
		cart.clearCart();
		return "cart";
	}
	
	//ɾ�����ﳵ�е���Ʒ
	@RequestMapping(value="/removeCart/{pid}")
	public String removeCart(@PathVariable("pid") Integer pid, HttpSession session){
		//��ù��ﳵ����
		Cart cart = (Cart) session.getAttribute("cart");
		//������Ʒ��pid�ӹ��ﳵ���Ƴ���Ʒ
		cart.removeCart(pid);
		return "cart";
	}
	
	//��ӵ����ﳵ
	@RequestMapping(value="/addCart")
	public String addCart(Integer pid, Integer count, HttpSession session){
		Product product = productService.findByPid(pid);
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		cartItem.setProduct(product);
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		// ����������ӵ����ﳵ.
		cart.addCart(cartItem);
		return "cart";
	}
	
}
