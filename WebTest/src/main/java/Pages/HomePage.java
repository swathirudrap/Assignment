package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.BaseClass;

public class HomePage extends BaseClass{
	Wait wait;

	@FindBy(xpath = "//div[contains(@class,'custombox')]/descendant::span[@aria-label='Close']")
	WebElement modalClose;

	@FindBy(xpath = "//input[@name='LOAN_AMOUNT']")
	WebElement loanamt;

	@FindBy(xpath = "//select[@name='TERM']")
	WebElement term;

	@FindBy(xpath = "//input[@id='KJE-INTEREST_RATE']")
	WebElement rate;

	@FindBy(xpath = "//input[@id='KJE-BY_YEAR1']")
	WebElement byYear;

	@FindBy(xpath = "//input[@class='KJECommandButton'][@value='Calculate']")
	WebElement calculate;

	@FindBy(xpath = "//div[@id='KJE-MONTHLY_PAYMENT']")
	WebElement monthlyPay;

	@FindBy(xpath = "//h2[@class='KJEGraphTitle'][contains(text(),'Total Payments')]")
	WebElement totalPayment;
	
	@FindBy(xpath = "//div[@class='KJESubTitle'][contains(text(),'Total Interest')]")
	WebElement totalInterest;
	
	public HomePage() {
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);	
	}

	public void closemodal() {
		
		((WebElement) wait.until(ExpectedConditions.visibilityOf(modalClose))).click();
	}

	public void enterLoan(String loan) {
		loanamt.clear();
		loanamt.sendKeys(loan);
	}

	public void selectTerm(String term1) {
		Select s = new Select(term);
		s.selectByValue(term1);
	}

	public void enterRate(String rate1) {
		rate.clear();
		rate.sendKeys(rate1);
	}

	public void selectYear() {
		byYear.click();
	}

	public void clickCalculate() {
		Actions a = new Actions(driver);
		a.moveToElement(calculate);
		calculate.click();
	}
	
	public String getMonthly() {
		String month = monthlyPay.getText();
		System.out.println("Monthly Payments : "+month);
		return month;
	}
	
	public String getTotalPayment() {
		String temp = totalPayment.getText().replace("\n","").replace("\t","").replace("\r","");
		String pay = temp.substring(temp.indexOf("$")-1,temp.indexOf("Total Interest")).trim();
		System.out.println("Total Payments : "+pay);
		return pay;
	}
	
	public String getTotalInterest() {
		String temp = totalPayment.getText().replace("\n","").replace("\t","").replace("\r","");
		String inte = temp.substring(temp.lastIndexOf("$")-1).trim();
		System.out.println("Total Interests : "+inte);
		return inte;
	}
	
	
	
}
