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
        catalogPage.selectProduct(title);
        OnlinerComparePage comparePage = catalogPage.navigateToComparePage();
        Assert.assertTrue(comparePage.isPageOpened(), "Compare page was not opened!");
    }
}