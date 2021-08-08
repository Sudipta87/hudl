package testCases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageConstants;


import java.io.File;

public class TakeScreenShot  {

    public static void takeSnapShot(WebDriver driver, String fileWithPath) throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(PageConstants.imagePath+fileWithPath+".png");
        FileUtils.copyFile(SrcFile, DestFile);

    }
}
