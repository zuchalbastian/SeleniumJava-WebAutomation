package automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

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

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input.submit-button")).click();

        //Test Scenario Add Product
        Thread.sleep(1000);
        String productName = "Sauce Labs Bolt T-Shirt";
        WebElement cardElement = null;

        List<WebElement>listProducts = driver.findElements(By.cssSelector(".inventory_item"));

        for (WebElement webElement : listProducts) {
            String product = webElement.findElement(By.cssSelector(".inventory_item_name")).getText();
            // System.out.println("ini adalah product " + product);
            if (product.equals(productName)) {
                cardElement = webElement;
                break;
            }
        }

        cardElement.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")).click();

        Thread.sleep(1000);

        //Test Scenario Checkout
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@id='checkout'][@name='checkout']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@type='text'][@id='first-name']")).sendKeys("Alberto");
        driver.findElement(By.id("last-name")).sendKeys("Giround");
        driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).sendKeys("80331");

        driver.findElement(By.cssSelector("input#continue")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@name='finish']")).click();

        Thread.sleep(1000);

        // Scenario confirmation page

        String confirmationPage = driver.findElement(By.cssSelector(".complete-header")).getText();

        Assert.assertTrue(confirmationPage.equals("Thank you for your order!"));

        driver.quit();  

    }
}
