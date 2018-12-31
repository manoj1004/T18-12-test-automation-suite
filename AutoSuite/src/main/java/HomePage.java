import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	Integer[] listofprice;
	String[] listofnames;
	List<WebElement> filteredList = new ArrayList<WebElement>();
	List<String> listofNameElements = new ArrayList<String>();
	List<String> listofPriceElements = new ArrayList<String>();
	int rand_num;

	public void navToHome(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(Constants.Home_URL);

	}

	// Find if page contents match
	public boolean pageContents(WebDriver driver) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (driver.findElements(Constants.menuButton).size() != 0)

		// & driver.findElements(Constants.CartButton).size()!=0) {
		{
			return true;
		} else
			return false;
	}

	// Click on the Menu Stack button
	public void clickMenuButton(WebDriver driver) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("inventory")) {
			driver.findElement(Constants.menuButton).click();
		} else
			driver.get(Constants.Home_URL);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Click on the Product Filter button
	public void clickSorterButton(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(Constants.ProductFilter).click();

	}

	// Get Size of Inventory
	int getInventory(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElements(Constants.inventory_items).size();
	}

	// Test Sorting Tool in Home page By All Categories
	boolean sort(WebDriver driver, String selection) {

		Select sorter = new Select(driver.findElement(By.className("product_sort_container")));
		clickSorterButton(driver);
		switch (selection) {

		case "Price (low to high)":

			sorter.selectByIndex(2);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new Utilities().testLowToHighPrice((Integer[]) setArrays(driver, selection));

		case "Price (high to low)":

			sorter.selectByIndex(3);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// return new Utilities().testHighToLowPrice((Integer[]) setArrays(driver,
			// selection));

		case "Name (A to Z)":

			sorter.selectByIndex(0);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new Utilities().testAtoZ((String[]) setArrays(driver, selection));

		case "Name (Z to A)":

			sorter.selectByIndex(1);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new Utilities().testZtoA((String[]) setArrays(driver, selection));

		}
		return false;

	}

	// Collect all WebElements and store in Arrays for sort comparison
	Object[] setArrays(WebDriver driver, String selection) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (selection.contains("Price")) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			filteredList = driver.findElements(Constants.inventory_item_price);
			for (int i = 0; i < filteredList.size(); i++) {
				listofPriceElements.add(filteredList.get(i).getText());
			}
			listofprice = (Integer[]) listofPriceElements.toArray();
			return listofprice;

		} else {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			filteredList = new ArrayList<WebElement>();
			filteredList = driver.findElements(Constants.inventory_item_name);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (int i = 0; i < filteredList.size(); i++) {
				try {
					Thread.sleep(1200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				listofNameElements.add(filteredList.get(i).getText());
			}

			String[] result = new String[listofNameElements.size()];
			System.arraycopy(listofNameElements.toArray(), 0, result, 0, listofNameElements.toArray().length);
			return result;
		}
	}

	// Set Add To Cart / Remove buttons
	// to a List for future reference
	void setAllAddToCartButtons(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Constants.addtocart_buttonList = driver.findElements(Constants.add_to_cart_);

	}

	// Add Items to Cart
	int addItems(WebDriver driver, int rand) {

		int count = 0;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Constants.invItems = driver.findElements(Constants.inventory_items);
		setAllAddToCartButtons(driver);
		for (int i = 0; i < rand; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.rand_num = new Utilities().getRandomNumber();
			Constants.addtocart_buttonList.get(i).click();
			count++;
		}
		return count;

	}

	// Remove All Items from Cart
	void removeAllItems(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Constants.removefromcart_buttonList = driver.findElements(Constants.remove_from_cart);
		// Constants.invItems = driver.findElements(Constants.inventory_items);

		for (int i = 0; i < 2; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Constants.removefromcart_buttonList.get(i).click();
		}

	}

	// Verify the cart size and status
	boolean verifyCartStatus(WebDriver driver, String option) {

		if (option.equals("Add")) {
			int i1 = addItems(driver, 2);
			System.out.println(i1);
			int i2 = new CartItems().getNumOfItemsInCart(driver);
			System.out.println(i2);

			return i1 == i2;
		} else {

			removeAllItems(driver);
			return new CartItems().getNumOfItemsInCart(driver) == 0;
		}

	}

}
