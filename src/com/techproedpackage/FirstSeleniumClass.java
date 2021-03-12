package com.techproedpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/selenium dependencies/drivers/chromedriver.exe");

        //Create our driver object
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.google.com");

        //sample windows path
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Hp I7\\Documents\\Selenium Libraries\\drivers\\chromedriver.exe");



    }
}
