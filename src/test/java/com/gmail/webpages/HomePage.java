package com.gmail.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Marek on 2/4/2017.
 */
public class HomePage {
    private WebDriver driver;
    private By gmailTagLine = By.xpath("//p[@class='tagline']");
    private By emailName = By.id("Email");
    private By nextButton = By.id("next");
    private By emailPass = By.id("Passwd");
    private By signInBtn = By.id("signIn");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getGmailTagLine() {
        return driver.findElement(gmailTagLine).getText();
    }

    public void enterName(String name) {
        driver.findElement(emailName).sendKeys(name);
    }

    public void clickBextBtn() {
        driver.findElement(nextButton).click();
    }

    public void enterPassword(String password) {
        driver.findElement(emailPass).sendKeys(password);
    }

    public void clickSignInBtn() {
        driver.findElement(signInBtn).click();
    }

    public void signIn(String name, String password) {
        this.enterName(name);
        this.clickBextBtn();
        this.enterPassword(password);
        this.clickSignInBtn();
    }

}
