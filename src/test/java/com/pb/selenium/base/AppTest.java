package com.pb.selenium.base;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest 
{
	WebDriver driver;
	
	@BeforeTest
	public void bt()
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+File.separator+"drivers"+File.separator+"geckodriver");
       
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList",2);
		
		profile.setPreference("browser.download.dir", System.getProperty("user.dir")+File.separator+"downloads");
		
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv,application/zip");
		
		FirefoxOptions option = new FirefoxOptions();
		option.setProfile(profile);
		
		driver = new FirefoxDriver(option);  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
   }
	
    @Test
    public void shouldAnswerWithTrue()
    {
        driver.get("http://autopract.com/selenium/download.html");
        driver.findElement(By.cssSelector(".mydownload")).click();;
       
    }
}
