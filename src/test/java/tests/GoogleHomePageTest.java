package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;

public class GoogleHomePageTest {
    @Test
    public void Test01() {

        Driver.getDriver().get("https://www.google.com/");


        String expected = "Google";
        String actual = Driver.getDriver().getTitle();

        Assert.assertEquals(actual, expected);


        Driver.closeDriver();
    }

    @DataProvider(name = "searchData")
    public Object[][] provideSearchData() {
        return new Object[][]{
                {"selenium", "selenium - Google Search"},
                {"java", "java - Google Search"},
                {"istanbul", "istanbul - Google Search"},

        };
    }


    @Test (dataProvider = "searchData")
    public void Test02(String keyword,String expectedTitle) {

        Driver.getDriver().get("https://www.google.com/");

        WebElement searchBox=Driver.getDriver().findElement(By.name("q"));

        searchBox.sendKeys(keyword+ Keys.ENTER);

        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);

        Driver.closeDriver();



    }
}
