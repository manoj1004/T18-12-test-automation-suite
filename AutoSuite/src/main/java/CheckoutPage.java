import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	// Go to CheckOut page
	public void goToCheckOutPage(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(Constants.checkOutLink).click();
	}

	
	
	// Fill Checkout Form
	public void fillCheckOutform(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(Constants.firstname).sendKeys("Dwight");
		driver.findElement(Constants.lastname).sendKeys("Schrute");
		driver.findElement(Constants.zipcode).sendKeys("54321");
	}

	
	
	// Proceed without filling out form
	public boolean continueToSummaryOnFill(WebDriver driver) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(Constants.cartCheckoutLink).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.findElements(Constants.summaryInfo).size() > 0) {
			return true;
		} else
			return false;

	}

	
	
	// Proceed after filling out form
	public boolean continueToCheckSummaryOnBlank(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.findElements(Constants.errorButton).size() > 0)
			return true;
		else
			return false;
	}
}
