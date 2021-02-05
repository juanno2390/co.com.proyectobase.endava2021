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

    public void ValidateSelectecTab(String tabMsg) throws InterruptedException {
        appTestPage.ValidateSelectedTab(tabMsg);
    }

    public void ClickOnWishListButton(){
        appTestPage.ClickOnWishListButton();
    }

    public void ClickOnSignInButton(){
        appTestPage.ClickOnSignInButton();
    }

    public void ValidateSignInPageDisplayed() throws InterruptedException {
        appTestPage.ValidateSignInPageDisplayed();
    }

    public void ValidateUserAccountTextFieldIsEmpty() throws InterruptedException {
        appTestPage.ValidateUserAccountTextFieldIsEmpty();
    }

    public void ValidateExceptionMessageSignInDisplayed() throws InterruptedException {
        appTestPage.ValidateExceptionMessageSignInDisplayed();
    }


}
