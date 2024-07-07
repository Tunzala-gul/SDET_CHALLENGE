package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.GoldBarPage;
import utils.Driver;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class GoldBar {

    WebDriver driver = Driver.getDriver();
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    GoldBarPage page = new GoldBarPage();
    String fakeCoin;
// Navigate to the website
    @Given("I am on the SDET challenge site")
    public void iAmOnTheSDETChallengeSite() {
        driver.get("http://sdetchallenge.fetch.com/");
        driver.manage().window().maximize();
    }

// Run through the combinations to find the fake gold bar option and select the fake gold bar
    @When("I check the all combinations to find a fake gold bar")
    public void iCheckTheAllCombinationsToFindAFakeGoldBar()  {
        int j=8;
        for (int i = 0; i <4 ; i++,j--) {
         String num_i = String.valueOf(i);
         String num_j = String.valueOf(j);
         driver.findElement(By.xpath("//input[@id='left_"+i+"']")).sendKeys(num_i);
         driver.findElement(By.xpath("//input[@id='right_"+i+"']")).sendKeys(num_j);
         page.weighButton.click();

         int num = i+1;
         try { wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//ol/li["+num+"]")))); }
         catch (org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.NoSuchElementException message)
           { System.out.println(message.getMessage()); }

         if(page.result.getText().equals(">")){
             fakeCoin = driver.findElement(By.xpath("//button[@id='coin_"+j+"']")).getText();
             driver.findElement(By.xpath("//button[@id='coin_"+j+"']")).click();
             break;
         }
         else if(page.result.getText().equals("<")){
             fakeCoin = driver.findElement(By.xpath("//button[@id='coin_"+i+"']")).getText();
             driver.findElement(By.xpath("//button[@id='coin_"+i+"']")).click();
             break;
         }
         else if(i==3) {
             i+=1;
             fakeCoin = String.valueOf(i);
             driver.findElement(By.xpath("//button[@id='coin_"+i+"']")).click();
         }
        }
    }

// After selection I confirm the correct alert message
    @Then("I confirm that I found the fake gold bar")
    public void iConfirmThatIFoundTheFakeGoldBar() {
        Alert alert = driver.switchTo().alert();
        String successfulMessage = "Yay! You find it!";
        Assert.assertEquals("Alert message does not match successful message.",successfulMessage,alert.getText());
        System.out.println(alert.getText());
        alert.accept();
    }

// Output the weigh combinations
    @And("I output the weighing information")
    public void iOutputTheWeighingInformation() {
        List<WebElement> weighInfo = new ArrayList<>(driver.findElements(By.xpath("//ol/li")));
        for (WebElement each : weighInfo) {
            System.out.println(each.getText());
        }
        System.out.println("The fake coin is " + fakeCoin);
        driver.close();
    }
}
