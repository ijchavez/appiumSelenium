package Android.Appium.Clase1;

import Android.Appium.Utilities.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class clockTest {
    public static AndroidDriver driver;

    String appiumServerURL = Constants.APPIUM_URL;
    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Constants.ANDROID_DEVICE); //"Android"
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,Constants.ANDROID_12_VERSION);//version de android q tengas
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Constants.GENERIC_S10_APP_PATH + Constants.CLOCK_APP_PACKAGE);
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Constants.GENERIC_S10_APP_PATH + Constants.CLOCK_APP_PACKAGE + Constants.CLOCK_APP_ACTIVITY);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, Constants.ANDROID_DEVICE_NAME);//el nombre de tu disp va aca
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        dc.setCapability("noReset",true);
        dc.setCapability("showChromedriverLog",true);

        driver = new AndroidDriver(new URL(appiumServerURL), dc);

        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void openClockAndGetActualTimeTest(){
        WebElement worldClock = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Reloj Mundial Ficha 2 de 4\"]/android.widget.RelativeLayout"));
        worldClock.click();

        WebElement localClock = driver.findElement(By.id("com.sec.android.app.clockpackage:id/worldclock_current_local_time"));
        System.out.println(">>> " + localClock.getText());

    }
    @Test
    public void printTextViewTest(){
        WebElement worldClock = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Reloj Mundial Ficha 2 de 4\"]/android.widget.RelativeLayout"));
        worldClock.click();

        List<WebElement> textViewList = driver.findElements(By.className("android.widget.TextView"));
        for(WebElement textViewElement : textViewList){
            System.out.println("--> " + textViewElement.getText());

        }

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.closeApp();

    }

}
