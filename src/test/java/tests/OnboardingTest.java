package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class OnboardingTest extends BaseTest {

    @Test
    public void testUserOnboarding() {
        setup();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser", "password123");
        // Add assertions and further test steps
        teardown();
    }
}
