package serenitylabs.tutorials.vetclinic;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Managed;

import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.ToDoubleBiFunction;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;


public class WhenAddingATodoItem {

    @Before
    public void setupClass(){
        WebDriverManager.firefoxdriver().setup();
    }

    @Managed
    WebDriver driver;

    @Test
    public void should_add_new_item_to_list() {

        //System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:/Program Files/firefoxdriver/geckodriver.exe");


        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://todomvc.com/examples/angularjs/#//");

        //When
        driver.findElement(By.cssSelector(".new-todo")).sendKeys("buy some milk", Keys.ENTER);


        List<String> todoItems =
        driver.findElements(By.cssSelector(".todo-list li label")).stream().map(webElement -> webElement.getText()).collect(Collectors.toList());

        //Then
        driver.findElement(By.xpath("//a[contains(text(),'Active')]")).click();
        

       // List<String> setActive =
        //driver.findElements(By.xpath("//a[contains(text(),'Active')]")).stream().map(webElement -> webElement.getText()).collect(Collectors.toList());
        //Assertions.assertThat(setActive).contains("Active");

        Assertions.assertThat(driver.findElement(By.xpath("//a[contains(text(),'Active')]")).getText()).contains("Active");
        System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Active')]")).getText());

        //String getLabel = setActive.getText();
        //String getColour = setActive.getCssValue("border-color");

       // System.out.println(getColour);
        //Assertions.assertThat(getColour).contains("rgb");




       //WebElement setActive = driver.findElement(By.xpath("//a[contains(text(),'Active')]"));
        //String getLabel = setActive.getText();
        //Assertions.assertThat(getLabel).contains("active");


        //WebElement findActive = driver.findElement(By.xpath("//a[contains(text(),'Active')]"));
        //Assertions.assertThat(findActive.getText()).contains("Active");



     //String getText = driver.findElement(By.xpath("//a[contains(text(),'Active')]")).getText();
     //Assertions.assertThat(getText).contains("Active");

       //Assertions.assertThat(todoItems).contains("buy some milk");
       //Assertions.assertThat(getText).contains("Active");

    }

}
