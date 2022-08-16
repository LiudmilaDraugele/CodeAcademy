package OOPKartojimas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class OrderTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}


	@Test
	public void orderByTypeTest() {
		
		Order order1 = new Order("Nr1", null, OrderType.PURCHASE);
		Order order2 = new Order("Nr1", null, OrderType.PURCHASE);
		Order order3 = new Order("Nr1", null, OrderType.SALE);
		Order order4 = new Order("Nr1", null, OrderType.PURCHASE);
		Order order5 = new Order("Nr1", null, OrderType.SALE);
		Order order6 = new Order("Nr1", null, OrderType.PURCHASE);
		
		List<Order>orders = new ArrayList<>(Arrays.asList(order1,order2,order3,order4,order5,order6));
		
		assertEquals(4, Order.filterOrderByType(orders,OrderType.PURCHASE).size());
		assertEquals(2, Order.filterOrderByType(orders,OrderType.SALE).size());
	}
	
	@Test
	
	public void makeOrderTestPurchase() throws FileNotFoundException, InsufficientProductException {
		
		List<Product> products = Product.importProducts("products1.txt");
		
		Shop banginis = new Shop ("Banginis", "Zirmunu g. 40", products);
		
		HashMap<String, Integer> order = new HashMap<>();
		
		order.put("07886659844", 5);
		order.put("06669844723", 7);
		
		Order.makeOrder(banginis, OrderType.PURCHASE, order);
		
		assertEquals(11, products.get(0).getReminder());
		assertEquals(9, products.get(1).getReminder());
		
		
			
	}
	
@Test
	
	public void makeOrderTestSale() throws FileNotFoundException, InsufficientProductException {
		
		List<Product> products = Product.importProducts("products1.txt");
		
		Shop banginis = new Shop ("Banginis", "Zirmunu g. 40", products);
		
		HashMap<String, Integer> order = new HashMap<>();
		
		
		Order.makeOrder(banginis, OrderType.SALE, order);
		
		order.put("07886659844", 2);
		order.put("06669844723", 2);
		
		assertEquals(6, products.get(0).getReminder());
		assertEquals(2, products.get(1).getReminder());
			
	}
@Test
	public void makeOrderTestException() throws FileNotFoundException, InsufficientProductException {
	
		List<Product> products = Product.importProducts("products1.txt");
	
		Shop banginis = new Shop ("Banginis", "Zirmunu g. 40", products);
		
		HashMap<String, Integer> order = new HashMap<>();
	
	
		order.put("06669844723", 5);
	
		InsufficientProductException exception = assertThrows(InsufficientProductException.class, () ->{
			Order.makeOrder(banginis, OrderType.SALE, order);
	});
	}
}
