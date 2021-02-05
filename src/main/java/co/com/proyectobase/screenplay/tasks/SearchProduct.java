package co.com.proyectobase.screenplay.tasks;

import co.com.proyectobase.screenplay.ui.AppTestHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class SearchProduct implements Task {

    public SearchProduct(String description) {
        super();
        this.description = description;
    }

    private String description;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(description).into(AppTestHomePage.SEARCH_TEXTBOX).thenHit(Keys.ENTER));
    }

    public static SearchProduct SearchWithText(String description) {
        return Tasks.instrumented(SearchProduct.class, description);
    }

}
