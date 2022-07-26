package Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainWorkWithFiles {

	public static void main(String[] args) {
		
		
		File data = new File("FileWithString.txt");
		File newData = new File("New.txt");
		
		try {
			newData.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("File already exist");
		}
		
		try {
			Scanner scanner = new Scanner(data);
			scanner.useDelimiter(";");
			
			while (scanner.hasNext()) {
				System.out.println(scanner.next());
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not found");
		}

	}

}
