package test.java;

import main.java.pageEvents.HomePageEvents;
import main.java.pageEvents.LoginPageEvents;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {
    @Test
    public void sampleMethodForHomePage(){
        HomePageEvents homePageEvents = new HomePageEvents();
        homePageEvents.signInButton();

        LoginPageEvents loginPageEvents = new LoginPageEvents();
        loginPageEvents.verifyLogInButton();
    }
}
