//@formatter:off
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class Navigation {

	public static List<String> actual_pageheaders = new ArrayList<String>();

	// Navigate from home page to Checkout Confirmation
	static void navigate(WebDriver driver) {

		if (driver.getCurrentUrl().contains("inventory")) {
			setHeaderArray(driver);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(Constants.cartButton).click();

		} else if (driver.getCurrentUrl().contains("cart")) {
			setHeaderArray(driver);

			driver.findElement(Constants.cartCheckoutLink).click();

		} else if (driver.getCurrentUrl().contains("checkout-step-one")) {
			setHeaderArray(driver);

			new CheckoutPage().fillCheckOutform(driver);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			driver.findElement(Constants.cartCheckoutLink).click();

		} else if (driver.getCurrentUrl().contains("checkout-step-two")) {
			setHeaderArray(driver);

			driver.findElement(Constants.cartCheckoutLink).click();

		} else {
			setHeaderArray(driver);

		}

	}

	// Initialize Arrays with the Page Headers from each page
	static void setHeaderArray(WebDriver driver) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (driver.getCurrentUrl().contains("inventory")) {
			actual_pageheaders.add(driver.findElement(Constants.products_header_label).getText());

		} else {
			actual_pageheaders.add(driver.findElement(Constants.page_header_label).getText());
		}

	}

	// Get Actual Page headers from each page
	public String[] getActualHeaders(WebDriver driver) {
		for (int i = 0; i < Constants.page_headers.length-1; i++) {
		
			navigate(driver);
			
		}
		String[] result = new String[actual_pageheaders.size()];
		System.arraycopy(actual_pageheaders.toArray(), 0, result, 0, actual_pageheaders.toArray().length);
		return result;
	}
}
