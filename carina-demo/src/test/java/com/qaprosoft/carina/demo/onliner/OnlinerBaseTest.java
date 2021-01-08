package com.qaprosoft.carina.demo.onliner;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.onliner.OnlinerBasePage;
import com.qaprosoft.carina.demo.gui.pages.onliner.OnlinerSearchFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OnlinerBaseTest extends AbstractTest {

    protected OnlinerBasePage openHomePage(WebDriver driver) {
        OnlinerBasePage homePage = new OnlinerBasePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Onliner home page was not opened!");
        return homePage;
    }

}
