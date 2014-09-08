package co.tyec.selenium.extjs.webelements;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

public class CheckboxIT3 extends BaseTest {
    final static Logger logger = LoggerFactory.getLogger(CheckboxIT3.class);
    static WebDriver driver;
    static String htmlTestLocation;
    static String locator = "//";
    static FirefoxProfile profile = new FirefoxProfile();

    public CheckboxIT3() {
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
        URL res = CheckboxIT3.class.getResource("ExtJSTest3.html");
        htmlTestLocation = CheckboxIT3.class.getResource("ExtJSTest3.html").toString();
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
    }

    /*	@Test
        public void selectExtJSCheckBox() {
            Checkbox checkbox = new Checkbox(driver, ExtJSQueryType.ComponentQuery, "[name='myCheckbox']");
            Assert.assertNotNull(checkbox.isChecked());

            checkbox.check();
            Assert.assertTrue(checkbox.isChecked());

            checkbox.uncheck();
            Assert.assertFalse(checkbox.isChecked());

            checkbox.check(false);
            Assert.assertFalse(checkbox.isChecked());
        }
    */
    @Test
    public void selectExtJSComboBox() {
        // get Combo
        ComboBox comboBox = new ComboBox(driver, ExtJSQueryType.ComponentQuery3, "[name='state']");

        // set Value
        comboBox.setValue("Alaska");

        // get Value
        String value = comboBox.getValue();
        Assert.assertEquals("Alaska", value);

        // select value
        comboBox.select(2);

        // get Value
        value = comboBox.getValue();
        Assert.assertEquals("Arizona", value);
    }


    @Test
    public void selectExtJSComboBoxByWebdriver() {

        // WebDriver get value
        WebElement stateInput = driver.findElement(By.name("state"));
        Assert.assertNotNull(stateInput);

        String selectedState = stateInput.getAttribute("value");
        Assert.assertNotNull(selectedState);
        Assert.assertEquals("Arizona", selectedState);
    }
}
