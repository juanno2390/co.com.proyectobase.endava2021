package co.com.proyectobase.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.amazon.com/")
public class AppTestHomePage extends PageObject {

    public static final Target SEARCH_TEXTBOX = Target.the("SEARCH_TEXTBOX")
            .located(By.cssSelector("input[id='twotabsearchtextbox']"));

    public static final Target SEARCH_BUTTON = Target.the("SEARCH_BUTTON")
            .located(By.cssSelector("input[id='nav-search-submit-button']"));
}
