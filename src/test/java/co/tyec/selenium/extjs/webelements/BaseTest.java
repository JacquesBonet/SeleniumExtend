package co.tyec.selenium.extjs.webelements;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;



public class BaseTest {
    final static Logger logger = LoggerFactory.getLogger(Button3IT.class);
    public static WebDriver driver;
    public static String htmlTestLocation;
    static String locator = "//";
    public static FirefoxProfile profile = new FirefoxProfile();

    @Before
    public void beforeMethod() {
        if (driver == null) {
            logger.info("Starting Selenium FirefoxDriver");
            driver = new FirefoxDriver(profile);
            JSExtendedWebElement.setDriver(driver);
            logger.info("Navigating to: " + htmlTestLocation);
            driver.navigate().to(htmlTestLocation);
        }
    }


    @AfterClass
    public static void afterclass() {
        try {
            if (driver != null) {
                driver.quit();
                driver = null;
                JSExtendedWebElement.driver = null;
            }
        } catch (Exception e) {
            logger.debug("Exception closing driver", e);
        }
    }

    /**
	 * This rule states that if there is an exception, log it to logger.
	 * Without this, Junit will catch it in it's own XML logs, but it will not be displayed
	 * in your personal logs or console.
	 * To get the logs in your console, configure log4j to append to the console.
	 * 
	 * @author tyork
	 */
	public class ExceptionLoggingRule implements TestRule {
		Logger logger = LoggerFactory.getLogger(ExceptionLoggingRule.class);
		
		public Statement apply(Statement base, Description description) {
			return statement(base);
		}
		
		private Statement statement(final Statement base) {
			return new Statement() {
				@Override
				public void evaluate() throws Throwable {
					try {
						base.evaluate();
					} catch (Exception e) {
						logger.error("JUnit Test Threw Exception: ", e);
						throw e;
					}
				}
			};
		}
	}
	
	/**
	 * This Chain states that we only want to see the thrown exception for regular test cases.
	 * If a Test expects an exception, that exception will NOT be logged.
	 * If a Test does NOT expect any exceptions, there will be a logged message.
	 */
	@Rule
	public RuleChain ruleChain = RuleChain.outerRule(new ExceptionLoggingRule()).around(ExpectedException.none());
	
}