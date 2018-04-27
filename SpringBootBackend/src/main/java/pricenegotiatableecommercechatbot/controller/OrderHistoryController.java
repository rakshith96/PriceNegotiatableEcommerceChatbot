package pricenegotiatableecommercechatbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pricenegotiatableecommercechatbot.entity.OrderHistory;
import pricenegotiatableecommercechatbot.service.OrderHistoryService;

@CrossOrigin
@RestController
public class OrderHistoryController {

	@Autowired
	private OrderHistoryService orderHistoryService;

	@RequestMapping(value="/addNewOrder",  method= RequestMethod.POST)
	public Integer addProduct(@RequestBody OrderHistory orderHistory) {
		return orderHistoryService.addNewOrder(orderHistory);
	}

	@RequestMapping(value="/viewAllOrders",  method= RequestMethod.GET)
	public List<OrderHistory> viewAllOrders() {
		return orderHistoryService.findAllOrderHistory();
	}
	
	@RequestMapping(value="/getOrderByOrderId",  method= RequestMethod.GET)
	public List<OrderHistory> findOrderByOrderId(@RequestParam("orderId") Integer orderId) {
		return orderHistoryService.findByOrderId(orderId);
	}
	
	@RequestMapping(value="/getLatestOrderOfUser",  method= RequestMethod.GET)
	public OrderHistory findLatestOrder(@RequestParam("userId") Integer userId) {
		return orderHistoryService.findLatestOrder(userId);
	}
	
	@RequestMapping(value="/updateOrder",  method= RequestMethod.GET)
	public OrderHistory updateOrder(@RequestParam("orderId") Integer orderId) {
		return orderHistoryService.updateOrderStatus(orderId);
	}
	
}
