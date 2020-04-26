package ecommerceApp;

import java.net.MalformedURLException;
import java.time.Duration;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class G_S_tc_2 extends BasicsGeneralStoreApp{
	
	

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
		
		//tc_2.......Item1+Item2:- shop the item in the app by scrolling to specific item and add to cart
		
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"));");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"**/\"Jordan Lift Off/**\").instance(0))");
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(" + "new UiSelector().text(\"Jordan Lift Off\"));");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		System.out.println(driver.findElementsById("com.androidsample.generalstore:id/productName").size());
		
		for(int i=0; i<count; i++) {
			System.out.println(driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText());
			String item1 = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			
			if (item1.equalsIgnoreCase("Jordan Lift Off")) {
				driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']").get(i).click();
				
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(" + "new UiSelector().text(\"Nike SFB Jungle\"));");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}
			
			else if (item1.equalsIgnoreCase("Nike SFB Jungle"))	{
				driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']").get(i).click();	
				
			}
				
		}
		driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']").get(0).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		// Tc_3 – validate if items selected matched cart
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" + ".resourceId(\"com.androidsample.generalstore:id/rvCartProductList\")).scrollIntoView(" + "new UiSelector().text(\"PG 3\"));");
		System.out.println(driver.findElementsById("com.androidsample.generalstore:id/productName").get(0).getText());
		System.out.println(driver.findElementsById("com.androidsample.generalstore:id/productName").get(1).getText());
		System.out.println(driver.findElementsById("com.androidsample.generalstore:id/productName").get(2).getText());
		int count1 = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		for (int j=0; j>count1; j++) {
			System.out.println(driver.findElementsById("com.androidsample.generalstore:id/productName").get(j).getText());
			String cart = driver.findElementsById("com.androidsample.generalstore:id/productName").get(j).getText();
			Assert.assertEquals(("Nike SFB Jungle,Jordan Lift Off,PG 3"), cart);
		}
		
		
		// Tc_4 – validate if total amount matched the sum of items in the cart
		
		G_S_tc_4_Method tc_4 = new G_S_tc_4_Method();
		
		/*Double doubleValue1 = tc_4.getAmountValue(0, driver);
		Double doubleValue2 = tc_4.getAmountValue(1, driver);
		Double doubleValue3 = tc_4.getAmountValue(2, driver);
		Double sumAmt = doubleValue1+doubleValue2+doubleValue3;
		System.out.println(sumAmt);*/
		
		
		Double sum = tc_4.getAmountValue1(driver);
		System.out.println(sum);
		
		
		
		String totalAmount = driver.findElements(By.id("com.androidsample.generalstore:id/totalAmountLbl")).get(0).getText();
		totalAmount = totalAmount.substring(1);
		Double totalAmt = Double.parseDouble(totalAmount);
		
		Assert.assertEquals(sum, totalAmt);
		
		
		/*//Item2
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(" + "new UiSelector().text(\"Nike SFB Jungle\"));");
		//driver.manage().timeouts().implicitlyWait(, TimeUnit.SECONDS);
		System.out.println(driver.findElementsById("com.androidsample.generalstore:id/productName").size());
		int count1 = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		
		for(int j=0; j<count1; j++) {
			
			System.out.println( driver.findElementsById("com.androidsample.generalstore:id/productName").get(j).getText());
			String item2 = driver.findElementsById("com.androidsample.generalstore:id/productName").get(j).getText();
			
			
			if (item2.equalsIgnoreCase("Nike SFB Jungle")) {
				
				driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']").get(j).click();
			}
	
		}*/
	
		
		
		//Tc_5 – validate mobile gestures working for link(long press) and navigate to webview.
		AndroidElement terms = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		TouchAction t = new TouchAction(driver);
		t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(terms)).withDuration(Duration.ofSeconds(2))).release().perform();
		String termsCo = (driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText());
		Assert.assertEquals(termsCo, "Terms Of Conditions");
		
		driver.findElement(By.xpath("//android.widget.Button[@text='CLOSE']")).click();
		
		AndroidElement tap = driver.findElement(By.className("android.widget.CheckBox"));
		t.tap(TapOptions.tapOptions().withElement(ElementOption.element(tap))).perform();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		
		
		//Tc_6 – validate mobile gestures working for link(long press) and navigate to webview.
		// Search hybrid app appium (on how to switch/ get how many context such as  NATIVE_APP and WEBVIEW is present in an APP)
		Set <String> contexts = driver.getContextHandles();
		Thread.sleep(7000);
		
		//the contexts can only be printed using for loop¡¡¡¡¡
		for (String contextName :contexts) {
			Thread.sleep(5000);
			System.out.println(contextName);
			
		}
		driver.context("WEBVIEW_chrome");
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Rilwan");
		
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys(Keys.ENTER);

		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		driver.context("NATIVE_APP");
		
		
	}
	
	
	
}
