package BasePackageMainspring;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.DateUtils;

public class PageBaseClass extends BaseClassMainspring {

	public ExtentTest logger;

	public PageBaseClass(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	/****************** Reporting Functions ******************/
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenshot();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
		takeScreenshot();
	}

	public void reportInfo(String reportInfo) {
		logger.log(Status.INFO, reportInfo);
	}

	/************************* Capture Screenshot **********************/
	public void takeScreenshot() {
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(
				System.getProperty("user.dir") + "\\Screenshots\\" + DateUtils.getTimeStamp() + ".png");

		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "\\Screenshots\\" + DateUtils.getTimeStamp() + ".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
