import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		SoftAssert a = new SoftAssert();
		
		List<WebElement> lists = driver.findElements(By.cssSelector("[class='gf-li'] a" ));
		
		for(WebElement list : lists) {
			String url = list.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int status = conn.getResponseCode();
			System.out.println(status);
			a.assertTrue(status<400, "The link with Text "+ list.getText()+" is broken with sttaus code "+ status);
			
		}
		a.assertAll();
	
	}

}
