package qa11.n0211;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class OpenHomePageTest extends TestBase {

    @Test
    public void openHomePageTest() {
       // wd.findElement(By.cssSelector(".search-container"));
        isElementPresent1(By.cssSelector(".search-container"));
        System.out.println("Site is opened, searchbox is here");
    }

}
