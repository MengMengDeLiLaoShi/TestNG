package JavaStudy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class StringSplit {
	public static void main(String[] args){
		String line = "";
		File file = new File("D:\\cookie.txt");
		try {
			FileReader filereader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
