package co.tyec.selenium.extjs.webelements;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

/**
 * Created by root on 9/6/14.
 */
public class Grid3IT extends BaseTest {
    final static Logger logger = LoggerFactory.getLogger(Grid3IT.class);
    static WebDriver driver;
    static String htmlTestLocation;
    static String locator = "//";
    static FirefoxProfile profile = new FirefoxProfile();

    public Grid3IT() {
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
        URL res = Grid3IT.class.getResource("ExtJSTest3.html");
        htmlTestLocation = Grid3IT.class.getResource("ExtJSTest3.html").toString();
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
    public void selectExtJSGrid() {
        Grid grid = new Grid(driver, ExtJSQueryType.ComponentQuery3, "[id='grid']");
        Assert.assertNotNull(grid);
        Assert.assertEquals(grid.getGridRowCount().longValue(), 4L);
        Assert.assertEquals(grid.getGridStoreCount().longValue(), 4L);
        Assert.assertEquals(grid.getCellValue(0, 0), "1001");
        Assert.assertEquals(grid.getCellValue(0, 1), "Doe");
        Assert.assertEquals(grid.getCellValue(0, 2), "John");
        Assert.assertEquals(grid.getCellValue(0, 3), "23");
        Assert.assertEquals(grid.getCellValue(0, 4), "08/06/2009");
        Assert.assertEquals(grid.getCellValue(1, 0), "1002");
        Assert.assertEquals(grid.getCellValue(1, 1), "Sparrow");
        Assert.assertEquals(grid.getCellValue(1, 2), "Jack");
        Assert.assertEquals(grid.getCellValue(1, 3), "26");
        Assert.assertEquals(grid.getCellValue(1, 4), "08/12/2010");

        grid.editCellAndSetValue(0, 3, 24);
        Assert.assertEquals("24", grid.getCellValue(0, 3));

        grid.editCellAndSetValue(0, 4, "08/08/2009");
        Assert.assertEquals("08/08/2009", grid.getCellValue(0, 4));
    }
}

