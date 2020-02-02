package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartLoginPage 
{
	WebDriver driver ;
	@FindBy(xpath="//input[@type='text']")
	private WebElement emailEdit;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordEdit;
	
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	private WebElement loginBTN;
	
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	private WebElement closeBTN;
	
	@FindBy(xpath="//button[text()='Request OTP']")
	private WebElement requestOTP;
	
	public FlipkartLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public FlipkartHomePage closeLoginPopUp()
	{
		closeBTN.click();
		return new FlipkartHomePage(driver);
	}
}
