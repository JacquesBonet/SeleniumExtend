package com.outbrain.selenium.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.thoughtworks.selenium.Selenium;

public class ExtjsUtils {

	public static String getComponentXpath(final WebDriver driver, final String element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript(String.format("return window.createXPathFromElement(%s)", element));
	}
}
