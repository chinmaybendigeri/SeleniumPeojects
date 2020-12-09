import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveJavaScript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://ksrtc.in/oprs-web/");
		
	
		driver.findElement(By.id("fromPlaceName")).sendKeys("BENG");
		Thread.sleep(2000);
		JavascriptExecutor js= (JavascriptExecutor) driver; 
		//System.out.println(driver.findElement(By.id("fromPlaceName")).getText());
		String script = "return document.getElementById(\"fromPlaceName\").value;";
		String text = "";
		int count = 0;
		
		while(!text.contains("chinmay")) {
			 count++;
			 driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ARROW_DOWN);
			 //script = "return document.getElementById(\"fromPlaceName\").value;";
			 text = (String) js.executeScript(script);
			 
			 if(count >= 10) {
				 break;
			 }
			 System.out.println(text +" "+ count);
		}
		
		driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ENTER);
		if(count>= 10) {
			System.out.println("Element Not Found");
		}else
			System.out.println(text);
		
	}

}
