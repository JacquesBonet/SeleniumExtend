package co.tyec.selenium.extjs.webelements;

import java.io.IOException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckboxIT extends BaseTest {

	static String locator = "//";
	
	final static Logger logger = LoggerFactory.getLogger(CheckboxIT.class);

	@SuppressWarnings("unused")
	@BeforeClass
	public static void beforeClass() throws IOException {
		URL res = CheckboxIT.class.getResource("ExtJSTest.html");
		htmlTestLocation = CheckboxIT.class.getResource("ExtJSTest.html").toString();
		logger.info("ExtJSTest Location: "
				+ htmlTestLocation);
	}
	
	public CheckboxIT() {
	}

	@Test
	public void selectExtJSButton() {
		Button button = new Button("[itemId='pressed']");
		button.click();
		// DomElement pressedDiv = page.domElementGet("DIV[@id='pressed']//*[@textContents='pressed: true']", "//");
		WebElement pressedDiv = driver.findElement(By.xpath("//div[@id='pressed']//*[contains(text(), 'pressed: true')]"));
		Assert.assertNotNull(pressedDiv);
		
	}
	
	@Test
	public void selectExtJSCheckBox() {
		Checkbox checkbox = new Checkbox("[name='myCheckbox']");
		Assert.assertNotNull(checkbox.isChecked());
		
		checkbox.check();
		Assert.assertTrue(checkbox.isChecked());
		
		checkbox.uncheck();
		Assert.assertFalse(checkbox.isChecked());
		
		checkbox.check(false);
		Assert.assertFalse(checkbox.isChecked());
	}
	
	@Test
	public void selectExtJSComboBox() {
		ComboBox comboBox = new ComboBox("[name='state']");
		comboBox.setValue("Alaska");
		
		// DomElement stateInput = page.domElementGet("INPUT[@name='state']", "//");
		WebElement stateInput = driver.findElement(By.name("state"));
		Assert.assertNotNull(stateInput);
		
		// // WebDriver get value
		// String selectedState = (String) stateInput.getAttribute("value");
		// Assert.assertNotNull(selectedState);
		// Assert.assertEquals("Alaska", selectedState);
		
		// Via framework
		String selectedState = comboBox.getValue();
		Assert.assertNotNull(selectedState);
		Assert.assertEquals("Alaska", selectedState);
	}
	
}
