package com.p4fun.otinane.webapp;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.util.concurrent.TimeUnit;

public class ObjectFormBookDoneTestNA {
    @Test
    public void BookDoneAnswered() {

        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("geo.prompt.testing", true);
        profile.setPreference("geo.prompt.testing.allow", true);
        WebDriver driver = new FirefoxDriver(profile);


        driver.navigate().to("http://localhost:8080/login");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("TestAcc3");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:8080/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id='map-canvas']/div/div/div/div[3]")).click();


        //  driver.findElement(By.xpath("//div[@id='map-canvas']/div/div/div/div[3][title='Books.png']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }
}
