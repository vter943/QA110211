package qa11.n0211;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void logOut() {
        click(By.xpath("//app-navigator/div[1]/a[5]"));
    }

    public boolean userLoggedIn() {
        return isElementPresent1(By.xpath("//a[contains(text(),'Logout')]"));
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }

    public void logIn() {
        clickLoginTab();

        fillLoginForm(new User()
                .setEmail("vitter2@mail.ru")
                .setPassword("Antwort455"));
        submit();
        click(By.xpath("//button[contains(text(),'Ok')]"));
    }

    public void logInRegisteredUser() {
        clickLoginTab();
        fillLoginForm(new User()
                .setEmail("vitter2@mail.ru")
                .setPassword("Antwort455"));
        submit();
        click(By.xpath("//button[contains(text(),'Ok')]"));
        Assert.assertTrue(isLogoutButtonPresent());
    }

    public void clickRegistrationButtons() {
        click(By.xpath("//div[@class='checkbox-container']"));
        click(By.xpath("//app-registration/form/button"));
        click(By.xpath("//button[contains(text(),'Ok')]"));
        Assert.assertTrue(isLogoutButtonPresent());
    }


    public boolean isLogoutButtonPresent() {
        isElementPresent2(By.xpath("//a[contains(text(),'Logout')]"));
        return true;
    }

    public void clickLoginTab() {
        click(By.xpath("//app-navigator/div[1]/a[6][contains(text(),'Log in')]"));
    }

}
