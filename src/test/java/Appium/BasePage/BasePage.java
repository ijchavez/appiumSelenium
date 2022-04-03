package Android.Appium.BasePage;

import Android.Appium.Clase6.FakerClass;
import Android.Appium.Clase6.airbnbGlobalVariables;
import Android.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {
    public static AndroidDriver driver;

    public String appiumServerURL = Constants.APPIUM_URL;

    public DesiredCapabilities dc = new DesiredCapabilities();
    public DesiredCapabilities getDesiredCapabilities(String anAndroidDevice, String anAndroidVersion, String anAppPackage,
                                                      String anAppActivity, String aDeviceName){
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, anAndroidDevice); //"Android"
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, anAndroidVersion);//version de android q tengas
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, anAppPackage);
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, anAppActivity);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, aDeviceName);//el nombre de tu disp va aca
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,Constants.AUTOMATION_NAME);
        dc.setCapability(Constants.SHOW_CHROMEDRIVER_LOG,true);

        return dc;

    }
    public FakerClass fkr = new FakerClass();

    public List<WebElement> getElementsByClassName(String aLocator){
        return driver.findElements(By.className(aLocator));

    }
    public WebElement getElementByClassName(String aLocator){
        return driver.findElement(By.className(aLocator));

    }
    public WebElement getElementByAccessibilityId(String aLocator){
        return driver.findElementByAccessibilityId(aLocator);

    }
    public List<WebElement> getListOfWebElementsById(String aLocator){
        Assert.assertFalse(driver.findElements(By.id(aLocator)).isEmpty());
        return driver.findElements(By.id(aLocator));

    }
    public WebElement getAWebElementById(String aLocator){
        return driver.findElement(By.id(aLocator));

    }
    public boolean textIsPresentOnList(List<WebElement> aListOfWebElements, String aTextToBePresent){
        for(WebElement textViewEl : aListOfWebElements){
            if(textViewEl.getText().contains(aTextToBePresent)){
                return true;

            }

        }
        return false;

    }
    public void printAListOfWebElements(List<WebElement> aListOfWebElements){
        for(WebElement textViewEl : aListOfWebElements){
            System.out.println(textViewEl.getText());

        }
        System.out.println(aListOfWebElements.size());

    }
    public List<String> getAnAttributeFromAListOfWebElements(List<WebElement> aListOfWebElements, String anAttribute){
        List<String> aListOfStrings = new ArrayList<>();

        for(WebElement el : aListOfWebElements){
            String elAttr = el.getAttribute(anAttribute);
            if(elAttr != null){
                System.out.println(elAttr);
                aListOfStrings.add(elAttr);

            }

        }
        return aListOfStrings;

    }
    public String getAttributeValueFromAWebElement(WebElement aWebElement, String anAttribute){
        String attributeToReturn = aWebElement.getAttribute(anAttribute);
        return attributeToReturn;

    }
    public List<String> getTextFromAListOfWebElements(List<WebElement> aListOfWebElements){
        List<String> aListOfStrings = new ArrayList<>();

        for(WebElement el : aListOfWebElements){
            String elText= el.getText();
            aListOfStrings.add(elText);

        }
        return aListOfStrings;

    }
    public String getTextFromAWebElement(WebElement aWebElement){
        String aWebElementText = aWebElement.getText();
        return aWebElementText;

    }
    Wait<WebDriver> wait;
    public Wait<WebDriver> getWaitElement(int aWithTimeOut, int aPollingEvery){
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(aWithTimeOut))
                .pollingEvery(Duration.ofSeconds(aPollingEvery))
                .ignoring(NoSuchElementException.class);

        return wait;

    }
    public void waitForAWebElementToHaveCertainText(WebElement anElement, String aTextToWait){
        wait = getWaitElement(30, 3);
        wait.until(ExpectedConditions.textToBePresentInElement(anElement, aTextToWait));

    }
    public void waitForAWebElementToBeClickable(WebElement anElement){
        wait = getWaitElement(30, 3);
        wait.until(ExpectedConditions.elementToBeClickable(anElement));

    }
    protected airbnbGlobalVariables airbnbGV = new airbnbGlobalVariables();
    protected List<WebElement> textViewList;
    protected List<WebElement> buttonList;

}
