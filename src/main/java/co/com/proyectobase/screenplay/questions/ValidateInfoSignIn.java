package co.com.proyectobase.screenplay.questions;

import co.com.proyectobase.screenplay.ui.AppTestSignInPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidateInfoSignIn implements Question<String> {

    public static ValidateInfoSignIn is() {
        return new ValidateInfoSignIn();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(AppTestSignInPage.SIGN_IN_TEXTBOX).viewedBy(actor).asString();
    }
}
