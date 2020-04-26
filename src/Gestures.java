import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.ElementOption;

public class Gestures extends CommonMethod4RealAndEmulator {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement>  driver = Capabilities("real");
		/*driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']").click();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")").click();*/
		
		//click n hold UI
		TouchAction t =new TouchAction(driver);
		
		// unforfunately, there is not direct import for tapOption. We need to copy $ modify the TouchAction import. See Blelow
		// we add static, edit TouchAction = touch. to give method TapOptions. TapOption. to give = tapOptions
		// import static io.appium.java_client.touch.TapOptions.tapOptions;
		
		// Same thing applies to element(tap). we add static, edit TouchAction = touch. to give method offset. and to element. see below
		// import static io.appium.java_client.touch.offset.ElementOption.element;
		
		// no import for ofSeconds. so, u need to do the same as above
		// import static java.time.Duration.ofSeconds;
		
		// t.tap(tapOptions().withElement(webElement().))         create webelement for the object to tap
		WebElement tap = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
		t.tap(tapOptions().withElement(element(tap))).perform();
		
		// normal click method
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']").click();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")").click();
		
		// Long Press
		WebElement longPress = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		t.longPress(longPressOptions().withElement(element(longPress)).withDuration(ofSeconds(2))).release().perform();
		
		System.out.println(driver.findElementById("android:id/title").isDisplayed());
	}

}

