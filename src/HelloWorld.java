import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class HelloWorld {
	public static void main(String args[]) {

//	create a browser object for your script in which the selenium script will run
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
	WebDriver driver = new ChromeDriver(); // This line of code doesn't alone sufficient to invoke the chrome browser , we have to invoke the chrome .exe file which is nothing but the browser driver seen in the architecture diagram earlier
	driver.get("https://www.fb.com\\");
	System.out.println(driver.getTitle());

	System.out.println(driver.getCurrentUrl()); 
	//System.out.println(driver.getPageSource());
	
	/*
	 * driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("This is Chinmay"
	 * ); //driver.findElement(By.id("pass")).sendKeys("Passwor5d");
	 * driver.findElement(By.cssSelector("#pass")).sendKeys("12345");
	 * driver.findElement(By.name("login")).click();
	 */
	//driver.findElement(By.linkText("Forgotten password?")).click();
	//driver.findElement(By.xpath("//*[@id='u_0_b']")).click();
	
	
	//driver.close();
	
	driver.findElement(By.cssSelector("input[class='inputtext _55r1 _6luy']")).sendKeys("Custom email");
	driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("test");
	driver.findElement(By.cssSelector("button[type='submit']")).click();
	
	//System.out.println(driver.findElement(By.xpath("//form[@id='login_form']/div/div[2]")).getAttribute("innerHTML"));
	//System.out.println(driver.findElement(By.xpath("//*[@id='error_box']/div[2]")).getText());
	
	//System.out.println(driver.findElement(By.cssSelector("form[id='login_form']/div/div[2]")).getText());
	
	
	}
}
