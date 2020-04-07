package com.fb.config;

import com.fb.lib.SeleniumLib;
import com.fb.proj.util.Debugger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumDriver extends EventFiringWebDriver {

    private static  WebDriver DRIVER;

    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            try {
                DRIVER.quit();
            } catch (Exception exp) {
                Debugger.println("Exception from Quiting the Driver...." + exp.getLocalizedMessage());
            }
        }
    };

    static {
        DRIVER = new BrowserFactory().getDriver();
        SeleniumLib.ParentWindowID = DRIVER.getWindowHandle();
        DRIVER.manage().window().maximize();
        DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public SeleniumDriver() {
        super(DRIVER);
    }

    @Override
    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException("You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        super.close();
        Debugger.println("From SeleniumDriver...........Close");
    }

}//end
