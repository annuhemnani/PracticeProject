package academy.practiceproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public Properties prop;
	public WebDriver driver;

	public WebDriver intializeDriver() throws IOException{
		prop= new Properties();
		FileInputStream fp= new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\practiceproject\\src\\main\\java\\academy\\practiceproject\\data.properties");
		prop.load(fp); 
		String brwoserName =prop.getProperty("browser");
		if(brwoserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "I:\\myjava\\chromedriver\\chrome95\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		
		else if (brwoserName.equalsIgnoreCase("IE")) {
			
		}
		
		else if (brwoserName.equalsIgnoreCase("firefox")) {
			
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
		
		
	}

}
