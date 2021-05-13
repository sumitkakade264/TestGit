package PagePackageMainspring;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BasePackageMainspring.BaseClassMainspring;

public class AstraZeGlobalProjectPage extends BaseClassMainspring {

	static WebDriver driver;

	public AstraZeGlobalProjectPage(WebDriver driver) {
		this.driver = driver;
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

		try {
			WebDriverWait wait = new WebDriverWait(driver, 35);
			wait.until(ExpectedConditions.visibilityOf(hoverExecuteLink));

			Assert.assertTrue(hoverExecuteLink.isEnabled());
			if (hoverExecuteLink.isEnabled()) {
				Actions act = new Actions(driver);
				act.moveToElement(hoverExecuteLink).build().perform();

				WebDriverWait waits = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.elementToBeClickable(defectsLink));

				defectsLink.click();
			} else
				System.out.println("Execute Link is not enabled");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addDefect() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(addDefectLink));

			Assert.assertTrue(addDefectLink.isDisplayed());
			if (addDefectLink.isDisplayed()) {
				addDefectLink.click();
			} else
				System.out.println("Add Defect Symbol is not displayed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void filldefectName(String defectName) {

		try {
			Thread.sleep(18000);

			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='contentframe']")));

			if (nameTextBox.isEnabled()) {
				nameTextBox.sendKeys(defectName);
			} else
				System.out.println("Name Text Box is not enabled");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectdefectSeverity(String defectSeverity) {
		try {

			if (severityDropBox.isEnabled()) {
				Select severityDropdown = new Select(severityDropBox);
				severityDropdown.selectByVisibleText(defectSeverity);
			} else
				System.out.println("Severity Drop Box is not enabled");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectdefectPriority(String defectPriority) {
		try {
			if (priorityDropBox.isEnabled()) {
				Select priorityDropdown = new Select(priorityDropBox);
				priorityDropdown.selectByVisibleText(defectPriority);
			} else
				System.out.println("Priority Drop Box is not enabled");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectdefectReportingSource(String defectReportingSource) {
		try {

			if (reportingSourceDropBox.isEnabled()) {
				Select reportingSourceDropdown = new Select(reportingSourceDropBox);
				reportingSourceDropdown.selectByVisibleText(defectReportingSource);
			} else
				System.out.println("Reporting Source Drop Box is not enabled");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectdefectAppraisalType(String defectAppraisalType) {
		try {

			if (appraisalTypeDropBox.isEnabled()) {
				Select appraisalTypeDropdown = new Select(appraisalTypeDropBox);
				appraisalTypeDropdown.selectByVisibleText(defectAppraisalType);
			} else
				System.out.println("Appraisal Type Drop Box is not enabled");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectdefectDetectionActivity(String defectDetectionActivity) {
		try {

			if (defectDetectionActivityDropBox.isEnabled()) {
				Select defectDetectionActivityDropdown = new Select(defectDetectionActivityDropBox);
				defectDetectionActivityDropdown.selectByVisibleText(defectDetectionActivity);
			} else
				System.out.println("Defect Detection Activity Drop Box is not enabled");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectdefectPhaseDetected(String defectPhaseDetected) {
		try {

			if (phaseDetectedDropBox.isEnabled()) {
				Select phaseDetectedDropdown = new Select(phaseDetectedDropBox);
				phaseDetectedDropdown.selectByVisibleText(defectPhaseDetected);
			} else
				System.out.println("Defect Detection Activity Drop Box is not enabled");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void filldefectDueDate(String defectDueDate) {

		try {

			if (dueDateTextBox.isEnabled()) {
				dueDateTextBox.sendKeys(defectDueDate);
			} else
				System.out.println("Due Date Text Box is not enabled");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveDetails() {
		try {

			saveFormLink.click();

			Thread.sleep(13000);
			driver.switchTo().parentFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeBrowser() {

		driver.close();
	}

}
