package seleniumjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class browserchecking {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sys\\Downloads\\selenium\\geckodriver-v0.36.0-win32\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

        WebDriver driver = new FirefoxDriver(options);
        
        driver.get("https://www.saucedemo.com/v1/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[2]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        System.out.println(driver.getTitle());

        // ✅ Click "Add to cart" button
       driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button")).click();
       System.out.println("added");
        
        
        
    }
}
