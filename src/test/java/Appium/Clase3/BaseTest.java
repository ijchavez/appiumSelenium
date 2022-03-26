package Android.Appium.Clase3;

import Android.Appium.BasePage.BasePage;
import Android.Appium.Utilities.Constants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest extends BasePage {

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc = getDesiredCapabilities(Constants.ANDROID_DEVICE, Constants.ANDROID_12_VERSION,
                        Constants.API_DEMOS_APP_PACKAGE,
                        Constants.API_DEMOS_APP_PACKAGE + Constants.API_DEMOS_APP_ACTIVITY,
                                    Constants.ANDROID_DEVICE_NAME);

        driver = new AndroidDriver(new URL(appiumServerURL), dc);

        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.closeApp();

    }

}
