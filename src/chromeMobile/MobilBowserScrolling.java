package chromeMobile;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import mobileTesting.Yes;

public class MobilBowserScrolling {

	
		
		public static void main(String[] args) throws MalformedURLException {
			// TODO Auto-generated method stub
			
			Yes y = new Yes();
			AndroidDriver<AndroidElement> driver = y.Capabilities();

			driver.get("http://cricbuzz.com");
			driver.findElementByXPath("//a[@href='#menu']").click();
			driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
			System.out.println(driver.getCurrentUrl());
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			   jse.executeScript("window.scrollBy(0,480)", "");
			   Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));

	}

}
