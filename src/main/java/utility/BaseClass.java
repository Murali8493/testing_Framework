package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.simple.parser.JSONParser;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;
import java.io.FileReader;

import org.json.simple.JSONObject;

import io.cucumber.java.AfterAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;

    public WebDriver launchBrowser(String browserName, String url) throws Exception {

        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
            driver = new ChromeDriver(chromeOptions);
        }
        if (browserName.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    public void switchWindowOrTab(int index) {
        Set<String> str = driver.getWindowHandles();
        Object[] windowName = str.toArray();
        driver.switchTo().window(windowName[index].toString());
    }

    public void pressEscapeKey() throws Exception {

        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ESCAPE);
        r.keyRelease(KeyEvent.VK_ESCAPE);

    }

   public JSONObject readJsonData(String filePath) throws Exception {
       JSONParser jsonParser = new JSONParser();

       FileReader reader = new FileReader(filePath);
       Object obj = jsonParser.parse(reader);

       JSONObject jsonObject= (JSONObject)obj;

       return jsonObject ;


   }

}



