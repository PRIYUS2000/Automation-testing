package seleniumjava;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;

public class browserchoice {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the browser you want to use (chrome / firefox / edge):");
        String browser = scanner.nextLine().trim().toLowerCase();

        WebDriver driver = null;

        switch (browser) {
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
                return;
        }

        // Test starts
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item")));

        // Add Sauce Labs Backpack
        WebElement addBackpack = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button"));
        addBackpack.click();
        System.out.println("Product added to cart successfully in " + browser.toUpperCase());

    	
    }
}


