package com.outbrain.selenium.extjs.core.locators;

import com.outbrain.selenium.util.ExtjsUtils.Xtype;
import com.thoughtworks.selenium.Selenium;

/**
 * @author Asaf Levy
 * @version $Revision: 1.0
 */
public class TextOrLableInComponentLocator extends ComponentLocator {

  /**
   * Field textOrLable.
   */
  private final String textOrLable;
  /**
   * Field parentCmpId.
   */
  private final String parentCmpId;

  /**
   * Constructor for TextOrLableInComponentLocator.
   * @param sel Selenium
   * @param parentCmpId String
   * @param textOrLable String
   * @param xtype Xtype
   */
  public TextOrLableInComponentLocator(final Selenium sel, final String parentCmpId, final String textOrLable, final Xtype xtype) {
    super(sel, xtype);
    this.parentCmpId = parentCmpId;
    this.textOrLable = textOrLable;
  }
  
  public TextOrLableInComponentLocator(final Selenium sel, final String parentCmpId, final String textOrLable, final Xtype xtype, final boolean incInvisible) {
	    super(sel, xtype);
	    this.parentCmpId = parentCmpId;
	    this.textOrLable = textOrLable;
	    this.incInvisible = incInvisible;
	  }

  /**
   * Method getComponentId.
   * @return String */
  @Override
  public String getComponentId() {
	  
	String incInv = (this.incInvisible)?"true":"false";

    return waitCmpNotNull(String.format("window.findInComponentByText('%s','%s','%s',%s)", parentCmpId, textOrLable, getXtype().getName(),incInv));

  }

}
