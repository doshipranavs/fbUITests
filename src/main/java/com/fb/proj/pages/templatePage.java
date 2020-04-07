package com.fb.proj.pages;

import com.fb.lib.Click;
import com.fb.lib.Wait;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class templatePage {
    WebDriver driver;
    public templatePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String tabTitle = "Index Page";

    @FindBy(linkText = "sign in to your existing account")
    public WebElement linkSignIn;

    @FindBy(id = "username")
    public WebElement txtUserName;


    public void ClickSignIn(){
        Click.element(driver,linkSignIn);
    }
    public void waitUntilHomePageResultsContainerIsLoaded() {
        Wait.forElementToBeDisplayed(driver, txtUserName);
        Assert.assertEquals("Page loaded is not as expected....Actual Page Title is:"+driver.getTitle(),driver.getTitle(),tabTitle);
    }
}
