package qa11.n0211;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;

    @BeforeClass
    public void setUp() {
        init();
    }

    public void init() {
        wd = new ChromeDriver();
        wd.get("https://ilcarro.xyz/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public boolean isElementPresent1(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public boolean isElementPresent2(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @AfterClass (enabled = false)
    public void tearDown() {
        stop();
    }

    public void stop() {
        wd.quit();
    }

    public void type(By locator, String text) {
        if (text!= null) {
            wd.findElement(locator).click();
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isLogoutButtonPresent() {
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
        return isElementPresent1(By.xpath("//a[contains(text(),'Logout')]"));
    }

    public boolean isSign_upTabPresentinHeader() {
        return isElementPresent1(By.linkText("Sign up"));
    }

    public void clickLoginTab() {
        click(By.xpath("//app-navigator/div[1]/a[6][contains(text(),'Log in')]"));
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }

    public void logIn(){
        clickLoginTab();

         fillLoginForm(new User()
                 .setEmail("vitter2@mail.ru")
                 .setPassword( "Antwort455"));
         submit();
         click(By.xpath("//button[contains(text(),'Ok')]"));
        }

    public void logInRegisteredUser() {
        clickLoginTab();
        fillLoginForm(new User()
                .setEmail("vitter2@mail.ru")
                .setPassword( "Antwort455"));
        submit();
        click(By.xpath("//button[contains(text(),'Ok')]"));
        Assert.assertTrue(isLogoutButtonPresent());
    }

    public void fillTheCarForm(Car car) {
        click(By.xpath("//a[@id='1']"));
        type(By.cssSelector("#pickUpPlace"), car.getPickUpPlace());

        //click(By.xpath("/html/body/app-root/app-navigator/app-let-car-work/div/form/div[2]"));
        type(By.cssSelector("#make"), car.getMake());
        type(By.cssSelector("#model"), car.getModel());
        type(By.cssSelector("#year"), car.getYear());
        type(By.cssSelector("#engine"), car.getEngine());
        WebElement selectFuel = wd.findElement(By.xpath("//*[@id='fuel']"));
        Select select = new Select(selectFuel);
        select.selectByIndex(1);


        wd.findElement(By.xpath("//*[@id='gear']")).click();
        click(By.xpath("//*[@id='gear']/option[2]"));
        wd.findElement(By.xpath("//*[@id='wheelsDrive']")).click();
        click(By.xpath("//*[@id='wheelsDrive']/option[3]"));


        type(By.cssSelector("#doors"), car.getDoors());
        type(By.cssSelector("#seats"), car.getSeats());
        type(By.cssSelector("#class"), car.getAutoclass());
        type(By.cssSelector("#fuelConsumption"), car.getFuelConsumption());

        type(By.cssSelector("#serialNumber"), car.getSerialNumber());
        type(By.cssSelector("#price"), car.getPrice());
        type(By.cssSelector("#distance"), car.getDistance());
        type(By.xpath("//input[@placeholder='Type feature']"), "Skoda");
        click(By.xpath("//form/div[17]/button"));
        type(By.cssSelector("#about"), "salon-swinina, wsjo na farsche");
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
}

    public void clickRegistrationButtons() {
        click(By.xpath("//div[@class='checkbox-container']"));
        click(By.xpath("//app-registration/form/button"));
        click(By.xpath("//button[contains(text(),'Ok')]"));
        Assert.assertTrue(isLogoutButtonPresent());
    }

    public void openSignUpFormFromHeader() {
        click(By.linkText("Sign up"));
        Assert.assertTrue(isElementPresent1(By.xpath("//*[@class='login-registration-container']")));
    }

    public void openAddCarFormFromHeader() {
        click(By.xpath("//a[@id='1']"));
    }

    public boolean LoginFormPresent() {
        return isElementPresent2(By.xpath("//app-login-registration/././div"));
    }
}
