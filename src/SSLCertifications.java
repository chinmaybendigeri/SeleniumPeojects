import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertifications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//general profile for any browser
		DesiredCapabilities ch = new DesiredCapabilities();
		ch.acceptInsecureCerts();
		
		//local browser
		FirefoxOptions f = new FirefoxOptions();
		f.merge(ch);
		
		ChromeOptions c = new ChromeOptions();
		c.merge(ch);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
	}

}
