/**********************
Scenario Description:
 Defects
Case Study: Add Defects

Problem Statement : Add Defects

Detailed Description: Main Project

1. Launch the given site
2. Click on Execute Button and Go to Defects option from the dropdown.
3. Add Defects using data from data input.
4. Navigate back to homepage after adding defects.

*Author           :G MUSKAAN NASREEN
*Empid            :904053
*Date of creation :05/11/2021
*************************/
package TestPackageMainspring;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePackageMainspring.BaseClassMainspring;
import PagePackageMainspring.AstraZeGlobalProjectPage;
import PagePackageMainspring.MainspringHomePage;
import Utilities.ExcelUtils;

public class TestClassMainspring extends BaseClassMainspring {

	ExcelUtils excel = new ExcelUtils(System.getProperty("user.dir") + "\\DataInput\\TestData.xlsx", "TestData");
	MainspringHomePage homePage;
	AstraZeGlobalProjectPage astraPage;

	@Test(dataProvider = "dataInput")
	public void automateDefectsMainspring(Map<String, String> data) {
		logger = report.createTest("Mainspring Add Defects: " + data.get("Iteration"));
		invokeBrowser(data.get("Browser"));
		homePage = openApplication();
		astraPage = homePage.clickOnProject();
		astraPage.clickOnDefects();
		astraPage.addDefect();
		astraPage.filldefectName(data.get("DefectName"));
		astraPage.selectdefectSeverity(data.get("DefectSeverity"));
		astraPage.selectdefectPriority(data.get("DefectPriority"));
		astraPage.selectdefectReportingSource(data.get("ReportingSource"));
		astraPage.selectdefectAppraisalType(data.get("AppraisalType"));
		astraPage.selectdefectDetectionActivity(data.get("DetectionActivity"));
		astraPage.selectdefectPhaseDetected(data.get("PhaseDetected"));
		astraPage.filldefectDueDate(data.get("DueDate"));
		astraPage.saveDetails();
		// astraPage.closeBrowser();
	}

	/*
	 * @Test(priority = 1) public void SignInWithNewAccount() {
	 * invokeBrowser("Mozilla"); homePage = openApplication(); astraPage =
	 * homePage.clickOnProject(); astraPage.clickOnDefects(); astraPage.addDefect();
	 * astraPage.filldefectName("Login Defect");
	 * astraPage.selectdefectSeverity("Major");
	 * astraPage.selectdefectPriority("High");
	 * astraPage.selectdefectReportingSource("Cognizant");
	 * astraPage.selectdefectAppraisalType("Testing");
	 * astraPage.selectdefectDetectionActivity("Smoke Testing");
	 * astraPage.selectdefectPhaseDetected("Validation");
	 * astraPage.filldefectDueDate("21-May-2021"); astraPage.saveDetails();
	 * astraPage.closeBrowser(); }
	 */
	@DataProvider
	public Object[][] dataInput() {
		int startIteration = 1;
		int least = startIteration;
		int endIteration = 1;
		// The iteration values are to be changed for the desired data output
		Object[][] data = new Object[endIteration - startIteration + 1][1];
		for (int start = startIteration; start <= endIteration; start++) {
			data[start - least][0] = excel.getMap(String.valueOf((float) start));
			// hashmap is implemented

		}
		return data;
	}

}
