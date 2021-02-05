package co.com.proyectobase.screenplay.questions;

import co.com.proyectobase.screenplay.ui.AppTestSearchResultsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidateSearchResults implements Question<String> {
    public static ValidateSearchResults is() {
        return new ValidateSearchResults();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(AppTestSearchResultsPage.PRODUCT_TITLE).viewedBy(actor).asString();
    }

}
