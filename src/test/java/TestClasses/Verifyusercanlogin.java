package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClasses.Baseclass1;
import PomClasses.Homepage;
import PomClasses.Loginpage;

@Listeners(ListenerClasses.Listener1.class)

public class Verifyusercanlogin {
   static WebDriver driver;
   Loginpage lp;
   ExtentHtmlReporter htmlreporter;
   ExtentReports report;
   ExtentTest test;
   
	@BeforeClass()
	public void beforeclass() throws IOException {
		 htmlreporter = Baseclass1.getHtmlReporter();
		 report = Baseclass1.getReports();
     	 test	= Baseclass1.getExtentTest("Verifyusercanaddaddress");
			
		driver=Baseclass1.getDriver("chrome");
	}
	
	@BeforeMethod
	public void beforemethod() {
		 lp= new Loginpage(driver);
	}
	
	@Test
	public void verifyusercanlogin() throws IOException, InterruptedException {
	  lp.enteremail();
	  lp.enterpassword();
	  lp.clicklogin();
	  
	  
	  Homepage hp = new Homepage(driver);
		hp.getProfileName();
		
		Assert.assertTrue(hp.getProfileName());
		
	}
		
		@AfterMethod
		public void aftermethod(ITestResult result) throws IOException
		{
			if(result.getStatus()==ITestResult.SUCCESS)
			{
				test.log(Status.PASS,"Test is passed" + result.getName());
			}
			else
			{
				String path=lp.getscreenshot(driver,result.getName());
				test.log(Status.FAIL,"Test is failed" + result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			}
		}
	
		@AfterClass
		public void afterclass()
		{
			report.flush();
		}

		
	}
	
	
	
