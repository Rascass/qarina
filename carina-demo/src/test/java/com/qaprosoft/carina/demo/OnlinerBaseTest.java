package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.gui.pages.onliner.OnlinerBasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OnlinerBaseTest extends AbstractTest {
    protected OnlinerBasePage openHomePage(WebDriver driver) {
        OnlinerBasePage homePage = new OnlinerBasePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Onliner home page was not opened!");
        return homePage;
    }
}
