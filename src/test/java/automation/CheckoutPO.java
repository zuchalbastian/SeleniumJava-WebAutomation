package automation;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniumjava.pageobjects.CheckoutInformationData;
import com.seleniumjava.pageobjects.Login;
import com.seleniumjava.pageobjects.ProductList;

public class CheckoutPO {
    
    @Test(dataProvider = "getData")
    public void checkoutProduct(HashMap<String, String>inputMap) throws InterruptedException {
        //setup driver
        System.setProperty("webdriver.chrome.driver", "D:/Mini Bootcamp Gratis Web Automation/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    
        driver.manage().window().maximize();
    
        driver.get("https://www.saucedemo.com/");
    
        Login login = new Login(driver);
        // System.out.println("ini " + inputMap.get("email"));
        login.loginApplication(inputMap.get("email"), inputMap.get("password"));

        //Test Scenario Add Product
        Thread.sleep(1000);

        String productName = inputMap.get("productName");
        
        ProductList productList = new ProductList(driver);

        productList.addProduct(productName);

        Thread.sleep(1000);

        //Test Scenario Checkout
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@id='checkout'][@name='checkout']")).click();

        Thread.sleep(1000);

        CheckoutInformationData checkoutInformationData = new CheckoutInformationData(driver);

        checkoutInformationData.informationDataUser("Jordan", "Elijah", "820-0704");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@name='finish']")).click();

        Thread.sleep(1000);

        // Scenario confirmation page

        String confirmationPage = driver.findElement(By.cssSelector(".complete-header")).getText();

        Assert.assertTrue(confirmationPage.equals("Thank you for your order!"));


        driver.quit();  

    }

    @DataProvider(name = "getData")
    public Object[][] getData(){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("email", "standard_user");
        map.put("password", "secret_sauce");
        map.put("productName", "Sauce Labs Bolt T-Shirt");

        return new Object[][] {{map}};
    }
}
