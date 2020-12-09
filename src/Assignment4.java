import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		//System.out.println("Before switching: " + driver.getTitle());
		
		driver.findElement(By.xpath("//*[contains(text(),'Multiple Windows')]")).click();
		
		System.out.println("Before switching: " + driver.getTitle());
		
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		System.out.println(windowIds.size());
		
		System.out.println("After Clicking New Window: " + driver.getTitle());
		Iterator<String> it = windowIds.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		
		driver.switchTo().window(childId);
		System.out.println("After switching: " + driver.getTitle());
		System.out.println(driver.findElement(By.cssSelector(".example")).getText());
		
		driver.switchTo().window(parentId);
		System.out.println("After switching back to Parent Window: " + driver.getTitle());
		System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
	}

}
