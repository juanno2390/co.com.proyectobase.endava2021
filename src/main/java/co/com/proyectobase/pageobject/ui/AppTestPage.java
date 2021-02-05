package co.com.proyectobase.pageobject.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;

@DefaultUrl("https://www.amazon.com/")
public class AppTestPage extends PageObject {
    private static final int DEFAULT_WAIT_TIME = 5000;
    private static final String SEARCH_TEXTBOX = "input[id='twotabsearchtextbox']";
    private static final String SEARCH_BUTTON = "input[id='nav-search-submit-button']";
    private static final String SECTION_HOME_PAGE = "div[id=#Hr8WmbwcXhdD8z_DfEBTjg]";
    private static final String SPAN_PRODUCT_TITLE = "span[id='productTitle']";

    @FindBy(css = SEARCH_TEXTBOX)
    WebElementFacade searchTextbox;

    @FindBy(css = SEARCH_BUTTON)
    WebElementFacade searchButton;

    @FindBy(css = SECTION_HOME_PAGE)
    WebElementFacade sectionHomePage;

    @FindBy(css = SPAN_PRODUCT_TITLE)
    WebElementFacade spanProductTitle;

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

    public void ValidateDescriptionOnThePositionIdResult(String idPosition, String productTitle) throws InterruptedException {
            waitResultsPage(3000);
            getDriver().findElement(By.cssSelector("span[data-component-id="+idPosition+"]")).click();
            Assert.assertEquals(getDriver().findElement(By.cssSelector("span[id='productTitle']")).getText(), productTitle);
    }

    public void validateSelectedTab(String tabMsg) {
        waitResultsPage(1000);
        if(tabMsg.equalsIgnoreCase("Paperback tab was shown pre-selected")) {
            Assert.assertTrue(tabMsg, getDriver().findElement(By.cssSelector("#mediaTab_heading_2 > a > span > div:nth-child(1) > span")).isDisplayed());
        }else{
            Assert.assertFalse(tabMsg, getDriver().findElement(By.cssSelector("#mediaTab_heading_2 > a > span > div:nth-child(1) > span")).isDisplayed());
        }
    }
}
