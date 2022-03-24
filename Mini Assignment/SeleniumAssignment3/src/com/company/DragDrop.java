package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\priyankverma\\Downloads\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        driver.navigate().to("https://jqueryui.com/droppable/");
        Actions act = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        WebElement from= driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement to= driver.findElement(By.xpath("//*[@id=\"droppable\"]"));

        act.clickAndHold(from).moveToElement(to).release().build().perform();
        System.out.println();

    }
}
