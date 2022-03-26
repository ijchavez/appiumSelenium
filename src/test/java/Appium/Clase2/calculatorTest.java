package Android.Appium.Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class calculatorTest extends BaseTest{

    @Test
    public void sumCalculatorTest(){
        /*
        List<WebElement> buttonList = driver.findElements(By.className("android.widget.Button"));
        for(int i = 0; i < buttonList.size(); i++){
            System.out.println(i + " >>> " + buttonList.get(i).getText());

        }
        WebElement digit5 = buttonList.get(9);
        WebElement op_mult = buttonList.get(7);
        WebElement digit2 = buttonList.get(13);
        WebElement op_equal = buttonList.get(19);
        */

        WebElement digit5 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05"));
        WebElement op_mult = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul"));
        WebElement digit2 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02"));
        WebElement op_equal = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));

        digit5.click();
        op_mult.click();
        digit2.click();
        op_equal.click();

        WebElement result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        System.out.println("--> " + result.getText());

        Assert.assertEquals(result.getText(), "10", "El resultado es incorrecto");

    }
    @Test
    public void otherSumCalculatorTest(){
        WebElement digit3 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03"));
        WebElement digit7 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07"));

        WebElement op_sum = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
        WebElement op_equal = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));

        digit7.click();
        op_sum.click();
        digit3.click();
        op_equal.click();

        WebElement result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        System.out.println("--> " + result.getText());

        Assert.assertEquals(result.getText(), "10", "El resultado es incorrecto");

    }
    @Test
    public void sumAndDivideCalculatorTest(){
        WebElement digit7 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07"));
        WebElement digit6 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_06"));
        WebElement digit2 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02"));

        WebElement op_sum = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
        WebElement op_div = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_div"));
        WebElement op_equal = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));

        digit7.click();
        op_sum.click();
        digit6.click();

        op_div.click();
        digit2.click();

        op_equal.click();

        WebElement result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        System.out.println("--> " + result.getText());

        Assert.assertEquals(result.getText(), "10", "El resultado es incorrecto");

    }
    @Test
    public void sumAndDivideWithParenthesisCalculatorTest(){

        WebElement parenthesis = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_parenthesis"));

        WebElement digit7 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07"));
        WebElement digit6 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_06"));
        WebElement digit2 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02"));

        WebElement op_sum = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
        WebElement op_div = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_div"));
        WebElement op_equal = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));

        parenthesis.click();

        digit7.click();
        op_sum.click();
        digit6.click();

        parenthesis.click();

        op_div.click();
        digit2.click();

        op_equal.click();

        WebElement result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        System.out.println("--> " + result.getText());

        Assert.assertEquals(result.getText(), "6.5", "El resultado es incorrecto");

    }
    @Test
    public void piTest(){
        WebElement cientificCalculator = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_handle_btn_rotation"));
        cientificCalculator.click();

        WebElement pi = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_pie"));
        WebElement digit2 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02"));

        WebElement op_mul = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul"));
        WebElement op_equal = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));

        pi.click();
        op_mul.click();
        digit2.click();

        op_equal.click();

        WebElement result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        System.out.println("--> " + result.getText());

        Assert.assertEquals(result.getText(), "6.2831853072", "El resultado es incorrecto");

    }
    @Test
    public void powerTest(){
        WebElement cientificCalculator = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_handle_btn_rotation"));
        cientificCalculator.click();

        WebElement op_powerXY = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_x_y"));

        WebElement digit5 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05"));
        WebElement digit3 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03"));

        WebElement op_equal = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));

        digit5.click();
        op_powerXY.click();
        digit3.click();

        op_equal.click();

        WebElement result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        System.out.println("--> " + result.getText());

        Assert.assertEquals(result.getText(), "125", "El resultado es incorrecto");

    }
    @Test
    public void cubePowerTest(){
        WebElement cientificCalculator = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_handle_btn_rotation"));
        cientificCalculator.click();

        WebElement alternativeFunctions = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_1st_2nd"));
        alternativeFunctions.click();

        WebElement digit5 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05"));
        WebElement cube = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_pie"));

        WebElement op_equal = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));

        digit5.click();
        cube.click();

        op_equal.click();

        WebElement result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        System.out.println("--> " + result.getText());

        Assert.assertEquals(result.getText(), "125", "El resultado es incorrecto");

    }
    @Test
    public void factorialTest(){
        WebElement cientificCalculator = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_handle_btn_rotation"));
        cientificCalculator.click();

        WebElement alternativeFunctions = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_1st_2nd"));
        alternativeFunctions.click();

        WebElement digit5 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05"));
        WebElement factorial = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_e"));

        WebElement op_equal = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));

        digit5.click();
        factorial.click();

        op_equal.click();

        WebElement result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        System.out.println("--> " + result.getText());

        Assert.assertEquals(result.getText(), "120", "El resultado es incorrecto");

    }
}
