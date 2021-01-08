package com.qaprosoft.carina.demo.gui.pages.onliner;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.onliner.OnlinerSearchFrameCatalogComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class OnlinerSearchFrame extends AbstractPage {

    @FindBy(className = "search__input")
    private WebElement searchField;

    @FindBy(xpath = "div[@class='result__item result__item_product']")
    private List<OnlinerSearchFrameCatalogComponent> products;

    @FindBy(xpath = "button[@class='compare-button__sub compare-button__sub_main']")
    private WebElement compareProductsButton;

    public OnlinerSearchFrame(WebDriver driver) {
        super(driver);
    }

    public void searchProductsByTitle(String title) {
        searchField.sendKeys(title);
        searchField.submit();
    }

    @Override
    public boolean isPageOpened() {
        return super.isPageOpened();
    }

    public void selectProduct(OnlinerSearchFrameCatalogComponent product) {
        if (products.contains(product)) {
            product.getCheckbox().click();
        }
        throw new NoSuchElementException(product.getTitle() + " was not found");
    }

    public OnlinerComparePage openComparePage() {
        long countSelectedProducts = products.stream()
                .map(OnlinerSearchFrameCatalogComponent::getCheckbox).filter(el -> el.isChecked()).count();
        if (countSelectedProducts > 0) {
            compareProductsButton.submit();
            return new OnlinerComparePage(getDriver());
        }
        throw new NoSuchElementException("cannot find this button. Please, select products for compare");
    }
}
