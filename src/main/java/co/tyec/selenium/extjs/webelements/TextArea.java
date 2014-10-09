package co.tyec.selenium.extjs.webelements;

import org.openqa.selenium.WebElement;

public class TextArea extends Field {
	
	public TextArea(String query) {
		super(query);
	}
	
	public TextArea(WebElement topElement) {
		super(topElement);
	}
}
