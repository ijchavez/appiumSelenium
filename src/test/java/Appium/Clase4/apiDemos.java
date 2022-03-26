package Android.Appium.Clase4;

import Android.Appium.Utilities.Constants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class apiDemos extends BaseTest {
    List<WebElement> textViewsList;

    WebElement preference;
    WebElement prefsFromXML;

    List<WebElement> titleList;
    List<WebElement> subTitleList;

    List<WebElement> radioButtonList;

    @Test
    public void textViewsListText(){
        textViewsList = getElementsByClassName(Constants.ANDROID_WIDGET_TEXTVIEW);
        printAListOfWebElements(textViewsList);

    }
    @Test
    public void preferenceOptionsText(){
        preference = this.getElementByAccessibilityId(Constants.PREFERENCE);
        preference.click();

        textViewsList = this.getElementsByClassName(Constants.ANDROID_WIDGET_TEXTVIEW);
        printAListOfWebElements(textViewsList);

        boolean isDefaultValuePresent = this.textIsPresentOnList(textViewsList, "Default");
        boolean isHeaderValuePresent = this.textIsPresentOnList(textViewsList, "Header");

        Assert.assertTrue(isDefaultValuePresent, "4. Default values no está presente");
        Assert.assertTrue(isHeaderValuePresent, "8. Headers no está presente");

    }
    @Test
    public void xmlInPreferenceTextClickRadioButtonTest() throws InterruptedException {
        preference = getElementByAccessibilityId(Constants.PREFERENCE);
        preference.click();

        prefsFromXML = getElementByAccessibilityId(Constants.PREFERENCES_FROM_XML);
        prefsFromXML.click();

        titleList = getListOfWebElementsById(Constants.ANDROID_ID + Constants.TITLE);
        printAListOfWebElements(titleList);

        subTitleList = this.getListOfWebElementsById(Constants.ANDROID_ID + Constants.SUMMARY);
        printAListOfWebElements(subTitleList);

        //subTitleList.get(0).click();

        List<WebElement> checkboxList = getListOfWebElementsById(Constants.ANDROID_ID + Constants.CHECKBOX);
        System.out.println(checkboxList.size());

        checkboxList.get(0).click();

        List<String> checkboxCheckedAttribute = this.getAnAttributeFromAListOfWebElements(checkboxList, Constants.CHECKED);

        Assert.assertEquals(checkboxCheckedAttribute.get(0), "true");
        Assert.assertEquals(checkboxCheckedAttribute.get(1), "false");
        Assert.assertEquals(checkboxCheckedAttribute.get(2), "false");

    }
    @Test
    public void xmlInPreferenceTextEditTextTest() throws InterruptedException {
        preference = getElementByAccessibilityId(Constants.PREFERENCE);
        preference.click();

        prefsFromXML = getElementByAccessibilityId(Constants.PREFERENCES_FROM_XML);
        prefsFromXML.click();

        titleList = getListOfWebElementsById(Constants.ANDROID_ID + Constants.TITLE);
        printAListOfWebElements(titleList);

        subTitleList = getListOfWebElementsById(Constants.ANDROID_ID + Constants.SUMMARY);
        printAListOfWebElements(subTitleList);

        subTitleList.get(1).click();

        WebElement editTextBox = getAWebElementById((Constants.ANDROID_ID + Constants.EDIT));
        editTextBox.clear();

        editTextBox.sendKeys("Goose");

        WebElement acceptBtn = getAWebElementById((Constants.ANDROID_ID + Constants.BUTTON + "1"));
        acceptBtn.click();

    }
    @Test
    public void xmlInPreferenceTextRadioButtonTest(){
        preference = getElementByAccessibilityId(Constants.PREFERENCE);
        preference.click();

        prefsFromXML = getElementByAccessibilityId(Constants.PREFERENCES_FROM_XML);
        prefsFromXML.click();

        titleList = getListOfWebElementsById(Constants.ANDROID_ID + Constants.TITLE);

        subTitleList = getListOfWebElementsById(Constants.ANDROID_ID + Constants.SUMMARY);
        subTitleList.get(2).click();

        radioButtonList = getListOfWebElementsById(Constants.ANDROID_ID + Constants.TEXT1);
        radioButtonList.get(2).click();

        subTitleList = getListOfWebElementsById(Constants.ANDROID_ID + Constants.SUMMARY);
        subTitleList.get(2).click();

        radioButtonList = getListOfWebElementsById(Constants.ANDROID_ID + Constants.TEXT1);

        List<String> radioButtonListText = getTextFromAListOfWebElements(radioButtonList);
        List<String> radioButtonListCheckedAttribute = getAnAttributeFromAListOfWebElements(radioButtonList,Constants.CHECKED);


        for(int i = 0; i < radioButtonList.size(); i++){
            Assert.assertEquals(radioButtonListText.get(i), Constants.RADIO_BUTTON_LIST.get(i),
            radioButtonListText.get(i) + " y " + Constants.RADIO_BUTTON_LIST.get(i) + "no son iguales!");

        }

        Assert.assertEquals(radioButtonListCheckedAttribute.get(0), "false");
        Assert.assertEquals(radioButtonListCheckedAttribute.get(1), "false");
        Assert.assertEquals(radioButtonListCheckedAttribute.get(2), "true");

    }

}
