package com.seledoc.pages.flightreservation;

import com.seledoc.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class registrationPage extends AbstractPage {




    public void setBtnRegister(WebElement btnRegister) {
        this.btnRegister = btnRegister;
    }

    @FindBy(id="firstName")
    private WebElement txtfirstName;
    @FindBy(id="lastName")
    private WebElement txtlastName;
    @FindBy(id="email")
    private WebElement txtemail;
    @FindBy(id="password")
    private WebElement txtpassword;
    @FindBy(id="register-btn")
    private WebElement btnRegister;

    public registrationPage(WebDriver driver){
       super(driver);
    }
    @Override
    public boolean isAt(){
        this.wait.until(ExpectedConditions.visibilityOf(this.txtfirstName));
        return this.txtfirstName.isDisplayed();
    }
    public void goTo(String url){
        this.driver.get(url);
    }
    public void enterUserDetails(String fname, String lname){
        this.txtfirstName.sendKeys(fname);
        this.txtlastName.sendKeys(lname);
    }

    public void enterCredentials(String email, String psw){
        this.txtemail.sendKeys(email);
        this.txtpassword.sendKeys(psw);
    }
    public void register(){
        this.btnRegister.click();
    }
}
