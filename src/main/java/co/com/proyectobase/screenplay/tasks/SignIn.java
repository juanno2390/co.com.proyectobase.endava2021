package co.com.proyectobase.screenplay.tasks;

import co.com.proyectobase.screenplay.ui.AppTestSearchResultsPage;
import co.com.proyectobase.screenplay.ui.AppTestSignInPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class SignIn implements Task {

    public SignIn() {
        super();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(AppTestSignInPage.SIGN_IN_BUTTON));
    }

    public static SignIn ClickButton() {
        return Tasks.instrumented(SignIn.class);
    }

}
