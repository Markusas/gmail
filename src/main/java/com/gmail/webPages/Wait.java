package com.gmail.webPages;


import com.google.common.base.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Created by Marek on 2/6/2017.
 */
public class Wait {
    public void waitForJavascript(WebDriver driver) {
        new WebDriverWait(driver, 5).until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
            }
        });
    }


}
