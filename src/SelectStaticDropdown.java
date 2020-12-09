import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectStaticDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		Thread.sleep(5000); // Added wait time to wait till the page is loaded completely
		
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		//Thread.sleep(5000); // Not required wait time here , might need to add the wait time if the internet is slow so that complete page is loaded and the object can be identified after the page loaded 
		
		Select adultSelect = new Select(driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_Adult']")));
		
		//Select adultSelect = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		
		System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
		adultSelect.selectByIndex(5);
		Thread.sleep(2000);
		adultSelect.selectByValue("2");
		Thread.sleep(2000);
		adultSelect.selectByVisibleText("3");
		
		
		System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
	}

}
