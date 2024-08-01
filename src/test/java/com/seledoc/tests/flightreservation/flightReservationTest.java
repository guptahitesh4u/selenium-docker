package com.seledoc.tests.flightreservation;
import com.seledoc.util.config;
import com.seledoc.pages.flightreservation.*;
import com.seledoc.tests.AbstractTest;
import com.seledoc.tests.flightreservation.model.FlightReservationTestData;
import com.seledoc.util.Constants;
import com.seledoc.util.JsonUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class flightReservationTest extends AbstractTest {

    private FlightReservationTestData testData;

    @BeforeTest
    @Parameters("testDataPath")
            public void setParameters(String testDataPath){
        this.testData= JsonUtil.getTestData(testDataPath,FlightReservationTestData.class);
            }

    @Test
    public void userRegistrationTest(){

        registrationPage regPage=new registrationPage(driver);
        String url=(config.get(Constants.FLIGHT_RESERVATION_URL));
        regPage.goTo(url);
        regPage.enterUserDetails(testData.firstName(),testData.lastName());
        regPage.enterCredentials(testData.email(), testData.password());
        regPage.register();
    }

    @Test(dependsOnMethods = "userRegistrationTest")
    public void registrationConfirmationTest(){
        RegistrationConfirmation regconfirmPage=new RegistrationConfirmation(driver);
        Assert.assertTrue(regconfirmPage.isAt());
        regconfirmPage.GotoflightSearch();
    }

    @Test(dependsOnMethods = "registrationConfirmationTest")
    public void flightSearchTest(){
        FlightSearchPage flightsearchpage=new FlightSearchPage(driver);
        Assert.assertTrue(flightsearchpage.isAt());
        flightsearchpage.selectPassenger(testData.noOfPassengers());
        flightsearchpage.searchFlights();
    }

    @Test(dependsOnMethods = "flightSearchTest")
    public void flightSelectionTest(){
        SelectFlightsPage selectFlight=new SelectFlightsPage(driver);
        Assert.assertTrue(selectFlight.isAt());
        selectFlight.selectFlight();
        selectFlight.confirmFlight();
    }
    @Test(dependsOnMethods = "flightSelectionTest" )
    public void flightConfirmationTest(){
        FlightConfirmationPage flightconfirmationpage=new FlightConfirmationPage(driver);
        Assert.assertTrue(flightconfirmationpage.isAt());
        Assert.assertEquals(flightconfirmationpage.getPrice(),testData.price());
    }

}
