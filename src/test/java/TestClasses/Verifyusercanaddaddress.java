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

import PomClasses.Profilepage;

@Listeners(ListenerClasses.Listener1.class)

public class Verifyusercanaddaddress {

	static WebDriver driver;
	Homepage hp;
	Profilepage pp;
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
		 hp= new Homepage(driver);
	}
	
	@Test
	public void verifyusercangotoprofile() {
		hp.moveToProfileName();
		hp.clickOnProfileText();
	   hp.movebyoffset(driver);
		pp=new Profilepage(driver);
		Assert.assertTrue(pp.getFullProfileName());
		
	}
	
	@Test(priority=1)
	public void verifyuserupdateaddress() throws InterruptedException {
		pp.manageaddress();
		
		int previousaddcount =pp.savedAddressCount();
		System.out.println(previousaddcount);
		
		pp.addaddressbtn();
		pp.addressinput();
		pp.inputadrestext();
		pp.savebtn();
		
		Thread.sleep(1000);
		int currentaddcount =pp.savedAddressCount();
		System.out.println(currentaddcount);
		
		Assert.assertEquals(currentaddcount,previousaddcount + 1);
		
		System.out.println("passed");
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
			String path=hp.getscreenshot(driver,result.getName());
			test.log(Status.FAIL,"Test is failed" + result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}	
	}

	@AfterClass
	public void afterclass()
	{
		report.flush();
	}

}
