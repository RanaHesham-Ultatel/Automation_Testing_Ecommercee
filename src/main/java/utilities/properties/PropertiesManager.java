package utilities.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    public static Properties webConfig;
    public static Properties reportConfig;

    public PropertiesManager() {

    }

    public static void initializeProperties() {
        FileInputStream webConfigFile = null;
        FileInputStream reportConfigFile = null;
        try {
            webConfigFile = new FileInputStream("src/main/resources/WebConfigurations.properties");
            reportConfigFile = new FileInputStream("src/main/resources/Reporting.properties");

            webConfig = new Properties();
            webConfig.load(webConfigFile);

            reportConfig = new Properties();
            reportConfig.load(reportConfigFile);

        } catch (FileNotFoundException e) {
            System.out.println("File isn't readable");

        } catch (IOException e) {
            System.out.println("Property file is not found");
        }


      /* finally {
           try {
               fileInputStream.close();
           } catch (IOException e) {
               System.out.println("");
           }
       }*/

    }

}
