package melvin_raulshettyacademy;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MiscellaneousAppiumActions extends BaseTest{

	
	@Test
	public void Miscellaneous() throws MalformedURLException 
	{
		
		//App Package y App Activity 
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
		
		//estos pasos de navegación ya no se necesitan
		//driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//tagName[@attribute=”value”]    //Forma de un xpath
		//driver.findElement(AppiumBy.xpath
		//("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]"))
		//.click();
		
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		// set wifi name
		
		//Agregar la clase DeviceRotation para girar y quedar horizontal. 90 grados
		DeviceRotation landScape = new DeviceRotation(0,0,90);
		driver.rotate(landScape);
		
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
		
		//Copiar en el portapapeles un texto para luego pegarlo
		driver.setClipboardText("WiFi Melvin");
		
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		//Presionar enter en el teclado, para que baje una linea al escribir
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		//Crea un array con los botones de la pantalla. Cada botón tiene su Index 0/1
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		//Le da al botón de atrás, para regresar una pantalla
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	//Presiona el botón de home para salir de la app
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}
	
}
