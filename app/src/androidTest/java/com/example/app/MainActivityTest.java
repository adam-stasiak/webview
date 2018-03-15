package com.example.app;


import android.support.test.espresso.web.webdriver.DriverAtoms;
import android.support.test.espresso.web.webdriver.Locator;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.web.sugar.Web.onWebView;
import static android.support.test.espresso.web.webdriver.DriverAtoms.clearElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.findElement;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void beforeMethod() {
        onWebView().forceJavascriptEnabled();
    }

    @Test
    public void mainActivityTest() throws InterruptedException {
        Thread.sleep(6000);
        onWebView()
                .withElement(findElement(Locator.ID, "email--21"))
                .perform(clearElement())
                .perform(DriverAtoms.webKeys("It works!"));
        onWebView()
                .withElement(findElement(Locator.ID, "username--20"))
                .perform(clearElement())
                .perform(DriverAtoms.webKeys("The same!"));

    }

}
