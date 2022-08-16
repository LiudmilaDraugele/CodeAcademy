package OOPKartojimas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ProductTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	//@Test
	//void test() {
	//	fail("Not yet implemented");
	//}

	@Test
	void importProductsTest() throws FileNotFoundException{
		
		List<Product> products = Product.importProducts("products1.txt");
		assertEquals(5, products.size());
		
		assertEquals("Varske", products.get(0).getName());
		
	}
}
