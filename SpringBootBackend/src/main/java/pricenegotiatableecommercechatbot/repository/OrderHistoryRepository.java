package pricenegotiatableecommercechatbot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pricenegotiatableecommercechatbot.entity.OrderHistory;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory,Integer> {
	
	List<OrderHistory> findByOrderId(Integer orderId);
	
	List<OrderHistory> findByTransactionId(Integer transactionId);
	
	List<OrderHistory> findByUserId(Integer userId);
	
	@Query("SELECT o FROM OrderHistory o ORDER BY time DESC")
	List<OrderHistory> findOrderedUserHistory(Integer userId);

}
