package co.com.proyectobase.pageobject.steps;

import co.com.proyectobase.pageobject.ui.AppTestPage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class AppTestSteps extends PageObject {
    AppTestPage appTestPage;

    @Step
    public void OpenWebPage()  {
        appTestPage.open();
    }

    public void WriteOnSearchTextbox(String description) {
        appTestPage.WriteOnSearchTextbox(description);
    }

    public void ClickOnSearchButton(){
        appTestPage.ClickOnSearchButton();
    }

    public void ValidateDescriptionOnThePositionIdResult(String idPosition, String productTitle) throws InterruptedException{
        appTestPage.ValidateDescriptionOnThePositionIdResult(idPosition,productTitle);
    }

    public void ValidateSelectecTab(String tabMsg) {
        appTestPage.validateSelectedTab(tabMsg);
    }
}
