import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		//driver.findElement(By.xpath("//a[@value='BLR']")).click(); // This will select BLR from FROM dropdown instead of TO dropdown as the xpath is same for both of them.
		Thread.sleep(1000);
		// To explicitly select the required element mention the xpath required as follows
		//driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click(); // But some cases even this is not suggested as it contains indexes
		
		//driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
		driver.findElement(By.cssSelector("div[id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] a[value='MAA']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		//[name='ctl00$mainContent$view_date2']
		
		System.out.println(driver.findElement(By.cssSelector("[name='ctl00$mainContent$view_date2']")).isEnabled());
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
		
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		//Thread.sleep(5000); // Not required wait time here , might need to add the wait time if the internet is slow so that complete page is loaded and the object can be identified after the page loaded 
		
		Select adultSelect = new Select(driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_Adult']")));
		
		//Select adultSelect = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		
		System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
		adultSelect.selectByIndex(5);
		System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
		//System.out.println(driver.findElement(By.cssSelector("[name='ctl00$mainContent$view_date2']")).isEnabled());
		//Assert.assertTrue(driver.findElement(By.cssSelector("[id='ctl00_mainContent_view_date1']")).isDisplayed());
		
		Select curSelect = new Select(driver.findElement(By.xpath("//*[@id='ctl00_mainContent_DropDownListCurrency']")));
		curSelect.selectByIndex(2);
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
		
		
		//Thread.sleep(5000);
		//driver.quit();
	}

}
