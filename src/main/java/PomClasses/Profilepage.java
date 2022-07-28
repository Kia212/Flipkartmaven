package PomClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtulityClasses.UtilityClass1;

public class Profilepage extends UtilityClass1 {

	
   WebDriver driver;
	
	@FindBy(xpath="//div[@class='_1ruvv2']")
	private WebElement profileFullName;
	
	@FindBy(xpath="//div[text()='Manage Addresses']")
	private WebElement manageaddressbtn;
	
	@FindBy(xpath="//div[@class='_1QhEVk']")
	private WebElement newaddressbtn;
	
	@FindBy(xpath="//div[@class='_1lRtwc _1Jqgld']/input") 
	private List<WebElement>  addaddressfeild;

	@FindBy(xpath="//textarea[@name='addressLine1']")
	private WebElement streetaddtext;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement savebtn;
	
	@FindBy(xpath="//div[@class='_1CeZIA']")
	private List<WebElement> savedAddressCount;

	
	public Profilepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public boolean getFullProfileName()
	{
		WebElement element = explicitwait(driver, profileFullName);
		String fullName = element.getText();
		
		if(fullName.contains("Akshay"))
		{
			return true;
		}	
		return false;
	}
	
	public void manageaddress() {
		manageaddressbtn.click();
	}
	
	public void addaddressbtn() {
		newaddressbtn.click();
	}
	
	public void addressinput() {
		String [] p = {"Rahul", "7845124512", "411041", "Nanded City, Pune"};
		for(int i=0;i<4;i++) {
			addaddressfeild.get(i).sendKeys(p[i]);
		}	
	}
	
	public void inputadrestext() {
		streetaddtext.sendKeys("G-102, Asawari,Nanded City pune");
	}
	
	public void savebtn() {
		savebtn.click();
	}
	
	public int savedAddressCount()
	{
		return savedAddressCount.size();
	}
}
