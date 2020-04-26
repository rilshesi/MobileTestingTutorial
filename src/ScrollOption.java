import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollOption extends CommonMethod4RealAndEmulator {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		// Scroll into WebElement WebView
		AndroidDriver<AndroidElement> driver = Capabilities("real");
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		// Syntax = new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"););
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
		

	}

}
