package Android.Appium.Clase6;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class airbnbGlobalVariables {
    public airbnbGlobalVariables(){

    }
    public List<WebElement> enabledButtonList = new ArrayList<WebElement>();
    public List<WebElement> disabledButtonList = new ArrayList<WebElement>();

    public WebElement continueBtn;
    public WebElement loginWithMail;
    public WebElement email;
    public WebElement continueButtonInLoginWithEmail;

    public List<WebElement> editTextList;

    public WebElement emailField;
    public String fakerEmail = "";

}
