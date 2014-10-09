package co.tyec.selenium.extjs.webelements;

import org.openqa.selenium.WebElement;

/**
 * @author Taylor york
 */
public class BasicForm extends ExtJSComponent {
	
	public BasicForm(String query) {
		super(query);
	}
	
	public BasicForm(WebElement topElement) {
		super(topElement);
	}
	
	public ExtJSComponent findComponentIn(String query) {
		return new ExtJSComponent(query);
	}
}
