package Android.Appium.Clase6;

import Android.Appium.Utilities.Constants;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AirbnbTest extends BaseTest {
    List<WebElement> textViewList;
    List<WebElement> buttonList;

    @Test
    public void airbnbTest(){
        textViewList = getElementsByClassName(Constants.ANDROID_WIDGET_TEXTVIEW);
        printAListOfWebElements(textViewList);

    }
    @Test
    public void clickOnAParticularCountryTest(){
        textViewList = getElementsByClassName(Constants.ANDROID_WIDGET_TEXTVIEW);
        textViewList.get(1).click();

        textViewList = getElementsByClassName(Constants.ANDROID_WIDGET_TEXTVIEW);
        printAListOfWebElements(textViewList);

        List<WebElement> countriesList = getListOfWebElementsById("android:id/text1");
        for(WebElement country : countriesList){
            if(country.getText().contains("Alemania ( +49 )")){
                country.click();
                break;

            }

        }
        textViewList = getElementsByClassName(Constants.ANDROID_WIDGET_TEXTVIEW);
        printAListOfWebElements(textViewList);

        Assert.assertEquals(textViewList.get(2).getText(), "Alemania ( +49 )", "el mensaje de error no es correcto o no aparece");
    }
    @Test
    public void invalidPhoneTest(){
        WebElement telephone = getElementByClassName(Constants.ANDROID_WIDGET_EDITTEXT);
        telephone.sendKeys("123123");

        textViewList = getElementsByClassName(Constants.ANDROID_WIDGET_TEXTVIEW);
        Assert.assertEquals(textViewList.get(3).getText(), "Número de teléfono inválido", "el mensaje de error no es correcto o no aparece");

    }
    @Test
    public void buttonListLoginTest(){
        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);
        printAListOfWebElements(buttonList);

        List<WebElement> enabledButtonList = new ArrayList<WebElement>();
        List<WebElement> disabledButtonList = new ArrayList<WebElement>();

        for(WebElement btn : buttonList){
            System.out.println(">>> " + btn.getText() + " está habilitado? " + btn.isEnabled());
            if(btn.isEnabled() == true){
                enabledButtonList.add(btn);

            }else {
                disabledButtonList.add(btn);

            }

        }
        Assert.assertEquals(buttonList.size(), enabledButtonList.size() + disabledButtonList.size(), "las cantidades no concuerdan");

    }
    @Test
    public void userMailToLoginTest(){
        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);
        printAListOfWebElements(buttonList);

        buttonList.get(1).click();

        WebElement email = getElementByClassName(Constants.ANDROID_WIDGET_EDITTEXT);
        email.sendKeys("qqqqqqq");

        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);
        Assert.assertFalse(buttonList.get(0).isEnabled(), "El botón debería estár deshabilitado");

        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);
        email.sendKeys("test@test.com");

        Assert.assertTrue(buttonList.get(0).isEnabled(), "El botón debería estár habilitado");

    }
    @Test
    public void googleLoginTest() throws InterruptedException {
        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);
        printAListOfWebElements(buttonList);

        buttonList.get(3).click();

        WebElement googleLoginTitle = getAWebElementById("com.google.android.gms:id/main_title");
        String googleLoginTitleText = getTextFromAWebElement(googleLoginTitle);

        Assert.assertEquals(googleLoginTitleText, AirbnbConstants.CHOOSE_AN_ACCOUNT, "El texto no coincide");

        WebElement googleLoginSubTitle = getAWebElementById("com.google.android.gms:id/subtitle");
        String googleLoginSubTitleText = getTextFromAWebElement(googleLoginSubTitle);

        Assert.assertEquals(googleLoginSubTitleText, AirbnbConstants.TO_CONTINUE_USING_AIRBNB, "El texto no coincide");

        WebElement addAnotherAccount = getAWebElementById("com.google.android.gms:id/add_account_chip_title");
        String anotherAccountText = getTextFromAWebElement(addAnotherAccount);

        Assert.assertEquals(anotherAccountText, AirbnbConstants.ADD_ANOTHER_ACCOUNT, "El texto no coincide");

        WebElement consentText = getAWebElementById("com.google.android.gms:id/consent_text");
        String consentTextText = getTextFromAWebElement(consentText);

        Assert.assertEquals(consentTextText, AirbnbConstants.GOOGLE_CONSENT_TEXT, "El texto no coincide");

        WebElement choosedAccount = getAWebElementById("com.google.android.gms:id/account_display_name");
        choosedAccount.click();

        Thread.sleep(10000);

        textViewList = getElementsByClassName(Constants.ANDROID_WIDGET_TEXTVIEW);
        List<String> textViewListText = getTextFromAListOfWebElements(textViewList);
        printAListOfWebElements(textViewList);

        for(int i = 0; i < 5; i++){
            waitForAWebElementToHaveCertainText(textViewList.get(i), AirbnbConstants.FOOTER_MENU.get(i));
            Assert.assertEquals(textViewListText.get(i), AirbnbConstants.FOOTER_MENU.get(i), "El texto no coincide");

        }

    }
    @Test
    public void registerAnAccountTest(){
        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);
        printAListOfWebElements(buttonList);

        WebElement loginWithEmail = buttonList.get(1);
        loginWithEmail.click();

        String name = fkr.getFakerName();
        String lastName = fkr.getFakerLastName();
        String fakerEmail = fkr.getFakerEmail();

        List<WebElement> editTextList = getElementsByClassName(Constants.ANDROID_WIDGET_EDITTEXT);
        editTextList.get(0).sendKeys(fakerEmail);

        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);

        WebElement continueBtn = buttonList.get(0);
        continueBtn.click();

        editTextList = getElementsByClassName(Constants.ANDROID_WIDGET_EDITTEXT);
        WebElement nameField = editTextList.get(0);

        try{
            nameField.sendKeys(name);

        }catch(StaleElementReferenceException sere){
            System.out.println(sere.getLocalizedMessage());

            editTextList = getElementsByClassName(Constants.ANDROID_WIDGET_EDITTEXT);

            nameField = editTextList.get(0);
            nameField.sendKeys(name);

        }
        editTextList.get(1).sendKeys(lastName);
        editTextList.get(2).click();

        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);
        buttonList.get(7).click();

        editTextList = getElementsByClassName(Constants.ANDROID_WIDGET_EDITTEXT);

        String emailText = getTextFromAWebElement(editTextList.get(3));
        Assert.assertEquals(emailText, fakerEmail);

        editTextList.get(4).sendKeys("unpassword12345");

        editTextList = getElementsByClassName(Constants.ANDROID_WIDGET_EDITTEXT);

        String passwordAttributeValue = getAttributeValueFromAWebElement(editTextList.get(4), "password");
        Assert.assertEquals(passwordAttributeValue, "true");

        textViewList = getElementsByClassName(Constants.ANDROID_WIDGET_TEXTVIEW);
        printAListOfWebElements(textViewList);

        textViewList.get(4).click();

        editTextList = getElementsByClassName(Constants.ANDROID_WIDGET_EDITTEXT);

        passwordAttributeValue = getAttributeValueFromAWebElement(editTextList.get(4), "password");
        Assert.assertEquals(passwordAttributeValue, "false");

        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);
        buttonList.get(0).click();

        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);

        try{
            waitForAWebElementToBeClickable(buttonList.get(0));
            buttonList.get(1).click();

        }catch(StaleElementReferenceException sere){
            System.out.println(sere.getLocalizedMessage());

            buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);

            waitForAWebElementToBeClickable(buttonList.get(0));
            buttonList.get(1).click();

        }
        textViewList = getElementsByClassName(Constants.ANDROID_WIDGET_TEXTVIEW);
        printAListOfWebElements(textViewList);

        waitForAWebElementToBeClickable(textViewList.get(4));
        textViewList.get(4).click();

        WebElement profileName = getAWebElementById("com.airbnb.android:id/title");
        waitForAWebElementToHaveCertainText(profileName, name);

        String profileNameText = getTextFromAWebElement(profileName);

        Assert.assertEquals(profileNameText, name, "El nombre no coincide");

    }

}
