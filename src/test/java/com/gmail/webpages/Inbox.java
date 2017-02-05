package com.gmail.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Marek on 2/5/2017.
 */
public class Inbox {
    private WebDriver driver;
    private By accountInfo = By.xpath("//span[@class='gb_9a gbii']");
    private By userName = By.xpath("//div[@class='gb_vb']");

    public Inbox(WebDriver driver) {
        this.driver = driver;
    }

    public void getUserInfo() {
        driver.findElement(accountInfo).click();
    }

    public String getUserName() {
        return driver.findElement(userName).getText();
    }
}
