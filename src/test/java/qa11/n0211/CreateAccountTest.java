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
        openSignUpFormFromHeader();

        fillSignUpForm(new User()
                .setName("A999kkks")
                .setLastname("A999uhna")
                .setEmail("arwa999@gmail.com")
                .setPassword("AlWaskk999"));

        clickRegistrationButtons();
    }

    public void fillSignUpForm(User user) {
        type(By.cssSelector("#name"), user.getName());
        type(By.cssSelector("#lastName"), user.getLastname());
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }

    //if (!isElementPresent1())) {
    // wd.findElement(By.xpath("a[contains(text(),'Logout')])").click();
}

