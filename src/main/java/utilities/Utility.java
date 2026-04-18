package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
    public static void takeScreenshot(WebDriver driver, String testName) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotName = testName + "_" + timestamp + ".png";
            Path destination = Paths.get("screenshots", screenshotName);

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.createDirectories(destination.getParent());
            Files.move(source.toPath(), destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}