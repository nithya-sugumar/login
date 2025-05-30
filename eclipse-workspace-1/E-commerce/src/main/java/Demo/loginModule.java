package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class loginModule{
	public static void main(String args[]) {
		System.out.println("this is output");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nithya\\eclipse-workspace-1\\Demo\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.get("https://www.flipkart.com/");
		
		WebElement sear = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		sear.sendKeys("vivo T4x 5G (Pronto Purple, 128 GB)");
		sear.sendKeys(Keys.ENTER);

		// Wait for product list to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_1fQZEK")
				)); // outer container of search items

		// Click the specific product
		WebElement product = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//div[contains(text(),'vivo T4x 5G (Pronto Purple, 128 GB)')]")));
		product.click();
		
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
	}
}
        
