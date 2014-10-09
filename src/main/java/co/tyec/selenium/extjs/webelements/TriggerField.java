package co.tyec.selenium.extjs.webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TriggerField extends ExtJSComponent {
	
	/**
	 * Field trigger.
	 */
	private Button trigger;
	
	public TriggerField(String query) {
		super(query);
		trigger = new Button(query);
	}
	
	public TriggerField(WebElement topElement) {
		super(topElement);
		trigger = new Button(getComponentId()
				+ ".trigger");

  //      trigger = new Button(driver, ExtJSQueryType.GetCmp, getExpression()
  //              + ".trigger");
	}
	
	/**
	 * Method clickTrigger.
	 * 
	 * @return TriggerField
	 */
	public TriggerField clickTrigger() {
		trigger.click();
		
		return this;
	}
	
}
