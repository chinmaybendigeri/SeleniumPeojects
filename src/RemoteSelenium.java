import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteSelenium {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		/*
		 * DesiredCapabilities dc = new DesiredCapabilities();
		 * dc.setBrowserName("chrome"); dc.setPlatform(Platform.WINDOWS);
		 * 
		 * WebDriver driver = new RemoteWebDriver(new
		 * URL("http://localhost:4444/wd/hub/"),dc);
		 */
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement aboveElement = driver.findElement(By.cssSelector("[class='form-group'] input[name='name']"));
		
		//driver.findElement(By.tagName("a").above(aboveElement)).getText();
		
		
	
	}

}
