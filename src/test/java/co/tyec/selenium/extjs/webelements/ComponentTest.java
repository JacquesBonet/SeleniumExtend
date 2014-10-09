package co.tyec.selenium.extjs.webelements;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

/**
 * The class <code>ComponentTest</code> contains tests for the class <code>{@link ExtJSComponent}</code>.
 */
public class ComponentTest {
    JavascriptExecutor js = null;

	@Before
	public void setUp() throws Exception {
        JSExtendedWebElement.setDriver( Mockito.mock(WebDriver.class, Mockito.withSettings().extraInterfaces(JavascriptExecutor.class)));
        js = JSExtendedWebElement.getJS();
		// Global Mocks
		Mockito.when(js.executeScript(Mockito.contains("Ext.Ajax.isLoading()"))).thenReturn(Boolean.FALSE);
	}
	
	/**
	 * Run the boolean cleanEvalTrue(String) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCleanEvalTrue() throws Exception {
		final ExtJSComponent cmp_result = new ExtJSComponent("cmp_id");
		
		Mockito.when(js.executeScript("window.Ext.getCmp('cmp_id')")).thenReturn("true");
		final boolean result = cmp_result.execScriptCleanReturnBoolean(cmp_result.getExpression());
		
		assertTrue(result);
	}
	
	/**
	 * Run the boolean cleanEvalTrue(String) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCleanEvalTrue_1() throws Exception {
		final ExtJSComponent cmp_result = new ExtJSComponent("null");
		final boolean result = cmp_result.execScriptCleanReturnBoolean(cmp_result.getExpression());
		assertEquals(false, result);
	}
	
	/**
	 * Run the ExtJSComponent(Selenium,ComponentLocator) constructor test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testComponent_id() throws Exception {
		final ExtJSComponent result = new ExtJSComponent("cmp_id");
		Mockito.when(js.executeScript(Mockito.contains("hidden"))).thenReturn(Boolean.FALSE);
		Mockito.when(js.executeScript(Mockito.contains("disabled"))).thenReturn(Boolean.FALSE);
		Mockito.when(js.executeScript(Mockito.contains("return extCmp == null"))).thenReturn(Boolean.FALSE);
		
		// add additional test code here
		assertNotNull(result);
		assertEquals("cmp_id", result.getComponentId());
		assertEquals(true, result.visible());
		assertEquals(false, result.disabled());
		assertEquals("window.Ext.getCmp('cmp_id')", result.getExpression());
		assertEquals(false, result.hidden());
		assertEquals("cmp_id", result.getComponentId());
		assertEquals(true, result.waitForIsVisible());
	}
	
	/**
	 * Run the boolean disabled() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDisabled() throws Exception {
		WebElement mockedEl = Mockito.mock(WebElement.class);
		final ExtJSComponent cmp_result = new ExtJSComponent("cmp_id");
		Mockito.when(js.executeScript(Mockito.contains("disabled"), Mockito.anyVararg())).thenReturn(Boolean.TRUE);
		assertTrue(cmp_result.disabled());
	}
	
	/**
	 * Run the boolean evalNullComponent(String) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEvalNullComponent() throws Exception {
		final ExtJSComponent cmp_result = new ExtJSComponent("cmp_id");
		Mockito.when(js.executeScript("window.Ext.getCmp('cmp_id')")).thenReturn("null");
		final boolean result = cmp_result.execScriptOnExtJSCmpReturnIsNull(cmp_result.getExpression());
		
		assertTrue(result);
	}
	
	/**
	 * Run the boolean evalNullComponent(String) method test. return false
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEvalNullComponent_false() throws Exception {
		final ExtJSComponent cmp_result = new ExtJSComponent("cmp_id");
		Mockito.when(js.executeScript(Mockito.contains("var extCmp = Ext.getCmp"))).thenReturn("something");
		final boolean result = cmp_result.execScriptOnExtJSCmpReturnIsNull(cmp_result.getExpression());
		assertEquals(false, result);
	}
	
	/**
	 * Run the String getComponentId() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetComponentId() throws Exception {
		final ExtJSComponent cmp_result = new ExtJSComponent("cmp_id");
		final String result = cmp_result.getComponentId();
		assertNotNull(result);
	}
	
	/**
	 * Run the String getElDom() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetElDom() throws Exception {
		WebElement mockedEl = Mockito.mock(WebElement.class);
		final ExtJSComponent cmp_result = new ExtJSComponent("cmp_id");
		assertNotNull(cmp_result);
		Mockito.when(js.executeScript(Mockito.contains("getEl().dom"))).thenReturn(mockedEl);
		assertEquals(mockedEl, cmp_result.getElDom());
	}
	
	@Test
	public void waitForFinishAjaxRequestTest() {
		final ExtJSComponent cmp_result = new ExtJSComponent("cmp_id");
		assertTrue(cmp_result.waitForFinishAjaxRequest());
	}
}