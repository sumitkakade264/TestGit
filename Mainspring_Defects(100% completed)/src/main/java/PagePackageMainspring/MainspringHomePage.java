package PagePackageMainspring;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import BasePackageMainspring.BaseClassMainspring;
import BasePackageMainspring.PageBaseClass;

public class MainspringHomePage extends PageBaseClass {

	public MainspringHomePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(xpath = "//div[@id='navbar']/div[3]/div[1]")
	public WebElement mouseHoverElement;

	@FindBy(xpath = "/html/body/div[8]/div[3]/ul/li[5]/ul/li[1]/a")
	public WebElement projectElement;

	public AstraZeGlobalProjectPage clickOnProject() {
		// logger.log(Status.INFO, "Project is launched");
		try {
			Thread.sleep(54000);
			// Wait is implemented so that the login credentials are filled manually
			Assert.assertTrue(mouseHoverElement.isEnabled());
			if (mouseHoverElement.isEnabled()) {
				reportInfo("Hovering on Hamburger Button");
				Actions act = new Actions(driver);
				act.moveToElement(mouseHoverElement).build().perform();
				// Actions class is used to hover over Execute Link

				WebDriverWait wait = new WebDriverWait(driver, 25);
				wait.until(ExpectedConditions.elementToBeClickable(projectElement));
				// Explicit Wait is implemented so that AstraZeGlobalProject link is visible
				reportInfo("Clicking AstraZeGlobalProject");

				projectElement.click();
			} else
				System.out.println("Project Mouse Hover Element is not enabled");
			// If project mouse hover element is not enabled ,Error message is displayed
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());

		}
		AstraZeGlobalProjectPage projectPage = new AstraZeGlobalProjectPage(driver, logger);
		PageFactory.initElements(driver, projectPage);
		// This method takes the driver instance of the given class and the class type,
		// and returns a Page Object with its fields fully initialized
		return projectPage;

	}

}
