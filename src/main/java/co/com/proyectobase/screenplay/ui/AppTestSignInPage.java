package co.com.proyectobase.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AppTestSignInPage extends PageObject {

    public static final Target SIGN_IN_TEXTBOX = Target.the("SEARCH_TEXTBOX")
            .located(By.xpath("//input[@id='ap_email']"));

    public static final Target SIGN_IN_BUTTON = Target.the("SEARCH_BUTTON")
            .located(By.cssSelector("#continue"));
}
