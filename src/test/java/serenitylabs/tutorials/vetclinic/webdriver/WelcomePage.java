package serenitylabs.tutorials.vetclinic.webdriver;

import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.assertj.core.api.Assertions.assertThat;

public class WelcomePage {

    WebDriver driver;

        @Before
        public void setup() {
            System.setProperty("webdriver.gecko.driver", "C:/Program Files/firefoxdriver/geckodriver.exe");
            driver = new FirefoxDriver();

            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.get("https://app.evaluate.com/ux/webreport/Welcome2.aspx");

            driver.manage().window().maximize();

            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(250))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-byemail")));

            driver.findElement(By.id("login-byemail")).click();

            WebElement email = driver.findElement(By.id("login-email"));
            email.click();
            email.sendKeys("chrissiep@evaluategroup.com");

            WebElement password = driver.findElement(By.id("login-password-1"));
            password.click();
            password.sendKeys("tester");

            driver.findElement(By.id("login-button-1")).click();
        }

    @Test
    public void on_load_of_Welcome_Page_correct_URL_and_SearchBox_displayed(){

            //Find the Search box
            WebElement search = driver.findElement(By.id("inpage_search"));

            //Confirm search box displayed and correct URL
            MatcherAssert.assertThat(search.isDisplayed(), is(true));
            MatcherAssert.assertThat(driver.getCurrentUrl(), Matchers.equalTo("https://app.evaluate.com/ux/WebReport/Welcome2.aspx"));
    }

    @Test
    public void Latest_news_appears_and_first_headline_matches_on_view_story_aspx_when_clicked(){
            //Wait for the page element to load
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#latest-news-content .story:nth-child(1) a")));

        //Get first latest news headline text from the welcome page
        String headline = driver.findElement(By.cssSelector("#latest-news-content .story:nth-child(1) a")).getText();

        //Click the first headline from Latest News
        driver.findElement(By.cssSelector("#latest-news-content .story:nth-child(1) a")).click();

        //Get the page header text for ViewStory.aspx
        String headlineCompare = driver.findElement(By.className("page-heading")).getText();

        //Verify the headline on the welcome page matches the headline on ViewStory.aspx
        Assertions.assertThat(headline).isEqualTo(headlineCompare);
    }

    @After
    public void tidy_up(){
        driver.quit();
    }
}

