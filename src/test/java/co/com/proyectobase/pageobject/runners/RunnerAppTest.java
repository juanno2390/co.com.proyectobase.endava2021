package co.com.proyectobase.pageobject.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/appTest.feature",
        tags="@Test",
        glue="co.com.proyectobase.pageobject.definitions",
        snippets=SnippetType.CAMELCASE)

public class RunnerAppTest {
}

