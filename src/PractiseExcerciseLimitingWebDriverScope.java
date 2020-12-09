import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PractiseExcerciseLimitingWebDriverScope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Set<String> windowIds;
		Iterator<String> it;

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.findElements(By.tagName("a")).size());

		WebElement footerDriver = driver.findElement(By.cssSelector("[id='gf-BIG']"));

		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		WebElement columnDriver = footerDriver.findElement(By.xpath("table/tbody/tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());

		// --- click on each link in the column section and verify if all the links are
		// working

		// driver.switchTo().window(arg0);// pass the window id here

		for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {

			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			Thread.sleep(2000);
		}

		windowIds = driver.getWindowHandles(); // all the window ids stored
		it = windowIds.iterator();

		/*
		 * it.next(); int num = columnDriver.findElements(By.tagName("a")).size();
		 * 
		 * for (int i = 1; i < num; i++) { driver.switchTo().window(it.next());
		 * System.out.println(driver.getTitle()); }
		 */

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}
}
