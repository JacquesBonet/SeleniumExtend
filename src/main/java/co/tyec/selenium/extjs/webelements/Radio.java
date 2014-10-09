package co.tyec.selenium.extjs.webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Radio extends ExtJSComponent {
	public Radio(String query) {
		super(query);
	}
	
	public Radio( WebElement topElement) {
		super(topElement);
	}
	
	/**
	 * @return boolean
	 */
	public boolean isChecked() {
		return execScriptOnExtJsCmpReturnBoolean("return extCmp.checked");
	}
	
}