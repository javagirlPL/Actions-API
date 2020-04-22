package com.capgemini.tests.pages2.client;

import com.capgemini.tests.common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    private WebDriver driver;

/*    public WebElement RoomsSec() {
        return driver.findElement(By.xpath("//div[@class='row hotel-room-info']"));
    }

    public WebElement BookRoomBtn() {
        return RoomsSec().findElement(By.xpath("//button"));
    }

    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
        driver.navigate().to("https://automationintesting.online/");
    }*/

    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.navigate().to("https://automationintesting.online/");
        PageFactory.initElements(driver, this);
        Utils.waitForElement(driver,"//button[@id='submitContact']");
    }

    @FindBy(xpath = "//div[@class='row hotel-room-info']")
    public WebElement roomSect;
    @FindBy(xpath = "//button")
    public WebElement  btn;
    @FindBy(xpath = "//div[@class='popup-content ']")
    public WebElement popUp;
//    @FindBy(xpath = "//button[@id='next']")
//    public WebElement nextBtn;
    @FindBy(xpath = "//button[@id='closeModal']")
    public WebElement closeBtn;
    @FindBy (xpath = "//button[contains(@class, 'openBooking')]")
    public WebElement bookRoomBtn;
    @FindBy (xpath = "//div[@class='rbc-calendar']")
    public WebElement calendar;
    @FindBy(xpath = "//div[@class='rbc-month-view']/div[3]/div/div[1]")
    public WebElement firstDayOfSecondWeek;
    @FindBy(xpath = "//div[@class='rbc-month-view']/div[3]/div/div[3]")
    public WebElement thirdDayOfSecondWeek;

    // zgodnie z dokumentacja
    public WebElement nextBtn() {
        List<WebElement> list = driver.findElements(By.xpath("//button[@id='next']"));
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
