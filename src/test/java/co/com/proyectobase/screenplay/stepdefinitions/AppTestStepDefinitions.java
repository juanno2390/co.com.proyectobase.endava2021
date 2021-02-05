package co.com.proyectobase.screenplay.stepdefinitions;

import co.com.proyectobase.screenplay.questions.ValidateInfoSignIn;
import co.com.proyectobase.screenplay.questions.ValidateSearchResults;
import co.com.proyectobase.screenplay.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.ElementLocated;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class AppTestStepDefinitions {

    public static List<List<String>> data;

    @Managed(driver="chrome")
    private WebDriver hisBrowser;
    private Actor theActorInTheSpotlight = Actor.named("EndavaTester");

    @Before
    public void configuracionInicial() {
        theActorInTheSpotlight.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^He enters to the website$")
    public void HeEntersToTheWebsite() {
        theActorInTheSpotlight.wasAbleTo(OpenPage.AppTestWebStore());
    }

    @When("^He search products by filters: (.*)$")
    public void HeSearchProductsByFilters(String description) {
        theActorInTheSpotlight.attemptsTo(SearchProduct.SearchWithText(description));
    }

    @Then("^He should be able to see in the search results: (.*) with title: (.*)$")
    public void HeShouldBeAbleToSeeInTheResultWithTitle(String idPosition, String productTitle) throws InterruptedException {
        theActorInTheSpotlight.attemptsTo(OpenProductDetail.ClickToIndexResult(idPosition));
        theActorInTheSpotlight.should(seeThat(ValidateSearchResults.is(), equalTo(productTitle)));
    }

    @Then("^He should be able to see that is display: (.*)$")
    public void HeShouldBeAbleToSeeThatIsDisplay(String tabMsg){
        if(tabMsg.equalsIgnoreCase("Paperback tab was shown pre-selected")) {
            theActorInTheSpotlight.attemptsTo(Ensure.that(ElementLocated.by("#mediaTab_heading_2 > a > span > div:nth-child(1) > span")).isDisplayed());
        }else{
            theActorInTheSpotlight.attemptsTo(Ensure.that(ElementLocated.by("#mediaTab_heading_2 > a > span > div:nth-child(1) > span")).isNotDisplayed());
        }
    }

    //Another Assertions
    @When("^He try to add the product in his wish List$")
    public void heTryToAddTheProductInHisWishList() {
        theActorInTheSpotlight.attemptsTo(AddToWishList.ClickButton());
    }


    @Then("^He should be able to see the sign-in is display$")
    public void heShouldBeAbleToSeeTheSignInIsDisplay() {
        List<String> TitleOptions = Arrays.asList("Amazon Iniciar sesión", "Amazon Sign-In");
        String titleDisplayed = hisBrowser.getTitle();
        theActorInTheSpotlight.attemptsTo(Ensure.that(titleDisplayed).isIn(TitleOptions));
    }

    @Then("^He should be able to see the user account field is empty$")
    public void heShouldBeAbleToSeeTheUserAccountFieldIsEmpty() {
        theActorInTheSpotlight.should(seeThat(ValidateInfoSignIn.is(), isEmptyString()));
    }

    @When("^He try to sign-in$")
    public void heTryToSignIn() {
        theActorInTheSpotlight.attemptsTo(SignIn.ClickButton());
    }

    @Then("^He should be able to see the verify message for sign-in is display$")
    public void heShouldBeAbleToSeeTheVerifyMessageForSignInIsDisplay() {
        theActorInTheSpotlight.attemptsTo(Ensure.that(ElementLocated.by("//div[@id='auth-email-missing-alert']")).isDisplayed());
    }


}
