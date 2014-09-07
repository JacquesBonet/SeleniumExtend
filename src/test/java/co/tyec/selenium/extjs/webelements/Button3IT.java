package co.tyec.selenium.extjs.webelements;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Button3IT extends BaseTest {
    final static Logger logger = LoggerFactory.getLogger(Button3IT.class);
    static WebDriver driver;
    static String htmlTestLocation;
    static String locator = "//";
    static FirefoxProfile profile = new FirefoxProfile();

    public Button3IT() {
    }

    @AfterClass
    public static void afterclass() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            logger.debug("Exception closing driver", e);
        }
    }

    @SuppressWarnings("unused")
    @BeforeClass
    public static void beforeClass() throws IOException {
        Button3IT.class.getResource("ExtJSTest3.html");
        htmlTestLocation = Button3IT.class.getResource("ExtJSTest3.html").toString();
        logger.info("ExtJSTest Location: "
                + htmlTestLocation);
    }

    @Before
    public void beforeMethod() {
        if (driver == null) {
            logger.info("Starting Selenium FirefoxDriver");
            driver = new FirefoxDriver(profile);
            logger.info("Navigating to: "
                    + htmlTestLocation);
            driver.navigate().to(htmlTestLocation);
        }
    }

    @Test
    public void selectExtJSButton() {
        Button button = new Button(driver, ExtJSQueryType.ComponentQuery3, "[type='button']");
        button.click();
        Assert.assertEquals(button.getElDom().getText(), "pressed: true");
        // DomElement pressedDiv = page.domElementGet("DIV[@id='pressed']//*[@textContents='pressed: true']", "//");
        //	WebElement pressedDiv = driver.findElement(By.xpath("//div[@id='cadPicker']//*[contains(text(), 'pressed: true')]"));
        //	Assert.assertNotNull(pressedDiv);

    }

}
