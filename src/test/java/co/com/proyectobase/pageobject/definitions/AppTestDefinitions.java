package co.com.proyectobase.pageobject.definitions;

import co.com.proyectobase.pageobject.steps.AppTestSteps;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;
import java.util.HashMap;

public class AppTestDefinitions extends PageObject {
    @Steps
    AppTestSteps appTestSteps;

    private static HashMap<Integer,String> scenarios;

    public AppTestDefinitions(){ //or even inside of your singleton's getInstance();
        if(scenarios == null) {
            scenarios = new HashMap<Integer,String>();
        }
    }

    @Before
    public void beforeHook(Scenario scenario) {
        addScenario(scenario.getName());
    }

    private void addScenario(String scenario){
        Thread currentThread = Thread.currentThread();
        int threadID = currentThread.hashCode();
        scenarios.put(threadID,scenario);
    }

    private synchronized String getScenario(){
        Thread currentThread = Thread.currentThread();
        int threadID = currentThread.hashCode();
        return scenarios.get(threadID);
    }

    @Given("^He enters to the website$")
    public void HeEntersToTheWebsite() {
        String scenario = getScenario();
        appTestSteps.OpenWebPage();
    }

    @When("^He search products by filters: (.*)$")
    public void HeSearchProductsByFilters(String description) {
        appTestSteps.WriteOnSearchTextbox(description);
        appTestSteps.ClickOnSearchButton();
    }

    @Then("^He should be able to see in the search results: (.*) with title: (.*)$")
    public void HeShouldBeAbleToSeeInTheResultWithTitle(String idPosition, String productTitle) throws InterruptedException {
        appTestSteps.ValidateDescriptionOnThePositionIdResult(idPosition, productTitle);
    }

    @Then("^He should be able to see that is display: (.*)$")
    public void HeShouldBeAbleToSeeThatIsDisplay(String tabMsg){
        appTestSteps.ValidateSelectecTab(tabMsg);
    }


}
