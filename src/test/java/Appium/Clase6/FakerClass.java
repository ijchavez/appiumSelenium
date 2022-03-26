package Android.Appium.Clase6;

import com.github.javafaker.Faker;

public class FakerClass {
    public FakerClass(){

    }
    Faker fk = new Faker();
    public String getFakerName(){
        return fk.name().firstName();

    }
    public String getFakerLastName(){
        return fk.name().lastName();

    }
    public String getFakerEmail(){
        return fk.internet().emailAddress();

    }

}
