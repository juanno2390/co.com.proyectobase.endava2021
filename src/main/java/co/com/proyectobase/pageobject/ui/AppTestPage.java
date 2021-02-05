package co.com.proyectobase.pageobject.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;

@DefaultUrl("https://www.amazon.com/")
public class AppTestPage extends PageObject {
    private static final int DEFAULT_WAIT_TIME = 5000;
    private static final String SEARCH_TEXTBOX = "input[id='twotabsearchtextbox']";
    private static final String SEARCH_BUTTON = "input[id='nav-search-submit-button']";
    private static final String SECTION_HOME_PAGE = "div[id=#Hr8WmbwcXhdD8z_DfEBTjg]";
    private static final String SPAN_PRODUCT_TITLE = "span[id='productTitle']";
    private static final String WISH_LIST_BUTTON = "//a[@id='wishListMainButton-announce']";
    private static final String SIGN_IN_BUTTON = "#continue";
    private static final String SIGN_IN_TEXTBOX = "//input[@id='ap_email']";

    @FindBy(css = SEARCH_TEXTBOX)
    WebElementFacade searchTextbox;

    @FindBy(css = SEARCH_BUTTON)
    WebElementFacade searchButton;

    @FindBy(css = SECTION_HOME_PAGE)
    WebElementFacade sectionHomePage;

    @FindBy(css = SPAN_PRODUCT_TITLE)
    WebElementFacade spanProductTitle;

    @FindBy(xpath = WISH_LIST_BUTTON)
    WebElementFacade wishListButton;

    @FindBy(css = SIGN_IN_BUTTON)
    WebElementFacade signInButton;

    @FindBy(xpath = SIGN_IN_TEXTBOX)
    WebElementFacade signInTextbox;

    public void waitResultsPage(){
        waitABit(DEFAULT_WAIT_TIME);
        sectionHomePage.waitUntilNotVisible();
    }

    public void waitResultsPage(int tiempo){
        waitABit(tiempo);
        sectionHomePage.waitUntilNotVisible();
    }

    public void WriteOnSearchTextbox(String description) {
        searchTextbox.clear();
        searchTextbox.sendKeys(description);
    }

    public void ClickOnSearchButton() {
        searchButton.click();
        //searchTextbox.sendKeys(Keys.ENTER);
    }

    public void ClickOnWishListButton() {
        wishListButton.click();
    }

    public void ClickOnSignInButton() {
        signInButton.click();
    }

    public void ValidateDescriptionOnThePositionIdResult(String idPosition, String productTitle) throws InterruptedException {
        waitResultsPage(3000);
        getDriver().findElement(By.cssSelector("span[data-component-id="+idPosition+"]")).click();
        Assert.assertEquals(getDriver().findElement(By.cssSelector("span[id='productTitle']")).getText(), productTitle);
    }

    public void ValidateSelectedTab(String tabMsg)  throws InterruptedException {
        waitResultsPage(1000);
        if(tabMsg.equalsIgnoreCase("Paperback tab was shown pre-selected")) {
            Assert.assertTrue(tabMsg, getDriver().findElement(By.cssSelector("#mediaTab_heading_2 > a > span > div:nth-child(1) > span")).isDisplayed());
        }else{
            Assert.assertFalse(tabMsg, getDriver().findElement(By.cssSelector("#mediaTab_heading_2 > a > span > div:nth-child(1) > span")).isDisplayed());
        }
    }

    public void ValidateSignInPageDisplayed() throws InterruptedException {
        waitResultsPage(2000);
        String titleDisplayed = getDriver().getTitle();
        Assert.assertThat("Validate the title on Displayed Page", titleDisplayed, anyOf(
                containsString("Amazon Iniciar sesión"),
                containsString("Amazon Sign-In")
        ));
    }

    public void ValidateUserAccountTextFieldIsEmpty() throws InterruptedException {
        waitResultsPage(2000);
        Assert.assertThat("Validate the user account text field is empty",signInTextbox.getText().isEmpty(), is(true));
    }

    public void ValidateExceptionMessageSignInDisplayed() throws InterruptedException {
        waitResultsPage(2000);
        Assert.assertTrue("Validate the Sign-In Exception its Displayed", getDriver().findElement(By.xpath("//div[@id='auth-email-missing-alert']")).isDisplayed());
    }

}
