package Android.Appium.BasePage;

import Android.Appium.Clase6.FakerClass;
import Android.Appium.Clase6.airbnbGlobalVariables;
import Android.Appium.Clase78.Pages.LandingPage;
import Android.Appium.Clase78.Pages.LoginPage;
import Android.Appium.Clase78.Pages.RegistrationPage;
import Android.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
    protected airbnbGlobalVariables airbnbGV = new airbnbGlobalVariables();
    public LandingPage landingPage;
    public LoginPage loginPage;
    public RegistrationPage registrationPage;

    public LandingPage startTest(){
        LandingPage lap = new LandingPage(driver);
        return lap;

    }
    public void initElements(){
        PageFactory.initElements(driver, this);

    }
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
        List<WebElement> listToReturn = driver.findElements(By.className(aLocator));
        return listToReturn;

    }
    @FindBy(className = Android.Appium.Utilities.Constants.ANDROID_WIDGET_TEXTVIEW)
    List<WebElement> androidWidgetTextView;
    public List<WebElement> getAndroidWidgetTextView(){
        return androidWidgetTextView;

    }
    @FindBy(className = Android.Appium.Utilities.Constants.ANDROID_WIDGET_BUTTON)
    List<WebElement> androidWidgetButton;
    public List<WebElement> getAndroidWidgetButton(){
        return androidWidgetButton;

    }
    public WebElement getElementByClassName(String aLocator){
        return driver.findElement(By.className(aLocator));

    }
    @FindBy(className = Android.Appium.Utilities.Constants.ANDROID_WIDGET_EDITTEXT)
    WebElement androidWidgetEditText;
    public WebElement getAndroidWidgetEditText(){
        return androidWidgetEditText;

    }
    public WebElement getElementByAccessibilityId(String aLocator){
        return driver.findElementByAccessibilityId(aLocator);

    }
    public List<WebElement> getListOfWebElementsById(String aLocator){
        List<WebElement> listToReturn = driver.findElements(By.id(aLocator));

        this.waitForAListOfWebElementsToFullyLoad(listToReturn, 30, 3);
        Assert.assertFalse(listToReturn.isEmpty());
        return listToReturn;

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
    public void waitForAWebElementToHaveCertainText(WebElement anElement, String aTextToWait, int aWithTimeOut, int aPollingEvery){
        wait = getWaitElement(aWithTimeOut, aPollingEvery);
        wait.until(ExpectedConditions.textToBePresentInElement(anElement, aTextToWait));

    }
    public void waitForAWebElementToBeClickable(WebElement anElement, int aWithTimeOut, int aPollingEvery){
        wait = getWaitElement(aWithTimeOut, aPollingEvery);
        wait.until(ExpectedConditions.elementToBeClickable(anElement));

    }
    public void waitForAListOfWebElementsToFullyLoad(List<WebElement> aListOfWebElements, int aWithTimeOut, int aPollingEvery){
        wait = getWaitElement(aWithTimeOut, aPollingEvery);
        wait.until(ExpectedConditions.visibilityOfAllElements(aListOfWebElements));

    }
    public void waitForAWebElementToFullyLoad(WebElement aWebElement, int aWithTimeOut, int aPollingEvery){
        wait = getWaitElement(aWithTimeOut, aPollingEvery);
        wait.until(ExpectedConditions.visibilityOf(aWebElement));

    }
    public void sendKeysToAWebElement(WebElement anElement, String aKeysToSend){
        anElement.sendKeys(aKeysToSend
        );
    }
    public boolean isWebElementEnabled(WebElement aWebElement){
        boolean isEnabled = aWebElement.isEnabled();
        return isEnabled;

    }
    public boolean isWebElementDisplayed(WebElement aWebElement){
        boolean isDisplayed = aWebElement.isDisplayed();
        return isDisplayed;

    }
    public WebElement getAWebElementFromList(List<WebElement> aListOfWebElements, int pos){
        WebElement aWebElement = aListOfWebElements.get(pos);
        return aWebElement;

    }
    protected List<WebElement> textViewList;
    protected List<WebElement> buttonList;

}
