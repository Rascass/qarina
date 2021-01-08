package com.qaprosoft.carina.demo.utils;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class Waits {
    private static final int POLLING_INTERVAL = 10;

    public static boolean isTextChanged(WebDriver driver, ExtendedWebElement element, String expectedText, int timeout) {
        Wait wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(POLLING_INTERVAL))
                .ignoring(TimeoutException.class)
                .ignoring(NoSuchElementException.class);

        boolean changed = (boolean) wait.until(
                new Function<ExtendedWebElement, Boolean>() {
                    @Override
                    public Boolean apply(ExtendedWebElement element) {
                        return element.getText().equals(expectedText);
                    }
                }
        );
        return changed;
    }
}


/*
public static Boolean waitForLogFound(GetLogsV1Method getLogsV1Method, int expectedCount) {
        ExecutionServiceImpl apiExecutor = new ExecutionServiceImpl();

        Wait wait = new FluentWait<GetLogsV1Method>(getLogsV1Method)
                .withTimeout(TimeConstant.LOG_WITH_TIMEOUT_DURATION, TimeUnit.SECONDS)
                .pollingEvery(TimeConstant.LOG_POLLING_EVERY_DURATION, TimeUnit.SECONDS);

        boolean found = (boolean) wait
                .until(new Function<GetLogsV1Method, Boolean>() {
                           public Boolean apply(GetLogsV1Method getLogsV1Method) {
                               return JsonPath.from
                                       (apiExecutor.callApiMethod(getLogsV1Method)).
                                       getInt(JSONConstant.TOTAL_RESULTS_KEY) == expectedCount;
                           }
                       }
                );
        return found;
    }
 */