package com.qaprosoft.carina.demo.gui.pages.googleclass;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleClassHomePage extends AbstractPage {

    @FindBy(xpath = "//div[@jsname='rymPhb']//a")
    private List<ExtendedWebElement> posts;
    public GoogleClassHomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://classroom.google.com/c/MjIwNDcxMTg2MzI3?hl=ru");
    }

    public List<ExtendedWebElement> getPosts() {
        return posts;
    }

    public void setPosts(List<ExtendedWebElement> posts) {
        this.posts = posts;
    }
}
