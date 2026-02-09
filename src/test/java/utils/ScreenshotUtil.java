package utils;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class ScreenshotUtil {

    public static void capture(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File dest = new File("screenshots/" + name + ".png");

            FileUtils.copyFile(src, dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}