package co.tyec.selenium.extjs.webelements;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

/**
 * @author Asaf Levy
 * @version $Revision: 1.0
 */
public class ButtonComponentTest {

	@Before
	public void setUp() throws Exception {
		WebDriver driver = Mockito.mock(WebDriver.class, Mockito.withSettings().extraInterfaces(JavascriptExecutor.class));
        JSExtendedWebElement.setDriver( driver);
		// Global Mocks
		Mockito.when(((JavascriptExecutor) driver).executeScript(Mockito.contains("Ext.Ajax.isLoading()"))).thenReturn("false");
	}
	
	@Test
	public void basicTest() {
		final Button button = Mockito.spy(new Button("[@text='pressed']"));
		Mockito.doReturn("_id").when(button).getComponentId();
		String id = button.getComponentId();
		assertEquals("id is incorrect", "_id", button.getComponentId());
	}
	
}
