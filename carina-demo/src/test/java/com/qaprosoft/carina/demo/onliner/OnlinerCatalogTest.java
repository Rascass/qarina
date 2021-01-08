package com.qaprosoft.carina.demo.onliner;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.enums.onliner.MenuItem;
import com.qaprosoft.carina.demo.gui.pages.onliner.OnlinerBasePage;
import com.qaprosoft.carina.demo.gui.pages.onliner.OnlinerCatalogPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class OnlinerCatalogTest extends OnlinerBaseTest {

    private final List<String> NOTEBOOKS_MODELS =
            Arrays.asList("Ноутбук Apple Macbook Air 13\" M1 2020 MGN73", "Ноутбук Apple Macbook Pro 13\" M1 2020 MYD92");

    @Test(description = "JIRA#AUTO-0010, searches if any notebook is present")
    @MethodOwner(owner = "yantonuyk")
    public void testLaptopsSearch() {
        OnlinerBasePage homePage = openHomePage(getDriver());
        OnlinerCatalogPage catalogPage = homePage.openCatalogPage(MenuItem.NOTEBOOKS);
        Assert.assertTrue(catalogPage.isPageOpened(), "Catalog page was not opened!");

        List<String> actualTitles = catalogPage.getProductsTitles();

        for (String model : NOTEBOOKS_MODELS) {
            Assert.assertTrue(actualTitles.contains(model),
                    String.format("Expected notebook model '%s' are not contained in the list!", model));
        }

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
