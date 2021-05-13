package PagePackageMainspring;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.google.common.base.Function;

import BasePackageMainspring.BaseClassMainspring;
import BasePackageMainspring.PageBaseClass;

public class AstraZeGlobalProjectPage extends PageBaseClass {

	public AstraZeGlobalProjectPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(xpath = "//a[@id='LOCK_Execute']")
	public WebElement hoverExecuteLink;

	@FindBy(xpath = "//a[@id='LOCK_Defects']")
	public WebElement defectsLink;

	@FindBy(xpath = "//span[@id='KEY_BUTTON_Add-btnIconEl']")
	public WebElement addDefectLink;

	@FindBy(xpath = "//input[@id='_Text_Check_CM_Name']")
	public WebElement nameTextBox;

	@FindBy(xpath = "//select[@id='DN_Severity']")
	public WebElement severityDropBox;

	@FindBy(xpath = "//select[@id='CM_Priority']")
	public WebElement priorityDropBox;

	@FindBy(xpath = "//select[@id='DN_ReportingSource']")
	public WebElement reportingSourceDropBox;

	@FindBy(xpath = "//select[@id='DN_AppraisalType']")
	public WebElement appraisalTypeDropBox;

	@FindBy(xpath = "//select[@id='StandardCode']")
	public WebElement defectDetectionActivityDropBox;

	@FindBy(xpath = "//select[@id='PhaseDetected']")
	public WebElement phaseDetectedDropBox;

	@FindBy(xpath = "//input[@id='CM_DUEDATE']")
	public WebElement dueDateTextBox;

	@FindBy(xpath = "//input[@id='SaveBtn']")
	public WebElement saveFormLink;

