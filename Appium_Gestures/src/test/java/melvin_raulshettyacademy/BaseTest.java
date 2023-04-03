package melvin_raulshettyacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
		//AppiumServiceBuilder = Para iniciar/detener el server Appium
				// Hay que pasarle la ruta donde está la carpeta de appium main.js
				service = new AppiumServiceBuilder()
						.withAppiumJS(new File("C:\\Users\\Usuario\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723).build();
				
				
				//Iniciar el servidor
				service.start();
				
				
				
				//Para poder automatizar apps Android
				UiAutomator2Options options = new UiAutomator2Options();
				
				//Nombre del dispositivo que ejecutará la prueba
				options.setDeviceName("MelvinEmulator2");
				//Ruta de la apk a ejecutar
				options.setApp("C:\\Users\\melvi\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
				
				
				
				//Driver Android: ip+puerto del server , UiAutomator2Options
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
				// Hace que espere 10 segundos entre cada acción.
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration", 3000));
	}
	
	public void scrollToEndAction()
	{
		//No se sabe donde parar
				// Lo que hace es solamente un pequeño scroll en la pantalla
				//Si se quiere seguir bajando se puede meter en un ciclo do while
				//La condición es que encuentre algún elemento que se llame  X
				// El booleano va a retornar True mientras pueda seguir el scroll, si ya no puede es false y sale del ciclo
				// Se le puede agregar alguna condición al código para que rompa el ciclo si encuentra algún elemento.. De lo contrario llegará hasta ya no dar scroll
				boolean canScrollMore;
				do
				{
				canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0
				));
				}
				while(canScrollMore);
	}
	
	public void swipeAction(WebElement ele, String direction) 
	{
	
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				   "elementId", ((RemoteWebElement)ele).getId(),
				    "direction", direction,
				    "percent", 0.75
				));
		
	}
	
	public void dragAndDropAction(WebElement ele, int X, int Y) 
	{
		
		// Java
				((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) ele).getId(),
				    "endX", X,
				    "endY", Y
				));
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		//Cerrar el driver virtual o físico
		driver.quit();
		
		//Detener el servidor Appium
		service.stop();
	}
	
}
