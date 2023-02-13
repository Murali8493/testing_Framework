package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class LoginPage {
    @FindBy(how = How.XPATH, using = "//input[@name='email']")
    WebElement emailTextField;

    @FindBy(how=How.XPATH, using = "//input[@type='password']")
    WebElement passwordTextField;


}
