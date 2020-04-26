package ecommerceApp;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class G_S_tc_4_Method {

	
	public Double getAmountValue(int value, AndroidDriver<AndroidElement> driver) {
		
		String amount = driver.findElements( By.id("com.androidsample.generalstore:id/productPrice")).get(value).getText();	
		
		amount = amount.substring(1);
		Double doubleValue = Double.parseDouble(amount);
		return doubleValue;
	}
	
	
	
	

	public Double getAmountValue1(AndroidDriver<AndroidElement> driver) {
		int amount = driver.findElements( By.id("com.androidsample.generalstore:id/productPrice")).size();
		double sum = 0;
		for (int i=0; i<amount; i++) {
		 String values = driver.findElements( By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
		 values = values.substring(1);
		 Double valuesAmount = Double.parseDouble(values);
		 sum = sum + valuesAmount;
		
		}
		return sum;
	}
	
	
	
	
	
}
