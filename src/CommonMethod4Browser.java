
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class CommonMethod4Browser {
	
	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
		// TODO Auto-generated method stub
		
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Andriod");
		//cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		cap.setCapability(MobileCapabilityType.BROWSER_VERSION, "76.0");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		//connection to server
		//AndroidDriver driver = new AndroidDriver(IPaddressOfserver,capabilities);    // This will invokes android object. see below
		
		AndroidDriver<AndroidElement>  driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap); // IP address of every local host in any machine is http://127.0.0.1
		return driver;
		
	}	

}
