import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Test {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		File appDir = new File("src");
		File app = new File(appDir, "ApiDemos-debug.apk"); // allows u to access file in any computer
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		//connection to server
		//AndroidDriver driver = new AndroidDriver(IPaddressOfserver,capabilities);    // This will invokes android object. see below
		
		AndroidDriver<AndroidElement>  driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap); // IP address of every local host in any machine is http://127.0.0.1
	
		
		

	}

}
