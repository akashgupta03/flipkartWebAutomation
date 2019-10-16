package pages;

import driver.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage {

    @FindBy(className = "_29YdH8")
    private WebElement guestUserLogin;
    @FindBy(className = "_114Zhd")
    private WebElement homePageHeader;


    public LoginPage() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }


    public void guestUserLogin() {
        waitForElementToBeDisplay(guestUserLogin);
        jsClick(guestUserLogin);
        waitForElementToBeDisplay(homePageHeader);
        Assert.assertTrue(homePageHeader.isDisplayed(), "user unable to login as a guest user");
    }
}
