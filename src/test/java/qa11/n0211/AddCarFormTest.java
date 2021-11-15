package qa11.n0211;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCarFormTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getUser().userLoggedIn()) {
            app.getUser().logIn();
            // logInRegisteredUser();
        }
    }

    @Test
    public void addCarFormTest() throws InterruptedException {

        {
            app.getHeader().openAddCarFormFromHeader();
            app.getUser().pause(100);
            app.getCar().fillTheCarForm(new Car()
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
                    .setDistance("500"));
            //logOut();
        }
    }

    @Test
    public void addCarWithoutDoorsTest() {
        app.getHeader().openAddCarFormFromHeader();
        app.getCar().fillTheCarForm(new Car()
                .setPickUpPlace("Herzl Street 2, Tel Aviv, Israel")
                .setMake("Skoda")
                .setModel("Q7")
                .setYear("2012")
                .setEngine("v8")
                .setSeats("5")
                .setAutoclass("S")
                .setFuelConsumption("12")
                .setSerialNumber("35-26-bg")
                .setPrice("250")
                .setDistance("500"));
        // logOut();
    }

}
