package qa11.n0211;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase {

    @Test

    public void letTheCatWorkTest() {
        wd.findElement(By.xpath("//*[@id='1']")).click();

        isElPres1();

    }
////body/app-root[1]/app-navigator[1]//app-terms-of-use[1]/div[1]

    @Test
    public void termsOfUseTest() {
        wd.findElement(By.xpath("//*[@id='2']")).click();

        isElpres2(By.cssSelector(".terms-container"));
    }


    @Test
    public void loginButtonTest() {
        wd.findElement(By.xpath("//app-navigator/div[1]/a[6]")).click();
        isElpres2(By.xpath("//app-login-registration/././div"));

    }

    public boolean isElpres2(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            ;
            return false;

        }
    }

    public boolean isElPres1() {
        return wd.findElements(By.xpath("//*[@class='search-container']")).size() > 0;
    }
}




