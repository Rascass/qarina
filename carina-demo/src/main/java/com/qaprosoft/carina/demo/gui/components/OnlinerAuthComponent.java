package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.constant.LocatorConstant;
import com.qaprosoft.carina.demo.gui.constant.TimeoutConstant;
import com.qaprosoft.carina.demo.gui.pages.OnlinerBasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

public class OnlinerAuthComponent extends AbstractUIObject {

    public OnlinerAuthComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public OnlinerBasePage authentication(String login, String password) {
        WebElement activeElement = driver.switchTo().activeElement();
        WebElement logField = activeElement.findElement(By.xpath(LocatorConstant.LOGIN_FIELD));
        logField.sendKeys(login);
        WebElement passwordField = activeElement.findElement(By.xpath(LocatorConstant.PASSWORD_FIELD));
        passwordField.sendKeys(password);
        activeElement.findElement(By.xpath(LocatorConstant.SIGN_IN_BUTTON)).click();
        return new OnlinerBasePage(this.driver);
    }
}
