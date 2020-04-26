package chromeMobile;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import mobileTesting.Yes;
public class ChromeTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		Yes y = new Yes();
		AndroidDriver<AndroidElement> driver = y.Capabilities();
		driver.get("https://myaccount.peabody.org.uk/");
		WebElement email = driver.findElementByXPath("//input[@name='email']");
		TouchAction t = new TouchAction(driver);
		t.tap(TapOptions.tapOptions().withElement(ElementOption.element(email))).perform();
		driver.findElementByXPath("//input[@name='email']").sendKeys("olushesi_rilwan@yahoo.com");
		driver.findElementByXPath("//input[@name='usr_password']").sendKeys("Rodman");
		driver.findElementByXPath("//button[@class='login-button login-submit']").click();
		System.out.println(driver.getTitle());

	}

}
