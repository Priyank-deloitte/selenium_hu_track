package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\priyankverma\\Downloads\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350);","");
        WebElement alert = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[29]/a"));
        alert.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
        String text= driver.switchTo().alert().getText();
        System.out.println(text);
        driver.switchTo().alert().sendKeys("Test");
        driver.switchTo().alert().accept();

    }
}
