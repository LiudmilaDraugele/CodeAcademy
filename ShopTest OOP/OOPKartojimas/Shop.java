package OOPKartojimas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Shop {
	
	private String name;
	private String address;
	private List<Product> products;
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop(String name, String address, List<Product> products) {
		super();
		this.name = name;
		this.address = address;
		this.products = products;
	}
	
	public Double shopBalance() {
		
		DecimalFormat df = new DecimalFormat("0.00");
		double balance = 0;
		
		for( Product product: products ) {
			balance = balance+(product.getPrice()*product.getReminder());
		}
			
		return new BigDecimal( balance).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
	public static List<Shop> sortByName (List<Shop> shopList){
		List<Shop> ordered = shopList
				.stream()
				.sorted(Comparator.comparing(Shop::getName, Comparator.naturalOrder()))
				.collect(Collectors.toList());
		return ordered;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> orderedProducts) {
		this.products = products;
	}
	
	

}
