package Test;

import Utilities.ReadConfig;
import WebPages.Chapter1Page;
import WebPages.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_cases {

    WebDriver driver;
    ExtentReports extent;
    ExtentHtmlReporter htmlReporter;
    ExtentTest test;
    String htmlReportPath = ".//Resource//Reports//ExtentReport.html"; //Path for the HTML report to be saved

    @BeforeClass
    public void setup(){
        htmlReporter = new ExtentHtmlReporter(htmlReportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent Report");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        ReadConfig readconfig=new ReadConfig();
        String baseURL=readconfig.getApplicationURL();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//drivers//chromedriver.exe");
        //use Chrome Driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @Test(priority = 1, enabled = true)
    public void testBookSite() {

        test = extent.createTest("Test Case 1:", "Navigating to 'http://book.theautomatedtester.co.uk/");
        //Create object of HomePage Class
        HomePage home = new HomePage(driver);
        test = extent.createTest("Test Case 2:", "Click on Chapter 1 link");
        home.clickChapter1();
        test.log(Status.INFO, "Clicked on chapter 1 link");
        //Create object of Chapter1Page Class
        test = extent.createTest("Test Case 3:", "Verify text is present on Chapter 1 Page");
        Chapter1Page ch = new Chapter1Page(driver);
        Assert.assertTrue(driver.getPageSource().contains("Assert that this text is on the page"));
        test.log(Status.INFO, "Verified the text is present on the page");
        test = extent.createTest("Test Case 4:", "Navigate back to Home Page");
        ch.navigateToHome();
        test.log(Status.INFO, "Navigate back to Home Page");

    }

    @AfterTest
    public void testEnd() throws Exception {
        extent.flush();
    }

    @AfterClass
    public void close(){
        driver.close();
    }

}
