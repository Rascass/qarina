package com.qaprosoft.carina.demo.gui.pages.onliner;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OnlinerArticlePage extends AbstractPage {

    @FindBy(className = "news-entry__speech")
    private ExtendedWebElement newsEntry;

    public OnlinerArticlePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return newsEntry.isPresent();
    }
}
