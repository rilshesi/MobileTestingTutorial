package ecommerceApp;

import java.net.MalformedURLException;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class G_S_tc1b extends BasicsGeneralStoreApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities("real");
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		String taostmessage  = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
		//System.out.println(taostmessage);
		Assert.assertEquals("Please enter your name", taostmessage);

	}

}
