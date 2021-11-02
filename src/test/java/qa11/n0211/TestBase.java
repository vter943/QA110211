package qa11.n0211;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.get("https://ilcarro.xyz/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public boolean isElementPresent1(By locator){
        return wd.findElements(locator).size()>0;
    }

    public boolean isElementPresent2(By locator) {
        try {
            wd.findElement(locator);
            return true;
        }
        catch (NoSuchElementException ex) {
            return false;
        }
    }

    @AfterMethod (enabled=false)
    public void tearDown() {
        wd.quit();
    }

    public void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isLogoutButtonPresent(){
        isElementPresent2(By.xpath("//a[contains(text(),'Logout')]"));
        return true;
    }

    public void submit() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void logOut() {
        click(By.xpath("//app-navigator/div[1]/a[5]"));
    }

    public boolean userLoggedIn() {
        return isElementPresent1(By.xpath("//app-navigator/div[1]/a[5]"));
    }

    public boolean isSign_upTabPresentinHeader() {
        return isElementPresent1(By.linkText("Sign up"));
    }

    public void clickLoginTab() {
        click(By.xpath("//app-navigator/div[1]/a[6]"));
    }
}
