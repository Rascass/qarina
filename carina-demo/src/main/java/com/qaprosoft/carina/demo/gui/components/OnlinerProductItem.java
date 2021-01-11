package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class OnlinerProductItem extends AbstractUIObject {

    @FindBy(xpath = ".//input[@class='i-checkbox__real'][@type='checkbox']")
    private ExtendedWebElement checkbox;

    @FindBy(xpath = ".//div[@class='schema-product__title']")
    private ExtendedWebElement title;

    public OnlinerProductItem(WebDriver driver) {
        super(driver);
    }

    public OnlinerProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void selectProduct() {
        checkbox.check();
    }

    public String getTitle() {
        return title.getText();
    }

    public boolean isChecked() {
        return checkbox.isChecked();
    }
}
