package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHomePage {
	
	WebDriver driver;
	
	@FindBy(name="q")
	private WebElement searchBox;
	
	@FindBy(xpath="//a[@class='_3Ep39l']")
	private WebElement loginBTN;
	
	@FindBy(xpath="//span[text()='Electronics']")
	private WebElement elecCategory;
	
	@FindBy(xpath="//span[text()='TVs & Appliances']")
	private WebElement tvAppCategory;
	
	@FindBy(xpath="//span[text()='Men']")
	private WebElement menCategory;
	
	@FindBy(xpath="//span[text()='Women']")
	private WebElement womenCategory;
	
	@FindBy(xpath="//span[text()='Baby & Kids']")
	private WebElement kidsCategory;
	
	@FindBy(xpath="//span[text()='Home & Furniture']")
	private WebElement homeCategory;
	
	@FindBy(xpath="//span[text()='Sports, Books & More']")
	private WebElement sportsBooksCategory;
	
	@FindBy(xpath="//button[@class='vh79eN']")
	private WebElement searchBTN;
	
	public FlipkartHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public FlipkartProdsListPage searchForProduct(String productName)
	{
		searchBox.sendKeys(productName);
		searchBTN.click();
		return new FlipkartProdsListPage(driver);
	}
	
	
}
