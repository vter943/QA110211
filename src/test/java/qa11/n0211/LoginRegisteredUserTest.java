package qa11.n0211;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginRegisteredUserTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (userLoggedIn()) {
            logOut();
        }
        clickLoginTab();
    }

    @Test
    public void loginRegisteredUser() {

        type(By.cssSelector("#email"), "arjak@gmail.com");
        type(By.cssSelector("#password"), "AkojaanD89");
        submit();
        click(By.xpath("//button[contains(text(),'Ok')]"));
        Assert.assertTrue(isLogoutButtonPresent());
        logOut();
    }


}

