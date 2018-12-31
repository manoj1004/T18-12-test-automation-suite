import org.openqa.selenium.WebDriver;

public class CartItems {

	// Navigate to Cart Page
	void gotoCart(WebDriver driver) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(Constants.cartButton).click();
	}

	// Get Number of items present in the cart
	int getNumOfItemsInCart(WebDriver driver) {

		gotoCart(driver);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return driver.findElements(Constants.cartItems).size();

	}

}
