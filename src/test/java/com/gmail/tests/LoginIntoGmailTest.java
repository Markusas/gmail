package com.gmail.tests;

import com.gmail.webPages.*;
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
    Compose compose;
    NewMessage newMessage;
    MsgAfterSendinMail msgAfterSendinMail;
    Wait wait;


    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://gmail.com");
    }

    @Test(priority = 0)
    public void GmailLoadTest() {
        homePage = new HomePage(driver);
        String actualTagLine = homePage.getGmailTagLine();
        Assert.assertTrue(actualTagLine.contains("One Google Account for everything Google"));


    }

    @Test(priority = 1)
    public void loginIntoGmailTest() {
        homePage = new HomePage(driver);
        homePage.signIn("*****", "*****");

        inbox = new Inbox(driver);
        inbox.getUserInfo();
        String userName = inbox.getUserName();
        Assert.assertTrue(userName.contains("Marek Butrimas"));
    }

    @Test(priority = 2)
    public void ComposeBtnWorkTest() {
        compose = new Compose(driver);
        compose.clickCompose();
        Assert.assertTrue(compose.isComposeWindowOpened());
        newMessage = new NewMessage(driver);
        newMessage.senMail("saltinio@gmail.com", "Test", "Test \n Test test test.");

    }

    @Test(priority = 3)
    public void mailSendingTest() throws InterruptedException {
        msgAfterSendinMail = new MsgAfterSendinMail(driver);
//        wait = new Wait();
//        wait.waitForJavascript(driver);
        Thread.sleep(10000);
        Assert.assertTrue(msgAfterSendinMail.getMsgHasBeenSend().contains("Your message has been sent."));
    }


}
