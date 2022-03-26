package Android.Appium.Utilities;

import io.thedocs.soyuz.to;
import java.util.List;

public class Constants {
    //Constantes en el BeforeMethod para levantar el telefono
    public static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
    public static final String ANDROID_DEVICE ="Android";
    public static final String ANDROID_12_VERSION = "12.0";
    //public static final String APK_PATH = "/Users/gchavez/Downloads/sampleApk/ApiDemos-debug.apk";
    public static final String API_DEMOS_APP_PACKAGE = "io.appium.android.apis";
    public static final String API_DEMOS_APP_ACTIVITY = ".ApiDemos";
    public static final String ANDROID_DEVICE_NAME = "RF8MB041RKJ";
    public static final String AUTOMATION_NAME = "UiAutomator2";
    public static final String NO_RESET = "noReset";
    public static final String SHOW_CHROMEDRIVER_LOG = "showChromedriverLog";
    public static final String GENERIC_S10_APP_PATH = "com.sec.android.app.";
    //Constantes comunes de Appium
    public static final String ANDROID_WIDGET_TEXTVIEW = "android.widget.TextView";
    public static final String ANDROID_WIDGET_EDITTEXT = "android.widget.EditText";
    public static final String ANDROID_WIDGET_BUTTON = "android.widget.Button";
    public static final String ANDROID_ID = "android:id/";
    public static final String TITLE = "title";
    public static final String SUMMARY = "summary";
    public static final String TEXT1 = "text1";
    public static final String CHECKBOX = "checkbox";
    public static final String EDIT = "edit";
    public static final String BUTTON = "button";
    //atributos
    public static final String CHECKED = "checked";
    //Constantes de la aplicacion
    public static final String APP_NAME = "API Demos";
    public static final String ALERT_DIALOGUES_MENU ="App/Alert Dialogs";
    public static final String PREFERENCE = "Preference";
    public static final String PREFERENCES_FROM_XML = "1. Preferences from XML";
    public static final List<String> RADIO_BUTTON_LIST = to.list("Alpha Option 01", "Beta Option 02", "Charlie Option 03");
    //clock
    public static final String CLOCK_APP_PACKAGE = "clockpackage";
    public static final String CLOCK_APP_ACTIVITY = ".ClockPackage";
    //calculator
    public static final String CALCULATOR_APP_PACKAGE = "popupcalculator";
    public static final String CALCULATOR_APP_ACTIVITY = ".Calculator";
    //facebook
    public static final String FACEBOOK_APP_PACKAGE = "com.facebook.katana";
    public static final String FACEBOOK_APP_ACTIVITY = ".LoginActivity";
    public static final String FACEBOOK_USERNAME = "info.gerwrdo.chavez@gmail.com";
    public static final String FACEBOOK_PASSWORD = "qwertyu1234";
    //airbnb
    public static final String AIRBNB_APP_PACKAGE = "com.airbnb.android";
    public static final String AIRBNB_APP_ACTIVITY = ".feat.homescreen.HomeActivity";


}
