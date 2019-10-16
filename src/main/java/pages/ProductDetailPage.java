package pages;

import driver.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProductDetailPage extends BasePage {

    @FindBy(className = "_3togXc")
    private WebElement firstSearchedProduct;

    @FindBy(css = "._1TJldG")
    private List<WebElement> sizeOfProduct;

    @FindBy(className = "_1wX7_H")
    private List<WebElement> unAvailableSize;

    @FindBys({
            @FindBy(className = "_2I_hq9"),
            @FindBy(className = " _3c2Xi9")
    })
    private WebElement sizeIsSelected;


    @FindBy(css = "._1k1QCg .col-6-12:nth-child(2)")
    private WebElement buyButton;

    @FindBy(className = "_3vKPvR")
    private WebElement searchBrand;
    @FindBy(className = "_4IiNRh")
    private List<WebElement> selectBrand;
    @FindBy(className = "_2B_pmu")
    private WebElement firstSearchedProductName;

    public ProductDetailPage() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickOnFirstSearchProduct() {
        waitForElementToBeDisplay(firstSearchedProduct);
        jsClick(firstSearchedProduct);
    }

    public void selectSizeOfProduct(String size) {
        switchToActiveTab();
        waitForListOfElementToBeDisplay(sizeOfProduct);
        for (WebElement e : sizeOfProduct) {
            if (e.getText().equalsIgnoreCase(size)) {
                jsClick(e);
                break;
            } else {

                System.out.println("size of product is not available");

            }

        }


    }

    public void clickOnBuyButton() {
        waitForElementToBeDisplay(buyButton);
        System.out.println(buyButton.getText());
        buyButton.click();
    }


    public void searchBrand(String brandName) {
        waitForElementToBeDisplay(searchBrand);
        searchBrand.sendKeys(brandName);
        for (WebElement e : selectBrand) {
            if (e.getText().toLowerCase().contains(brandName)) {
                e.click();
                break;
            }
            System.out.println("searched brand is not available");

        }
        wait(3000);
        waitForElementToBeDisplay(firstSearchedProductName);
        System.out.println(firstSearchedProductName.getText().toLowerCase());
        Assert.assertTrue(firstSearchedProductName.getText().toLowerCase().contains(brandName), String.format("user is not able to search product for this brand %s ", brandName));

    }

}
