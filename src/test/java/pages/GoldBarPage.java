package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class GoldBarPage {

    WebDriver driver;

    public GoldBarPage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);


    }

    @FindBy(xpath = "//button[@id='reset'][contains(.,'Reset')]")
    public WebElement resetButton;

    @FindBy(xpath = "//button[@id='weigh'][contains(.,'Weigh')]")
    public WebElement weighButton;

    @FindBy(xpath = "//button[@id='coin_0']")
    public WebElement coin_0;
    @FindBy(xpath = "//button[@id='coin_1']")
    public WebElement coin_1;
    @FindBy(xpath = "//button[@id='coin_2']")
    public WebElement coin_2;
    @FindBy(xpath = "//button[@id='coin_3']")
    public WebElement coin_3;
    @FindBy(xpath = "//button[@id='coin_4']")
    public WebElement coin_4;
    @FindBy(xpath = "//button[@id='coin_5']")
    public WebElement coin_5;
    @FindBy(xpath = "//button[@id='coin_6']")
    public WebElement coin_6;
    @FindBy(xpath = "//button[@id='coin_7']")
    public WebElement coin_7;
    @FindBy(xpath = "//button[@id='coin_8']")
    public WebElement coin_8;

    @FindBy(xpath = "//input[@id='left_0']")
    public WebElement leftBox_0;
    @FindBy(xpath = "//input[@id='left_1']")
    public WebElement leftBox_1;
    @FindBy(xpath = "//input[@id='left_2']")
    public WebElement leftBox_2;
    @FindBy(xpath = "//input[@id='left_3']")
    public WebElement leftBox_3;
    @FindBy(xpath = "//input[@id='left_4']")
    public WebElement leftBox_4;
    @FindBy(xpath = "//input[@id='left_5']")
    public WebElement leftBox_5;
    @FindBy(xpath = "//input[@id='left_6']")
    public WebElement leftBox_6;
    @FindBy(xpath = "//input[@id='left_7']")
    public WebElement leftBox_7;
    @FindBy(xpath = "//input[@id='left_8']")
    public WebElement leftBox_8;


    @FindBy(xpath = "//input[@id='right_0']")
    public WebElement rightBox_0;
    @FindBy(xpath = "//input[@id='right_1']")
    public WebElement rightBox_1;
    @FindBy(xpath = "//input[@id='right_2']")
    public WebElement rightBox_2;
    @FindBy(xpath = "//input[@id='right_3']")
    public WebElement rightBox_3;
    @FindBy(xpath = "//input[@id='right_4']")
    public WebElement rightBox_4;
    @FindBy(xpath = "//input[@id='right_5']")
    public WebElement rightBox_5;
    @FindBy(xpath = "//input[@id='right_6']")
    public WebElement rightBox_6;
    @FindBy(xpath = "//input[@id='right_7']")
    public WebElement rightBox_7;
    @FindBy(xpath = "//input[@id='right_8']")
    public WebElement rightBox_8;


    @FindBy(xpath = "//button[@disabled]")
    public WebElement result;






}
