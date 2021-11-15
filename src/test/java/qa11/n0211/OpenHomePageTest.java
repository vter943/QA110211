package qa11.n0211;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OpenHomePageTest extends TestBase {

    @Test
    public void openHomePageTest() {
       // wd.findElement(By.cssSelector(".search-container"));
        app.getHeader().isElementPresent1(By.cssSelector(".search-container"));
        System.out.println("Site is opened, searchbox is here");
    }

}
