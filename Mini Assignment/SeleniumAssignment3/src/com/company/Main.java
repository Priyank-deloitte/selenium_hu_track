package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import javax.swing.text.Element;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver","C:\\Users\\priyankverma\\Downloads\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350);","");
        WebElement frames = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[22]/a"));
        frames.click();
        Thread.sleep(3000);
        WebElement nestedFrames= driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/a"));
        nestedFrames.click();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println("Frame left found");
        String leftFrameData=(driver.findElement(By.xpath("/html/body")).getText());
        System.out.println(leftFrameData);
        driver.quit();
        System.out.println("pass");

    }
}
