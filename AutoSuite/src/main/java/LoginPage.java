import org.openqa.selenium.WebDriver;

public class LoginPage {

	// Verify the contents of the Login Page
	public boolean pageContents(WebDriver driver) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (driver.findElement(Constants.loginButton).isDisplayed()
				& driver.findElement(Constants.userNameField).isDisplayed()
				& driver.findElement(Constants.passwordField).isDisplayed()) {
			return true;
		} else
			return false;
	}

	// Log into the application or Home Page
	public void login(WebDriver driver) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(Constants.userNameField).sendKeys(Constants.userNameValue);
		driver.findElement(Constants.passwordField).sendKeys(Constants.passwordValue);
		driver.findElement(Constants.loginButton).click();
	}

	// Go To Login Page from any other page 
	public void navToLoginPage(WebDriver driver) {
		if (driver.findElement(Constants.menuButton).isDisplayed()) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(Constants.menuButton).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(Constants.Logoutlink).click();
		}
	}
}
