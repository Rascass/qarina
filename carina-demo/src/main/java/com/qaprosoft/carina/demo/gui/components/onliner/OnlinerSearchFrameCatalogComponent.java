package com.qaprosoft.carina.demo.gui.components.onliner;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OnlinerSearchFrameCatalogComponent extends AbstractUIObject {

    @FindBy(xpath = ".//a[@class='product__title-link']")
    private ExtendedWebElement titleLink;

    @FindBy(xpath = ".//span[@class='i-checkbox__faux']")
    private ExtendedWebElement checkbox;

    @FindBy(xpath = ".//a[@class='product__description']")
    private ExtendedWebElement description;

    @FindBy(xpath = ".a//[@class='product__price-value product__price-value_primary']/span")
    private ExtendedWebElement price;

    public OnlinerSearchFrameCatalogComponent(WebDriver driver) {
        super(driver);
    }

    public OnlinerSearchFrameCatalogComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getTitleLink() {
        return titleLink;
    }

    public String getTitle() {
        return titleLink.getText();
    }

    public ExtendedWebElement getCheckbox() {
        return checkbox;
    }

    public String getDescription() {
        return description.getText();
    }

    public String getPrice() {
        return price.getText();
    }
}
