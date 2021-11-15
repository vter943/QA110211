package qa11.n0211;

import netscape.security.UserDialogHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper user;
    CarHelper car;
    HeaderHelper header;

    public UserHelper getUser() {
        return user;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    public CarHelper getCar() {
        return car;
    }




    public void init() {
        wd = new ChromeDriver();
        user = new UserHelper(wd);
        car = new CarHelper(wd);
        header=new HeaderHelper(wd);
        wd.get("https://ilcarro.xyz/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    public void stop() {
        wd.quit();
    }


}
