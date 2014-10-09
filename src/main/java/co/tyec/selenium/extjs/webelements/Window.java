package co.tyec.selenium.extjs.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Window extends BasicForm {
	
	public Window(String query) {
		super(query);
	}
	
	public Window(WebElement topElement) {
		super(topElement);
	}
	
	/**
	 * Method close.
	 */
	public void close() {
		topElement.findElement(By.xpath(".//div[contains(@class, 'x-tool-close')]")).click();
	}
	
}
