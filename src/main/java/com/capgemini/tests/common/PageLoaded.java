package com.capgemini.tests.common;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.function.Function;

public class PageLoaded implements ExpectedCondition<Boolean> {
    String expectedTitle;
    String expectedUrl;

    public PageLoaded(String expectedTitle, String expectedUrl) {
        this.expectedTitle = expectedTitle;
        this.expectedUrl = expectedUrl;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        Boolean isTitleCorrect = driver.getTitle().contains(expectedTitle);
        Boolean isUrlCorrect = driver.getCurrentUrl().contains(expectedUrl);

        return isTitleCorrect && isUrlCorrect;
    }
}