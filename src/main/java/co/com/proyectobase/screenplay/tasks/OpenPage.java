package co.com.proyectobase.screenplay.tasks;

import co.com.proyectobase.screenplay.ui.AppTestHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class OpenPage implements Task {
    AppTestHomePage storeHomePage;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(net.serenitybdd.screenplay.actions.Open.browserOn(storeHomePage));
    }

    public static OpenPage AppTestWebStore() {
        return Tasks.instrumented(OpenPage.class);
    }
}
