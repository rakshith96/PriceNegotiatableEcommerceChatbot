package pricenegotiatableecommercechatbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pricenegotiatableecommercechatbot.service.PriceNegotiatorService;

@CrossOrigin
@RestController
public class PriceNegotiatorController {
	
	@Autowired
	private PriceNegotiatorService priceNegotiatorService;
	
	@RequestMapping(value="/getCombinedPrice")
	public List<Integer> authenticateUser(@RequestParam("productId") Integer productId) {
		return priceNegotiatorService.findProductPurchaseHistory(productId);
	}
	
	@RequestMapping(value="/getUserPrice")
	public double getPriceForUser(@RequestParam("userId") Integer userId) {
		return priceNegotiatorService.getUserDiscount(userId);
	}
}
