package org.example;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Steps {
    int divisionResult = 0;
    WebDriver driver;

//    @Before
//    public void BeforeScenarioHook(Scenario scenario){
//        divisionResult = 0;
//        System.out.println(" Before Scenario: divisionResult is set to 0");
//    }
//
//    @BeforeStep
//    public void doSomethingBeforeStep(Scenario scenario){
//        System.out.println(" Before Step hook");
//    }
//
//    @AfterStep
//    public void doSomethingAfterStep(Scenario scenario){
//        System.out.println(" After Step hook");
//    }
//
//    @After
//    public void AfterScenarioHook(Scenario scenario){
//        divisionResult = 0;
//        System.out.println(" After Scenario: divisionResult is set to 0");
//    }

    @Given("Google Chrome browser is opened")
    public void OpenChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aleksejs\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @When("Open {string} page")
    public void Divide(String url){
        driver.get(url);
    }

    @When("Search for {string}")
    public void SearchFor(String searchInput){
//        WebDriverWait wait = new WebDriverWait(driver, 15);
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Search']")));

        WebElement search = driver.findElement(By.xpath("//input[@id='text']"));
        search.sendKeys(searchInput);

        WebElement findButton = driver.findElement(By.xpath("//div[@class=\"search2__button\"]/button[@role='button']"));
        findButton.click();


    }


    @Given("I have calculator")
    public void IHaveCalc(){
    }

    @When("divide {int} by {int}")
    public void Divide(int cipars1, int cipars2){
        divisionResult = cipars1/cipars2;
    }

    @Then("result should be {int}")
    public void CheckResult(int result){
        Assertions.assertEquals(divisionResult, result);
    }
}
