package co.tyec.selenium.extjs.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.html.HTML;

public class ComboBox extends ExtJSComponent {
	final static Logger logger = LoggerFactory.getLogger(ComboBox.class);
    private static final By TEXT_INPUT_LOCATOR = By.cssSelector("input.x-form-field.x-form-text");

    private WebElement input;

    /**
     * @param query
     */
    public ComboBox(String query) {
		super(query);
	}
	
	/**
	 * @param elementContainer
	 *            - locator of either parent element which wraps text input and drop down button or text input
	 */
	public ComboBox( WebElement elementContainer) {
		super(elementContainer);
		
	}
	
	public void clear() {
		getTextInput().clear();
	}
	
	private void collapseDropDown() {
        js.executeScript(SCRIPT_TOP_ELEMENT_TO_EXT_JS_CMP + " extCmp.collapse();", getTextInput());
    }

    /**
	 * Method getCount.
	 *
     * @return int
     */
    public Integer getCount() {
		final String eval = (String) execScriptOnExtJsCmp("return extCmp.store.getCount();");
		if (eval == null
				|| "null".equals(eval)) {
            return 0;
        }
        return Integer.valueOf(eval).intValue();
    }

    private WebElement getTextInput() {
		if (input == null) {
			if (!topElement.getTagName().equals(HTML.Tag.INPUT.toString())) {
				input = topElement.findElement(TEXT_INPUT_LOCATOR);
			} else {
				input = topElement;
			}
		}
		return input;
	}
	
	/**
	 * Returns the currently selected field value or empty string if no value is set.
	 * 
	 * @return String
	 */
	public String getValue() {
        return (String) execScriptOnExtJsCmp("return extCmp.getValue();");
    }

	/**
	 * Resets the current field value to the originally-loaded value and clears any validation messages.
	 * 
	 * @return String
	 */
	public Boolean reset() {
        return (Boolean) execScriptOnExtJsCmp("return extCmp.reset();");
    }


    /**
	 * Method select.
     *
	 * @param i  int
     */
    public void select(final int i) {
        execScriptOnExtJsCmp("extCmp.setValue(extCmp.store.getAt(" + i + ").get(extCmp.valueField) )");
    }

    /**
     * sends arrow down key to combo box
     */
    public void sendArrowDown() {
        sendKeys(Keys.ARROW_DOWN);
    }

    /**
     * sends arrow up key to combo box
     */
    public void sendArrowUp() {
        sendKeys(Keys.ARROW_UP);
    }

    /**
     * sends enter key to combo box
     */
    public void sendEnter() {
        sendKeys(Keys.ENTER);
    }

    /**
     * sends key to text box
     */
    public void sendKeys(CharSequence... arg0) {
		getTextInput().sendKeys(arg0);
	}
	
	/**
	 * Method setValue.
	 *
     * @param  value    String
     * @return String
	 */
	public String setValue(final String value) {
        execScriptOnExtJsCmp("extCmp.setValue( '" + value + "' )");
        return value;
	}
}