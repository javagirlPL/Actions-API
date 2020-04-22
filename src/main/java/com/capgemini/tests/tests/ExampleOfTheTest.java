package com.capgemini.tests.tests;

import com.capgemini.tests.common.CustomConditions;
import com.capgemini.tests.common.PageLoaded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ExampleOfTheTest {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "example")
    public WebElement exampleOfSearchF;

    By searchF = By.id("example");

    // zgodnie z dokumentacja
    public WebElement exampleOfSearchF() {
        List<WebElement> list = driver.findElements(By.xpath("//input[@id='example']"));
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    String homeUrl = "https://automationintesting.online/#/";
    String homeTitle = "Restful-booker-platform demo";


    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testWithoutPageLoaded() {

        driver.get(homeUrl);

        if (!wait.until(titleContains(homeTitle)) || !wait.until(urlContains(homeUrl)))
            throw new RuntimeException("home page is not displayed");

        WebElement searchField = wait.until(elementToBeClickable(searchF));
        searchField.click();
        searchField.sendKeys("test");
    }

    @Test
    public void testWithPageLoaded(){
        driver.get(homeUrl );

        if (!wait.until(new PageLoaded(homeTitle, homeUrl)))
            throw new RuntimeException("home page is not displayed");

        WebElement searchField = wait.until(elementToBeClickable(searchF));
        searchField.click();
        searchField.sendKeys("test");
    }
// różnica w kwestii zapisu, poniżej spójne z tym co robi selenium
// selenium dostarcza ExpectedConditions w ten sposób -> nie klasy, a metody dostarczajace
// anonimowe implementacje -> return new ExpectedCondition<Boolean>(){...}
    @Test
    public void testWithCustomMethod(){
        driver.get(homeUrl );

        if (!wait.until(CustomConditions.pageLoaded(homeTitle, homeUrl)))
            throw new RuntimeException("home page is not displayed");

        WebElement searchField = wait.until(elementToBeClickable(searchF));
        searchField.click();
        searchField.sendKeys("test");
    }

}

