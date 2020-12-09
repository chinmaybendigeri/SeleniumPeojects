import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("[name*='chk_friendsandfamily']")).click();
		
		//System.out.println(driver.findElement(By.cssSelector("[name*='chk_friendsandfamily']")).isSelected());
		
		Assert.assertTrue(driver.findElement(By.cssSelector("[name*='chk_friendsandfamily']")).isSelected());
		
		Thread.sleep(2000);
		
		
		driver.findElement(By.cssSelector("[name*='chk_friendsandfamily']")).click();
		
		// count the number of checkboxes present in the webpage
		//System.out.println(driver.findElement(By.cssSelector("[name*='chk_friendsandfamily']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("[name*='chk_friendsandfamily']")).isSelected(), "This returned false");
		
		Assert.assertEquals(driver.findElements(By.cssSelector("[type='checkbox']")).size(), 6);
		//System.out.println(driver.findElements(By.cssSelector("[type='checkbox']")).size());
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
