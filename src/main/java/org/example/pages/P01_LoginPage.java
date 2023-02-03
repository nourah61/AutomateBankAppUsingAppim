package org.example.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class P01_LoginPage {

    public P01_LoginPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/usernameTextField")
    public WebElement username;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/passwordTextField")
    public WebElement password;

    // xpath to Toast message
    @AndroidFindBy(xpath = "//android.widget.Button[@index='3']")
    public WebElement Loginbutton;







}