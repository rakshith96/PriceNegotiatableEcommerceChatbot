package pricenegotiatableecommercechatbot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pricenegotiatableecommercechatbot.entity.OrderHistory;
import pricenegotiatableecommercechatbot.entity.RegisteredUser;
import pricenegotiatableecommercechatbot.repository.OrderHistoryRepository;

@Service
public class OrderHistoryService {

	@Autowired
	private OrderHistoryRepository orderHistoryRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserService userService;
	
	public Integer addNewOrder(OrderHistory orderHistory) {
		RegisteredUser user = userService.getUserByUserId(orderHistory.getUserId());
		Integer orderId = orderHistoryRepository.save(orderHistory).getOrderId();
		String body = "Your order has been accepted with order Id "+orderId+", further status will be notified /n Thank you for shopping at AnHeRa ";
		emailService.sendSimpleMessage(user.getEmail(), "Order Status",body);
		return orderId;
	}

	public List<OrderHistory> findByOrderId(Integer orderId) {
		return orderHistoryRepository.findByOrderId(orderId);
	}
	
	public List<OrderHistory> findAllOrderHistory(){
		return orderHistoryRepository.findAll();
	}
	
	public List<OrderHistory> findLatestFiveUserTransaction(Integer userId){
		return orderHistoryRepository.findOrderedUserHistory(userId);
	}
	
	public OrderHistory findLatestOrder(Integer userId){
		return orderHistoryRepository.findOrderedUserHistory(userId).get(0);
	}
	
	public OrderHistory updateOrderStatus(Integer orderId) {
		OrderHistory orderHistory = orderHistoryRepository.findByOrderId(orderId).get(0);
		orderHistory.setStatus("Delivered");
		orderHistoryRepository.save(orderHistory);
		return orderHistory;
	}
}
