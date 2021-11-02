package qa11.n0211;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    //user schould be logged out
    //click on signUp Button
    //registration button
    // submit button
    // check login form displayed
    //a[contains(text(),'Logout')]
    //[href='/registration?url=%2Fsearch']
    //signup not present click on logout button

    @BeforeMethod
    public void ensurePreconditions() {
        if (!isSign_upTabPresentinHeader()) {
            logOut();
        }
    }

    @Test

    public void createAccountTest() {
        click(By.linkText("Sign up"));
        Assert.assertTrue(isElementPresent1(By.xpath("//*[@class='login-registration-container']")));

        type(By.cssSelector("#name"), "A7rjhse");

        type(By.cssSelector("#lastName"), "Ak7jphjejasn");

        type(By.cssSelector("#email"), "areja7shk@gmail.com");

        type(By.cssSelector("#password"), "Alko7hsjanD89");

        click(By.xpath("//div[@class='checkbox-container']"));
        click(By.xpath("//app-registration/form/button"));
        click(By.xpath("//button[contains(text(),'Ok')]"));
        Assert.assertTrue(isLogoutButtonPresent());
    }

    //if (!isElementPresent1())) {
    // wd.findElement(By.xpath("a[contains(text(),'Logout')])").click();
}

