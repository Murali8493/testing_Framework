package stepDefnition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.json.simple.JSONObject;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import utility.BaseClass;
import utility.Constrants;


public class LoginStepDefn extends BaseClass {
    LoginPage loginPage;
    String userName;
    String password;

    @Given("the application url and credentials to login")
    public void login() throws Exception {
        JSONObject jsonEntireObject = (JSONObject) readJsonData(Constrants.urlsPath);

        String browser = (String) jsonEntireObject.get("Browser");
        System.out.println("Application opening on the drowser : " + browser);

        String url = ((JSONObject) jsonEntireObject.get("URLS")).get("QA").toString();
        System.out.println("Application URL : " + url);

        driver = launchBrowser(browser, url);

        loginPage = PageFactory.initElements(driver, LoginPage.class);

    }


    @And("enter valid user credentials")
    public void enterUsername() throws Exception {
        JSONObject jsonEntireObject = (JSONObject) readJsonData(Constrants.userCredentialsPath);

        userName = ((JSONObject) jsonEntireObject.get("user1")).get("userId").toString();
        password = ((JSONObject) jsonEntireObject.get("user1")).get("password").toString();

        Thread.sleep(2000);

        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);

    }

    @After
    public void quitBrowser() {
        driver.quit();

    }


}

