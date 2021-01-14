package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.OnlinerBasePage;
import org.testng.annotations.Test;

public class OnlinerAuthTest extends OnlinerBaseTest {

    @Test(description = "JIRA#AUTO-0010, authentication user")
    @MethodOwner(owner = "yantonuyk")
    public void testAuthentication() {
        OnlinerBasePage homePage = openHomePage(getDriver());
        homePage = homePage.authentication("yanaantonyuk001@gmail.com", "Finwow-9kubhi-hoctew");
    }
}
