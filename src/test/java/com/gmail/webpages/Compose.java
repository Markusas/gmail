package com.gmail.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Marek on 2/5/2017.
 */
public class Compose {
    private WebDriver driver;
    private By composeBtn = By.xpath("//div[@class='z0']/div");
    private By heading = By.className("aYF");

    public Compose(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCompose() {
        driver.findElement(composeBtn).click();
    }

    public boolean isComposeWindowOpened() {
        return driver.findElement(heading).getText().toString().contains("New Message");
    }
}
