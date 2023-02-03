package TestCases;

import com.relevantcodes.extentreports.LogStatus;
import org.example.pages.P01_LoginPage;
import org.example.pages.P02_BalancePage;
import org.example.pages.P03_PaymentPage;
import org.example.pages.PageBases;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC01_CheckLogin_P extends TestBases {

    P02_BalancePage balancePage;

    P03_PaymentPage paymentPage;

    @Test(priority = 2)
    public void CheckPayement() throws InterruptedException  {

        balancePage = new P02_BalancePage(driver);
        paymentPage = new P03_PaymentPage(driver);

        Thread.sleep(2000);
        // step 1 click payment
        paymentPage.makePayment.click();

        Thread.sleep(3000);
        // step 2 fill phone number
        balancePage.phone.sendKeys("999888777");
        // step 3 fill the name
        balancePage.name.sendKeys("nora");
        // step 4 choes Amount
        balancePage.Amount.click();
        // step 5 click select button to choes the country
        balancePage.select.click();
        Thread.sleep(2000);
        // step 6 choes the country
        balancePage.usa.click();
        // step 7 click send payement
        balancePage.send.click();
        // step 8 click yes button
        balancePage.yes.click();
      //  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        Thread.sleep(2000);
        // step captuer screen shot
        PageBases.captureScreenshot(driver,"After Send Money");
        // step 9 click logout button
        balancePage.Logout.click();


        Thread.sleep(3000);

    }


}
