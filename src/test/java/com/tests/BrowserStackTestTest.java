package com.tests;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;


public class BrowserStackTestTest extends BrowserStackTestNGTest {

    @Test
    public void amazontest() throws InterruptedException {
      test.log(LogStatus.INFO,"Browser opened");

      //Navigating to amazon
        JavascriptExecutor jse = (JavascriptExecutor)driver;


        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(@class,'search-field')]/input")).sendKeys("iphoneX");
        driver.findElement(By.xpath("//div[contains(@class,'search-field')]/input")).sendKeys(Keys.ENTER);
       // test.log(LogStatus.INFO,"Logged in amazon");
        Thread.sleep(3000);
        //Applying filters

        //driver.findElement(By.xpath("//span[contains(text(),'iOS')]/parent::a/div/label/input")).click();
        //driver.findElement(By.xpath("//label[contains(text(),'Sort by:')]")).click();
        //driver.findElement(By.linkText("Price: High to Low")).click();
        List<WebElement> phones=driver.findElements(By.xpath("//div[starts-with(@class,'s-result-item') and starts-with(@data-cel-widget,'search_result') and @data-asin!='']//span[@class='a-price-whole']"));
        int elements=phones.size();
        System.out.println(elements);
        //Printing the details of all the products

        test.log(LogStatus.INFO,"Product info listed");
        for(int i=1;i<elements;i++) {

            String link = driver.findElement(By.xpath("(//div[starts-with(@class,'s-result-item') and starts-with(@data-cel-widget,'search_result') and @data-asin!='']//span[@class='a-price-whole'])["+i+"]")).getText();
            String productname = driver.findElement(By.xpath("(//div[starts-with(@class,'s-result-item') and starts-with(@data-cel-widget,'search_result') and @data-asin!='']//h2)["+i+"]")).getText();
            String productlink = driver.findElement(By.xpath("(//div[starts-with(@class,'s-result-item') and starts-with(@data-cel-widget,'search_result') and @data-asin!='']//h2/a)["+i+"]")).getAttribute("href");

            System.out.println(productname);
            System.out.println(link);
            System.out.println(productlink);
        }
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Test passed!\"}}");
    }


}