import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalParameters {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\win10\\eclipse-workspace\\SeleniumProject\\data.properties");
		pro.load(fis);
		
		System.out.println(pro.getProperty("browser"));
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\win10\\eclipse-workspace\\SeleniumProject\\data.properties");
		pro.store(fos, null);
		pro.setProperty("browser","firefox");
		System.out.println(pro.getProperty("browser"));
	}

}
