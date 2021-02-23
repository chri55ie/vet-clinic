package serenitylabs.tutorials.vetclinic.webdriver;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Pod {

    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:/Program Files/firefoxdriver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://checkout.pod-point.com");
    }

    @Test
    public void selectacar(){

        driver.findElement(By.className("cookie__btn")).click();

        new Select(driver.findElement(By.id("vehicleBrand"))).selectByVisibleText("Mitsubishi");
          new Select(driver.findElement(By.id("vehicleId"))).selectByVisibleText("Outlander");

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);


        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("optOut")).click();

        driver.findElement(By.xpath("//h4[contains(.,'Universal Charger')]")).click();

        //click
        driver.findElement(By.xpath("//h4[contains(.,'7kW')]")).click();

        //get the first line price and concatenate
        String first = driver.findElement(By.xpath("//span[contains(.,'£879.00')]")).getText();
        String second = driver.findElement(By.xpath("//span[contains(.,'full price')]")).getText();

        String fullPrice = Arrays.asList(second, " - ", first).stream().collect(Collectors.joining());
        System.out.println(fullPrice);
        Assertions.assertThat(fullPrice).isEqualTo("full price - £879.00");

        //get the second line price and concatenate
        String first1 = driver.findElement(By.xpath("//span[contains(.,'£529.00')]")).getText();
        String second1 = driver.findElement(By.xpath("//span[contains(.,'with OLEV grant')]")).getText();

        String fullPrice1 = Arrays.asList(second1, " - ", first1).stream().collect(Collectors.joining());
        System.out.println(fullPrice1);
        Assertions.assertThat(fullPrice1).isEqualTo("with OLEV grant - £529.00");



        //CHECK there are 6 options
       List<WebElement> allExtras = driver.findElements(By.cssSelector(".grid__col-lg-4"));
       Assertions.assertThat(allExtras.size()).isEqualTo(6);

       //pick a random option
       int pickRandom = allExtras.size();
       Random random = new Random();
       int myExtra = random.nextInt(pickRandom);
       allExtras.get(myExtra).click();

        //get the text of the selection and remove the £, then convert string to a number
       String getPrice = allExtras.get(myExtra).findElement(By.className("h4")).getText();
       String removeSymbol = getPrice.replaceAll("[£]","");
       float convertPrice = Float.parseFloat(removeSymbol);
        System.out.println(convertPrice);

       //convert firstprice 879 to integer
        String removeSymbol1 = first.replaceAll("[£]","");
        float convertPrice1 = Float.parseFloat(removeSymbol1);
        System.out.println(convertPrice1);

        //convert firstprice 529 to integer
        String removeSymbol2 = first1.replaceAll("[£]","");
        float convertPrice2 = Float.parseFloat(removeSymbol2);
        System.out.println(convertPrice2);

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("next-button")));

        //gettotals top line
        String finalTotal = driver.findElement(By.cssSelector("#sticky-basket .p-b-none")).getText();
        System.out.println(finalTotal);
        //convert GETTOTALS TOP LINE TO integer
        String TOT = finalTotal.replaceAll("[£]","");
        float convertTot = Float.parseFloat(TOT);
        System.out.println(convertTot);


        //gettotals bottom line
        String finalTotalg = driver.findElement(By.cssSelector("#sticky-basket .grid__col-md-4 span:nth-child(1)")).getText();
        System.out.println(finalTotalg);
        //convert GETTOTALS Bottom LINE TO integer
        String TOT1 = finalTotalg.replaceAll("[£]","");
        float convertTot1 = Float.parseFloat(TOT1);
        System.out.println(convertTot1);

        //calculate
        Float p = convertPrice + convertPrice1;
        Float p1 = convertPrice + convertPrice2;

        System.out.println(p+ " " +p1);
        System.out.println(convertTot);
        System.out.println(convertTot1);

        Assertions.assertThat(p).isEqualTo(convertTot);
        Assertions.assertThat(p1).isEqualTo(convertTot1);

        driver.quit();


    }

}