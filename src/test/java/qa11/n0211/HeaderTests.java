package qa11.n0211;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase {

    @Test

    public void letTheCatWorkTest() {
        click(By.xpath("//*[@id='1']"));

       isElementPresent2(By.xpath("//*[@id='1']"));

    }
////body/app-root[1]/app-navigator[1]//app-terms-of-use[1]/div[1]

    @Test
    public void termsOfUseTest() {
        click(By.xpath("//*[@id='2']"));

        isElementPresent1(By.cssSelector(".terms-container"));
    }


    @Test
    public void loginButtonTest() {
        clickLoginTab();
        LoginFormPresent();

    }

    public boolean LoginFormPresent() {
        return isElementPresent2(By.xpath("//app-login-registration/././div"));
    }


}




