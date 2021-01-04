package serenitylabs.tutorials.vetclinic.webdriver;

import net.thucydides.core.webdriver.WebdriverAssertionError;
import net.thucydides.core.webdriver.WebdriverManager;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import org.hamcrest.CoreMatchers;
import org.hamcrest.number.OrderingComparison;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.*;

public class WhenAddingATodoItem {
    //WebDriver CJ;

    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "C:/Program Files/firefoxdriver/geckodriver.exe");
       WebDriver CJ = new FirefoxDriver();

    }

    

//    @Test
//    public void should_add_new_item_to_list() {
//
//        WebDriver driver = new FirefoxDriver();
//
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//        driver.get("http://todomvc.com/examples/angularjs/#/");
//
//        WebElement inputfield = driver.findElement(By.className("new-todo"));
//        inputfield.sendKeys("Buy Some Milk");
//
//        inputfield.sendKeys(Keys.RETURN);
//
//        List<String> todoItems =
//                driver.findElements(By.cssSelector(".todo-list li label")).stream().map(webElement -> webElement.getText()).collect(Collectors.toList());
//        Assertions.assertThat(todoItems).contains("Buy Some Milk");
//
//        driver.quit();
//    }


//    @Test
//    public void cj_go() {
//
//        WebDriver mydriver = new FirefoxDriver();
//
//        mydriver.get("http://todomvc.com/examples/angularjs/#/");
//
//        mydriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//        WebElement input = mydriver.findElement(By.className("new-todo"));
//        input.sendKeys("Buy Some Milk");
//        input.sendKeys(Keys.ENTER);
//
//        List<String> getLabel = mydriver.findElements(By.cssSelector(".todo-list li label")).stream().map(webElement -> webElement.getText()).collect(Collectors.toList());
//        Assertions.assertThat(getLabel).contains("Buy Some Milk");
//
//        mydriver.quit();
//    }


    @Test
    public void cj_second(){
        CJ.get("http://todomvc.com/examples/angularjs/#/");

        CJ.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);


        WebElement type = CJ.findElement(By.className("new-todo"));
        type.sendKeys("Buy Some Milk");
        type.sendKeys(Keys.ENTER);

        List<String> getLabel = CJ.findElements(By.cssSelector(".todo-list li label")).stream().map(WebElement::getText).collect(Collectors.toList());
        Assertions.assertThat(getLabel).contains("Buy Some Milk");

    }

  @Test
    public void Create_a_todo_item() {

      openSite("http://todomvc.com/examples/angularjs/#/");
      addATodo("Buy Some Milk");
      confirmTaskAdded();
      closeBrowser();

  }

    private void confirmTaskAdded() {
        List<String> findLabel = CJ.findElements(By.cssSelector(".todo-list li label")).stream().map(WebElement::getText).collect(Collectors.toList());
        Assertions.assertThat(findLabel).contains("Buy Some Milk");
    }

    private void openSite(String site) {
        CJ.get(site);
        CJ.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private void closeBrowser() {
        CJ.quit();
    }

    private void addATodo(String task) {
        WebElement input = CJ.findElement(By.className("new-todo"));
        input.sendKeys("Buy Some Milk");
        input.sendKeys(Keys.ENTER);
    }


















//    @Test
//    public void default_seven_rows_in_task_table_AND_content() {
//        WebDriver CJ1 = new FirefoxDriver();
//
//        CJ1.get("http://seleniumeasy.com/test/table-search-filter-demo.html");
//
//        //When I see the Tasks table
//        WebElement getTable = CJ1.findElement(By.cssSelector("#task-table > tbody"));
//
//        //Confirm default # of Record Rows = 7
//        List<WebElement> rows = getTable.findElements(By.tagName("tr"));
//        Assertions.assertThat
//                (rows.size()).isEqualTo(7);
//
//        //Confirm first cell in first row = 1
//        WebElement firstValue = getTable.findElement(By.cssSelector("#task-table > tbody > tr:nth-child(1) > td:nth-child(1)"));
//        Assertions.assertThat(firstValue.getText().contains("1"));
//
//        CJ1.quit();
//
//    }
//    @Test
//    public void select_value() {
//        WebDriver driver = new FirefoxDriver();
//        driver.get("http://seleniumeasy.com/test/basic-select-dropdown-demo.html");
//
//
//        Select day = new Select(driver.findElement(By.cssSelector("#select-demo")));
//        day.selectByIndex(1);
//        Assertions.assertThat(day.getFirstSelectedOption().getText()).contains("Sunday");
//        //Assertions.assertThat(day.getFirstSelectedOption(), equalTo("Please select"));
//
//        driver.quit();
//
//        //why does , equalto(t) not work



    }













































































































