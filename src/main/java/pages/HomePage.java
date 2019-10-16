package pages;

import driver.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage {


    @FindBy(name = "q")
    WebElement productSearchTextBox;
    @FindBy(className = "vh79eN")
    WebElement searchButton;

    @FindBy(className = "_2yAnYN")
    WebElement searchResult;

    public HomePage() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }


    public void searchProductSearchTextBox(String searchProductName) {
        waitForElementToBeDisplay(productSearchTextBox);
        productSearchTextBox.sendKeys(searchProductName);
        clickSearch();
        waitForElementToBeDisplay(searchResult);
        Assert.assertTrue(searchResult.getText().contains(searchProductName), "search product is not available");

    }

    public void clickSearch() {
        waitForElementToBeDisplay(searchButton);
        jsClick(searchButton);

    }
}
