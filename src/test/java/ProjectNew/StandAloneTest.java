package ProjectNew;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import org.testng.annotations.Test;
import ProjectNew.baseComponent.BaseClass;
import ProjectNew.baseComponent.Retry;


public class StandAloneTest extends BaseClass {

	@Test(retryAnalyzer=Retry.class)
	public  void abc() throws IOException, InterruptedException {
	}
	 
	 
	@Test(retryAnalyzer=Retry.class)
	public  void cheakBorrowIstimate() throws IOException, InterruptedException {
		
		
		landingPage.applicationType("singal");
		WebElement select =landingPage.selectNoOfDependant();
		Select s = new Select(select);
		s.selectByVisibleText("0");
		landingPage.homeToLiveIn("singal");
		landingPage.annualIncom("80000");
		landingPage.annualOtherIncom("10000");
		landingPage.livingExpenses("500");
		landingPage.homeLoanmonthlyRepayment("0");
		landingPage.monthlyOtherLoanRepayment("100");
		landingPage.monthlyOtherComitment("0");
		landingPage.creditCardLimit("10000");
		landingPage.clickOnBorrowCalculatorBtn();
		String v=landingPage.estimateYouBorrow();
		Assert.assertEquals(v, "$419,000");
		landingPage.clickOnStartOver();
		landingPage.livingExpenses("1");
		landingPage.clickOnBorrowCalculatorBtn();
		String errorMassage =landingPage.errorMassege(); 
		Assert.assertEquals(errorMassage, "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.");  
		
		
	}
	
	
	
	
	
	
	
	
	

}
