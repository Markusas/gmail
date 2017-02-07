package com.gmail.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ala on 2/6/2017.
 */
public class MsgAfterSendinMail {
    private WebDriver driver;
    private By msgHasBeenSend = By.xpath("//div[@class='vh']");

    public MsgAfterSendinMail(WebDriver driver) {
        this.driver = driver;
    }

    public String getMsgHasBeenSend() {
        return driver.findElement(msgHasBeenSend).getText();
    }
}
