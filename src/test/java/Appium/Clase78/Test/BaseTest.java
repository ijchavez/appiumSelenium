package Android.Appium.Clase78.Test;

import Android.Appium.BasePage.BasePage;
import Android.Appium.Utilities.Constants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest extends BasePage {

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc = getDesiredCapabilities(Constants.ANDROID_DEVICE, Constants.ANDROID_12_VERSION, Constants.AIRBNB_APP_PACKAGE,
                        Constants.AIRBNB_APP_PACKAGE + Constants.AIRBNB_APP_ACTIVITY, Constants.ANDROID_DEVICE_NAME);
        driver = this.instanciateAppium(Constants.APPIUM_URL, dc);

        PageFactory.initElements(driver, this);
        this.implicitWait(driver, 15);

        landingPage = startTest();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.closeApp();

    }
    public AndroidDriver instanciateAppium(String anAppiumServerUrl, DesiredCapabilities aDesiredCapabilities) throws MalformedURLException {
        AndroidDriver dvr = new AndroidDriver(new URL(anAppiumServerUrl), aDesiredCapabilities);

        return dvr;

    }
    public void implicitWait (WebDriver aWebDriver, int timeMeasure){
        aWebDriver.manage().timeouts().implicitlyWait(timeMeasure, TimeUnit.SECONDS);

    }

}
