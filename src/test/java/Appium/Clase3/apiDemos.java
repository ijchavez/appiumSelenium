package Android.Appium.Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class apiDemos extends BaseTest{
    List<WebElement> textViewsList;

    @Test
    public void textViewsListText(){
        textViewsList = driver.findElements(By.className("android.widget.TextView"));
        for(WebElement textViewEl : textViewsList){
            System.out.println(textViewEl.getText());

        }
        System.out.println(textViewsList.size());

    }
    @Test
    public void preferenceOptionsText(){
        WebElement preference = driver.findElementByAccessibilityId("Preference");
        preference.click();

        textViewsList = driver.findElements(By.className("android.widget.TextView"));

        boolean isDefaultValuePresent = false;
        boolean isHeaderValuePresent = false;

        for(WebElement textViewEl : textViewsList){
            System.out.println(textViewEl.getText());
            if(textViewEl.getText().contains("Default")){
                isDefaultValuePresent = true;

            }
            if(textViewEl.getText().contains("Header")){
                isHeaderValuePresent = true;

            }

        }
        System.out.println(textViewsList.size());

        Assert.assertTrue(isDefaultValuePresent, "4. Default values no está presente");
        Assert.assertTrue(isHeaderValuePresent, "8. Headers no está presente");


    }
    @Test
    public void xmlInPreferenceTextClickRadioButtonTest() throws InterruptedException {
        WebElement preference = driver.findElementByAccessibilityId("Preference");
        preference.click();

        WebElement prefsFromXML = driver.findElementByAccessibilityId("1. Preferences from XML");
        prefsFromXML.click();

        List<WebElement> titleList = driver.findElements(By.id("android:id/title"));
        System.out.println(titleList.size());

        for(WebElement title : titleList){
            System.out.println(">>> " + title.getText());

        }
        List<WebElement> subTitleList = driver.findElements(By.id("android:id/summary"));
        System.out.println(subTitleList.size());

        for(WebElement subTitle : subTitleList){
            System.out.println(">>> " + subTitle.getText());

        }
        //subTitleList.get(0).click();

        List<WebElement> checkbox = driver.findElements(By.id("android:id/checkbox"));
        System.out.println(checkbox.size());

        checkbox.get(0).click();

        List<String> checkboxCheckedAttribute = new ArrayList<String>();

        for(WebElement el : checkbox){
            String elAttr = el.getAttribute("checked");
            System.out.println(elAttr);

            checkboxCheckedAttribute.add(elAttr);

        }
        Assert.assertEquals(checkboxCheckedAttribute.get(0), "true");
        Assert.assertEquals(checkboxCheckedAttribute.get(1), "false");
        Assert.assertEquals(checkboxCheckedAttribute.get(2), "false");

    }
    @Test
    public void xmlInPreferenceTextEditTextTest() throws InterruptedException {
        WebElement preference = driver.findElementByAccessibilityId("Preference");
        preference.click();

        WebElement prefsFromXML = driver.findElementByAccessibilityId("1. Preferences from XML");
        prefsFromXML.click();

        List<WebElement> subTitleList = driver.findElements(By.id("android:id/summary"));
        subTitleList.get(1).click();

        WebElement editTextBox = driver.findElement(By.id("android:id/edit"));
        editTextBox.clear();

        editTextBox.sendKeys("Goose");

        WebElement acceptBtn = driver.findElement(By.id("android:id/button1"));
        acceptBtn.click();


    }


}
