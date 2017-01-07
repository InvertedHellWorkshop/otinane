package com.p4fun.otinane.Sellenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mixalis on 29/12/2016.
 */

public class LogoutTest {




    @Test
    public void testLogout()
             {
        System.setProperty("webdriver.gecko.driver", "C:\\selleniumjarfiles\\geckodriver-v0.11.1-arm7hf\\geckodriver.exe");

               FirefoxProfile profile= new FirefoxProfile();
                 profile.setPreference("geo.prompt.testing",true);
                 profile.setPreference("geo.prompt.testing.allow",true);
                 WebDriver driver = new FirefoxDriver(profile);


        driver.navigate().to("http://localhost:8080/login");
       driver.findElement(By.name("username")).clear();
       driver.findElement(By.name("username")).sendKeys("TestAcc2");
        driver.findElement(By.name("password")).clear();
       driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                 driver.navigate().to("http://localhost:8080/");
                 driver.findElement(By.linkText("Logout")).click();

     //   driver.quit();
    }

}

