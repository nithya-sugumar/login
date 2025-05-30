package demoPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class DemoPackage {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nithya\\eclipse-workspace-1\\Demo\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            long startTime = System.currentTimeMillis(); // Start time

            driver.get("https://www.flipkart.com/");

            // Wait for a visible element that confirms the page is loaded
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[title='Search for Products, Brands and More']")));

            long endTime = System.currentTimeMillis(); // End time

            long loadTime = endTime - startTime;

            System.out.println("Page Load Time: " + loadTime + " milliseconds");

            if (loadTime <= 2000) {
                System.out.println("✅ Page loaded within 2 seconds.");
            } else {
                System.out.println("❌ Page took more than 2 seconds to load.");
            }

        } finally {
            driver.quit();
        }
    }
}
