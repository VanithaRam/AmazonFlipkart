package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
	WebDriver driver; 
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy(linkText="Best Sellers")
	private WebElement bestSellersLink;
	
	@FindBy(linkText="Gift Ideas	")
	private WebElement giftIdeasLink;
	
	@FindBy(linkText="New Releases")
	private WebElement newReleasesLink;
	
	@FindBy(linkText="Today's Deals")
	private WebElement todaysDealsLink;
	
	@FindBy(linkText="Coupons")
	private WebElement couponsLink;

	@FindBy(id="nav-link-accountList")
	private WebElement signIn;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement searchButton;
	
	public AmazonHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}

	public ProdsListInAmazonPage searchForProduct(String productName)
	{
		searchBox.sendKeys(productName);
		searchButton.click();
		return new ProdsListInAmazonPage(driver);
	}
}
