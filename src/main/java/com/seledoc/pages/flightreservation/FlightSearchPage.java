package com.seledoc.pages.flightreservation;

import com.seledoc.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends AbstractPage {

    @FindBy(id="passengers")
    private WebElement passengerSelect;
    @FindBy(id="search-flights")
    private WebElement searchFlightButton;

    public FlightSearchPage(WebDriver driver){
        super(driver);
    }
    @Override
    public boolean isAt(){
        this.wait.until(ExpectedConditions.visibilityOf(this.searchFlightButton));
        return this.searchFlightButton.isDisplayed();
    }
    public void selectPassenger(String PassengerCount){

        Select passengers = new Select(this.passengerSelect);
        passengers.selectByValue(PassengerCount);
    }
    public void searchFlights(){
        this.searchFlightButton.click();
    }
}
