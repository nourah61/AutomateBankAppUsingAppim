package TestCases;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.org.apache.bcel.internal.generic.BALOAD;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.example.capabilities.Capabilities;
import org.example.pages.P01_LoginPage;
import org.example.pages.P02_BalancePage;
import org.example.pages.P03_PaymentPage;
import org.example.pages.PageBases;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestBases extends Capabilities {
    static AndroidDriver<AndroidElement> driver;
    P01_LoginPage loginPage;
    P02_BalancePage balancePage;
    // extend report
    protected static ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"/BankTestReport.html");
    protected static ExtentTest test = report.startTest("Bank App");

    @BeforeTest
    public void setupDriver() throws IOException {
        // TODO start application with appium
        driver = baseCapabilities("AppName");


    }

    @Test(priority = 1)
    public void CheckLogin() throws InterruptedException {
        loginPage = new P01_LoginPage(driver); // create object
        balancePage = new P02_BalancePage(driver);
        Thread.sleep(5000);



            // step 1: Enter username
            loginPage.username.sendKeys(PageBases.getExcelData(1, 0, "Sheet1"));

            // step 2: Enter password
            loginPage.password.sendKeys(PageBases.getExcelData(1, 1, "Sheet1"));

            // Take screenshot before click login button
            PageBases.captureScreenshot(driver, "loginpage");

            // step 3: click loginbutton
            loginPage.Loginbutton.click();



            //Assert if login successfully
            Assert.assertEquals("Make Payment", balancePage.makePayment.getText());

            // Take screenshot after click login button
            PageBases.captureScreenshot(driver, "Balancepage");




    }

    @AfterMethod
    public void getresult(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE)
            test.log(LogStatus.FAIL,result.getName()+" test fail with folowing error "+result.getThrowable());
        else if(result.getStatus() == ITestResult.SUCCESS)
            test.log(LogStatus.PASS,result.getName());

    }



        @AfterClass
    public void TearDown() throws InterruptedException {
        // flush extent report
        report.endTest(test); //end report
        report.flush(); // open the report

        driver.quit();

    }




}
