package pages;

import driver.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GuestUserLoginSignUpPage extends BasePage {


    @FindBy(className = "_1fM65H")
    private WebElement guestUserLoginPageTitle;

    public GuestUserLoginSignUpPage() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void isUserLandOnGuestUserLoginSignUpPage() {
        waitForElementToBeDisplay(guestUserLoginPageTitle);
        Assert.assertTrue(guestUserLoginPageTitle.isDisplayed(), " after click on buy button user is not land on guestUser login or signUp page or checkout page");
    }
}
