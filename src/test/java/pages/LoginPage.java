package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

import stepDefnition.LoginStepDefn;
import utility.BaseClass;

public class LoginPage extends LoginStepDefn {
    @FindBy(how = How.XPATH, using = "//input[@name='email']")
    WebElement emailTextField;

    @FindBy(how=How.XPATH, using = "//input[@type='password']")
    WebElement passwordTextField;

    @FindBy(how = How.XPATH, using = "//div[text()='Login']")
    WebElement loginButton;


    public void enterUserName(String userName)
    {
        emailTextField.sendKeys(userName);
        //log.info("Selected the value form the field :"+WebElement);
}
    public void enterPassword(String password)
    {
        passwordTextField.sendKeys(password );
    }
    public void clickOnLoginButton()
    {
        loginButton.click();
    }
}
