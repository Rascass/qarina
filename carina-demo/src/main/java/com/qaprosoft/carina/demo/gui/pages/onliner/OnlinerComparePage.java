package com.qaprosoft.carina.demo.gui.pages.onliner;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnlinerComparePage extends AbstractPage {

    @FindBy(xpath = "//tr[@class='product-table__row product-table__row_header product-table__row_top']" +
            "/th[@class='product-table__cell']")
    private List<ExtendedWebElement> products;

    public OnlinerComparePage(WebDriver driver) {
        super(driver);
    }

    public List<ExtendedWebElement> getProducts() {
        return products;
    }
}
