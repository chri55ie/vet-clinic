package serenitylabs.tutorials.vetclinic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class WhenLookingForAPetStore {

    @Before
    public void setupClass(){
        WebDriverManager.firefoxdriver().setup();
    }

    @Test
    public void when_looking_for_a_pet_store(){

        //System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:/Program Files/firefoxdriver/geckodriver.exe");


        WebDriver driver = new FirefoxDriver();

        driver.get("http://duckduckgo.com/");

        driver.findElement(By.id("search_form_input_homepage")).sendKeys("pet store");

        driver.findElement(By.id("search_button_homepage")).click();

        assertThat(driver.getTitle(), CoreMatchers.equalTo("pet store at DuckDuckGo"));

        driver.quit();

    }
}
