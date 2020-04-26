package ecommerceApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

 class BasicsGeneralStoreApp {
	public static AndroidDriver<AndroidElement> Capabilities(String device) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		File appDir = new File("src");
		File app = new File(appDir, "General-Store.apk"); // allows u to access file in any computer
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		if (device.equalsIgnoreCase("demo")) {
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
		}
		else if(device.equalsIgnoreCase("real")) {
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		
		}
		
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10");
		//connection to server
		//AndroidDriver driver = new AndroidDriver(IPaddressOfserver,capabilities);    // This will invokes android object. see below
		
		AndroidDriver<AndroidElement>  driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap); // IP address of every local host in any machine is http://127.0.0.1
		Thread.sleep(5000);
		return driver;
	}
}
