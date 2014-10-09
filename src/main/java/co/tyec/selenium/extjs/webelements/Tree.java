package co.tyec.selenium.extjs.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Tree extends ExtJSComponent {
	
	public Tree(String query) {
		super(query);
	}
	
	public Tree(WebElement topElement) {
		super(topElement);
	}
	
	/**
	 * Method contains.
	 * 
	 * @param id
	 *            String
	 * @return boolean
	 */
	public boolean contains(final String id) {
		return execScriptOnExtJsCmpReturnBoolean("return extCmp.nodeHash['"
				+ id
				+ "'] != null");
	}
	
	/**
	 * Method getErrorText.
	 * 
	 * @return String
	 */
	public String getErrorText() {
		WebElement errorText = driver.findElement(By.xpath(getXPath()
				+ "//div[@class='x-form-invalid-msg']"));
		return errorText.getText();
	}
	
	/**
	 * Method getRootNode.
	 * 
	 * @return TreeNode
	 */
	public TreeNode getRootNode() {
		final TreeNode treeNode = new TreeNode(getComponentId());
		return treeNode.getRootNode();
	}
	
	/**
	 * Method hasErrorText.
	 * 
	 * @param err
	 *            String
	 * @return boolean
	 */
	public boolean hasErrorText(final String err) {
		final String text = getErrorText();
		
		return err.equals(text);
	}
	
	/**
	 * Method select By Id.
	 * 
	 * @param id
	 *            String
	 * @return TreeNode
	 */
	public TreeNode select(final String id) {
		execScriptClean(".getSelectionModel().select(" //
				+ getExpression()
				+ ".nodeHash['"
				+ id
				+ "']"
				+ //
				")");
		final TreeNode treeNode = new TreeNode(getComponentId());
		
		return treeNode.getSelectedNode();
	}
	
}
