package com.seledoc.pages.flightreservation;

import com.seledoc.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmation extends AbstractPage {

    private WebDriver driver;
    @FindBy(id="go-to-flights-search")
    private WebElement btnGoToFlightSearch;

    public RegistrationConfirmation(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt(){
        this.wait.until(ExpectedConditions.visibilityOf(this.btnGoToFlightSearch));
        return this.btnGoToFlightSearch.isDisplayed();
    }
    public void GotoflightSearch(){
        this.btnGoToFlightSearch.click();

    }
}
