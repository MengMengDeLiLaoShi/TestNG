package button;

import org.openqa.selenium.io.FileHandler;//�ļ�������
import org.openqa.selenium.io.Zip;//ѹ�����߲�����
import org.openqa.selenium.io.TemporaryFilesystem;//��ʱ�ļ�������

import java.io.*;

public class SeleniumFile {

	public static void main(String[] args) {
		FileHandler filehandler = new FileHandler();
		Zip zip = new Zip();
		File source = new File("D:\\Baidu\\BaiduReaderLite\\ClientStat\\MainPath");
		File dest = new File("D:\\Baidu\\BaiduReaderLite\\ClientStat\\test");
		try {
			filehandler.copy(source, dest,"1.txt");
			filehandler.createDir(new File("D:\\Baidu\\BaiduReaderLite\\ClientStat\\test1"));
			String f = filehandler.readAsString(new File("D:\\Baidu\\BaiduReaderLite\\ClientStat\\test.txt"));
			System.out.print(filehandler.isZipped("d:1.txt"));
//			filehandler.makeWritable(file);
//			filehandler.canExecute(file);
//			zip.zip(inputDir, output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
