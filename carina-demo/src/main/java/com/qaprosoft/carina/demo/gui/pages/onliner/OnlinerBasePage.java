package com.qaprosoft.carina.demo.gui.pages.onliner;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.enums.MenuItem;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OnlinerBasePage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnlinerBasePage.class);

    @FindBy(className = "b-top-logo")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//span[@class='project-navigation__sign'][text()='%s']")
    private ExtendedWebElement menuItem;

    public OnlinerBasePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://onliner.by");
    }

    @Override
    public boolean isPageOpened() {
        return logo.isPresent();
    }

    public OnlinerCatalogPage openCatalogPage(MenuItem item) {
        LOGGER.info("Going to open catalog page {}", item.getValue());
        menuItem.format(item.getValue()).click();
        return new OnlinerCatalogPage(getDriver());
    }
}
