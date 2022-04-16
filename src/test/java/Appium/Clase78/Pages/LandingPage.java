package Android.Appium.Clase78.Pages;

import Android.Appium.BasePage.BasePage;
import Android.Appium.Utilities.Constants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LandingPage extends BasePage {
    public LandingPage(AndroidDriver remoteDriver){
        driver = remoteDriver;
        initElements();

    }
    @FindBy(className = Constants.ANDROID_WIDGET_BUTTON)
    List<WebElement> buttonList;
    public LoginPage clickOnEmailBtn(){
        WebElement emailBtn = getAWebElementFromList(buttonList, 1);
        emailBtn.click();

        loginPage = new LoginPage(driver);
        return loginPage;

    }
}
