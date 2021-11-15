package qa11.n0211;

import org.openqa.selenium.By;
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
        if (!app.getHeader().isSign_upTabPresentinHeader()) {
            app.getUser().logOut();
        }
    }

    @Test
    public void createAccountTest() {
        app.getHeader().openSignUpFormFromHeader();

        fillSignUpForm(new User()
                .setName("A9gggach")
                .setLastname("Aggg5uhnach")
                .setEmail("arwtgggch9@gmail.com")
                .setPassword("Algggch9kk999"));

        app.getUser().clickRegistrationButtons();
    }

    public void fillSignUpForm(User user) {
        app.getUser().type(By.cssSelector("#name"), user.getName());
        app.getUser().type(By.cssSelector("#lastName"), user.getLastname());
        app.getUser().type(By.cssSelector("#email"), user.getEmail());
        app.getUser().type(By.cssSelector("#password"), user.getPassword());
    }

    //if (!isElementPresent1())) {
    // wd.findElement(By.xpath("a[contains(text(),'Logout')])").click();
}

