package scripts;

import java.util.Set;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import generic.BaseClass;
import pages.AmazonHomePage;
import pages.FlipkartHomePage;
import pages.FlipkartLoginPage;
import pages.FlipkartProdDescPage;
import pages.FlipkartProdsListPage;
import pages.ProdDescInAmazonPage;
import pages.ProdsListInAmazonPage;

public class comparePriceTest extends BaseClass {
	
	public int amzProdPrice;
	public int fpkProdPrice;
	
	/**
	 * Fetches price of iPhone XR from Amazon
	 */
	@Test
	public void amazonTest()
	{
		ExtentTest logger = report.startTest("amazonTest");
		logger.log(LogStatus.INFO, "Launch Amazon.in");
		driver.get(flib.getDataFromProperties("amazonURL"));
		AmazonHomePage amzHome = new AmazonHomePage(driver);
		logger.log(LogStatus.INFO, "Search For iPhone XR");
		ProdsListInAmazonPage amzProdList = amzHome.searchForProduct("iPhone XR (64GB) - Yellow");
		logger.log(LogStatus.INFO, "Select the First Link");
		ProdDescInAmazonPage amzProdDesc = amzProdList.clickOnTheProdLink();
		logger.log(LogStatus.INFO, "View Product Description Page");
		Set<String> allWHS = driver.getWindowHandles();
		for(String wh : allWHS)
		{
			driver.switchTo().window(wh);
		}
		String str = amzProdDesc.getProductPrice().replace(",","").replace(" ","");
		String price = str.substring(1, str.length());
		amzProdPrice = Double.valueOf(price).intValue();
		System.out.println("Price in Amazon.in is ----> " + amzProdPrice);
		logger.log(LogStatus.PASS, "Price Captured From Amazon");
		report.endTest(logger);
	}
	
	/**
	 * Fetches price of iPhone XR from Flipkart
	 */
	@Test
	public void flipkartTest()
	{
		ExtentTest logger = report.startTest("flipkartTest");
		logger.log(LogStatus.INFO, "Launch Flipkart.com");
		driver.get(flib.getDataFromProperties("flipkartURL"));
		FlipkartLoginPage login = new FlipkartLoginPage(driver);
		FlipkartHomePage fpkhome = login.closeLoginPopUp();
		logger.log(LogStatus.INFO, "Search For iPhone XR");
		FlipkartProdsListPage fpkProdList = fpkhome.searchForProduct("iPhone XR (64GB) - Yellow");
		logger.log(LogStatus.INFO, "Select the First Link");
		FlipkartProdDescPage fpkProdDesc = fpkProdList.selectTheProd();
		logger.log(LogStatus.INFO, "View Product Description Page");
		Set<String> allWHS = driver.getWindowHandles();
		for(String wh : allWHS)
		{
			driver.switchTo().window(wh);
		}
		String str = fpkProdDesc.getProdPrice().replace(",","");
		String price = str.substring(1, str.length());
		fpkProdPrice = Integer.parseInt(price);
		System.out.println("Price in Flipkart.com is ----> " + fpkProdPrice);
		logger.log(LogStatus.PASS, "Price Captured From Flipkart");
		report.endTest(logger);
	}
		
	/**
	 * Compares Iphone price from amazon and Flipkart
	 * 
	 */
	@Test
	public void priceComparisionTest()
	{
		ExtentTest logger = report.startTest("priceComparisionTest");
		logger.log(LogStatus.INFO, "Compare the Price");
		if(amzProdPrice < fpkProdPrice)
		{
			System.out.println("Iphone price is lesser in Amazon");
			logger.log(LogStatus.PASS, "Iphone price is lesser in Amazon");
		}
		else
		{
			System.out.println("Iphone price is lesser in Flipkart");
			logger.log(LogStatus.PASS, "org is verified");
		}
		report.endTest(logger);
	}
}
