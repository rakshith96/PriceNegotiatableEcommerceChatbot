package pricenegotiatableecommercechatbot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pricenegotiatableecommercechatbot.entity.OrderHistory;
import pricenegotiatableecommercechatbot.repository.OrderHistoryRepository;

@Service
public class PriceNegotiatorService {
	
	@Autowired
	private OrderHistoryRepository orderHistoryRepository;
	
	public List<Integer> findProductPurchaseHistory(Integer productId) {
		List<OrderHistory> list = orderHistoryRepository.findAll();
		HashMap<String,Integer> support = new HashMap<String,Integer>();
		Integer countOfProductId=0;;
		for(int i=0;i<list.size();i++) {
			String s1 = list.get(i).getProductIds();
//			System.out.println(i+" "+s1);
			String s2 = productId.toString();
//			System.out.println(s1.contains(s2));
			if(s1!=null && s1.contains(s2)) {
				countOfProductId++;
//				System.out.println("Entered if with "+ s1);
				s1 = s1.replace(",", "");
				s1 = s1.replace(s2,"");
//				System.out.println("modified to "+s1+"lol "+support.containsKey(s1));
//				System.out.println(s1.length());
				if(s1.length()!= 0 &&support.containsKey(s1)) {
//					System.out.println("Product pair found was "+s1);
					Integer count = support.get(s1);
					support.put(s1, count+1);
				}
				else {
					if(s1.length() != 0) 
						support.put(s1, 1);
				}
			}
		}
		System.out.println(support.toString());
		String maxProductId = "0";
		Integer maxCount = 0;
		for (Map.Entry<String, Integer> entry : support.entrySet())
		{
//		    System.out.println(entry.getKey() + "/" + entry.getValue());
		    if(entry.getValue()>maxCount) {
		    	maxProductId = entry.getKey();
		    	maxCount = entry.getValue();
		    }
		}
		System.out.println("Maximun product pair found was " +maxProductId);// + " with count "+support.get(maxProductId));
		System.out.println("Count of productId P(X) is "+countOfProductId);
		double s = new Double(support.get(maxProductId));
		double confidence = s/countOfProductId;
		System.out.println("Support found P(XY) is "+maxProductId+" Confidence P(XY)/P(X) is "+confidence);
		
		List<Integer> l = new ArrayList<Integer>();
		l.add(new Integer(maxProductId));
		return l;
	}

	public double getUserDiscount(Integer userId) {
		List<OrderHistory> list = orderHistoryRepository.findByUserId(userId);
		double totalAmountPurchased = 0.0;
		for(int i = 0;i<list.size();i++) {
			if(i>5)
				break;
			double price = list.get(i).getFinalPrice();
//			System.out.println(price);
			totalAmountPurchased+=price; 
		}
		
		System.out.println("User "+userId+" has made a purchase of total Rs "+totalAmountPurchased+ " in the last 5 latest trasactions");
		if(totalAmountPurchased<=1000.0) {
		return 1.0;
		}
		else if(totalAmountPurchased<20000.0) {
			return totalAmountPurchased/1000.0;
		}
		else { 
			return 25.0;
		}
	}
	
}
