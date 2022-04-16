package Android.Appium.Clase78.Pages;

import Android.Appium.BasePage.BasePage;
import Android.Appium.Utilities.Constants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage {
    public LoginPage(AndroidDriver remoteDriver){
        driver = remoteDriver;
        initElements();

    }
    @FindBy(className = Constants.ANDROID_WIDGET_BUTTON)
    List<WebElement> buttonList;
    public RegistrationPage clickOnContinueToRegPage(){
        WebElement continueBtn = getAWebElementFromList(buttonList, 0);
        continueBtn.click();

        registrationPage = new RegistrationPage(driver);
        return registrationPage;

    }

}
