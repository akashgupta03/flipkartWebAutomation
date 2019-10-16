package pages;

import driver.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProductSearchPage extends BasePage {


    @FindBy(css = "._1xHtJz")
    private List<WebElement> ListOfFilter;
    @FindBy(css = "._1xHtJz:nth-child(2)")
    private WebElement RelevanceFilter;
    @FindBy(css = "._1xHtJz:nth-child(3)")
    private WebElement popularityFilter;
    @FindBy(css = "._1xHtJz:nth-child(4)")
    private WebElement priceLowToHighFilter;
    @FindBy(css = "._1xHtJz:nth-child(5)")
    private WebElement priceHighToLowFilter;
    @FindBy(css = "._1xHtJz:nth-child(6)")
    private WebElement newArrivalFilter;

    @FindBy(css = "._3vKPvR")
    private WebElement searchProductByBrand;

    @FindBy(className = "xufquN")
    private WebElement checkFilterApplied;


    public ProductSearchPage() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void isAllFilterIsDisplay() {
        waitForListOfElementToBeDisplay(ListOfFilter);
        ListOfFilter.forEach(e ->
                Assert.assertTrue(e.isDisplayed()));

    }

    public void selectRelevanceFilter() {
        waitForElementToBeDisplay(RelevanceFilter);
        jsClick(RelevanceFilter);
    }

    public void selectPopularityFilter() {
        waitForElementToBeDisplay(popularityFilter);
        jsClick(popularityFilter);
        Assert.assertEquals(checkFilterApplied.getText(), popularityFilter.getText(), String.format(" %s filter is not working", popularityFilter.getText()));

    }

    public void selectLowToHighFilter() {
        waitForElementToBeDisplay(priceLowToHighFilter);
        jsClick(priceLowToHighFilter);
        waitForElementToBeVisible(checkFilterApplied);
        wait(2000);
        Assert.assertEquals(checkFilterApplied.getText(), priceLowToHighFilter.getText(), String.format(" %s filter is not working", priceLowToHighFilter.getText()));
    }

    public void selectPriceHighToLowFilter() {
        waitForElementToBeDisplay(priceHighToLowFilter);
        jsClick(priceHighToLowFilter);
        Assert.assertEquals(checkFilterApplied.getText(), priceHighToLowFilter.getText(), String.format(" %s filter is not working", priceHighToLowFilter.getText()));

    }

    public void selectNewArrivalFilter() {
        waitForElementToBeDisplay(newArrivalFilter);
        jsClick(newArrivalFilter);
        Assert.assertEquals(checkFilterApplied.getText(), newArrivalFilter.getText(), String.format(" %s filter is not working", newArrivalFilter.getText()));

    }


    public void searchProductByBrand(String brand) {
        waitForElementToBeDisplay(searchProductByBrand);
        searchProductByBrand.sendKeys(brand);

    }


}
