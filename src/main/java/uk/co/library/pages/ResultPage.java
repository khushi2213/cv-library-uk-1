package uk.co.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import uk.co.library.utility.Utility;

public class ResultPage extends Utility {

    @CacheLookup
    @FindBy(tagName = "h1")
    WebElement resultText;
    public String getText() throws InterruptedException {
        Thread.sleep(2000);
        // waitUntilVisibilityOfElementLocated(By.tagName("h1"),20);
        return     getTextFromElement(resultText);
    }

    public String getSearchResultText() {
        String message = getTextFromElement(resultText);
        return message;
    }

    public void verifyTheResults(String expected) {
        String expectedMessage = expected;
        String actualMessage = getSearchResultText();
        Assert.assertEquals(expectedMessage, actualMessage, "Result page not displayed");
    }
}
