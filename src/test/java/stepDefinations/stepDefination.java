package stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ProjectNew.baseComponent.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vinay.pageObject.LandinPage;

public class stepDefination extends BaseClass {
	
	  // public LandinPage landingPage;
      
	 
@Given("Landed on home loan calculator page")  
public void landed_on_home_loan_calculator_page() throws IOException {
  
	landingPage = launchApplication();
}
	 
@When("Filling user data {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}") 
public void filling_user_data(String single, String depe, String buyingFor, String incom, String otherIncom, String expence, String payment, String otherPay, String comit, String credit) throws InterruptedException {
  
	landingPage.applicationType(single);
	WebElement select =landingPage.selectNoOfDependant();
	Select s = new Select(select);
	s.selectByVisibleText(depe);
	landingPage.homeToLiveIn(buyingFor);
	landingPage.annualIncom(incom);
	landingPage.annualOtherIncom(otherIncom);
	landingPage.livingExpenses(expence);
	landingPage.homeLoanmonthlyRepayment(payment);
	landingPage.monthlyOtherLoanRepayment(otherPay);
	landingPage.monthlyOtherComitment(comit);
	landingPage.creditCardLimit(credit);
	landingPage.clickOnBorrowCalculatorBtn();
	
}

@Then("massege is displayed has a borrowing estimate")
public void massege_is_displayed_has_a_borrowing_estimate() throws InterruptedException {
	String v=landingPage.estimateYouBorrow();
	Assert.assertEquals(v, "$419,000");
	landingPage.clickOnStartOver();
	landingPage.livingExpenses("1");
	landingPage.clickOnBorrowCalculatorBtn();
	String errorMassage =landingPage.errorMassege(); 
	Assert.assertEquals(errorMassage, "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.");
}


}
