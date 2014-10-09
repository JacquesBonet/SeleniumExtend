package co.tyec.selenium.extjs.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Asaf Levy
 * @version $Revision: 1.0
 */
public class Menu extends ExtJSComponent {
	
	public Menu(String query) {
		super(query);
	}
	
	public Menu(WebElement topElement) {
		super(topElement);
	}
	
	/**
	 * Method click.
	 * 
	 * @param itemKey
	 *            String
	 */
	public void click(final String itemKey) {
		final String id = String.valueOf(execScriptOnExtJsCmp("el.items.items["
				+ getExpression()
				+ ".items.indexOfKey('"
				+ itemKey
				+ "')].el.dom.id"));
		driver.findElement(By.xpath("//*[@id='"
				+ id
				+ "']")).click();
	}
	
	/**
	 * Method click.
	 * 
	 * @param propName
	 *            String
	 * @param propValue
	 *            String
	 */
	public void click(final String propName, final String propValue) {
		final String id = String.valueOf(execScriptOnExtJsCmp("return extCmp.items.items["
				+ getExpression()
				+ ".items.findIndex('"
				+ propName
				+ "', '"
				+ propValue
				+ "')].el.dom.id"));
		topElement.findElement(By.xpath("//*[@id='"
				+ id
				+ "']")).click();
	}
}