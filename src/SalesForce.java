import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SalesForce {
	public static void main(String args[]) {

//	create a browser object for your script in which the selenium script will run
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
	WebDriver driver = new ChromeDriver(); // This line of code doesn't alone sufficient to invoke the chrome browser , we have to invoke the chrome .exe file which is nothing but the browser driver seen in the architecture diagram earlier
	driver.get("https://login.salesforce.com\\");
	//System.out.println(driver.getTitle());

	System.out.println(driver.getCurrentUrl()); 
	//System.out.println(driver.getPageSource());
	
	driver.findElement(By.id("username")).sendKeys("This is Chinmay");
	driver.findElement(By.name("pw")).sendKeys("12345");
	driver.findElement(By.id("Login")).click();
	//System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());
	
	System.out.println(driver.findElement(By.id("error")).getAttribute("innerHTML"));
	
	
	driver.findElement(By.xpath("//a[@id='signup_link']")).click();
	//driver.close();
	
	
	
	}
}
