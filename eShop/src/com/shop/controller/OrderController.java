package com.shop.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.model.Cart;
import com.shop.model.CartItem;
import com.shop.model.Order;
import com.shop.model.OrderItem;
import com.shop.model.User;
import com.shop.service.OrderService;
import com.shop.utils.PaymentUtil;

@Controller
public class OrderController {
	
	@Resource
	private OrderService orderService;
	
	//���ݶ���id��ѯ����
	@RequestMapping(value="findByOid/{oid}")
	public String findByOid(@PathVariable("oid") Integer oid,
			Map<String,Object> map){
		Order order = orderService.findByOid(oid);
		map.put("order",order);
		return "order";
	} 
	
	//��ѯ����
	@RequestMapping(value="findOrderByUid/{page}")
	public String findOrderByUid(HttpSession session,Map<String,Object> map
			,@PathVariable("page") Integer page){
		//��session��ȡuser����
		User user = (User) session.getAttribute("user");
		if(user == null){
			map.put("notLogin", "notLogin");
			return "msg";
		}
		//��ѯ�ܹ��ж���ҳ������
		Integer count = orderService.findCountByUid(user.getUid());
		if(page > count){
			page = 1;
		}
		//�����û���ҳ��ѯ����
		List<Order> orders = orderService.findByUid(user.getUid(), page);
		map.put("orders", orders);
		map.put("page", page);
		map.put("count",count);
		return "orderList";
	}
	
	//���涩��
	@RequestMapping(value="saveOrder")
	public String saveOrder(HttpSession session,Map<String,Object> map){
		//�ж��û��Ƿ��½,
		User user = (User) session.getAttribute("user");
		if(user == null){
			map.put("notLogin","noLogin");
			return "msg";
		}
		//��session��ȡ���ﳵ����
		Cart cart = (Cart) session .getAttribute("cart");
		//������ﳵΪ�գ��򷵻ص��ҵĹ��ﳵҳ��
		if(cart == null){
			return "redirect:myCart";
		}
		//��������
		Order order = new Order();
		order.setTotal(cart.getTotal());
		// 1:δ����. 2.�Ѿ����û�з��� 3.������û��ȷ�Ϸ��� 4.�������
		order.setState(1);
		// ���ö���ʱ��
		order.setOrdertime(new Date());
		// ���ö��������Ŀͻ�:
		order.setUser(user);
		// ���ö������:
		Set<OrderItem> sets = new HashSet<OrderItem>();
		for (CartItem cartItem : cart.getCartItems()) {
			// ���������Ϣ�ӹ������õ�.
			OrderItem orderItem = new OrderItem();			
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			//˫�����ʱ�ڶ��һ������һ��һ��������
			orderItem.setOrder(order);
			//��orderItem������ӵ�������
			sets.add(orderItem);
		}
		//˫�����ʱ��һ��һ�����ö��һ��������
		order.setOrderItems(sets);
		orderService.save(order);
		//������ﳵ
		cart.clearCart();
		map.put("order",order);
		return "order";
	}
	
	/* ȷ�϶����Ĳ���,Ϊ��������:
	 * addr:�ջ��˵�ַ name:�ջ��� phone:��ϵ�绰  oid:������oid
	 * pd_FrpId:����֧��ͨ������
	 */
	@RequestMapping(value="/payOrder")
	public String payOrder(Integer oid, String addr,String name, String phone,
			String pd_FrpId,HttpServletResponse response){
		Order order = orderService.findByOid(oid);
		order.setAddr(addr);
		order.setName(name);
		order.setPhone(phone);
		//�޸Ķ���
		orderService.update(order);
		// 2.��ɸ���:
		// ������Ҫ�Ĳ���:
		String p0_Cmd = "Buy"; // ҵ������:
		String p1_MerId = "10001126856";// �̻����:
		String p2_Order = order.getOid().toString();// �������:
		String p3_Amt = "0.01"; // ������:
		String p4_Cur = "CNY"; // ���ױ���:
		String p5_Pid = ""; // ��Ʒ����:
		String p6_Pcat = ""; // ��Ʒ����:
		String p7_Pdesc = ""; // ��Ʒ����:
		String p8_Url = "http://localhost:8080/eShop/callBack"; // �̻�����֧���ɹ����ݵĵ�ַ:
		String p9_SAF = ""; // �ͻ���ַ:
		String pa_MP = ""; // �̻���չ��Ϣ:
		String pr_NeedResponse = "1"; // Ӧ�����:
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // ��Կ
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc,
				p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue); // hmac��
		// ���ױ���������:
		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);
		// �ض���:���ױ�����:
		try {
			response.sendRedirect(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * ����ɹ�����ת������·��:
	 * r6_Order,r3_Amt ���ո���ɹ���Ĳ���:
	 */
	@RequestMapping(value="/callBack")
	public String callBack(Integer r6_Order,Integer r3_Amt,Map<String,Object> map){
		// �޸Ķ�����״̬:
		Order currOrder = orderService.findByOid(r6_Order);
		// �޸Ķ���״̬Ϊ2:�Ѿ�����:
		currOrder.setState(2);
		orderService.save(currOrder);
		map.put("success", "֧���ɹ�!�������Ϊ: "+r6_Order +" ������Ϊ: "+r3_Amt);
		return "msg";
	}
	
	//ȷ���ջ�
	@RequestMapping(value="updateState/{oid}")
	public ModelAndView updateState(@PathVariable("oid") Integer oid){
		System.out.println(oid);
		Order order = orderService.findByOid(oid);
		order.setState(4);
		orderService.save(order);
		ModelAndView model = new ModelAndView("redirect:/findOrderByUid/1");
		return model;
	}
}
