package Android.Appium.Clase6;

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
        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);
        printAListOfWebElements(buttonList);

        airbnbGV.loginWithMail = buttonList.get(1);
        airbnbGV.loginWithMail.click();

        airbnbGV.email = getElementByClassName(Constants.ANDROID_WIDGET_EDITTEXT);
        airbnbGV.email.sendKeys("qqqqqqq");

        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);

        airbnbGV.continueButtonInLoginWithEmail = buttonList.get(0);
        Assert.assertFalse(airbnbGV.continueButtonInLoginWithEmail.isEnabled(), "El botón debería estár deshabilitado");



    }
    @Test
    public void createPasswordTest(){
        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);
        printAListOfWebElements(buttonList);

        airbnbGV.continueBtn = buttonList.get(0);
        Assert.assertFalse(airbnbGV.continueButtonInLoginWithEmail.isEnabled(), "El botón debería estár deshabilitado");

        airbnbGV.loginWithMail = buttonList.get(1);
        airbnbGV.loginWithMail.click();

        String fakeEmail = fkr.getFakerEmail();

        airbnbGV.email = getElementByClassName(Constants.ANDROID_WIDGET_EDITTEXT);
        airbnbGV.email.sendKeys(fakeEmail);

        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);
        airbnbGV.continueButtonInLoginWithEmail = buttonList.get(0);

        Assert.assertTrue(airbnbGV.continueButtonInLoginWithEmail.isEnabled(), "El botón debería estár habilitado");
        airbnbGV.continueButtonInLoginWithEmail.click();

        Assert.assertFalse(airbnbGV.continueButtonInLoginWithEmail.isDisplayed(), "El botón debería estár habilitado");

        /*
          Si completo la contraseña el botón aceptar y continuar sigue deshabilitado porque falta el nombre.
         */

    }
    @Test
    public void googleLoginTest() throws InterruptedException {
        buttonList = getElementsByClassName(Constants.ANDROID_WIDGET_BUTTON);
        printAListOfWebElements(buttonList);

        WebElement continueWithGoogle = buttonList.get(3);
        continueWithGoogle.click();

        WebElement googleLoginTitle = getAWebElementById(Constants.AIRBNB_GMSID + "main_title");
        String googleLoginTitleText = getTextFromAWebElement(googleLoginTitle);

        Assert.assertEquals(googleLoginTitleText, AirbnbConstants.CHOOSE_AN_ACCOUNT, "El texto no coincide");

        WebElement googleLoginSubTitle = getAWebElementById( Constants.AIRBNB_GMSID + "subtitle");
        String googleLoginSubTitleText = getTextFromAWebElement(googleLoginSubTitle);

        Assert.assertEquals(googleLoginSubTitleText, AirbnbConstants.TO_CONTINUE_USING_AIRBNB, "El texto no coincide");

        WebElement addAnotherAccount = getAWebElementById(Constants.AIRBNB_GMSID + "add_account_chip_title");
        String anotherAccountText = getTextFromAWebElement(addAnotherAccount);

        Assert.assertEquals(anotherAccountText, AirbnbConstants.ADD_ANOTHER_ACCOUNT, "El texto no coincide");

        WebElement consentText = getAWebElementById(Constants.AIRBNB_GMSID + "consent_text");
        String consentTextText = getTextFromAWebElement(consentText);

        Assert.assertEquals(consentTextText, AirbnbConstants.GOOGLE_CONSENT_TEXT, "El texto no coincide");

        WebElement choosedAccount = getAWebElementById(Constants.AIRBNB_GMSID + "account_display_name");
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
