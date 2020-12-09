import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String errorMsg = "Sorry, but we can't continue until you fix everything that's marked in RED";
		String from = "Indianapolis, US - Indianapolis (IND)";
		String to = "Green Bay, US - Austin Straubel Fld";

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.cleartrip.com//");
		Thread.sleep(5000);

		// ----------------------Code to select the from and to place from auto
		// suggestive dropdowns-------------------
		// driver.switchTo().alert().accept();

		/*
		 * driver.findElement(By.id("FromTag")).sendKeys("Ind");
		 * 
		 * Thread.sleep(2000);
		 * 
		 * List<WebElement> fromOptions = driver.findElements(By.id("ui-id-1"));
		 * Thread.sleep(2000);
		 * 
		 * for(WebElement fromOption : fromOptions) {
		 * System.out.println(fromOption.getText());
		 * if(fromOption.getText().equals(from)) { fromOption.click(); break; } }
		 * 
		 * Thread.sleep(2000);
		 * driver.findElement(By.cssSelector("[id='ToTag']")).sendKeys("Aus");
		 * 
		 * Thread.sleep(2000);
		 * 
		 * List<WebElement> toOptions = driver.findElements(By.id("ui-id-2"));
		 * Thread.sleep(2000);
		 * 
		 * for(WebElement toOption : toOptions) {
		 * System.out.println(toOption.getText()); if(toOption.getText().equals(to)) {
		 * toOption.click(); break; } }
		 */

		// ----------------------Code to select the date-------------------
		driver.findElement(By.id("DepartDate")).click();

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click();
		Thread.sleep(1000);

		// ----------------------Code to select number of adults and
		// children-------------------

		Select numAdults = new Select(driver.findElement(By.id("Adults")));
		numAdults.selectByValue("4");

		Select numChild = new Select(driver.findElement(By.id("Childrens")));
		numChild.selectByIndex(2);

		// Assert.assertFalse(driver.findElement(By.cssSelector("#AirlineAutocomplete")).isEnabled());

		// ----------------------Code to select number of adults and
		// children-------------------

		driver.findElement(By.xpath("//a[@id='MoreOptionsLink']")).click();

		Thread.sleep(3000);

		System.out.println(driver.findElement(By.id("moreOptions")).getAttribute("style"));

		// if(driver.findElement(By.cssSelector("[id='moreOptions']")).getAttribute("style").contains("block"))
		// {
		// Assert.assertTrue(true);
		// }
		// else {
		// Assert.assertTrue(false);
		// }

		// System.out.println(driver.findElement(By.cssSelector("#AirlineAutocomplete")).isEnabled());
		// Assert.assertTrue(driver.findElement(By.cssSelector("#AirlineAutocomplete")).isEnabled());

		driver.findElement(By.cssSelector("#AirlineAutocomplete")).sendKeys("King Fisher");

		// ----------------------Code to click on search flights
		// button-------------------
		Thread.sleep(2000);
		driver.findElement(By.id("SearchBtn")).click();

		Assert.assertEquals(driver.findElement(By.id("homeErrorMessage")).getText(), errorMsg);

		Thread.sleep(5000);
		driver.quit();
	}

}
