package com.p4fun.otinane.Sellenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mixalis on 3/1/2017.
 */
public class LoginFailTest {

    @Test
    public void LoginFail() {

        System.setProperty("webdriver.gecko.driver", "C:\\selleniumjarfiles\\geckodriver-v0.11.1-arm7hf\\geckodriver.exe");

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("geo.prompt.testing", true);
        profile.setPreference("geo.prompt.testing.allow", true);
        WebDriver driver = new FirefoxDriver(profile);


        driver.navigate().to("http://localhost:8080/login");
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("TestAcc2");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("12334353");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}