import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {
  private WebDriver driver;
  private WebDriverWait wait;

  @BeforeEach
  public void setUp() {
    System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
    FirefoxOptions options = new FirefoxOptions();
    options.addArguments("--headless");
    options.addArguments("--disable-extensions");
    driver = new FirefoxDriver(options);
    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  @DisplayName("Should Navigate To Selenium Extension Page And Version Must Be 3.17.1")
  public void shouldNavigateToSeleniumExtensionPageAndVersionMustBe3171() {
    driver.navigate().to("https://chrome.google.com/webstore");
    driver.findElement(By.id("searchbox-input")).click();
    driver.findElement(By.id("searchbox-input")).sendKeys("selenium ide");
    driver.findElement(By.id("searchbox-input")).sendKeys(Keys.ENTER);
    wait.until(webDriver -> webDriver.findElement(By.cssSelector(".a-d-na:nth-child(1) .a-na-d-w")));
    driver.findElement(By.cssSelector(".a-d-na:nth-child(1) .a-na-d-w")).click();
    wait.until(webDriver -> webDriver.findElement(By.cssSelector(".h-C-b-p-D-md")));
    assertEquals(driver.findElement(By.cssSelector(".h-C-b-p-D-md")).getText(), "3.17.1");
  }
}
