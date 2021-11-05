package qa11.n0211;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCarFormTest extends TestBase {

   @BeforeMethod
    public void ensurePreconditions() {
        if (!userLoggedIn()) {
            fillLoginForm(new User()
                    .setEmail("vitter2@mail.ru")
                    .setPassword("Antwort455"));
            submit();
            click(By.xpath("//button[contains(text(),'Ok')]"));
            isElementPresent2(By.xpath("//*[@id='1']"));
        }
    }

    @Test

    public void addCarFormTest()  {
        fillTheCarForm(new Car()
                .setPickUpPlace("Herzl Street 1, Tel Aviv, Israel")
                .setMake("Skoda")
                .setModel("Q7")
                .setYear("2012")
                .setEngine("v8")
                .setDoors("4")
                .setSeats("5")
                .setAutoclass("S")
                .setFuelConsumption("12")
                .setSerialNumber("35-26-bg")
                .setPrice("250")
                .setDistance("500") );

    }

    public void fillTheCarForm(Car car) {
        click(By.xpath("//a[@id='1']"));
        type(By.cssSelector("#pickUpPlace"), car.getPickUpPlace());
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

}
