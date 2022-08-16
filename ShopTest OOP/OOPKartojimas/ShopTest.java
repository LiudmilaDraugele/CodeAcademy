package OOPKartojimas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ShopTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	

	@Test
	void shopBalanceTest() throws FileNotFoundException {
		
	List<Product> products = Product.importProducts("products1.txt");
	
	Shop banginis = new Shop ("Banginis", "Zirmunu g. 40", products);
	
	assertEquals(226.55,banginis.shopBalance());
}
	@Test
	void sortShopByNameTest() {
		
		Shop banginis = new Shop ("Banginis", "Zirmunu g. 40", null);
		Shop mega = new Shop ("Mega", "Zirmunu g. 20", null);
		Shop eifelis = new Shop ("Eifelis", "Zirmunu g. 40", null);
		Shop babilonas = new Shop ("Babilonas", "Zirmunu g. 40", null);
		Shop akropolis = new Shop ("Akropolis", "Zirmunu g. 40", null);
		
		List <Shop> shops = new ArrayList<>(Arrays.asList(banginis, mega, akropolis, eifelis, babilonas));
		List<Shop> sortedShops = Shop.sortByName(shops);
		
		assertEquals("Akropolis",sortedShops.get(0).getName());
		assertEquals("Mega",sortedShops.get(4).getName());
		
	}
}
