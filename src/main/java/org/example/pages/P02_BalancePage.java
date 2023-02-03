package org.example.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class P02_BalancePage {

    public P02_BalancePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/makePaymentButton")
    public WebElement makePayment;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/phoneTextField")
    public WebElement phone;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/nameTextField")
    public WebElement name;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/amount")
    public WebElement Amount;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/countryButton")
    public WebElement select;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/sendPaymentButton")
    public WebElement send;

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
    public WebElement usa;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement yes;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/logoutButton")
    public WebElement Logout;
}

