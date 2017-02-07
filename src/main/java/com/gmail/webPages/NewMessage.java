package com.gmail.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Marek on 2/6/2017.
 */
public class NewMessage {
    private WebDriver driver;
    private By contactName = By.xpath("//div[@class='wO nr l1']/textarea");
    private By mailSubject = By.name("subjectbox");
    private By message = By.xpath("//div[@class='Am Al editable LW-avf']");
    private By sendBtn = By.xpath("//td[@class='gU Up']/div/div[2]");


    public NewMessage(WebDriver driver) {
        this.driver = driver;
    }

    public void addContactName(String name) {
        driver.findElement(contactName).sendKeys(name);
    }

    public void addSubject(String subject) {
        driver.findElement(mailSubject).sendKeys(subject);
    }

    public void addMessage(String text) {
        driver.findElement(message).sendKeys(text);
    }

    public void clickSendBtn() {
        driver.findElement(sendBtn).click();
    }

    public void senMail(String to, String subject, String messageText) {
        this.addContactName(to);
        this.addSubject(subject);
        this.addMessage(messageText);
        this.clickSendBtn();
    }


}
