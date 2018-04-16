package pricenegotiatableecommercechatbot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pricenegotiatableecommercechatbot.entity.PreviousSearchHistory;
import pricenegotiatableecommercechatbot.repository.PreviousSearchHistoryRepository;

@Service
public class PreviousSearchHistoryService {
	
	@Autowired
	private PreviousSearchHistoryRepository previousSearchHistoryRepository;
	
	public Integer addNewSearchHistory(PreviousSearchHistory previousSearchHistory) {
		return previousSearchHistoryRepository.save(previousSearchHistory).getSearchId();
	}
	
	public List<PreviousSearchHistory> findAllSearchHistory() {
		return previousSearchHistoryRepository.findAll();
	}
	
	public List<PreviousSearchHistory> findAllSearchHistoryOfUser(Integer userId) {
		return previousSearchHistoryRepository.findByUserId(userId);
	}
	
}
