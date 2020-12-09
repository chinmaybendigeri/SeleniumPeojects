import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ind");
		Thread.sleep(3000);

		System.out.println(driver.findElement(By.xpath("//div[@class='ui-menu-item-wrapper']")).getText());

		System.out.println(driver.findElements(By.cssSelector(".ui-menu-item-wrapper")).size());

		int size = driver.findElements(By.cssSelector(".ui-menu-item-wrapper")).size();
		int i = 0;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.getElementById(\"autocomplete\").value;";
		String text = "";

		while (!text.contains("India") && i < size) {
			i++;
			driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.ARROW_DOWN);
			text = (String) js.executeScript(script);
			
			System.out.println(text +" "+ i);
			//if(i >= 3) {
			//	break;
			//}
		}

		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.ENTER);
		if (text.contains("India")) {
			System.out.println("Element Found :" + text);

		} else
			System.out.println("No element Found!");
	}
}
