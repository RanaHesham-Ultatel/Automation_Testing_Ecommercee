package listeners.testng;

import driverfactory.Driver;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ScreenShotManager;
import utilities.properties.AllureReportHelper;

import java.io.IOException;
import java.lang.reflect.Field;

import static utilities.properties.AllureReportHelper.cleanAllureReport;
import static utilities.properties.PropertiesManager.initializeProperties;
import static utilities.properties.PropertiesManager.reportConfig;

public class TestNGListener implements ITestListener , IExecutionListener {

    //private WebDriver driver ;
    //private Driver driver;

    @Override
    public void onExecutionStart() {

        System.out.println("*********** Welcome To Selenium Framework *********** ");
        initializeProperties();
        if (reportConfig.getProperty("CleanAllureReport").equalsIgnoreCase("true")){
            AllureReportHelper.cleanAllureReport();
        }
    }
    @Override
    public void onExecutionFinish() {
       // System.out.println("Generating Report .... ");
        if(reportConfig.getProperty("OpenAllureReportAfterExecution").equalsIgnoreCase("true")) {
            try {
               System.out.println("Opening allure Report");
                Runtime.getRuntime().exec("generateAllureReport.bat");

            } catch (IOException e) {
                System.out.println("Unable to generate Allure Report , may be there's an issue in the batch file/commands");
            }
        }
        System.out.println("*********** End of Execution *********** ");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("**** Test is Started :" + result.getName() + "*****");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("**** Success of Test :" + result.getName() + "*****");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed");
        System.out.println("Taking screen shot.....");

        Driver driver = null;
        ThreadLocal<Driver> driverThreadLocal;
        Object currentClass = result.getInstance();
        Field[] fields = result.getTestClass().getRealClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                if (field.getType() == Driver.class) {
                    driver = (Driver) field.get(currentClass);
                }

                if (field.getType() == ThreadLocal.class) {
                    driverThreadLocal = (ThreadLocal<Driver>) field.get(currentClass);
                    driver = driverThreadLocal.get();
                }
            }
        } catch (IllegalAccessException exception) {
            System.out.println("Unable to get field, Field Should be public");
        }

        assert driver != null;
        ScreenShotManager.captureScreenshots(driver.get(), result.getName());

        String fullPath = System.getProperty("user.dir") + result.getName();

       /* try {
            Allure.addAttachment(result.getMethod().getConstructorOrMethod().getName(),
                    FileUtils.openInputStream(new File(fullPath)));
        } catch (IOException e) {
            System.out.println("Attachment isn't Found");
        }*/

//        try {
//            ScreenShotManager.captureScreenshot(
//                    (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance()), result.getName());
//        } catch (NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("******* Failure of Test: " + result.getName() + " ***************");


    }
}
