package pri.selenium_saucedemo_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;

import java.net.URL;

public class saucelabauto {
    public static final String USERNAME = "oauth-jackiechan1203jeyu-70650"; // replace
    public static final String ACCESS_KEY = "67e7982e-e7e0-42d1-8d6d-f83e6ca360c3"; // replace
    public static final String URL = "https://oauth-jackiechan1203jeyu-70650:"
    		+ "67e7982e-e7e0-42d1-8d6d-f83e6ca360c3"
    		+ "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "chrome");
        caps.setCapability("browserVersion", "latest");
        caps.setCapability("platformName", "Windows 10");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        
        

        driver.quit();
    }
}
