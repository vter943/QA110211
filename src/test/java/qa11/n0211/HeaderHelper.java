package qa11.n0211;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class HeaderHelper extends HelperBase{


    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isSign_upTabPresentinHeader() {
        return isElementPresent1(By.linkText("Sign up"));
    }



    public void openSignUpFormFromHeader() {
        click(By.linkText("Sign up"));
        Assert.assertTrue(isElementPresent1(By.xpath("//*[@class='login-registration-container']")));
    }

    public void openAddCarFormFromHeader() {
        click(By.xpath("//a[@id='1']"));
    }



}
