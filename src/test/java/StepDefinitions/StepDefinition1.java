package StepDefinitions;

import Resources.SharedDrivers;
import Resources.XPathsResourceFile;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class StepDefinition1 {
//    Logger log= LogManager.getLogger(StepDefinition1.class);
    public static Logger log= LoggerFactory.getLogger(StepDefinition1.class);


    WebDriver driver;
    String base = "https://wiki.geminisolutions.com/login";
    XPathsResourceFile xpath=new XPathsResourceFile();

    Actions action;
    @Before
    public void setup() {
        driver = SharedDrivers.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Given("^User is on the login page$")
    public void loginSetup()
    {
        driver.get(base);
        Assert.assertEquals(base,driver.getCurrentUrl());
        log.info("User is on login page");
    }

    @Then("^Validate all the texts are displayed$")
    public void validateAllTheTextsAreDisplayed() {
       matchText("Gemini Wiki",driver.findElement(By.xpath(xpath.loginTitle)).getText());
       matchText("Select Authentication Provider",driver.findElement(By.xpath(xpath.subTitle)).getText());
       matchText("Azure Active Directory",driver.findElement(By.xpath(xpath.azureButton)).getText());
    }

    public void matchText(String expectedText, String actualText)
    {
        if (expectedText.equalsIgnoreCase(actualText))
        {
            log.info(actualText+" is displayed");
        }
        else
        {
            log.error(actualText +" is not displayed");
        }
    }

    @When("User clicks on azure directory")
    public void userClicksOnAzureDirectory() {
        driver.findElement(By.xpath(xpath.azureButton)).click();
    }

    @Then("^Validate user has logged in$")
    public void validateUserHasLoggedIn() {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://wiki.geminisolutions.com/"));
        Assert.assertEquals("https://wiki.geminisolutions.com/",driver.getCurrentUrl());
    }

    @Then("^Validate title is being displayed$")
    public void validateTitleIsBeingDisplayed() {
       matchText("Gemini Wiki",driver.findElement(By.xpath(xpath.homeTitle)).getText());
    }

    @When("^User clicks on search box$")
    public void userClicksOnSearchBox() {
        driver.findElement(By.xpath(xpath.searchIcon)).click();
    }


    @Then("^Validate label for search box is being displayed$")
    public void validateLabelForSearchBoxIsDisplayed() {
        matchText("Search...", driver.findElement(By.xpath(xpath.searchLabel)).getText());
    }

    @Given("^User is logged in$")
    public void userIsLoggedIn() {
        Assert.assertEquals("https://wiki.geminisolutions.com/",driver.getCurrentUrl());
    }

    @And("Types {string}")
    public void typesText(String text) {
        driver.findElement(By.xpath(xpath.searchBox)).sendKeys(text);
    }

    @Then("^Validate result header is being displayed$")
    public void validateTextIsDisplayed() {
       if(driver.findElement(By.xpath(xpath.resultHeader)).getText().contains("results"))
       {
           log.info("Result is generated");

       }
       else {
           log.error("Result is not generated");
       }
    }

    @When("User sends {string}")
    public void userSendsInvalidText(String text) {
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(xpath.searchBox))).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
        driver.findElement(By.xpath(xpath.searchBox)).sendKeys(text);


    }

    @Then("^Validate result header is not displayed$")
    public void validateResultHeaderIsNotDisplayed() {
        if(!driver.findElement(By.xpath(xpath.resultHeader)).isDisplayed())
        {
           log.info("Result header is not displayed");
        }
        else {
           log.error("Result header is displayed");
        }

    }

    @And("No result image is displayed")
    public void noResultImageIsDisplayed() {
      if(driver.findElement(By.xpath(xpath.noResult)).isDisplayed())
      {
          log.info("No result icon is displayed");
      }
      else {
          log.error("No result icon is not displayed");
      }
    }

    @And("Validate result containers are displayed")
    public void validateResultContainersAreDisplayed() {
        List<WebElement>result=driver.findElements(By.xpath(xpath.resultContainer));
        if(result.size()>0)
        {
            log.info("Result is being displayed");
        }
        else {
            log.error("Result is not displayed");
        }
    }


    @Then("Validate language is displayed")
    public void validateLanguageIsDisplayed() {
        List<WebElement>result=driver.findElements(By.xpath(xpath.resultLanguage));
        for (WebElement e:result)
        {
            if(e.isDisplayed())
            {
                log.info("Language of the content is being displayed");
            }
            else
            {
                log.error("Language of the content is not being displayed");
            }

        }
    }

    @And("Validate close button is displayed")
    public void validateCloseButtonIsDisplayed() {
        if(driver.findElement(By.xpath(xpath.closeButton)).isDisplayed())
        {
            log.info("Close button is displayed");
        }
        else {
            log.error("Close button is not displayed");
        }
        matchText("Close",driver.findElement(By.xpath(xpath.closeText)).getText());
    }

    @And("Message is displayed")
    public void messageIsDisplayed() {
        matchText("No pages matching your query.",driver.findElement(By.xpath(xpath.noResultMessage)).getText());
    }

    @And("Click on close button")
    public void clickOnCloseButton() {
        if (driver.findElement(By.xpath(xpath.closeButton)).isEnabled())
        {
            driver.findElement(By.xpath(xpath.closeButton)).click();
        }
    }

    @Then("^Verify result page is closed$")
    public void verifyResultPageIsClosed() {

            if (driver.findElement(By.xpath(xpath.welcomeText)).isDisplayed()) {
                log.info("Close button is working");
            } else {
                log.error("Close button is not working");
            }
    }

    @And("^Validate Welcome message is displayed$")
    public void validateWelcomeMessageIsDisplayed() {
        matchText("Welcome to Gemini Solutions Wiki",driver.findElement(By.xpath(xpath.welcomeText)).getText());
    }
}
