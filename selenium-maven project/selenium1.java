package sp.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class selenium1 {
	WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		
		driver.get("https://www.saucedemo.com/v1/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[2]")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		System.out.println(driver.getTitle());  
		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button")).click();
	    System.out.println("product added");
		driver.close();  
		
			
	}

}
