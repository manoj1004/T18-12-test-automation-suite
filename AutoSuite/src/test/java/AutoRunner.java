import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

// WELCOME TO OUR TEST AUTOMATION SUITE
// This MAVEN project runs SELENIUM WebDrivers
// this is primarily designed based on a TEST NG framework

public class AutoRunner {

	// Selenium and Extent Report Object creation
	WebDriver driver;
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest test;

	// --To Test Sorting tool
	@Test(testName = "TC #01 - Test Sorter Tool")

	public void TestCase1() {

		test = extent.createTest("TC #01 - Test Sorter Tool");
		System.out.println("Executing TC #01");

		Assert.assertEquals(new HomePage().sort(driver, "Name (A to Z)"), true,
				"Sort order A - Z doesnt work");
		Assert.assertEquals(new HomePage().sort(driver, "Name (Z to A)"), true, "Sorting Z-A doesnt work");

	}

	// --To Test Menu Options
	@Test(testName = "TC #02 - Test Menu Options ")
	public void TestCase2() {
		test = extent.createTest("TC #02 - Menu Options ");
		System.out.println("Executing TC #2");

		boolean actual_result;
		new MenuButtonFunctions().setAndGetAllMenuOptions(driver);
		actual_result = new MenuButtonFunctions().loopThroughMenubutton(driver);
		assertEquals(actual_result, true);

	}

	// --To Test blank Form submissions error message
	@Test(testName = "TC #03 - Test Blank Forms Error message")
	public void TestCase3() {

		test = extent.createTest("TC #03 - Blank Forms Error message");
		System.out.println("Executing TC #03");

		// login // page blank submissions
		new LoginPage().navToLoginPage(driver);
		driver.findElement(Constants.loginButton).click();
		assertEquals(driver.findElement(Constants.errorButton).isDisplayed(), true);

		// checkout page - blank submissions
		new LoginPage().login(driver);
		new CartItems().gotoCart(driver);
		new CheckoutPage().goToCheckOutPage(driver);
		if (driver.findElements(Constants.checkoutForm).size() > 0) {
			driver.findElement(Constants.cartCheckoutLink).click();
		}
		assertEquals(new CheckoutPage().continueToCheckSummaryOnBlank(driver), true);
	}

	// --To Test Add and Remove Functionality
	@Test(testName = "TC #04 - Test Add or Remove Items")
	public void TestCase4() {

		test = extent.createTest("TC #04 - Test Add or Remove Items");
		System.out.println("Executing TC #04");

		// test Cart Status after adding/removing items
		assertEquals(new HomePage().verifyCartStatus(driver, "Add"), true);
		new HomePage().navToHome(driver);
		assertEquals(new HomePage().verifyCartStatus(driver, "Remove"), true);
	}

	// --To Test Navigation
	@Test(testName = "TC #05 - Test Page Sequence")
	public void TestCase5() {

		test = extent.createTest("TC #05 - Test Page Sequence");
		System.out.println("Executing TC #05");
		Arrays.equals(new Navigation().getActualHeaders(driver), Constants.page_headers);
	}

	// -- Pre Test Method Run prep
	@BeforeMethod
	public void beforeMethod() {

	}

	// -- Log Test Method Results after each Test Case Run
	@AfterMethod
	public void afterMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Fail", ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Pass", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Skip", ExtentColor.GREY));
			test.skip(result.getThrowable());
		}
		new HomePage().navToHome(driver);
	}

	// Pre Test Execution
	// --Logging in to the site
	@BeforeClass
	public void beforeClass() {

		if (driver.getCurrentUrl().contains("index")) {
			new LoginPage().login(driver);
			System.out.println("Log in : Success");
			System.out.println("Test Execution Begins");
		}
	}

	// Post Test Execution
	// --Logging out of the Website
	@AfterClass
	public void afterClass() {
		driver.get(Constants.Home_URL);
		new MenuButtonFunctions().logoutFunction(driver);

	}

	// Set Up Test Environment Pre Test Launch
	// --Set up Browser with URL references on launch
	// --Set up Report configuration
	@BeforeTest
	public void beforeTest() {

		System.setProperty(Constants.propKey, Constants.propValue);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);
		driver.get(Constants.Login_URL);

		extent = new ExtentReports();
		reporter = new ExtentHtmlReporter("./Report/ExtentReport.html");
		extent.attachReporter(reporter);
		reporter.config().setReportName("Sauce Labs Automated Test Execution");
		reporter.config().setDocumentTitle("Automated Regression");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setTestViewChartLocation(ChartLocation.TOP);

	}

	// Post Test Completion
	// -- Close all browser Sessions
	// -- End Active WebDrivers
	@AfterTest
	public void afterTest() {

		driver.close();
		driver.quit();
		System.out.println("Test Execution Complete; Launching Report");
		extent.flush();

	}
}
