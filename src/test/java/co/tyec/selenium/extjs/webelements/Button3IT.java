package co.tyec.selenium.extjs.webelements;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Button3IT extends BaseTest {

    public Button3IT() {
    }

    @SuppressWarnings("unused")
    @BeforeClass
    public static void beforeClass() throws IOException {
        htmlTestLocation = Button3IT.class.getResource("ExtJSTest.html").toString();
        logger.info("ExtJSTest Location: " + htmlTestLocation);
    }

    @Test
    public void selectExtJSButton() {
        Button button = new Button("[type='button']");
        button.click();
        Assert.assertEquals(button.getElDom().getText(), "pressed: true");
        // DomElement pressedDiv = page.domElementGet("DIV[@id='pressed']//*[@textContents='pressed: true']", "//");
        //	WebElement pressedDiv = driver.findElement(By.xpath("//div[@id='cadPicker']//*[contains(text(), 'pressed: true')]"));
        //	Assert.assertNotNull(pressedDiv);
    }
}
