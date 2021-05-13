package BasePackageMainspring;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PagePackageMainspring.MainspringHomePage;
import Utilities.ExtentReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassMainspring {

	public WebDriver driver;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;

	/****************** Invoke Browser ***********************/
	public void invokeBrowser(String browserName) {

		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				// System.setProperty("webdriver.chrome.driver",
				// System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
				driver = new ChromeDriver();
				/*
				 * WebDriverManager.chromedriver().setup(); Not working driver=new
				 * ChromeDriver();
				 */
			} else if (browserName.equalsIgnoreCase("Mozilla")) {
				WebDriverManager.firefoxdriver().setup();
				// System.setProperty("webdriver.gecko.driver",
				// System.getProperty("user.dir") + "//Drivers//geckodriver.exe");
				driver = new FirefoxDriver();
				/*
				 * WebDriverManager.firefoxdriver().setup(); Not working driver = new
				 * FirefoxDriver();
				 */
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

	}

	/********************** Open Application ***************/
	public MainspringHomePage openApplication() {
		driver.get("https://pratesting.cognizant.com/");
		MainspringHomePage homepage = new MainspringHomePage(driver, logger);
		PageFactory.initElements(driver, homepage);
		return homepage;
	}

	@AfterMethod
	public void flushReports() {
		logger.log(Status.INFO, "Closing browser");
		driver.quit();
		logger.log(Status.PASS, "Closed browser successfully");
		report.flush();

	}

}
