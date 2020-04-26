import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Basics extends CommonMethod {				//	INHERITANCE= Basics class inherit the features of CommonMethod class with a keyword extends

	public static void main(String[] args) throws MalformedURLException  {
		// TODO Auto-generated method stub
		
		// now we can call the Capabilites method which returns driver object
		//Capabilities();					//returning driver object with data type  AndroidDriver<AndroidElement>   looks like below
		
		AndroidDriver<AndroidElement>  driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
	    driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
	    driver.findElementById("android:id/checkbox").click();
	    driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
	    driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
	    driver.findElementsByClassName("android.widget.Button").get(1).click();
	     
		
		
	     //Android uiautomator object locator
	     
	    // driver.findElementByAndroidUIAutomator("attribute(\"value\")");
	     //driver.findElementByAndroidUIAutomator("text(\"views\")").click();		//common interview question
	     
	     
	     
	 //  Validate clickable feature for all options
	     //  driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)");  
	 //System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size()); 
	     
	     
		

	}

}
