package com.seleniumjava.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductList {
    
    WebDriver driver;
    WebElement cardElement = null;

    //contains element and function
    public ProductList(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //element
    @FindBy(css = ".inventory_item")
    List<WebElement> listProducts;

    @FindBy(css = ".inventory_item_name")
    WebElement productsName;

    By addButton = By.cssSelector(".btn.btn_primary.btn_small.btn_inventory");

    public void addProduct(String productName){
         for (WebElement webElement : listProducts) {
            String product = webElement.findElement(By.cssSelector(".inventory_item_name")).getText();
            // System.out.println("ini adalah product " + product);
            if (product.equals(productName)) {
                cardElement = webElement;
                break;
            }
        }

        cardElement.findElement(addButton).click();
    }
}
