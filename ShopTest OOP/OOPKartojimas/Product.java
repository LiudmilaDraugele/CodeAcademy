package OOPKartojimas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product {
	
	private String name;
	private Double price;
	private String barcode;
	private Integer reminder;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, Double price, String barcode, Integer reminder) {
		super();
		this.name = name;
		this.price = price;
		this.barcode = barcode;
		this.reminder = reminder;
	}
	
	public static List<Product> importProducts(String file) throws FileNotFoundException{
		List<Product> productList = new ArrayList<>();
		File products1 = new File(file);
		//File products2 = new File("products2.txt");
		Scanner productDataScanner = new Scanner(products1);
		
		
		while (productDataScanner.hasNextLine()) {
			String line = productDataScanner.nextLine();
			String [] fields = line.split(",");
			productList.add(new Product(fields[0].trim(), Double.valueOf(fields[1].trim()),fields[2].trim(),Integer.valueOf(fields[3].trim())));
		}
		
		return productList;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getReminder() {
		return reminder;
	}

	public void setReminder(Integer reminder) {
		this.reminder = reminder;
	}
	
	

}
