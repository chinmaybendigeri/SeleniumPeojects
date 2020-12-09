import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String selectMonth = "January";
		String selectDay = "31";

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.path2usa.com/travel-companions");
		
		Thread.sleep(5000);
		// Jan 31st
		// Select Jan 31st
		
		driver.findElement(By.cssSelector("input[id='travel_date']")).click();
		
		while (true) {
			if(driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
					.contains(selectMonth)) {
				break;
			}
			else
				driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
		}

		// select 31st day
		List<WebElement> days = driver.findElements(By.className("day"));
		int count = driver.findElements(By.className("day")).size();

		for (int i = 0; i < count; i++) {
			if (driver.findElements(By.className("day")).get(i).getText().equalsIgnoreCase(selectDay)) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
	}

}
