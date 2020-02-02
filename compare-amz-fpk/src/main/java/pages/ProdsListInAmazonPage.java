package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdsListInAmazonPage {

	WebDriver driver;
	@FindBy(xpath="//span[text()='Apple iPhone XR (64GB) - Yellow']")
	private WebElement prodLink;
	
	@FindBy(xpath="//span[@class='a-button-text a-declarative']")
	private WebElement sortByBTN;
	
	@FindBy(xpath="//span[@class='sb_1z4RmlJR']")
	private WebElement addFeedback;
	
	public ProdsListInAmazonPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getProdLink() {
		return prodLink;
	}

	public ProdDescInAmazonPage clickOnTheProdLink()
	{
		prodLink.click();
		return new ProdDescInAmazonPage(driver);
	}
}
