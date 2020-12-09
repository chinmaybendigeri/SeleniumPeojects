import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Tables {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/32073/nza-vs-wi-3-day-practice-match-west-indies-tour-of-new-zealand-2020");

		Thread.sleep(3000);

		WebElement table = driver
				.findElement(By.cssSelector("div[id='innings_1'] div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));

		int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();
		int sumOfRuns = 0;
		int individualRuns = 0;

		for (int i = 0; i < count - 3; i++) {
			individualRuns = Integer.parseInt(
					table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"))
							.get(i).getText());
			sumOfRuns = sumOfRuns + individualRuns;
		}
		int extraRuns = Integer.parseInt(
				table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(2)"))
						.get(count - 3).getText()); // or you can use sibling concepts //*[@attribute=''value]/following-sibling::tagname ---> find xpath for Extras text and from there traverse to its immediate sibling

		System.out.println(sumOfRuns);

		int total = Integer.parseInt(
				table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(2)"))
						.get(count - 2).getText());

		System.out.println(total);

		Assert.assertEquals(sumOfRuns, total, "Not Equal");

	}

}
