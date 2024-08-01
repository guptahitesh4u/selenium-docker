package com.seledoc.tests;

import com.google.common.util.concurrent.Uninterruptibles;
import com.seledoc.listener.TestListener;
import com.seledoc.util.Constants;
import com.seledoc.util.config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
@Listeners({TestListener.class})
public abstract class AbstractTest {
    private static final Logger log= LoggerFactory.getLogger(AbstractTest.class);
protected WebDriver driver;
@BeforeSuite
public void setupConfig(){
    log.info("Before Suite - Setup COnfig Method called");
    config.initialize();
}
    @BeforeTest
       public void setDriver(ITestContext ctx)  throws MalformedURLException{
        log.info("value of the grid.enabled property: {}, and boolean operation says",
                config.get(Constants.GRID_ENABLED), Boolean.parseBoolean(config.get(Constants.GRID_ENABLED)));
        this.driver=Boolean.parseBoolean(config.get(Constants.GRID_ENABLED)) ? getRemoteDriver() : getLocalDriver();
        ctx.setAttribute(Constants.DRIVER,this.driver);
    }

    private WebDriver getRemoteDriver() throws MalformedURLException {
        Capabilities capabilities = new ChromeOptions();
        if(Constants.FIREFOX.equalsIgnoreCase(config.get(Constants.BROWSER))){
            capabilities=new FirefoxOptions();
        }
        String urlFormat= config.get(Constants.GRID_URL_FORMAT);
        String hubHost= config.get(Constants.GRID_HUB_HOST);
        String url=String.format(urlFormat,hubHost);

        log.info("grid url: {}", url);
        System.out.println("sending you to remote");
        return new RemoteWebDriver(new URL(url),capabilities);
    }
  private WebDriver getLocalDriver(){
    System.out.println("giving you the local browser");
      WebDriverManager.chromedriver().setup();
     return new ChromeDriver();
  }
  @AfterTest
    public void afterTest(){
        this.driver.quit();
  }

  @AfterMethod
    public void sleep(){
      Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
  }
}
