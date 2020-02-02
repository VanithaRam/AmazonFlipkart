package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartProdDescPage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='_1vC4OE _3qQ9m1']")
	private WebElement prodPrice;
	
	@FindBy(id="pincodeInputId")
	private WebElement pincodeEdit;
	
	@FindBy(xpath="//span[@class='lF1Zia']")
	private WebElement viewEmiPlans;
	
	@FindBy(xpath="//span[@class='_3Fwewo']")
	private WebElement warrantyDetails;
	
	public FlipkartProdDescPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public String getProdPrice()
	{
		String price = prodPrice.getText();
		return price;
	}
	
}
