package com.techproedpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitleTest {
    //Create a new class:VerifyTitLEtEST
    //Navigate to google homepage
    //Verify if google title is "google"
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");

        //get the page title
        String actualTitle = driver.getTitle();

        String expectedTitle = "google";


        //Verify if google title is "google"
        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
            System.out.println("ACTUAL:"+actualTitle);
            System.out.println("EXPECTED: "+expectedTitle);
        }
    }
}