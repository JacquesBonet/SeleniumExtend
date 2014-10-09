package co.tyec.selenium.extjs.webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextField extends Field {
	
	public TextField(String query) {
		super(query);
	}
	
	public TextField(WebElement topElement) {
		super(topElement);
	}
	
}
