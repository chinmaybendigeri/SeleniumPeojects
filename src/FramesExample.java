import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");
		//WebDriverWait w = new WebDriverWait(driver,5);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
		
		//driver.findElement(By.id("draggable")).click();
		
		Actions dragNDrop = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		dragNDrop.dragAndDrop(source, target).build().perform();
		
		driver.switchTo().defaultContent();
		
		//driver.findElement(By.xpath("//*[contains(text(),'Draggable')]")).click();
		
		
		
	}

}
