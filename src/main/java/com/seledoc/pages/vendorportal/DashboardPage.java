package com.seledoc.pages.vendorportal;

import com.seledoc.pages.AbstractPage;
import com.seledoc.pages.flightreservation.FlightConfirmationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPage extends AbstractPage {

    private static final Logger log=LoggerFactory.getLogger(DashboardPage.class);
    @FindBy(id="monthly-earning")
       private WebElement monthlyEarning;

    @FindBy(id="annual-earning")
    private WebElement annualEarning;
    @FindBy(id="profit-margin")
    private WebElement profitMargin;

    @FindBy(id="available-inventory")
    private WebElement availableInventory;

    @FindBy(css="#dataTable_filter input")
    private WebElement searchField;

    public DashboardPage(WebDriver driver){
        super(driver);
    }


    @FindBy(id="dataTable_info")
    private WebElement searchResultCounts;
    @FindBy(css="img.img-profile")
    private WebElement userProfilePic;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(css = "#logoutModal a")
    private WebElement modalLogoutLink;

    @Override
    public boolean isAt(){
        this.wait.until(ExpectedConditions.visibilityOf(this.monthlyEarning));
        return this.monthlyEarning.isDisplayed();
    }

    public String getMonthlyEarning(){
        return this.monthlyEarning.getText();
    }


    public String getAnnualEarning(){
        return this.annualEarning.getText();
    }

    public String getProfitMargin(){
        return this.profitMargin.getText();
    }


    public String getAvailableInventory(){
        return this.availableInventory.getText();
    }

    public void searchOrderHistory(String SearchText){
        this.searchField.sendKeys(SearchText);
    }

    public int getSearchResultCount(){
        String resultText=this.searchResultCounts.getText();
        String[] arr=resultText.split(" ");
        int count=Integer.parseInt(arr[5]);
        log.info("Results count: {}", count);
        return count;
    }
    public void LogOut(){
        this.userProfilePic.click();
        this.logoutLink.click();
        this.modalLogoutLink.click();
    }
}
