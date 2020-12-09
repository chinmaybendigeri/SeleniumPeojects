import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class AddtoCarts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String[] items = { "Cucumber", "Beans", "Pumpkin" };

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000); // change to implicit or explicit wait
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // --- implicit wait of 5seconds
		
		addItemsToCart(driver, items);

		proceedToCheckOut(driver);
	}

	private static void addItemsToCart(WebDriver driver, String[] items) {
		// TODO Auto-generated method stub
		int count = 0;

		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		List itemsList = Arrays.asList(items);

		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();

			if (itemsList.contains(formattedName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// Thread.sleep(3000);
				count++;

				if (count == items.length) {
					break;
				}
			}

		}

	}

	private static void proceedToCheckOut(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.findElement(By.cssSelector("[class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		String promoCode = "rahulshettyacademy";

		try {
			applyPromoCode(driver, promoCode);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void applyPromoCode(WebDriver driver, String promoCode) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverWait w = new WebDriverWait(driver,5);
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		
		driver.findElement(By.cssSelector(".promoCode")).sendKeys(promoCode);
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		String promoCodeAppliedMsg = driver.findElement(By.cssSelector(".promoInfo")).getText();
		// verify code is applied
		if (promoCodeAppliedMsg.equalsIgnoreCase("Code applied ..!")) {
			Assert.assertTrue(true);
		} else if (promoCodeAppliedMsg.equalsIgnoreCase("Invalid code ..!")) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

	}

}
