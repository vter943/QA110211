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
        if (!isElementPresent1(By.linkText("Sign up"))) {
            wd.findElement(By.xpath("a[contains(text(),'Logout')])")).click();
        }
    }

    @Test

    public void createAccountTest() {
        wd.findElement(By.linkText("Sign up")).click();
        Assert.assertTrue(isElementPresent1(By.xpath("//*[@class='login-registration-container']")));

        wd.findElement(By.cssSelector("#name")).click();
        wd.findElement(By.cssSelector("#name")).clear();
        wd.findElement(By.cssSelector("#name")).sendKeys("Arik");

        wd.findElement(By.cssSelector("#lastName")).click();
        wd.findElement(By.cssSelector("#lastName")).clear();
        wd.findElement(By.cssSelector("#lastName")).sendKeys("Akopjan");

        wd.findElement(By.cssSelector("#email")).click();
        wd.findElement(By.cssSelector("#email")).clear();
        wd.findElement(By.cssSelector("#email")).sendKeys("ara@gmail.com");

        wd.findElement(By.cssSelector("#password")).click();
        wd.findElement(By.cssSelector("#password")).clear();
        wd.findElement(By.cssSelector("#password")).sendKeys("AkopjanZ89");

        wd.findElement(By.xpath("//div[@class='checkbox-container']")).click();

    }

    //if (!isElementPresent1())) {
    // wd.findElement(By.xpath("a[contains(text(),'Logout')])").click();
}

