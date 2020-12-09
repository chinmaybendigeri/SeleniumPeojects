import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption1")).click();

		String label = driver.findElement(By.cssSelector("label[for='bmw']")).getText();
		System.out.println(label);
		
		Select dropDown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropDown.selectByVisibleText(label);
		
		driver.findElement(By.id("name")).sendKeys(label);
		
		driver.findElement(By.id("alertbtn")).click();
		
		String alertMsg = driver.switchTo().alert().getText();
		
		if(alertMsg.contains(label)) {
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
		
		//driver.switchTo().alert().dismiss();
		
	}

}
