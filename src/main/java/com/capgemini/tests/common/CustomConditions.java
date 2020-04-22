package com.capgemini.tests.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {
    public static ExpectedCondition<Boolean> pageLoaded(String expectedTitle, String expectedUrl) {
        return new ExpectedCondition<Boolean>() {
            private String currentTitle = "";

            public Boolean apply(WebDriver driver) {
                Boolean isTitleCorrect = driver.getTitle().contains(expectedTitle);
//                Boolean isTitleCorrect2 = driver.getTitle().equals(expectedTitle);
                Boolean isUrlCorrect = driver.getCurrentUrl().contains(expectedUrl);

                return isTitleCorrect && isUrlCorrect;
            }

            public String toString() {
                return String.format("title to be \"%s\". Current title: \"%s\"", expectedTitle, this.currentTitle);
            }
        };
    }
}
