package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DemoTest {

    WebDriver driver;


    @BeforeMethod
    public void loginToWebOrders() throws InterruptedException {
        System.out.println("Login steps for application");

        // browser setup
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // navigate
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.manage().window().maximize();

        // username
        driver.findElement(By.xpath("//*[@id='ctl00_MainContent_username']")).sendKeys("Tester");

        // password
        driver.findElement(By.cssSelector("input[type=password]")).sendKeys("test" + Keys.ENTER);
        Thread.sleep(3000);

    }

    @AfterMethod
    public void closeBrowser() {
        System.out.println("closing the browser for following test cases");
        driver.close();
    }

    @Test
    public void checkBoxTest() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Implementing step 3 and 4 of Test Case 1");

        // click on 'Check All' button
        driver.findElement(By.linkText("Check All")).click();

        // get a list of all check boxes and check if each one is selected
        List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//input[@type ='checkbox']"));
        for (WebElement each : allCheckBoxes) {
            Assert.assertTrue(each.isSelected());
            //System.out.println("each.isSelected() = " + each.isSelected());

        }
    }}