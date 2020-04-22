package com.capgemini.tests.tests;

import com.capgemini.tests.common.Utils;
import com.capgemini.tests.pages2.client.MainPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;


public class ClientTests extends BaseClass {

    @Test
    public void firstTest() throws InterruptedException {
        MainPage page = new MainPage(driver);
        if (page.popUp.isDisplayed()) {
            while (page.nextBtn() != null) {//&& page.nextBtn().isDisplayed()){
                page.nextBtn().click();
            }
        }
    }

    @Test
    public void secondTest() {
        MainPage page = new MainPage(driver);
        if (page.popUp.isDisplayed()) {
            for (int i = 0; i < 4; i++) {
                page.nextBtn().click();
            }
            page.closeBtn.click();
        }
        page.bookRoomBtn.click();
        Utils.waitForElement(driver, page.calendar);
    }

    @Test
    public void thirdTest() {
        MainPage page = new MainPage(driver);
        Actions actions = new Actions(driver);
        if (page.popUp.isDisplayed()) {
            actions.doubleClick(page.nextBtn()).perform();
            actions.doubleClick(page.nextBtn()).perform();
            page.closeBtn.click();
        }
//        Utils.waitForElement(driver, page.bookRoomBtn);
        page.bookRoomBtn.click();
        Utils.waitForElement(driver, page.calendar);
//        actions.clickAndHold(page.firstDayOfSecondWeek).perform();
//        actions.moveToElement(page.thirdDayOfSecondWeek).release();
        //NOPE! :)
        actions.moveToElement(page.firstDayOfSecondWeek).clickAndHold(page.firstDayOfSecondWeek)
                .moveToElement(page.thirdDayOfSecondWeek).release().build().perform();
    }
}
