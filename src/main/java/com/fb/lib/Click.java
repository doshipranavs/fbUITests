package com.fb.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class Click {
	
	public static void element(WebDriver driver, WebElement element) {
		Wait.forElementToBeClickable(driver, element);
		element.click();
	}

	public static void mouseMoveByLocation (WebDriver driver, int x, int y) throws AWTException {
		Robot robot = new Robot();
		robot.mouseMove(x, y);
	}

}
