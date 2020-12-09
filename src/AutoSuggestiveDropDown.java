import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class AutoSuggestiveDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(5000);
		
	//	driver.findElement(By.cssSelector(".ui-menu-item a.ui-corner-all")).
		driver.findElement(By.cssSelector("#autosuggest")).sendKeys("in");
		Thread.sleep(2000);
		
		List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item a.ui-corner-all"));
		// First identify the generic selector for the dropdown d then iterate the list using for loop 
		
		
		boolean isFound = false;
		for(WebElement o : options) {
			if(o.getText().equalsIgnoreCase("India"))  // check if the option is equal to India 
			{
				o.click();  // select the required option
				isFound = true;
				break;  // break the for loop once the option required is found 
			}

		}
		if(isFound) {
			System.out.print("Text  found!");
		}
		else 
			System.out.print("Text not found!");
		
		Thread.sleep(5000);
		
		driver.close();
	}

}
