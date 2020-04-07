package com.fb.proj.pages;

import com.fb.lib.Click;
import com.fb.lib.Wait;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String tabTitle = "Gmail";

    @FindBy(id = "identifierId")
    public WebElement txtemail;

    @FindBy(id = "identifierNext")
    public WebElement btnNext;

    public void EnterEmail(String email){
        Wait.forElementToBeClickable(driver,txtemail);
        txtemail.sendKeys(email);
    }
    public void ClickNext(){
        Click.element(driver,btnNext);
    }
    public void waitUntilHomePageResultsContainerIsLoaded() {
        Wait.forElementToBeDisplayed(driver, txtemail);
        Assert.assertEquals("Page loaded is not as expected....Actual Page Title is:"+driver.getTitle(),driver.getTitle(),tabTitle);
    }
}
