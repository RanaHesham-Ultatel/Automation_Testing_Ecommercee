package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.profiler.model.TypeObject;
import org.testng.annotations.Factory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ScreenShotManager {

     static String  screenShotsDirectoryPath = "./screenshots";

    //File screenShotsDirectory = new File(screenShotsDirectoryPath);

    public static void captureScreenshots(WebDriver driver , String screenshotName){

       /* Path destination = Paths.get(screenShotsDirectoryPath + screenshotName + ".jpg");
        byte [] byteArray = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        try {
            Files.write(destination,byteArray, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Unable to save screenshot");
        }*/

    //*****************************************************************************/

        // Capture the screenshot and store it in a file
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define the destination directory and file name
        File destDir = new File("./screenshots"); // Ensure the directory exists

        if (!destDir.exists()) {
            destDir.mkdirs();  // Create the directory if it doesn't exist
        }

        File destFile = new File(destDir, screenshotName+".jpg");

        try {
            // Copy the screenshot to the destination file
            FileUtils.copyFile(srcFile, destFile);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Unable to save screenshot");
    }
}
