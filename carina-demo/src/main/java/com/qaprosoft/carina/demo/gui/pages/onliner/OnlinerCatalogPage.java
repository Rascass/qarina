package com.qaprosoft.carina.demo.gui.pages.onliner;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class OnlinerCatalogPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnlinerCatalogPage.class);

    @FindBy(xpath = "//div[@class='schema-product__title']//a/span")
    private List<ExtendedWebElement> products;

    @FindBy(className = "schema-filter__title")
    private ExtendedWebElement filterWrapper;

    public OnlinerCatalogPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return filterWrapper.isPresent(20);
    }

    public List<String> getProductsTitles() {
        List<String> names = products.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
        LOGGER.info("Available products are {}", names);
        return names;
    }

}
