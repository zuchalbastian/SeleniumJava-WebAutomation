package com.seleniumjava.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationData {

    WebDriver driver;
    //contains element and function
    public CheckoutInformationData(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //element
    @FindBy(id = "first-name")
    WebElement userFirstName;

    @FindBy(id = "last-name")
    WebElement userLastName;

    @FindBy(xpath = "//input[@placeholder='Zip/Postal Code']")
    WebElement userPostalCode;

    @FindBy(css = "input#continue")
    WebElement buttonContinue;

    public void informationDataUser(String firstname, String lastname, String postal_code){
        userFirstName.sendKeys(firstname);
        userLastName.sendKeys(lastname);
        userPostalCode.sendKeys(postal_code);

        buttonContinue.click();
    }

}
