package com.fb.lib;

import org.openqa.selenium.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.DateFormatSymbols;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Actions {

    static Random random = new Random();

    public static void clickElement(WebDriver driver, WebElement element) {
        Wait.forElementToBeClickable(driver, element);
        element.click();
    }

    public static void selectValueFromDropdown(WebElement dropdownValue, String value) {
        dropdownValue.findElement(By.xpath("//span[text()='" + value + "']")).click();
    }

    public static void selectByIndexFromDropDown(List<WebElement> dropDownValues, int index){
        dropDownValues.get(index).click();
    }

    public static void selectRandomValueFromDropdown(List<WebElement> dropdownValues) {
        int index = random.nextInt(dropdownValues.size() - 1);
        dropdownValues.get(index).click();
    }

    public static String getText(WebElement element) {
        return element.getText();
    }

    public static String getValue(WebElement element) {
        return element.getAttribute("value");
    }

    public static void fillInValue(WebElement element, String value) {
        element.sendKeys(value);
    }

    public static void fillInValue(WebDriver driver, WebElement element, String value) {
        new org.openqa.selenium.interactions.Actions(driver).moveToElement(element).click().perform();
        element.sendKeys(value);
    }

    public static void clearTextField(WebElement element) {
        element.clear();
    }

    public static void clearField(WebElement element) {
        while (!getValue(element).isEmpty()) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public static void clearField(WebDriver driver, WebElement element) throws AWTException{
        while (!getText(element).isEmpty()) {
            new org.openqa.selenium.interactions.Actions(driver).moveToElement(element).click().perform();
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        }
    }

    public static String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month - 1].substring(0, 3);
    }


    public static void switchTab(WebDriver driver) {
        String mainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String childWindow = i1.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                driver.switchTo().activeElement();
            }
        }
    }

    public static void scrollToTop(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }

    public static boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public static void acceptAlert(WebDriver driver) {
        if (isAlertPresent(driver)) {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Wait.seconds(2);
        }
    }

    public static void dismissAlert(WebDriver driver) {
        if (isAlertPresent(driver)) {
            driver.switchTo().alert().dismiss();
            driver.switchTo().defaultContent();
            Wait.seconds(2);
        }
    }

    public static String getTextOfAlertMessage(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    public static void refreshBrowser(WebDriver driver) {
        driver.navigate().refresh();
    }

    public static void browseBackward(WebDriver driver) {
        driver.navigate().back();
    }

    public static void browseForward(WebDriver driver) {
        driver.navigate().forward();
    }

    public static void closeBrowser(WebDriver driver) {
        driver.close();
    }

    public static void cleanUpSession(WebDriver driver) {
        driver.quit();
    }

    public static void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript( "window.scrollTo(0,document.body.scrollHeight);");
    }

    public static boolean isTabClickable(WebDriver driver, Integer expectedTabCount, List <WebElement> element) {
        Iterator<WebElement> itr = element.iterator();
        int actualTabCount = 0;
        while (itr.hasNext()) {
            Wait.forElementToBeClickable(driver, itr.next());
            actualTabCount++;
        }
        return actualTabCount == expectedTabCount;
    }
}
