import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkout {
    public static void main(String[] args) throws InterruptedException {
        //setup driver
        System.setProperty("webdriver.chrome.driver", "D:/Mini Bootcamp Gratis Web Automation/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        //Test Scenario Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");;
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("secret_sauce");;
        
        driver.findElement(By.cssSelector("input.submit-button")).click();

        Thread.sleep(3000);

        driver.quit();

    }
}
