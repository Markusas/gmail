package com.gmail.tests;

import com.gmail.webpages.HomePage;
import com.gmail.webpages.Inbox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Marek on 2/5/2017.
 */
public class LoginIntoGmailTest {
    WebDriver driver;
    HomePage homePage = new HomePage(driver);
    Inbox inbox;


    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://gmail.com");
    }

    @Test(priority = 0)
    public void checkOrGmailLoad() {
        homePage = new HomePage(driver);
        String actualTagLine = homePage.getGmailTagLine();
        Assert.assertTrue(actualTagLine.contains("One Google Account for everything Google"));


    }

    @Test(priority = 1)
    public void loginIntoGmail() {
        homePage = new HomePage(driver);
        homePage.signIn("********", "********");

        inbox = new Inbox(driver);
        inbox.getUserInfo();
        String userName = inbox.getUserName();
        Assert.assertTrue(userName.contains("Marek Butrimas"));
    }


}
