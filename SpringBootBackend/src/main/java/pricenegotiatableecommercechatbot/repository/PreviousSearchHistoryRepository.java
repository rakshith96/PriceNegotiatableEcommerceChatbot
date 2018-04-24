package pricenegotiatableecommercechatbot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pricenegotiatableecommercechatbot.entity.PreviousSearchHistory;

@Repository
public interface PreviousSearchHistoryRepository extends JpaRepository<PreviousSearchHistory,Integer>{
	
	PreviousSearchHistory findBySearchId(Integer searchId);

	@Query("SELECT p from PreviousSearchHistory p where p.userId = :userId ORDER BY p.time DESC")
	List<PreviousSearchHistory> findByUserId(@Param("userId") Integer userId);

}
