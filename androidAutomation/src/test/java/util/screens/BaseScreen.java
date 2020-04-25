package util.screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import screens.AlertHandler;
import util.CustomWait;

import static java.lang.String.format;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


// TODO: Auto-generated Javadoc
/**
 * Base class for all screens Objects.
 * 
 * @author Arley.Bolivar
 *
 */
public abstract class BaseScreen implements AlertHandler{
	
	/** The custom wait. */
	protected CustomWait customWait = new CustomWait();
	
	/** The driver. */
	protected final AndroidDriver<AndroidElement> driver;
	
	/** The log. */
	public Logger log = Logger.getLogger(BaseScreen.class);

	/**
	 * Constructor method for standard screens object.
	 * 
	 * @author Arley.Bolivar, Hans.Marquez
	 * 
	 * @param driver
	 *            : AndroidDriver
	 */
	public BaseScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
	}

	/**
	 * Tab on back button.
	 * 
	 * @author Arley.Bolivar
	 */
	public void tapBack() {
		// driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.navigate()
		.back();
	}


	/**
	 * Scroll down (From Top to Bottom).
	 *
	 * @author Hans.Marquez
	 * @param swipes the swipes
	 */
	public void scrollDown(int swipes) {
		String locator = "new UiScrollable(new UiSelector().resourceIdMatches(\".*ontainer.*\")).flingToEnd(1)";
		scroll(locator, swipes);
	}

	/**
	 * Scroll Up (From Bottom to Top).
	 *
	 * @author Hans.Marquez
	 * @param swipes the swipes
	 */
	public void scrollUp(int swipes) {
		String locator = "new UiScrollable(new UiSelector().resourceIdMatches(\".*ontainer.*\")).flingToBeginning(1)";
		scroll(locator, swipes);
	}


	/**
	 * Scroll.
	 *
	 * @param locator the locator
	 * @param swipes  the swipes
	 */
	public void scroll(String locator, int swipes) {
		int swipesAmount = 0;
		while (swipesAmount < swipes) {
			try {
				driver.findElementByAndroidUIAutomator(locator);
				swipesAmount++;
			} catch (Exception e) {
				swipesAmount++;
			}
		}
	}


	/**
	 * Swipe vertical.
	 *
	 * @param percentage of swipe
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	public void swipeVertical (float percentage) {
		Dimension windowSize = driver.manage().window().getSize();
		TouchAction ta = new TouchAction(driver);
		ta.press(PointOption.point(207, 582)).moveTo(PointOption.point(8, 
				-360)).release().perform();
	}

	/**
	 * Scroll to the text attribute received by parameter.
	 *
	 * @author Arley.Bolivar
	 *
	 * @param text
	 *            : String
	 */
	public void scrollToText(String text) {
		String automator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"%s\"))";
		AndroidElement textOnElement = driver.findElementByAndroidUIAutomator(format(automator, text));
		log.info(textOnElement.getText());
	}
	
	
	/**
	 * Wrapper for click  event specifying custom wait.
	 * 
	 * @author Hans.Marquez
	 *
	 * @param element : AndroidElement
	 */
	public void click(AndroidElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	
	/**
	 * Wrapper for click  event.
	 * 
	 * @author Hans.Marquez
	 *
	 * @param element : AndroidElement
	 */
	public void click(AndroidElement element) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	
	/**
	 * Wrapper for sendKeys event.
	 * 
	 * @author Hans.Marquez
	 *
	 * @param element : AndroidElement
	 * @param sequence: String
	 */
	public void sendKeys(AndroidElement element, String sequence) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(sequence);
	}
	
	/**
	 * Wrapper for sendKeys event.
	 * 
	 * @author Hans.Marquez
	 *
	 * @param element : AndroidElement
	 */
	public boolean isElementAvailable(AndroidElement element) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
		return true;
	}

	/**
	 * Wrapper for getText event.
	 *
	 * @author Hans.Marquez
	 *
	 * @param element : AndroidElement
	 */
	public String getTextFromElement(AndroidElement element) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}


	/**
	 * Wrapper for getText event.
	 *
	 * @author Hans.Marquez
	 *
	 * @param element : AndroidElement
	 */
	public boolean isDisplayed(AndroidElement element) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
		Boolean flag =element.isDisplayed();
		return flag;
	}
	
}
