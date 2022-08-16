package OOPKartojimas;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
	
	private String orderNr;
	private HashMap<String, Integer> products;
	private OrderType type;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String orderNr, HashMap<String, Integer> products, OrderType type) {
		super();
		this.orderNr = orderNr;
		this.products = products;
		this.type = type;
	}
	
	public static List<Order> filterOrderByType(List<Order> orderList, OrderType neededType){
		List<Order> filteredOrders  = orderList
				.stream()
				.filter(order -> order.getOrderType().equals(neededType))
				.collect(Collectors.toList());
		
		return filteredOrders;
	}
	
	public static void makeOrder(Shop shop, OrderType type, HashMap<String, Integer> products ) throws InsufficientProductException {
		
		
		for (int i=0; i<shop.getProducts().size();i++) {
			if (products.containsKey(shop.getProducts().get(i).getBarcode())) {
				if (type.equals(OrderType.PURCHASE)) {
					Integer newRemainder = shop.getProducts().get(i).getReminder() + products.get(shop.getProducts().get(i).getBarcode());
					shop.getProducts().get(i).setReminder(newRemainder);
					
				} else {
					
					if (shop.getProducts().get(i).getReminder() < products.get(shop.getProducts().get(i).getBarcode())) {
						throw new InsufficientProductException("Insufficient produts in the store." +shop.getProducts().get(i).getName() , shop.getProducts().get(i).getReminder() );
					}
					Integer newRemainder = shop.getProducts().get(i).getReminder() - products.get(shop.getProducts().get(i).getBarcode());
					shop.getProducts().get(i).setReminder(newRemainder);
				}
			}
		}
		
		
	}
	
	public String getOrderNr() {
		return orderNr;
	}
	public void setOrderNr(String orderNr) {
		this.orderNr = orderNr;
	}
	public HashMap<String, Integer> getProducts() {
		return products;
	}
	public void setProducts(HashMap<String, Integer> products) {
		this.products = products;
	}
	public OrderType getOrderType() {
		return type;
	}
	public void setOrderType(OrderType type) {
		this.type = type;
	}

	
}
