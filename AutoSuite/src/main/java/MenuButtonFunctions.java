import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuButtonFunctions {

	public static List<WebElement> menItmBtns = new ArrayList<WebElement>();
	public static List<Boolean> menuItemResults = new ArrayList<Boolean>();
	public static List<String> menItemList = new ArrayList<String>();

	// Fetch all Menu Stack Options and Collect them in a List
	public void setAndGetAllMenuOptions(WebDriver driver) {

		new HomePage().navToHome(driver);
		driver.findElement(Constants.menuButton).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		menItmBtns = driver.findElements(By.xpath("//*[@class='bm-menu']//nav/*"));

		for (int i = 0; i < menItmBtns.size(); i++) {

			menItemList.add(menItmBtns.get(i).getText());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		driver.findElement(Constants.closeMenu).click();

	}

	// Click the 'All Items' menu option
	public void allItems(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(Constants.Home_URL);
		new HomePage().clickMenuButton(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(Constants.allItemsLink).click();
	}

	// Click the 'About' - menu Option
	public void aboutFunction(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(Constants.Home_URL);
		new HomePage().clickMenuButton(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(Constants.aboutLink).click();

	}

	// Click the 'Log out' - menu Option
	public void logoutFunction(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(Constants.Home_URL);
		new HomePage().clickMenuButton(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(Constants.Logoutlink).click();

	}

	// Click the 'Reset App State ' - menu Option
	public void resetAppState(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(Constants.Home_URL);
		new HomePage().clickMenuButton(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(Constants.resetAppState).click();
		driver.findElement(Constants.closeMenu).click();

	}

	// Loop through the functionality of each Menu Option
	public boolean loopThroughMenubutton(WebDriver driver) {

		for (int i = 0; i < menItemList.size(); i++) {

			if (menItemList.get(i).equals("Reset App State")) {
				resetAppState(driver);
				new CartItems().gotoCart(driver);
				menuItemResults.add(new CartItems().getNumOfItemsInCart(driver) == 0);
			} else if (menItemList.get(i).equals("All Items")) {
				allItems(driver);
				menuItemResults.add(new HomePage().getInventory(driver) == Constants.total_Inventory);
			} else if (menItemList.get(i).equals("About")) {
				aboutFunction(driver);
				menuItemResults.add(driver.findElement(By.xpath("//*[@id='site-header']/div[1]/header/div[2]/a"))
						.getText().equalsIgnoreCase("Sign In"));
			} else {
				logoutFunction(driver);
				menuItemResults.add(new LoginPage().pageContents(driver));
			}

		}

		if (menuItemResults.contains(false)) {
			return false;
		} else
			return true;
	}

}
