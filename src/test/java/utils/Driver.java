package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
  private  Driver(){

  }
   private static WebDriver driver;

  public static synchronized WebDriver getDriver() {
      ChromeOptions options = new ChromeOptions();
      if (driver == null) {
        if (System.getProperty("browser") == null) {
            //options.addArguments("--headless");
            options.addArguments("--disable-notifications");
            WebDriverManager.chromedriver().setup();
            //WebDriverManager.chromedriver().browserVersion("121.0.6167.185").setup();
            //WebDriverManager.chromedriver().clearDriverCache().setup();
            //WebDriverManager.chromedriver().clearResolutionCache().setup();
            driver = new ChromeDriver(options);
          } else if (System.getProperty("browser").equals("chromeRemote")){
          try {
              options.addArguments("--headless");
              options.addArguments("--no-sandbox");
              options.addArguments("--disable-dev-shm-usage");
              options.addArguments("--disable-notifications");
              //options.setHeadless(false);
              driver = new RemoteWebDriver(new URL("http://selenium.sc-np.sports.nlsn.media/"), options);
          } catch (MalformedURLException e) {
              e.printStackTrace();
          }
      }
  }
      return driver;
  }
    public static synchronized void closeDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }

        }
    }

