package PomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import UtulityClasses.UtilityClass1;



public class Loginpage extends UtilityClass1 {
       WebDriver driver;
	
	   
	   @FindBy(xpath="(//input[@type='text'])[2]")
	      private WebElement emailadress;
	   
		@FindBy(xpath="//input[@type='password']")
		private WebElement password ;
		
		@FindBy(xpath="(//button[@type='submit'])[2]")
		private WebElement loginbtn;
		
	   
		public Loginpage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
			this.driver=driver;
		}
		
		public void enteremail() throws IOException {
		 emailadress.sendKeys(getProperty("username"));;
		}
		
	   public void enterpassword() throws IOException {
			password.sendKeys(getProperty("password"));;
		}
		
	   public void clicklogin() {
		   loginbtn.click();;
	   }

	
}
