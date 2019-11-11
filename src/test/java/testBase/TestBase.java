package testBase;

import com.browserstack.local.Local;
import driver.DriverInitializer;
import listener.ActivityCapture;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    private Local local;
    protected String url;


    protected LoginPage loginPage;
    protected HomePage homePage;
    protected ProductSearchPage productSearchPage;
    protected ProductDetailPage productDetailPage;
    protected GuestUserLoginSignUpPage guestUserLoginSignUpPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws Exception {
        driver = new DriverInitializer(System.getProperty("driver")).init();
        loginPage = new LoginPage();
        homePage = new HomePage();
        productSearchPage = new ProductSearchPage();
        productDetailPage = new ProductDetailPage();
        guestUserLoginSignUpPage = new GuestUserLoginSignUpPage();
        

    }

    protected void navigateTo(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected void navigateToRefresh() {
        driver.navigate().refresh();
    }

    protected String getCurrentURl() {
        return driver.getCurrentUrl();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    private boolean isPortBusy(int portNumber) {
        boolean isBusy = false;
        try (Socket socket = new Socket("localhost", portNumber)) {
            isBusy = true;
        } catch (IOException e) {
            isBusy = false;
        }
        return isBusy;
    }


    //used when you are using browser stack
    public void killThePort() {
        try {
            Runtime run = Runtime.getRuntime();
            Process process = run.exec("pgrep BrowserSt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String processId;
            while ((processId = reader.readLine()) != null) {
                int exitVal = process.waitFor();
                if (exitVal == 0) {
                    System.out.print("browserStack process is running on this process id ");
                    System.out.println(processId);
                    run.exec("kill -9 " + processId);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

