package test.java;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public static WebDriver driver;
    public ExtentHtmlReporter htmlReporter;

    public ExtentReports extent;
    //helps to generate the logs in test report.
    public ExtentTest logger;
   // private Object Constants;

    @BeforeTest
    public void beforeTestMethod() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "AutomationReport.html");

        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation test result");
        htmlReporter.config().setTheme(Theme.DARK);
    }


    @BeforeMethod
    @Parameters(value = {"browserName"})
    public void beforeMethodMethod(String browserName, Method testMethod) {
        logger = extent.createTest(testMethod.getName());
        setupDriver(browserName);
        driver.manage().window().maximize();
        driver.get(Constants.url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethodMethod(ITestResult result) {
        System.out.println("Status of execution is:" + result.getStatus());
        try {
            if (result.getStatus() == ITestResult.SUCCESS) {
                System.out.println("Test case execution status is SUCCESS");
            } else if (result.getStatus() == ITestResult.FAILURE) {
                // Do something here
                System.out.println("Test case execution status is FAILURE");
            } else if (result.getStatus() == ITestResult.SKIP) {
                System.out.println("Test case execution status is SKIP");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }

    @AfterTest
    public void afterTestMethod() {
        extent.flush();
    }

    public void setupDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
           // System.setProperty("webdriver.chrome.driver", "D:\\VFO GitCode\\seleniumframework1\\drivers\\chrome-win64\\chromedriver.exe");
            /*DesiredCapabilities capability = new DesiredCapabilities();
            capability.setCapability("binary", "D:\\VFO GitCode\\seleniumframework1\\drivers\\chromedriver.exe");
            WebDriver driver = new ChromeDriver(capability);*/
            /*driver = new ChromeDriver();*/
            WebDriverManager.chromedriver().setup();
           // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers"+ File.separator + "chrome-win64");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers");
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers");
            driver = new ChromeDriver();
        }
    }
}
