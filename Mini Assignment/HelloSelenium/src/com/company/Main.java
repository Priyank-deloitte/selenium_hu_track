package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\priyankverma\\Downloads\\chromedriver.exe");
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Headless");
        driver= new ChromeDriver(options);

        launchurl(driver);
        navigate(driver);
        checktitle(driver);
        login(driver);
        displayurl(driver);
        pricing(driver);
        reload(driver);
        driver.quit();
    }

    public static void launchurl(WebDriver driver){
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
    }

    public static void navigate(WebDriver driver){
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        driver.navigate().to("https://phptravels.com/demo");
    }
    public static void checktitle(WebDriver driver){
        String title= driver.getTitle();
        String str= "PHPTRAVELS";
        if(title.contains(str)){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }
    }

    public static void login(WebDriver driver){
        String Parent_window=driver.getWindowHandle();
        driver.findElement(By.xpath("//html/body/header/div/nav/a[4]")).click();
        String title=driver.getTitle();
        driver.navigate().to("https://phptravels.org/login");
        String title1=driver.getTitle();
        if(title==title1){
            System.out.println("PASS");
        }
        else System.out.println("FAIL");

        driver.switchTo().window(Parent_window);
        driver.navigate().to("https://phptravels.com/demo");

    }
    public static void displayurl(WebDriver driver){
        String url=driver.getCurrentUrl();
        System.out.println(url);
    }
    public static void pricing(WebDriver driver){
        driver.findElement(By.xpath("//html/body/header/div/nav/a[2]")).click();
        driver.navigate().back();
    }
    public static void reload(WebDriver driver){
        driver.navigate().refresh();

    }

}
