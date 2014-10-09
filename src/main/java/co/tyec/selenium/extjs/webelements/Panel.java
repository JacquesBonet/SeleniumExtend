package co.tyec.selenium.extjs.webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Panel extends ExtJSComponent {
	
	public Panel(String query) {
		super(query);
	}
	
	public Panel(WebElement topElement) {
		super(topElement);
	}
	
	/**
	 * Method collapse.
	 */
	public void collapse() {
		execScriptOnExtJsCmp("extCmp.collapse()");
		waitForExecScriptOnExtJSCmpToReturnTrue("return extCmp.collapsed == true");
	}
	
	/**
	 * Method expand.
	 */
	public void expand() {
		execScriptOnExtJsCmp("extCmp.expand()");
		waitForExecScriptOnExtJSCmpToReturnTrue("return extCmp.collapsed == false");
	}
}
