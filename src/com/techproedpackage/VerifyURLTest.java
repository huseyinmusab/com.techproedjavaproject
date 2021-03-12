package com.techproedpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyURLTest {
    public static void main(String[] args) {
        // Create a new Class
        //Navigate to google homepage
        //Verify if google homepage url is "www.google.com"

        System.setProperty("webdriver.chrome.driver", "C:/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");
        //getting the page url
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "www.google.com";

        if (actualURL.equals(expectedURL)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
            System.out.println("ACTUAL:" + actualURL);
            System.out.println("EXPECTED: " + expectedURL);

        }
    }
}
