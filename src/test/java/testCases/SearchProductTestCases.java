package testCases;

import annotation.Author;
import annotation.TestCaseNotes;
import org.testng.annotations.Test;
import testBase.TestBase;
import utils.Categories;
import utils.Properties;

import static annotation.TesterName.AKASH;

public class SearchProductTestCases extends TestBase {


    @Author(name = AKASH)
    @TestCaseNotes(Steps = "go  to Flipkart.com || close the login pop-up || Search the shoes|| ", expecatedResult = "shoes should be display")
    @Test(groups = {Categories.SMOKE})
    public void searchProductAsGuestUser() {
        navigateTo(Properties.baseUrl);
        loginPage.guestUserLogin();
        homePage.searchProductSearchTextBox("shoes");

    }

    @Author(name = AKASH)
    @TestCaseNotes(Steps = "go  to Flipkart.com || close the login pop-up || Search the shoes|| apply low to high Filter ", expecatedResult = "shoes should be display according to apply filter")
    @Test(groups = {Categories.SMOKE})
    public void filterProductByPriceLowToHigh() {
        navigateTo(Properties.baseUrl);
        loginPage.guestUserLogin();
        homePage.searchProductSearchTextBox("shoes");
        productSearchPage.isAllFilterIsDisplay();
        productSearchPage.selectLowToHighFilter();

    }


    @Author(name = AKASH)
    @TestCaseNotes(Steps = "go  to Flipkart.com || close the login pop-up || Search the shoes|| filter the shoes by brand name|| click on first search product", expecatedResult = "product detail page should be display")
    @Test(groups = {Categories.SMOKE})
    public void filterProductByBrand() {
        navigateTo(Properties.baseUrl);
        loginPage.guestUserLogin();
        homePage.searchProductSearchTextBox("shoes");
        productSearchPage.isAllFilterIsDisplay();
        productDetailPage.searchBrand("adidas");
        productDetailPage.clickOnFirstSearchProduct();


    }


    @Author(name = AKASH)
    @TestCaseNotes(Steps = "go  to Flipkart.com || close the login pop-up || Search the shoes|| select first searched product", expecatedResult = "product detail page should be display")
    @Test(groups = {Categories.SMOKE})
    public void selectFirstSearchProduct() {
        navigateTo(Properties.baseUrl);
        loginPage.guestUserLogin();
        homePage.searchProductSearchTextBox("shoes");
        productSearchPage.isAllFilterIsDisplay();
        productDetailPage.clickOnFirstSearchProduct();
        productDetailPage.selectSizeOfProduct("7");
        productDetailPage.clickOnBuyButton();
        guestUserLoginSignUpPage.isUserLandOnGuestUserLoginSignUpPage();

    }
}
