package pricenegotiatableecommercechatbot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pricenegotiatableecommercechatbot.entity.PreviousSearchHistory;

public interface PreviousSearchHistoryRepository extends JpaRepository<PreviousSearchHistory,Integer>{
	
	PreviousSearchHistory findBySearchId(Integer searchId);

	List<PreviousSearchHistory> findByUserId(Integer userId);

}
