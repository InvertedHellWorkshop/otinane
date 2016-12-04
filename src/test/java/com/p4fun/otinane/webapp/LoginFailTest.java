package com.p4fun.otinane.webapp;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginFailTest {
    @Test
    public void startByWebDriver() {


        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://localhost:8080/login");
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("TestAcc1");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("13345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
}
