package pricenegotiatableecommercechatbot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pricenegotiatableecommercechatbot.entity.OrderHistory;
import pricenegotiatableecommercechatbot.repository.OrderHistoryRepository;

@Service
public class OrderHistoryService {

	@Autowired
	private OrderHistoryRepository orderHistoryRepository;
	
	public Integer addNewOrder(OrderHistory orderHistory) {
		return orderHistoryRepository.save(orderHistory).getOrderId();
	}

	public List<OrderHistory> findByOrderId(Integer orderId) {
		return orderHistoryRepository.findByOrderId(orderId);
	}
	
	public List<OrderHistory> findAllOrderHistory(){
		return orderHistoryRepository.findAll();
	}
}
