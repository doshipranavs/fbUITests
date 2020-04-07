package com.fb.proj.pages;

import com.fb.aXe.Accessibility;
import com.fb.config.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Pages implements Navigable {

    public final String fbAppUrl = "TestUrl";

    protected WebDriver driver;

    //We have to initialize all the Pages Created in this class. HomePage provided as an example.
    protected HomePage homePage;
    protected Accessibility accessibility;
    protected templatePage template;

    public Pages(SeleniumDriver driver) {
        this.driver = driver;
        PageObjects();
    }

    public void PageObjects() {
        homePage = PageFactory.initElements(driver,HomePage.class);
        accessibility = PageFactory.initElements(driver,Accessibility.class);
        template=PageFactory.initElements(driver,templatePage.class);
    }

    @Override
    public void NavigateTo(String pageToNavigate) {
        driver.get(pageToNavigate);
    }



}//end class
