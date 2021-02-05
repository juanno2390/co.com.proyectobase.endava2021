package co.com.proyectobase.screenplay.tasks;

import co.com.proyectobase.screenplay.ui.AppTestSearchResultsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class OpenProductDetail implements Task {

    public OpenProductDetail(String idPosition) {
        super();
        this.idPosition = idPosition;
    }

    private String idPosition;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(AppTestSearchResultsPage.PRODUCT_INDEX_ID));
    }

    public static OpenProductDetail ClickToIndexResult(String idPosition) {
        return Tasks.instrumented(OpenProductDetail.class, idPosition);
    }

}
