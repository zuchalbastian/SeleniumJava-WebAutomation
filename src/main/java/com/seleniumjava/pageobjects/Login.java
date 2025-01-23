package com.seleniumjava.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    WebDriver driver;
    //contains element and function
    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //element
    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(xpath = "//input[@type='password']")
    WebElement userPass;

    @FindBy(css = "input.submit-button")
    WebElement loginButton;

    public void loginApplication(String email, String password){
        userName.sendKeys(email);
        userPass.sendKeys(password);

        loginButton.click();
    }

}
