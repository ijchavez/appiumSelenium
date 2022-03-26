package Android.Appium.Clase5;

import Android.Appium.Utilities.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FacebookTest extends BaseTest {
    List<WebElement> textViewList;

    WebElement userName;
    WebElement password;
    WebElement loginBtn;

    WebElement noSaveSessionInformation;
    WebElement denyLocationPermission;


    @Test
    public void facebookTest(){
            textViewList = driver.findElements(By.className(Constants.ANDROID_WIDGET_TEXTVIEW));
            for(WebElement el: textViewList){
                System.out.println(el.getText());

            }

    }
    @Test
    public void loginTest() throws InterruptedException {
        userName = getElementByAccessibilityId("Nombre de usuario");
        userName.sendKeys(Constants.FACEBOOK_USERNAME);

        password = getElementByAccessibilityId("Contraseña");
        password.sendKeys(Constants.FACEBOOK_PASSWORD);

        loginBtn = getElementByAccessibilityId("Iniciar sesión");
        loginBtn.click();

        noSaveSessionInformation = getElementByAccessibilityId("Omitir");
        noSaveSessionInformation.click();

        denyLocationPermission = getElementByAccessibilityId("Denegar");
        denyLocationPermission.click();

        WebElement makeAPublishInFb = getElementByAccessibilityId("Haz una publicación en Facebook");

        String makeAPublishContentDesc = getAttributeValueFromAWebElement(makeAPublishInFb, "content-desc");
        System.out.println("--> " + makeAPublishContentDesc);

        Thread.sleep(1000);

        List<WebElement> viewGroupList = getElementsByClassName("android.view.ViewGroup");
        getAnAttributeFromAListOfWebElements(viewGroupList, "content-desc");

        Assert.assertNotEquals(viewGroupList.size(), 0);

    }

}
