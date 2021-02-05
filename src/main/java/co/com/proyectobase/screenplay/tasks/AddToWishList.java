package co.com.proyectobase.screenplay.tasks;

import co.com.proyectobase.screenplay.ui.AppTestSearchResultsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class AddToWishList implements Task {

    public AddToWishList() {
        super();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(AppTestSearchResultsPage.WISH_LIST_BUTTON));
    }

    public static AddToWishList ClickButton() {
        return Tasks.instrumented(AddToWishList.class);
    }

}
