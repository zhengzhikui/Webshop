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
	
	//首页上跳转至购物车
	@RequestMapping("/myCart")
	public String myCart() {
		return "cart";
	}
	
	//清空购物车
	@RequestMapping(value="/clearCart")
	public String clearCart(HttpSession session){
		Cart cart = (Cart) session.getAttribute("cart");
		cart.clearCart();
		return "cart";
	}
	
	//删除购物车中的商品
	@RequestMapping(value="/removeCart/{pid}")
	public String removeCart(@PathVariable("pid") Integer pid, HttpSession session){
		//获得购物车对象
		Cart cart = (Cart) session.getAttribute("cart");
		//根据商品的pid从购物车中移除商品
		cart.removeCart(pid);
		return "cart";
	}
	
	//添加到购物车
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
		// 将购物项添加到购物车.
		cart.addCart(cartItem);
		return "cart";
	}
	
}
