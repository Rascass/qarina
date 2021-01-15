package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.OnlinerProductItem;
import com.qaprosoft.carina.demo.gui.constant.LocatorConstant;
import com.qaprosoft.carina.demo.gui.constant.TimeoutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class OnlinerCatalogPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnlinerCatalogPage.class);

    @FindBy(className = "schema-product__group")
    private List<OnlinerProductItem> products;

    @FindBy(className = "schema-filter__title")
    private ExtendedWebElement filterWrapper;

    public OnlinerCatalogPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return filterWrapper.isPresent(20);
    }

    public List<String> getProductsTitles() {
        List<String> names = products.stream().map(OnlinerProductItem::getTitle).collect(Collectors.toList());
        LOGGER.info("Available products are {}", names);
        return names;
    }

    private OnlinerProductItem findByTitle(String title) {
            int index = products.stream().map(OnlinerProductItem::getTitle)
                    .collect(Collectors.toList())
                    .indexOf(title);
            return products.get(index);
    }

    public OnlinerProductItem selectProduct(String title) {
        return findByTitle(title).selectProduct();
    }

    public boolean isProductSelected(String title) {
        return findByTitle(title).isCheckedForComparison();
    }

    public OnlinerComparePage navigateToComparePage() {
        findExtendedWebElement(By.xpath(LocatorConstant.COMPARE_LINK), TimeoutConstant.MEDIUM_TIMEOUT).click();
        return new OnlinerComparePage(this.driver);
    }
}
