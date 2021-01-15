package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OnlinerProductItem extends AbstractUIObject {

    @FindBy(className = "i-checkbox__real")
    private ExtendedWebElement checkbox;

    @FindBy(className = "schema-product__title")
    private ExtendedWebElement title;

    public OnlinerProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public OnlinerProductItem selectProduct() {
        checkbox.check();
        return this;
    }

    public String getTitle() {
        return title.getText();
    }

    public boolean isCheckedForComparison() {
        return checkbox.isChecked();
    }
}
