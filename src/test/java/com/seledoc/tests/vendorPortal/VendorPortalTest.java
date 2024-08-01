package com.seledoc.tests.vendorPortal;
import com.seledoc.pages.vendorportal.DashboardPage;
import com.seledoc.tests.AbstractTest;
import com.seledoc.util.Constants;
import com.seledoc.util.JsonUtil;
import com.seledoc.util.config;
import com.seledoc.pages.vendorportal.LoginPage;
import io.github.bonigarcia.wdm.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.seledoc.tests.vendorPortal.model.VendorPortalTestData;

public class VendorPortalTest extends AbstractTest {

    private VendorPortalTestData testData;
    private static final Logger log= LoggerFactory.getLogger(VendorPortalTest.class);

     private LoginPage loginpage;
    private DashboardPage dashboardpage;


    String url="https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html";

    @BeforeTest
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath) {
        this.loginpage = new LoginPage(driver);
        this.dashboardpage = new DashboardPage(driver);
        this.testData= JsonUtil.getTestData(testDataPath,VendorPortalTestData.class);

    }
    @Test
    public void loginTest(){
        log.info("the URL we got from the config is: {}",config.get(Constants.VENDOR_PORTAL_URL) );
       loginpage.goTo(config.get(Constants.VENDOR_PORTAL_URL));
        Assert.assertTrue(loginpage.isAt());
        loginpage.login(testData.username(),testData.password());

    }
    @Test(dependsOnMethods = "loginTest")
    public void dashboardTest(){
        Assert.assertTrue(dashboardpage.isAt());
        Assert.assertEquals(dashboardpage.getMonthlyEarning(),testData.monthlyEarning());
        dashboardpage.searchOrderHistory(testData.searchText());
        Assert.assertEquals(dashboardpage.getSearchResultCount(),testData.searchResultCount());

        dashboardpage.LogOut();

    }
}
