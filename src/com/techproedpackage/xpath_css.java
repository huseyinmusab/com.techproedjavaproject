package com.techproedpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpath_css {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //user goes to http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");
        Thread.sleep(2000);//puts 2 second wait
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //Locate the elements of email textbox,password textbox, and signin button

        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='session_email']"));
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@value='Sign in']"));

        //        Enter below username and password then click sign in button
        emailTextBox.sendKeys("testtechproed@gmail.com");

        //Username :  testtechproed@gmail.com
        //Password : Test1234!
        passwordTextBox.sendKeys("Test1234!");
        Thread.sleep(2000);

        signInButton.click();
        Thread.sleep(2000);

        // Then verify that the expected user id testtechproed@gmail.com

        //1. find the webelement of the testtechproed@gmail.com
        //2. get the text of the webelement using getText() method
        //3. We can assertion- verify the result

        String expectedUserID = "testtechproed@gmail.com"; //Siteye girdikten sonra user id sag ust kosede cikar .bu noktadaki text i check edecegiz.emailtext box a girdigimizi degil

        //<span class="navbar-text" data-test="current-user">testtechproed@gmail.com</span>

        WebElement userID  =driver.findElement(By.xpath("//span[@class='navbar-text']")); //we locate by using xpath
        String actualUserIDText =userID.getText();

        if (expectedUserID.equals(actualUserIDText)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
            System.out.println("EXPECTED ID : "+expectedUserID);
            System.out.println("ACTUAL ID TEXT : "+actualUserIDText);
        }
        //Sign out from the page
        //<a class="nav-item nav-link" data-test="sign-out" rel="nofollow" data-method="delete" href="/sign_out">Sign out</a>
        ////a[@class='nav-item nav-link'][2]

        Thread.sleep(2000);
        WebElement signOut=driver.findElement(By.xpath("(//a[@class='nav-item nav-link'])[2]"));
        signOut.click();

        //To understand if we signed out, we can find a core element like sign in button to verify
        Thread.sleep(2000);
        //I am checking if signInButton element is visible after clicking on sign out
        //WebElement signInButton = driver.findElement(By.xpath("//input[@value='Sign in']"));==>(StaleElementReferenceException)Bu olmaz ,cunku basta bunu tanimladik zaten,bir daha yazanayiz,selenium exception verir
        WebElement signIn         = driver.findElement(By.xpath("//input[@value='Sign in']"));// thats why we have to create a new element

        //isDispladed() =>>>> This method is used to check is the element is on the page or not. It Returned boolean
        //If the element is on the page, this returns true it the element is not on the page, this returns false.

        if (signIn.isDisplayed()){
            System.out.println("PASSED. YOU ARE IN SING IN PAGE");
        }else{
            System.out.println("FAILED. YOU ARE NOT ON SIGN IN PAGE");
        }

        //Locating the email, password, signin element with CSS locator

        WebElement emailTextCSS=driver.findElement(By.cssSelector("input[type='email']"));
        WebElement passwordTextCSS=driver.findElement(By.cssSelector("#session_password"));
        WebElement signInCSS=driver.findElement(By.cssSelector("input[type='submit']"));

        Thread.sleep(2000);
        emailTextCSS.sendKeys("testtechproed@gmail.com");
        Thread.sleep(2000);
        passwordTextCSS.sendKeys("Test1234!");
        Thread.sleep(2000);
        signInCSS.click();
        driver.close();






























    }

}
