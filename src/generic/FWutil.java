package generic;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FWutil {
	public static void getPhoto(WebDriver driver,String path) {
		
		try {
			TakesScreenshot t=  (TakesScreenshot)driver;
			File src=t.getScreenshotAs(OutputType.FILE);
			File dest= new File(path);
			FileUtils.copyFile(src, dest);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
