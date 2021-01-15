package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.constant.LocatorConstant;
import com.qaprosoft.carina.demo.gui.constant.TimeoutConstant;
import com.qaprosoft.carina.demo.gui.pages.OnlinerBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.function.Predicate;

public class OnlinerAuthTest extends OnlinerBaseTest {

    @Test(description = "JIRA#AUTO-0010, authentication user")
    @MethodOwner(owner = "yantonuyk")
    public void testAuthentication() throws InterruptedException {
        OnlinerBasePage homePage = openHomePage(getDriver());
        homePage = homePage.authentication("yanaantonyuk001@gmail.com", "Finwow-9kubhi-hoctew");
        Assert.assertEquals(homePage.getUserId(), "3214581", "authetication was failed");
    }
}
