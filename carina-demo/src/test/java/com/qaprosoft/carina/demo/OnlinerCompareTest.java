package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.enums.MenuItem;
import com.qaprosoft.carina.demo.gui.pages.OnlinerBasePage;
import com.qaprosoft.carina.demo.gui.pages.OnlinerCatalogPage;
import com.qaprosoft.carina.demo.gui.pages.OnlinerComparePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlinerCompareTest extends OnlinerBaseTest {

    @Test(description = "JIRA#AUTO-0010, compare products")
    @MethodOwner(owner = "yantonuyk")
    public void openComparePage() {
        OnlinerBasePage homePage = openHomePage(getDriver());
        OnlinerCatalogPage catalogPage = homePage.openCatalogPage(MenuItem.NOTEBOOKS);
        Assert.assertTrue(catalogPage.isPageOpened(), "Catalog page was not opened!");
        String title = catalogPage.getProductsTitles().get(0);
        String title2 = catalogPage.getProductsTitles().get(1);
        catalogPage.selectProduct(title);
        catalogPage.selectProduct(title2);
        OnlinerComparePage comparePage = catalogPage.compareSelectedProducts();
        Assert.assertTrue(comparePage.isPageOpened());
    }
}