package com.seledoc.pages.flightreservation;

import com.seledoc.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SelectFlightsPage extends AbstractPage {

    @FindBy(name="departure-flight")
    private List<WebElement> departureFlightOptions;

    @FindBy(id="arrival-flight")
    private List<WebElement> arrivalFlightOptions;

    @FindBy(id="confirm-flight")
    private WebElement confirmFlightButton;

    public SelectFlightsPage(WebDriver driver){
        super(driver);
    }
    @Override
    public boolean isAt(){

        this.wait.until(ExpectedConditions.visibilityOf(this.confirmFlightButton));
        return this.confirmFlightButton.isDisplayed();
    }

    public void selectFlight() {
        int rand = ThreadLocalRandom.current().nextInt(0, departureFlightOptions.size());
        this.departureFlightOptions.get(rand).click();
        this.arrivalFlightOptions.get(rand).click();
    }
    public void confirmFlight(){
        this.confirmFlightButton.click();
    }
}
