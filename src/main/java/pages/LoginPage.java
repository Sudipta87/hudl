package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;
    WebElement uName;
    WebElement pass;
    WebElement errorText;
    WebElement profile;


    //    @BeforeSuite
//    public void setChrome() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prashant\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(PageConstants.url);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }
public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }


    public void clickLoginSideBtn() {
        WebElement loginBtn = driver.findElement(By.xpath("(//a[text()='Log in'])[1]"));
        loginBtn.click();
//        currentUrl = driver.getCurrentUrl();
//        Assert.assertEquals(currentUrl, PageConstants.loginUrl);
    }

    public void enterCredentials() throws InterruptedException {
        Thread.sleep(3000);
         uName = driver.findElement(By.id("email"));
         pass = driver.findElement(By.id("password"));
        uName.sendKeys("sudiptaroy1987@gmail.com");
        pass.sendKeys("Yaashika@2021");
    }
    public void logout() throws InterruptedException {
        Actions act=new Actions(driver);

        profile=driver.findElement(By.xpath("//div[@class='hui-globaluseritem__display-name']"));
        act.moveToElement(profile).perform();
        Thread.sleep(2000);


        act.moveToElement(driver.findElement(By.xpath("(//span[text()='Log Out'])[1]")));
        act.click().build().perform();

    }

    public void clickLoginBtn() throws InterruptedException {
        WebElement loginBtn = driver.findElement(By.id("logIn"));
        loginBtn.click();
        Thread.sleep(2000);
//        currentUrl = driver.getCurrentUrl();
//        Assert.assertEquals(currentUrl,PageConstants. homeUrl);
    }
//    @AfterSuite
//    public void tearDown()
//    {
//        driver.manage().deleteAllCookies();
//        driver.close();
//    }
}
