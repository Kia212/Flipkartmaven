package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtulityClasses.UtilityClass1;

public class Homepage extends UtilityClass1 {

	 WebDriver driver;
	  
	  @FindBy(xpath="//div[text()='Akshay']")
	  private WebElement profilename;
	  
	  @FindBy(xpath="(//li[@class='_2NOVgj'])[1]")
		private WebElement myProfileText;
		
	
	
	public Homepage(  WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	
	public boolean getProfileName() throws InterruptedException
	{
		Thread.sleep(1000);
		explicitwait(driver, profilename);
		String pName = profilename.getText();
		
		if(pName.equals("Akshay"))
		{
			return true;
		}
		return false;	
	}

	public void moveToProfileName()
	{
		
		movetoelement(driver,profilename);
		
	}
	
	public void clickOnProfileText()
	{
		WebElement element = explicitwait(driver, myProfileText);
		element.click();
	}
	
	
	
	
	
}
