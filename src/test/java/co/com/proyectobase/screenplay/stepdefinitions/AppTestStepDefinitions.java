package co.com.proyectobase.screenplay.stepdefinitions;

import co.com.proyectobase.screenplay.questions.ValidateSearchResults;
import co.com.proyectobase.screenplay.tasks.OpenPage;
import co.com.proyectobase.screenplay.tasks.OpenProductDetail;
import co.com.proyectobase.screenplay.tasks.SearchProduct;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.ElementLocated;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import java.util.List;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

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
}
