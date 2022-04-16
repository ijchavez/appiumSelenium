package Android.Appium.Clase78.Test;

import Android.Appium.Clase6.AirbnbConstants;
import Android.Appium.Clase6.BaseTest;
import Android.Appium.Utilities.AssertionErrorMessages;
import Android.Appium.Utilities.Constants;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AirbnbTest extends BaseTest {

    @Test
    public void airbnbTest(){
        textViewList = landingPage.getAndroidWidgetTextView();
        landingPage.printAListOfWebElements(textViewList);

    }
    @Test
    public void clickOnAParticularCountryTest(){
        textViewList = landingPage.getAndroidWidgetTextView();

        WebElement countryOptionList = textViewList.get(1);
        countryOptionList.click();

        textViewList = landingPage.getAndroidWidgetTextView();
        landingPage.printAListOfWebElements(textViewList);

        List<WebElement> countriesList = landingPage.getListOfWebElementsById(Constants.ANDROID_ID + Constants.TEXT1);
        for(WebElement country : countriesList){
            if(country.getText().contains("Alemania ( +49 )")){
                country.click();
                break;

            }

        }
        textViewList = landingPage.getAndroidWidgetTextView();
        landingPage.printAListOfWebElements(textViewList);

        WebElement countrySelected = textViewList.get(2);
        String countrySelectedText = landingPage.getTextFromAWebElement(countrySelected);

        Assert.assertEquals(countrySelectedText, "Alemania ( +49 )", AssertionErrorMessages.MESSAGE_NOT_SHOWN);
    }
    @Test
    public void invalidPhoneTest(){
        WebElement telephone = landingPage.getAndroidWidgetEditText();
        telephone.sendKeys("123123");

        textViewList = landingPage.getAndroidWidgetTextView();

        WebElement invalidPhoneErrMsg = textViewList.get(3);
        String invalidPhoneErrMsgText = landingPage.getTextFromAWebElement(invalidPhoneErrMsg);

        System.out.println(invalidPhoneErrMsgText);
        Assert.assertEquals(invalidPhoneErrMsgText, AirbnbConstants.INVALID_TELEPHONE_NUMBER_ERR_MSG, AssertionErrorMessages.MESSAGE_NOT_SHOWN);

    }
    @Test
    public void buttonListLoginTest(){
        buttonList = landingPage.getAndroidWidgetButton();
        landingPage.printAListOfWebElements(buttonList);

        airbnbGV.enabledButtonList = new ArrayList<WebElement>();
        airbnbGV.disabledButtonList = new ArrayList<WebElement>();

        for(WebElement btn : buttonList){
            System.out.println(">>> " + btn.getText() + " está habilitado? " + btn.isEnabled());
            if(btn.isEnabled() == true){
                airbnbGV.enabledButtonList.add(btn);

            }else {
                airbnbGV.disabledButtonList.add(btn);

            }

        }
        Assert.assertEquals(buttonList.size(), airbnbGV.enabledButtonList.size() + airbnbGV.disabledButtonList.size(),
                    "las cantidades no concuerdan");

    }
    @Test
    public void invalidEmailTest(){
        buttonList = landingPage.getAndroidWidgetButton();
        landingPage.printAListOfWebElements(buttonList);

        loginPage = landingPage.clickOnEmailBtn();

        airbnbGV.email = loginPage.getAndroidWidgetEditText();
        loginPage.sendKeysToAWebElement(airbnbGV.email, "qqqqqq");

        buttonList = loginPage.getAndroidWidgetButton();

        airbnbGV.continueButtonInLoginWithEmail = buttonList.get(0);
        Assert.assertFalse(loginPage.isWebElementEnabled(airbnbGV.continueButtonInLoginWithEmail), AssertionErrorMessages.BUTTON_DISABLED);

    }
    @Test
    public void createPasswordTest(){
        buttonList = landingPage.getAndroidWidgetButton();
        landingPage.printAListOfWebElements(buttonList);

        airbnbGV.continueBtn = buttonList.get(0);
        Assert.assertFalse(landingPage.isWebElementEnabled(airbnbGV.continueBtn), AssertionErrorMessages.BUTTON_DISABLED);

        loginPage = landingPage.clickOnEmailBtn();

        airbnbGV.fakerEmail = fkr.getFakerEmail();

        airbnbGV.email = loginPage.getAndroidWidgetEditText();
        airbnbGV.email.sendKeys(airbnbGV.fakerEmail);

        buttonList = loginPage.getAndroidWidgetButton();

        airbnbGV.continueButtonInLoginWithEmail = buttonList.get(0);
        Assert.assertTrue(loginPage.isWebElementEnabled(airbnbGV.continueButtonInLoginWithEmail), AssertionErrorMessages.BUTTON_ENABLED);

        registrationPage = loginPage.clickOnContinueToRegPage();

        buttonList = registrationPage.getAndroidWidgetButton();
        waitForAListOfWebElementsToFullyLoad(buttonList, 30, 3);

        WebElement acceptAndContinueBtn = buttonList.get(0);
        Assert.assertFalse(registrationPage.isWebElementEnabled(acceptAndContinueBtn), AssertionErrorMessages.BUTTON_DISABLED);

        /*
          Si completo la contraseña el botón aceptar y continuar sigue deshabilitado porque falta el nombre.
         */

    }
    @Test
    public void googleLoginTest() throws InterruptedException {
        buttonList = landingPage.getAndroidWidgetButton();
        landingPage.printAListOfWebElements(buttonList);

        WebElement continueWithGoogle = buttonList.get(3);
        continueWithGoogle.click();

        WebElement googleLoginTitle = landingPage.getAWebElementById(Constants.AIRBNB_GMSID + "main_title");
        String googleLoginTitleText = landingPage.getTextFromAWebElement(googleLoginTitle);

        Assert.assertEquals(googleLoginTitleText, AirbnbConstants.CHOOSE_AN_ACCOUNT, AssertionErrorMessages.TEXT_MISMATCH);

        WebElement googleLoginSubTitle = landingPage.getAWebElementById( Constants.AIRBNB_GMSID + "subtitle");
        String googleLoginSubTitleText = landingPage.getTextFromAWebElement(googleLoginSubTitle);

        Assert.assertEquals(googleLoginSubTitleText, AirbnbConstants.TO_CONTINUE_USING_AIRBNB, AssertionErrorMessages.TEXT_MISMATCH);

        WebElement addAnotherAccount = landingPage.getAWebElementById(Constants.AIRBNB_GMSID + "add_account_chip_title");
        String anotherAccountText = landingPage.getTextFromAWebElement(addAnotherAccount);

        Assert.assertEquals(anotherAccountText, AirbnbConstants.ADD_ANOTHER_ACCOUNT, AssertionErrorMessages.TEXT_MISMATCH);

        WebElement consentText = landingPage.getAWebElementById(Constants.AIRBNB_GMSID + "consent_text");
        String consentTextText = landingPage.getTextFromAWebElement(consentText);

        Assert.assertEquals(consentTextText, AirbnbConstants.GOOGLE_CONSENT_TEXT, AssertionErrorMessages.TEXT_MISMATCH);

        WebElement choosedAccount = landingPage.getAWebElementById(Constants.AIRBNB_GMSID + "account_display_name");
        choosedAccount.click();

        Thread.sleep(10000);
        textViewList = landingPage.getAndroidWidgetTextView();

        List<String> textViewListText = landingPage.getTextFromAListOfWebElements(textViewList);
        landingPage.printAListOfWebElements(textViewList);

        for(int i = 0; i < 5; i++){
            waitForAWebElementToHaveCertainText(textViewList.get(i), AirbnbConstants.FOOTER_MENU.get(i), 30, 3);
            Assert.assertEquals(textViewListText.get(i), AirbnbConstants.FOOTER_MENU.get(i), AssertionErrorMessages.TEXT_MISMATCH);

        }

    }
    @Test
    public void registerAnAccountTest() {
        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);
        printAListOfWebElements(buttonList);

        airbnbGV.loginWithMail = buttonList.get(1);
        airbnbGV.loginWithMail.click();

        String name = fkr.getFakerName();
        String lastName = fkr.getFakerLastName();
        String fakerEmail = fkr.getFakerEmail();

        airbnbGV.editTextList = getElementsByClassName(Constants.ANDROID_WIDGET_EDITTEXT);

        WebElement email = airbnbGV.editTextList.get(0);
        email.sendKeys(fakerEmail);

        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);

        airbnbGV.continueBtn = buttonList.get(0);
        airbnbGV.continueBtn.click();

        airbnbGV.editTextList = getElementsByClassName(Constants.ANDROID_WIDGET_EDITTEXT);
        WebElement nameField = airbnbGV.editTextList.get(0);

        try{
            nameField.sendKeys(name);

        }catch(StaleElementReferenceException sere){
            System.out.println(sere.getLocalizedMessage());

            airbnbGV.editTextList = getElementsByClassName(Constants.ANDROID_WIDGET_EDITTEXT);

            nameField = airbnbGV.editTextList.get(0);
            nameField.sendKeys(name);

        }

        WebElement lastNameFiled = airbnbGV.editTextList.get(1);
        lastNameFiled.sendKeys(lastName);

        WebElement dateOfBirth = airbnbGV.editTextList.get(2);
        dateOfBirth.click();

        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);

        WebElement continueInDateOfBirthBtn = buttonList.get(7);
        continueInDateOfBirthBtn.click();

        airbnbGV.editTextList = getElementsByClassName(Constants.ANDROID_WIDGET_EDITTEXT);
        WebElement emailField = airbnbGV.editTextList.get(3);

        String emailText = getTextFromAWebElement(emailField);
        Assert.assertEquals(emailText, fakerEmail);

        WebElement password = airbnbGV.editTextList.get(4);
        password.sendKeys("unpassword12345");

        airbnbGV.editTextList = getElementsByClassName(Constants.ANDROID_WIDGET_EDITTEXT);

        String passwordAttributeValue = getAttributeValueFromAWebElement(password, "password");
        Assert.assertEquals(passwordAttributeValue, "true");

        textViewList = getElementsByClassName(Constants.ANDROID_WIDGET_TEXTVIEW);
        printAListOfWebElements(textViewList);

        WebElement showPassword = textViewList.get(4);
        showPassword.click();

        airbnbGV.editTextList = getElementsByClassName(Constants.ANDROID_WIDGET_EDITTEXT);

        passwordAttributeValue = getAttributeValueFromAWebElement(password, "password");
        Assert.assertEquals(passwordAttributeValue, "false");

        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);
        buttonList.get(0).click();

        /*
        Antes no salia un cartel de confirmación de cuenta sino que entraba directo en el usuario, este es el código
        siguiente si el cartel no saliera:

        try{
            buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);
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
        */
    }

}