	public void clickOnDefects() {
		// logger.log(Status.PASS, "Execute link is hovered");
		try {
			WebDriverWait wait = new WebDriverWait(driver, 35);
			wait.until(ExpectedConditions.visibilityOf(hoverExecuteLink));
			// Explicit Wait is implemented to wait for visibility of link
			
			

			Assert.assertTrue(hoverExecuteLink.isEnabled());
			// After the login of credentials Execute tab is hovered
			if (hoverExecuteLink.isEnabled()) {
				reportInfo("Hovering on Execute Tab");
				Actions act = new Actions(driver);
				act.moveToElement(hoverExecuteLink).build().perform();
				// Actions class is used to hover over Execute Link

				WebDriverWait waits = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.elementToBeClickable(defectsLink));
				// Explicit Wait is implemented to wait for visibility of dropdown
				reportInfo("Clicking on Defects Link");
				reportPass("Defects clicked");
				defectsLink.click();
				// reportPass("Defects clicked");
			} else
				System.out.println("Execute Link is not enabled");
			// If link is not present, Error message is displayed
		} catch (Exception e) {
			e.printStackTrace();
			reportFail("Defects was not clicked" + e.getMessage());// Fail message is reported
		}
	}

	public void addDefect() {
		// logger.log(Status.PASS, "NewDefect is added");
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(addDefectLink));
			// Explicit Wait is implemented so that Defects are visible in link

			reportInfo("Add Defect button is being clicked");
			Assert.assertTrue(addDefectLink.isDisplayed());
			// Assert is used to compare expected and actual values
			if (addDefectLink.isDisplayed()) {
				addDefectLink.click();
				reportPass("Add Defect is clicked");// If the values match, New Defect is added
			} else
				System.out.println("Add Defect Symbol is not displayed");
		} catch (Exception e) {
			e.printStackTrace();
			reportFail("Add Defect Link not clicked" + e.getMessage());
			// If the values don't match, Error message is displayed
		}
	}

	public void filldefectName(String defectName) {
		// logger.log(Status.PASS, "DefectName is added");
		try {
			// Thread.sleep(18000);
			/*WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//iframe[@id='contentframe']"))));
			// Explicit Wait is implemented so that DefectName is visible in link
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='contentframe']")));*/
			
			//Fluent Wait for iframe
			Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver)
					.withTimeout(30, TimeUnit.SECONDS)
					.pollingEvery(10, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);

					WebElement iFrameElement=wait2.until(new Function<WebDriver, WebElement>() {
					@Override
					public WebElement apply(WebDriver input) {
						// TODO Auto-generated method stub
						return input.findElement(By.xpath("//iframe[@id='contentframe']"));
					}
					});
			driver.switchTo().frame(iFrameElement);

			if (nameTextBox.isEnabled()) {
				reportInfo("Entering into Name Box");
				nameTextBox.sendKeys(defectName);
				reportPass(defectName + " Name added successfully");
				// If the defectName tab is present, data is added from data input
			} else
				System.out.println("Name Text Box is not enabled");
		} catch (Exception e) {
			e.printStackTrace();
			reportFail("Defect Name not added" + e.getMessage());
			// If the defectName tab is not present, Error message is displayed
		}
	}

	public void selectdefectSeverity(String defectSeverity) {
		// logger.log(Status.PASS, "DefectSeverity is selected");
		try {

			if (severityDropBox.isEnabled()) {
				reportInfo("Adding Severity");
				Select severityDropdown = new Select(severityDropBox);
				severityDropdown.selectByVisibleText(defectSeverity);
				reportPass(defectSeverity + " Severity Added");
				// If the defectSeverity tab is present, data is added from data input
			} else
				System.out.println("Severity Drop Box is not enabled");
		} catch (Exception e) {
			e.printStackTrace();
			reportFail("Defect Severity not added" + e.getMessage());
			// If the defectSeverity tab is not present, Error message is displayed
		}
	}

	public void selectdefectPriority(String defectPriority) {
		// logger.log(Status.PASS, "defectPriority is selected");
		try {
			if (priorityDropBox.isEnabled()) {
				reportInfo("Adding Priority");
				Select priorityDropdown = new Select(priorityDropBox);
				priorityDropdown.selectByVisibleText(defectPriority);
				reportPass(defectPriority + " Added Priority");
				// If the defectPriority tab is present, data is added from data input
			} else
				System.out.println("Priority Drop Box is not enabled");
		} catch (Exception e) {
			e.printStackTrace();
			reportFail("Defect Priority not added" + e.getMessage());
			// If the defectPriority tab is not present, Error message is displayed
		}
	}

	public void selectdefectReportingSource(String defectReportingSource) {
		// logger.log(Status.PASS, "defectReportingsource is selected");
		try {

			if (reportingSourceDropBox.isEnabled()) {
				reportInfo("Adding Source");
				Select reportingSourceDropdown = new Select(reportingSourceDropBox);
				// Select class is used to select adding source from dropdown
				reportingSourceDropdown.selectByVisibleText(defectReportingSource);
				reportPass(defectReportingSource + " Added source");
				// If the adding source is present, data is added from data input
			} else
				System.out.println("Reporting Source Drop Box is not enabled");
		} catch (Exception e) {
			e.printStackTrace();
			reportFail("Reporting Source not added" + e.getMessage());
			// If the defectREporting Source dropdown is not present, Error message is
			// displayed
		}
	}

	public void selectdefectAppraisalType(String defectAppraisalType) {
		// logger.log(Status.PASS, "defectAppraisalType is selected");
		try {

			if (appraisalTypeDropBox.isEnabled()) {
				reportInfo("Adding Appraisal");
				Select appraisalTypeDropdown = new Select(appraisalTypeDropBox);
				// Select class is used to select adding appraisal from dropdown
				appraisalTypeDropdown.selectByVisibleText(defectAppraisalType);
				reportPass(defectAppraisalType + " Added Appraisal");
				// If the adding appraisal tab is present, data is added from data input
			} else
				System.out.println("Appraisal Type Drop Box is not enabled");
		} catch (Exception e) {
			e.printStackTrace();
			reportFail("Appraisal Type not added" + e.getMessage());
			// If the AppraisalType drop box is not present, Error message is displayed
		}
	}

	public void selectdefectDetectionActivity(String defectDetectionActivity) {
		// logger.log(Status.PASS, "defectDetectionActivityDropBox is selected");
		try {

			if (defectDetectionActivityDropBox.isEnabled()) {
				reportInfo("Adding Activity");
				Select defectDetectionActivityDropdown = new Select(defectDetectionActivityDropBox);
				// Select class is used to select adding activity from dropdown
				defectDetectionActivityDropdown.selectByVisibleText(defectDetectionActivity);
				reportPass(defectDetectionActivity + " Added Activity");
				// If Adding Activity tab is present, data is added from data input
			} else
				System.out.println("Defect Detection Activity Drop Box is not enabled");
		} catch (Exception e) {
			e.printStackTrace();
			reportFail("Detection Activity not added" + e.getMessage());
			// If the DetectActivity Dropbox is not present, Error message is displayed
		}
	}

	public void selectdefectPhaseDetected(String defectPhaseDetected) {
		// logger.log(Status.PASS, "defectPhasedetected is selected");
		try {

			if (phaseDetectedDropBox.isEnabled()) {
				reportInfo("Adding Defect Phase Detected");
				Select phaseDetectedDropdown = new Select(phaseDetectedDropBox);
				// Select class is used to select adding defect Phase detected tab from dropdown
				phaseDetectedDropdown.selectByVisibleText(defectPhaseDetected);
				reportPass(defectPhaseDetected + " Added Defect Phase Detected");
				// If the adding defect Phase detected tab is present, data is added from data
				// input
			} else
				System.out.println("Defect Detection Activity Drop Box is not enabled");
		} catch (Exception e) {
			e.printStackTrace();
			reportFail("Phase Detected not added" + e.getMessage());
			// If the phaseDetected dropdown is not present, Error message is displayed
		}
	}

	public void filldefectDueDate(String defectDueDate) {
		// logger.log(Status.PASS, "filldefectDuedate is selected");

		try {

			if (dueDateTextBox.isEnabled()) {
				reportInfo("Adding Due Date");
				dueDateTextBox.sendKeys(defectDueDate);
				// sendKeys is used to add the data from data input
				reportPass(defectDueDate + " Added Due Date");
				// If the dueDateTextBox is present, data is added from data input
			} else
				System.out.println("Due Date Text Box is not enabled");
			// If TextBox is not enabled error message is displayed
		} catch (Exception e) {
			e.printStackTrace();
			reportFail("Due Date not added" + e.getMessage());
			// If the defectDueDate tab is not present, Error message is displayed
		}
	}

	public void saveDetails() {
		// logger.log(Status.PASS, "details are saved");
		try {
			reportInfo("Saving Form");
			saveFormLink.click();
			reportPass("Saved Form");
			// The details added from datainput are saved

			Thread.sleep(13000);// Needed for query buffer that saves the defect added
			driver.switchTo().parentFrame();
		} catch (Exception e) {
			e.printStackTrace();
			reportFail("Could not save details" + e.getMessage());
			// If the Saving Form link is not present, Error message is displayed
		}
	}

	public void closeBrowser() {
		// Close the browser
		driver.close();
	}

}
