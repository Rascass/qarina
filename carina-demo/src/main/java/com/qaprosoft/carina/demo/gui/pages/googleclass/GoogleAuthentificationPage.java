package com.qaprosoft.carina.demo.gui.pages.googleclass;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleAuthentificationPage extends AbstractPage {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmailField;

    @FindBy(xpath = "//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ " +
            "VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc']//span")
    private WebElement nextButton;

    public GoogleAuthentificationPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://classroom.google.com/c/MjIwNDcxMTg2MzI3?hl=ru");
    }

    public WebElement getInputEmailField() {
        return inputEmailField;
    }

    public void setInputEmailField(WebElement inputEmailField) {
        this.inputEmailField = inputEmailField;
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    public void setNextButton(WebElement nextButton) {
        this.nextButton = nextButton;
    }
}
