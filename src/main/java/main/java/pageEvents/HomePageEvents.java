package main.java.pageEvents;

import main.java.pageObjects.HomePageElements;
import main.java.utils.ElementFetch;

public class HomePageEvents {

    public void signInButton(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("XPATH",HomePageElements.acceptAll).click();
       // elementFetch.getWebElement("XPATH", HomePageElements.signInButton).click();
        elementFetch.getWebElement("XPATH",HomePageElements.destination).click();
        elementFetch.getWebElement("XPATH",HomePageElements.toDestination).click();

    }

}
