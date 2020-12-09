import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\win10\\eclipse-workspace\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.amazon.in/");
		
		Actions action = new Actions(driver);
		System.out.println(driver.getTitle());
		WebElement signinHoverObj = driver.findElement(By.id("nav-link-accountList"));
		
		signinHoverObj.click();
		
		System.out.println(driver.getTitle());
		//driver.findElement(By.xpath("//a[contains(text(),'Conditions of Use')]")).click();
		WebElement conditionObj = driver.findElement(By.xpath("//a[contains(text(),'Conditions of Use')]"));
		System.out.println(driver.getTitle());
		action.contextClick(conditionObj).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).click().build().perform();
		
		Set<String> windowIds = driver.getWindowHandles();
		System.out.println(windowIds.size());
		
		Iterator<String> it = windowIds.iterator();
		System.out.println(driver.getTitle());
		
		String firstWindowId = it.next();
		System.out.println(driver.getTitle());
		//String secondWindowId = it.next();
		
		System.out.println(driver.getTitle());
		
		//driver.switchTo().window(secondWindowId);
		
		
		//driver.switchTo().window(firstWindowId);
		//System.out.println(driver.getTitle());
	}

}
