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

    @Test(description = "JIRA#AUTO-0010, open home page")
    @MethodOwner(owner = "yantonuyk")
    protected OnlinerBasePage openHomePage(WebDriver driver) {
        OnlinerBasePage homePage = new OnlinerBasePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Onliner home page was not opened!");
        return homePage;
    }

    @Test(description = "JIRA#AUTO-0010, search a product")
    @MethodOwner(owner = "yantonuyk")
    public void searchTest() {
        OnlinerBasePage homePage = new OnlinerBasePage(getDriver());
        homePage.open();
       // OnlinerSearchFrame searchFrame = homePage.search("samsung");
       // Assert.assertTrue(searchFrame.isPageOpened(), "search frame is opened");
        WebElement searchField = getDriver().findElement(By.xpath("//input[@class='fast-search__input']"));
        Assert.assertTrue(searchField.isDisplayed(), "search is displayed");
        searchField.sendKeys("samsung");
        getDriver().switchTo()
                .frame(getDriver().findElement(By.className("modal-iframe")));
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.onliner.by/", "homePage is opened");
    }
}
