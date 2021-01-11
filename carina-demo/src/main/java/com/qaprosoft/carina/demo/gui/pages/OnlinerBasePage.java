package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.OnlinerArticlePrimaryComponent;
import com.qaprosoft.carina.demo.gui.components.OnlinerSearchFrameCatalogComponent;
import com.qaprosoft.carina.demo.gui.enums.MenuItem;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OnlinerBasePage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnlinerBasePage.class);

    @FindBy(className = "b-top-logo")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//span[@class='project-navigation__sign'][text()='%s']")
    private ExtendedWebElement menuItem;

    @FindBy(xpath = "//div[contains(@class, 'b-tile') and @id]")
    private List<OnlinerArticlePrimaryComponent> primaryNewsFeed;

    @FindBy(xpath = "//input[@class='fast-search__input']")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//div[@id='fast-search-modal']")
    private OnlinerSearchFrameCatalogComponent searchFrame;

    public OnlinerBasePage(WebDriver driver) {
        super(driver);
        setPageURL("/");
    }

    @Override
    public boolean isPageOpened() {
        return logo.isPresent() && primaryNewsFeed.size() > 0;
    }

    public OnlinerCatalogPage openCatalogPage(MenuItem item) {
        LOGGER.info("Going to open catalog page {}", item.getValue());
        menuItem.format(item.getValue()).click();
        return new OnlinerCatalogPage(getDriver());
    }

    public OnlinerArticlePage openArticleFromPrimaryPane(String title) {

        for (OnlinerArticlePrimaryComponent component : primaryNewsFeed) {
            if (component.getTitle().equals(title)) {
                return component.navigateTo();
            }
        }
        throw new NoSuchElementException(String.format("The article tile with title '%s' not found!", title));
    }

    public OnlinerCatalogItemPage search(String query) {
        getSearchFrame(query);
        return getCatalogPageByQuery(query);
    }

    private OnlinerCatalogItemPage getCatalogPageByQuery(String query) {
        searchFrame.activate();
        searchFrame.setSearchInput(query);
        return searchFrame.navigateToProduct();
    }

    private OnlinerSearchFrameCatalogComponent getSearchFrame(String query) {
        searchField.type(query.substring(0, 1));
        return searchFrame;
    }
}
