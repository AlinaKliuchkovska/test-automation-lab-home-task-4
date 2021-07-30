package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
    private static final PropertiesReader propertiesReader = new PropertiesReader();

    public static void setDriver() {
        System.setProperty(propertiesReader.getDriverName(), propertiesReader.getDriverLocation());
        driverPool.set(new ChromeDriver());
    }

    public static WebDriver getDriver() {
        driverPool.get().manage().window().maximize();
        return driverPool.get();
    }

    public static void getURL() {
        getDriver().get(propertiesReader.getURL());
    }

    public static void closeBrowser() {
        driverPool.get().close();
        driverPool.remove();
    }
}