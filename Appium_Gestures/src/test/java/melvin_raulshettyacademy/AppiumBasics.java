package melvin_raulshettyacademy;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics extends BaseTest{

	
	@Test
	public void WifiSettingsName() throws MalformedURLException 
	{
		//AndroidDriver, IOSDriver
		//Crear un objeto, instancia de AndroidDriver
		// Appium code -- > Appium Server -- > Mobile
		
		//Actual automation
		// Locator: Xpath, id, accessibilityId, Classname, androidUiAutomator.
		//Buscar un elemento por accessibilityId y darle click:
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//tagName[@attribute=”value”]    //Forma de un xpath
		driver.findElement(AppiumBy.xpath
		("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]"))
		.click();
		
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		// set wifi name
		
		//Otra forma de hacer un xpath es solamente con el tagname
		//Ejemplo android.widget.relativeLayout
		//Pero cuando tiene varios elementos dentro, como un array, se
		//Puede especificar con cual elemento queremos interactuar
		driver.findElement(AppiumBy.
				xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		
		//Get text: Traer el texto de un elemento para compararlo, se guarda en String
		String text = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		// Se crea un Assert para comparar lo obtenido con lo esperado:
		assertEquals(text, "WiFi settings");
		
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("WiFi Melvin");
		
		//Crea un array con los botones de la pantalla. Cada botón tiene su Index 0/1
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
				
	}
	
}
