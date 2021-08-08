package testCases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.PageConstants;
import util.ExcelReader;
import util.GetData;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static testCases.TakeScreenShot.takeSnapShot;

public class LoginTest extends GetData {
    static WebDriver driver;
    String currentUrl;
    LoginPage login;

@AfterSuite
    public void tearDown()

    {
        driver.close();
    }
    @AfterMethod
    public void scrnShot(ITestResult result)
    {
        System.out.println("taking screenshot");
        try {
            if(result.getStatus()==ITestResult.FAILURE)
            takeSnapShot(driver,result.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(dataProvider = "dataHudl")
    public void testLogin(String name,String pwd,String url,String tesType) throws InterruptedException {
        driver.get(PageConstants.url);
        login=new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver,30);
        System.out.println(driver.getTitle());
        wait.until(ExpectedConditions.titleContains("Performance analysis tools for sports teams"));
        login.clickLoginSideBtn();
        WebElement uName = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("logIn"));
        uName.clear();
        pass.clear();
        uName.sendKeys(name);
        pass.sendKeys(pwd);
        loginBtn.click();

        if(tesType.equals("Correct credentials")) {
            wait.until(ExpectedConditions.urlContains("home"));
            currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, url);
            login.logout();

        }
        else
        {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[ contains (text(), \"We didn't recognize\" ) ]"))));
            currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, url);
            uName.clear();
            pass.clear();
        }

        driver.manage().deleteAllCookies();
    }

    @BeforeSuite
    public void launchMethod()  {
    try {
        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\librarry\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
              excl = new ExcelReader(PageConstants.excelPath);
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }


}

