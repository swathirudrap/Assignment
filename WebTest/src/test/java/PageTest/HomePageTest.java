package PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.HomePage;

public class HomePageTest extends BaseClass{
	HomePage homepage;
	String loan = "$200,000";
	String rate = "5%";
	String term = "30";
	String expMonthly = "$1,073.64";
	String expPay = "$386,513";
	String expInterest = "$186,513";
	
	public HomePageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialize();
		homepage = new HomePage();
		homepage.closemodal();
		
	}
	
	@Test(priority=0)
	public void enterValues() {
		homepage.enterLoan(loan);
		homepage.enterRate(rate);
		homepage.selectTerm(term);
		homepage.selectYear();
		homepage.clickCalculate();
	}
	
	@Test(priority=1)
	public void getMonthly() {
		Assert.assertEquals(homepage.getMonthly(),expMonthly);
	}
	
	@Test(priority=2)
	public void getPayment() {
		Assert.assertEquals(homepage.getTotalPayment(),expPay);
	}
	
	@Test(priority=3)
	public void getInterest() {
		Assert.assertEquals(homepage.getTotalInterest(),expInterest);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}
