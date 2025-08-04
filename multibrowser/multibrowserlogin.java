package seleniumjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
public class multibrowserlogin {

    public static void main(String[] args) throws InterruptedException {
        String[] browsers = {"chrome", "firefox","Edge"};

        for (String browser : browsers) {
            WebDriver driver = null;

            // Set browser driver paths
            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sys\\Downloads\\selenium"
                    		+ "\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    System.setProperty("webdriver.firefox.driver", "C:\\Users\\Sys\\Downloads\\selenium\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                    
                case "edge":
                    System.setProperty("webdriver.edge.driver", "C:\\Users\\Sys\\Downloads\\selenium\\edgedriver_win64\\msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;
                
                default:
                    System.out.println("Unsupported browser: " + browser);
                    continue;
            }

            try {
                System.out.println("Running test on: " + browser.toUpperCase());

                driver.manage().window().maximize();
                driver.get("https://www.saucedemo.com/");

                // Login
                driver.findElement(By.id("user-name")).sendKeys("standard_user");
                driver.findElement(By.id("password")).sendKeys("secret_sauce");
                driver.findElement(By.id("login-button")).click();

                // Wait for inventory to load
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item")));

                // Add Sauce Labs Backpack
                WebElement addBackpack = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button"));
                addBackpack.click();
                System.out.println("Product added to cart successfully in " + browser.toUpperCase());

            } catch (Exception e) {
                System.out.println("Test failed in " + browser.toUpperCase() + ": " + e.getMessage());
            } finally {
            //	driver.get("https://www.flipkart.com/");
                Thread.sleep(200); // small pause to see result
                driver.quit();
            }
        }
    }
}
