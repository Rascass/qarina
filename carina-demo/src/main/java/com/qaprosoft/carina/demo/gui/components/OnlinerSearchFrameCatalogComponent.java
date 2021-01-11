package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.OnlinerCatalogItemPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OnlinerSearchFrameCatalogComponent extends AbstractUIObject {

    @FindBy(xpath = ".//iframe[@class='modal-iframe']")
    private ExtendedWebElement modalIframe;

    @FindBy(className = "search__input")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = ".//a[@class='product__title-link'][contains(text(), '%s')]")
    private ExtendedWebElement resulSuggestionItem;

    public OnlinerSearchFrameCatalogComponent(WebDriver driver) {
        super(driver);
    }

    public OnlinerSearchFrameCatalogComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void activate() {
        driver.switchTo().frame(modalIframe.getElement());
    }

    public OnlinerSearchFrameCatalogComponent setSearchInput(String query) {
        searchInput.type(query);

        return this;
    }

    public OnlinerCatalogItemPage navigateToProduct() {
        searchInput.sendKeys(Keys.ENTER);
        return new OnlinerCatalogItemPage(driver);
    }
}
