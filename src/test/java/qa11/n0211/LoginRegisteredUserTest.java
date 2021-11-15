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

        logInRegisteredUser();
        logOut();
    }


}

