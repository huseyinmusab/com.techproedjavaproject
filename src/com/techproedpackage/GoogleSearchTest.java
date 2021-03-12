package com.techproedpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {
        //    Create a new class : GoogleSearchTest 
        //    Create main method and complete the following task. 
        //    When user goes to https://www.google.com/ 
        //    Search for “porcelain teapot” 
        //    And print how many related results displayed on Google 
        //    Then verify the texts : Home, Stores, Departments

        System.setProperty("webdriver.chrome.driver", "C:/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement searchBox=driver.findElement(By.xpath("//input[@name='q']"));

        //We can clink on Enter using Keys.Enter command
        searchBox.sendKeys("porcelain teapot"+ Keys.ENTER);//sadece porcelain teapot yazarsak google da yazar,tiklayip girip sonuclari gormek icin Keys.ENTER eklemeliyiz
        Thread.sleep(2000);

        WebElement searchResultElement=driver.findElement(By.xpath("//div[@id='result-stats']"));
        String searchResultText=searchResultElement.getText().substring(6,16);// I dont wanna get all result,but some part of that
        System.out.println(searchResultText);

        //    And click on Shopping
        WebElement shopping=driver.findElement(By.linkText("Shopping"));
        shopping.click();
        Thread.sleep(2000);

        WebElement home=driver.findElement(By.linkText("Home")); //hata verdi NIYE? CUNKU BENDE HOME TUSU YOKKKK
        String actualHomeText=home.getText();
        String expectedHomeText="Home";
        if (actualHomeText.equals(expectedHomeText)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }










    }
}
