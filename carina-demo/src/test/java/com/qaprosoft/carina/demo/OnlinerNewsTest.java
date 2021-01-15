package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.OnlinerArticlePage;
import com.qaprosoft.carina.demo.gui.pages.OnlinerBasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlinerNewsTest extends OnlinerBaseTest {
    private static final String ARTICLE_TITLE_EXPECTED = "Чем нам грозит быстрый дрейф магнитного полюса";

    @Test(description = "The proper article opened correct")
    @MethodOwner(owner = "sshukalovich")
    public void testOpenArticle() {
        OnlinerBasePage homePage = openHomePage(getDriver());
        OnlinerArticlePage articlePage = homePage.openArticleFromPrimaryPane(ARTICLE_TITLE_EXPECTED);
        Assert.assertTrue(articlePage.isPageOpened(), "Article Page was not opened!");
    }
}
