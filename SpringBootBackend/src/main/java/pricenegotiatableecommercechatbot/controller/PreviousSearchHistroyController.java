package pricenegotiatableecommercechatbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pricenegotiatableecommercechatbot.entity.PreviousSearchHistory;
import pricenegotiatableecommercechatbot.service.PreviousSearchHistoryService;

@CrossOrigin
@RestController
public class PreviousSearchHistroyController {
	@Autowired
	private PreviousSearchHistoryService previousSearchHistroyService;

	@RequestMapping(value="/addSearchHistroy",  method= RequestMethod.POST)
	public Integer addProduct(@RequestBody PreviousSearchHistory previousSearchHistory) {
		return previousSearchHistroyService.addNewSearchHistory(previousSearchHistory);
	}

	@RequestMapping(value="/viewAllPreviousSearchHistroy",  method= RequestMethod.GET)
	public List<PreviousSearchHistory> viewAllOrders() {
		return previousSearchHistroyService.findAllSearchHistory();
	}
	
	@RequestMapping(value="/getPreviousSearchHistroyOfUser",  method= RequestMethod.GET)
	public List<PreviousSearchHistory> findOrderByOrderId(@RequestParam("userId") Integer userId) {
		return previousSearchHistroyService.findAllSearchHistoryOfUser(userId);
	}
	
}
