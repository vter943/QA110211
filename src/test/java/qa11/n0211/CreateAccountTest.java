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

        fillSignUpForm(new User()
                .setName("A7rghhes")
                .setLastname("Akwasjna")
                .setEmail("arwasjna@gmail.com")
                .setPassword("AlWasjna89"));

        click(By.xpath("//div[@class='checkbox-container']"));
        click(By.xpath("//app-registration/form/button"));
        click(By.xpath("//button[contains(text(),'Ok')]"));
        Assert.assertTrue(isLogoutButtonPresent());
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

