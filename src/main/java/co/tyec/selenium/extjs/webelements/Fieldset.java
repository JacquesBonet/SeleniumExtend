package co.tyec.selenium.extjs.webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Asaf Levy
 * @version $Revision: 1.0
 */
public class Fieldset extends ExtJSComponent {
	
	/**
	 * Field checkbox.
	 */
	private Checkbox checkbox;
	
	public Fieldset(String query) {
		super(query);
	}
	
	public Fieldset(WebElement topElement) {
		super(topElement);
	}
	
	/**
	 * Method check.
	 * 
	 * @param enable
	 *            boolean
	 * @return Fieldset
	 */
	public Fieldset check(final boolean enable) {
		checkbox.check(enable);
		
		return this;
	}
	
}
