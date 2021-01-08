package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.onliner.OnlinerArticlePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;
import java.net.URL;

public class OnlinerArticlePrimaryComponent extends AbstractUIObject {

    @FindBy(xpath = ".//a[@class='b-tile-section']")
    private ExtendedWebElement tag;

    @FindBy(xpath = ".//a[@class='b-tile-comments']//span")
    private ExtendedWebElement commentsCount;

    @FindBy(xpath = ".//h3[@class='b-tile-header']/span")
    private ExtendedWebElement titleLabel;

    @FindBy(xpath = ".//i[@class='b-tile-bg']")
    private ExtendedWebElement imageContainer;

    public OnlinerArticlePrimaryComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTag() {
        return tag.getText();
    }

    public int getCommentsCount() {
        return Integer.parseInt(commentsCount.getText());
    }

    public String getTitle() {
        return titleLabel.getText();
    }

    public OnlinerArticlePage navigateTo() {
        titleLabel.click();
        return new OnlinerArticlePage(this.driver);
    }

    public URL getBackgroundImageUrl() {
        String styleContent = imageContainer.getAttribute("style");
        String urlContent = styleContent.substring(
                styleContent.indexOf('('),
                styleContent.indexOf(')')
        );
        try {
            return new URL(urlContent);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
