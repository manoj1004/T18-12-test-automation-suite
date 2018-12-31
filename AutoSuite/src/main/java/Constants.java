import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Constants {

	// General
	public static final String Login_URL = "https://www.saucedemo.com/index.html";
	public static final String Home_URL = "https://www.saucedemo.com/inventory.html";
	public static final String propKey = "webdriver.chrome.driver";
	public static final String propValue = "/Users/manojmurali/Downloads/chromedriver1108";

	// Login Page WebElements
	public static final By userNameField = By.xpath("//*[@id='login_button_container']/div/form/input[1]");
	public static final By passwordField = By.xpath("//*[@id=\'login_button_container\']/div/form/input[2]");
	public static final String userNameValue = "standard_user";
	public static final String passwordValue = "secret_sauce";
	public final static By loginButton = By.xpath("//*[@class='login-button']");
	public static final By errorButton = By.xpath("//*[@class='error-button']");

	// Home Page Data Structures
	public static final int total_Inventory = 6;
	public static List<WebElement> invItems;
	public static List<WebElement> invItemButtons = new ArrayList<WebElement>();
	public static List<WebElement> inventory_itemnames;
	public static List<WebElement> addtocart_buttonList = new ArrayList<WebElement>();
	public static List<WebElement> removefromcart_buttonList;

	// Home Page WebElements
	public static final By menuButton = By.xpath("//*[@class=\"bm-burger-button\"]");
	public static final By cartButton = By.cssSelector("#shopping_cart_container > a > svg");
	public static final By ProductFilter = By.className("product_sort_container");
	public static final By homePage_title = By.cssSelector("#inventory_filter_container > div");
	public static final By page_title = By.cssSelector("#contents_wrapper > div.subheader_label");
	public static final By inventory_items = By.xpath("//*[@class='inventory_list']/div");
	public static final By inventory_item_price = By.xpath("//*[contains(@class, 'inventory_item_price')]/text()[2]");
	public static final By inventory_item_name = By.xpath("//*[contains(@class, 'inventory_item_name')]");
	public static final By add_to_cart_ = By.xpath("//*[contains(@class, 'add-to-cart-button')]");
	public static final By remove_from_cart = By.xpath("//*[contains(@class,'remove-from-cart-button')]");

	// MenuButton WebElements
	public static final By Logoutlink = By.xpath("//*[@id='logout_sidebar_link']");
	public static final By allItemsLink = By.xpath("//*[@id='inventory_sidebar_link']");
	public static final By aboutLink = By.xpath("//*[@id='about_sidebar_link']");
	public static final By resetAppState = By.xpath("//*[@id=\'reset_sidebar_link']");
	public static final String[] page_headers = { "Products", "Your Cart ", "Checkout: Your Information",
			"Checkout: Overview", "Checkout: Complete!" };
	public static List<String> menuOptions = new ArrayList<String>();
	public static final By closeMenu = By.xpath("//*[@class='bm-cross-button']//button");

	// Cart Page List
	public static final By cartItems = By.xpath("//*[contains(@class,'cart_item_label')]");
	public static final By checkOutLink = By.xpath("//*[@class='cart_footer']//a[2]");

	// CheckoutPage
	public static final By checkoutForm = By.xpath("//*[@class='checkout_info']");
	public static final By firstname = By.xpath("//*[@class='checkout_info']//input[1]");
	public static final By lastname = By.xpath("//*[@class='checkout_info']//input[2]");
	public static final By zipcode = By.xpath("//*[@class='checkout_info']//input[3]");
	public static final By cartCheckoutLink = By.xpath("//*[@class='cart_checkout_link']");

	// CheckoutSummary
	public static final By summaryInfo = By.xpath("//*[@class='summary_info']");

	// Page Headers
	public static final By products_header_label = By.xpath("//*[@id='inventory_filter_container']/div");
	public static final By page_header_label = By.xpath("//*[@id='contents_wrapper']/div[2]");

}
