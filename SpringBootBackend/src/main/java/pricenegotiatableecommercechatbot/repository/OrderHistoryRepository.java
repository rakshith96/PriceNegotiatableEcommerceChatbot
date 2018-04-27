package pricenegotiatableecommercechatbot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pricenegotiatableecommercechatbot.entity.OrderHistory;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory,Integer> {
	
	@Query("SELECT o FROM OrderHistory o WHERE o.orderId = :orderId ORDER BY time DESC")
	List<OrderHistory> findByOrderId(@Param("orderId") Integer orderId);
	
	List<OrderHistory> findByTransactionId(Integer transactionId);
	
	List<OrderHistory> findByUserId(Integer userId);
	
	@Query("SELECT o FROM OrderHistory o WHERE o.userId = :userId ORDER BY time DESC")
	List<OrderHistory> findOrderedUserHistory(@Param("userId") Integer userId);

}
