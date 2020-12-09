import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortFindElementsinTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// ---Sort the vegetables and verify if the sort is correct

		// Pseudo Code
		// 1. Click on the WebElement to sort the column
		// 2. Get all the vegetables present in the coloumn using getText()
		// 3. Sort all the vegetables based on the gettext and store into a list
		// 4. Sort the original list from step 3
		// 5. Compare the list from step 3 and step 4 if there is a match

		driver.findElement(By.xpath("//thead/tr/th[1]")).click();

		List<WebElement> vegList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<WebElement> vegStreamList = driver.findElements(By.xpath("//tbody/tr/td[1]"));

		List<String> vegetables = new ArrayList<String>(Arrays.asList("Beans", "Brinjal"));
		// Code without using Java Streams

		List<String> actualText = new ArrayList<String>();
		for (WebElement e : vegList) {
			actualText.add(e.getText());
		}
		List<String> expectedText = new ArrayList<String>(actualText);
		Collections.sort(expectedText);
		Assert.assertEquals(actualText, expectedText, "Sort is incorrect!");

		// Code with using JavaStreams
		List<String> originalList = vegList.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> expectedList = originalList.stream().sorted().collect(Collectors.toList());

		Assert.assertEquals(originalList, expectedList, "Sort is incorrect!");
		List<String> vegiePrice = new ArrayList<String>();
		List<String> priceInfo = new ArrayList<String>();
		// code to get the price of the vegetable without using Java Streams with
		// Pagination
		/*
		 * do { for (WebElement e : vegList) { if (e.getText().contains("Strawberry")) {
		 * vegiePrice.add(e.findElement(By.xpath("following-sibling::td[1]")).getText())
		 * ; System.out.println(vegiePrice); } } if (vegiePrice.size() < 1) {
		 * driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		 * Thread.sleep(2000); vegList =
		 * driver.findElements(By.xpath("//tbody/tr/td[1]")); }
		 * 
		 * } while (vegiePrice.size() < 1);
		 */
		// code to get the price of the vegetable/(s) using Java Streams with Pagination
		do {
			vegStreamList = driver.findElements(By.xpath("//tbody/tr/td[1]"));

			 priceInfo = vegStreamList.stream().filter(s -> s.getText().contains("Wheat"))
					.map(s -> getVegiePrice(s)).collect(Collectors.toList());
			// List<String> pricesInfo = vegList.stream().filter(s ->
			// vegetables.contains(s.getText())).map(s->getVegiePrice(s)).collect(Collectors.toList());
			if(priceInfo.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
			//priceInfo.stream().forEach(s -> System.out.println(s));
		} while (priceInfo.size() < 1);
		
		priceInfo.stream().forEach(s -> System.out.println(s));
	}

	private static String getVegiePrice(WebElement s) {
		// TODO Auto-generated method stub
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();

	}

}
