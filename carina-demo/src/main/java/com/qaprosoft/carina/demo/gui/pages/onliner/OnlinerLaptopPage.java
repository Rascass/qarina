package com.qaprosoft.carina.demo.gui.pages.onliner;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnlinerLaptopPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='schema-product__title']//a/span")
    private List<ExtendedWebElement> laptops;

    public OnlinerLaptopPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://catalog.onliner.by/notebook");
    }

    public List<ExtendedWebElement> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<ExtendedWebElement> laptops) {
        this.laptops = laptops;
    }
}
