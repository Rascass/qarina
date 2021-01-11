package com.qaprosoft.carina.demo.onliner;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.enums.onliner.MenuItem;
import com.qaprosoft.carina.demo.gui.pages.onliner.OnlinerBasePage;
import com.qaprosoft.carina.demo.gui.pages.onliner.OnlinerCatalogItemPage;
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
    private final static String SEARCH_QUERY = "Samsung Galaxy S20 Ultra 5G SM-G988B/DS 12GB/128GB Exynos 990";

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
    public void testSearchForProductSucceed() {
        OnlinerBasePage homePage = new OnlinerBasePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        OnlinerCatalogItemPage productItemPage = homePage.search(SEARCH_QUERY);
        Assert.assertTrue(productItemPage.isPageOpened(), "Product item page is not opened!");
    }
}
