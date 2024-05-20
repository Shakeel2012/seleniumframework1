package main.java.pageEvents;

import main.java.pageObjects.HomePageElements;
import main.java.pageObjects.LoginPageElements;
import main.java.utils.ElementFetch;

public class LoginPageEvents {
    public void verifyLogInButton(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("XPATH", LoginPageElements.logInButton).click();

    }
}
