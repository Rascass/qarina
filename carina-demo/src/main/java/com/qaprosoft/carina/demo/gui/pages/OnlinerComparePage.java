package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnlinerComparePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='product-table-cell-container']")
    private List<ExtendedWebElement> products;

    public OnlinerComparePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return products.size() > 0;
    }
}
