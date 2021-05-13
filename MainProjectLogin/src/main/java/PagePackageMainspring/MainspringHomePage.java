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

import BasePackageMainspring.BaseClassMainspring;

public class MainspringHomePage extends BaseClassMainspring {

	static WebDriver driver;

	public MainspringHomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@id='navbar']/div[3]/div[1]")
	public WebElement mouseHoverElement;

	@FindBy(xpath = "/html/body/div[8]/div[3]/ul/li[5]/ul/li[1]/a")
	public WebElement projectElement;

	public AstraZeGlobalProjectPage clickOnProject() {

		try {
			Thread.sleep(54000);
			Assert.assertTrue(mouseHoverElement.isEnabled());
			if (mouseHoverElement.isEnabled()) {
				Actions act = new Actions(driver);
				act.moveToElement(mouseHoverElement).build().perform();

				WebDriverWait wait = new WebDriverWait(driver, 25);
				wait.until(ExpectedConditions.elementToBeClickable(projectElement));

				projectElement.click();
			} else
				System.out.println("Project Mouse Hover Element is not enabled");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, AstraZeGlobalProjectPage.class);

	}

}
