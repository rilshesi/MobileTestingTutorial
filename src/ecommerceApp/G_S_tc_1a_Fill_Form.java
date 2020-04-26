package ecommerceApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class G_S_tc_1a_Fill_Form extends BasicsGeneralStoreApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = Capabilities("real");
		
		driver.findElementByXPath("//android.widget.TextView[@text='Afghanistan']").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Barbados\"));");
		//or
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));
		driver.findElementByXPath("//android.widget.TextView[@text='Barbados']").click();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Abibah");
		driver.hideKeyboard();
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

	}

}
