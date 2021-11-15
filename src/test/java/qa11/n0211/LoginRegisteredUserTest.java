package qa11.n0211;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginRegisteredUserTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.getUser().userLoggedIn()) {
            app.getUser().logOut();
        }
        app.getUser().clickLoginTab();
    }

    @Test
    public void loginRegisteredUser() {

        app.getUser().logInRegisteredUser();
        app.getUser().logOut();
    }


}

