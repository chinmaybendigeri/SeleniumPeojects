import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		WebElement table = driver.findElement(By.cssSelector("#product"));
		System.out.println(driver.findElements(By.cssSelector("[id='product'] tbody tr")).size());
		System.out.println(driver.findElements(By.cssSelector("[id='product'] tbody tr th")).size());
		
	//	for(int i =0; i< driver.findElements(By.cssSelector("[id='product'] tbody tr th")).size(); i++) {
			System.out.print(" "+driver.findElement(By.xpath("//*[@id='product']/tbody/tr[3]")).getText());
		//}
		
		System.out.println(table.findElement(By.xpath("//tr[3]")).getText());
	}
}
