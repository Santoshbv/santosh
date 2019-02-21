package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class basetest implements IAutoConstant{

	static {
		
		System.setProperty(CHOME_KEY, CHOME_VALUE);
	
	}
	public static WebDriver browser_launch() {
		 WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.get(URL);
		return driver;
		
	}
	

}
