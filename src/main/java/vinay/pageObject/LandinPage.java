package vinay.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vinay.AbstactComponents.AbstactComponent;

public class LandinPage extends AbstactComponent {

	  WebDriver driver;
	
	  public LandinPage(WebDriver driver) {
		  super(driver);
		  this.driver = driver;
		  PageFactory.initElements(driver, this); 
	  }
	  
	  @FindBy(xpath="//label[@for='application_type_single']")
	  WebElement applicationType;
	  
	  @FindBy(xpath="//label[@for='application_type_joint']")
	  WebElement applicationTypejoin;
	  
	  @FindBy(xpath="//select[@title='Number of dependants']")
	  WebElement selectDependant;
	  
	  @FindBy(xpath="//label[@for='borrow_type_home']")
	  WebElement likeToBuy;
	  
	  @FindBy(xpath="//label[@for='borrow_type_investment']")
	  WebElement resident;
	  
	  @FindBy(css="input[aria-labelledby='q2q2']")
	  WebElement otherIncom;
	  
	  @FindBy(css="input[aria-labelledby='q2q1']")
	  WebElement incom;
	  
	  @FindBy(id="expenses")
	  WebElement expences;
	  
	  @FindBy(id="homeloans")
	  WebElement rePayment;
	  
	  @FindBy(id="otherloans")
	  WebElement otherLoan;
	  
	  @FindBy(xpath="//input[@aria-describedby='q3q4i1 q3q4i2']")
	  WebElement otherCommitment;
	  
	  @FindBy(id="credit")
	  WebElement creditLimit;
	  
	  @FindBy(id="btnBorrowCalculater")
	  WebElement btnBorrow;
	  
	  @FindBy(id="borrowResultTextAmount")
	  WebElement estimation;
	  
	  @FindBy(xpath="//div[@class='result__restart'] //button[@class='start-over']")
	  WebElement restart;
	  
	  @FindBy(css=".borrow__error__text")
	  WebElement massage;
	  
	  public void goTo() {
		  driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow");
		  driver.manage().window().maximize();  
	  }
	  
	  public String errorMassege() throws InterruptedException {
		  waitForWebElementAppear(massage);
		  return massage.getText();
	  }
	  
	  public String estimateYouBorrow() throws InterruptedException {
		  waitForWebElementAppear(estimation);
		  return estimation.getText();
	  }
	  
	  public void clickOnStartOver() throws InterruptedException {
		  waitForWebElementAppear(restart);
		  restart.click();
	  }
	  
	  public void clickOnBorrowCalculatorBtn() {
		  btnBorrow.click();
	  }
	  
	  public void creditCardLimit(String i) {
		  creditLimit.click();
		  creditLimit.sendKeys(i);
	  }
	  
	  public void monthlyOtherComitment(String i) {
		  otherCommitment.click();
		  otherCommitment.sendKeys(i);
	  }
	  
	  public void monthlyOtherLoanRepayment(String i) {
		  otherLoan.click();
		  otherLoan.sendKeys(i);
	  }
	  
	  public void homeLoanmonthlyRepayment(String i) {
		  rePayment.click();
		  rePayment.sendKeys(i);
	  }
	  
	  public void livingExpenses(String exp) {
		  expences.click();
		  expences.sendKeys(exp);
	  }
	  
	  public void annualIncom(String inc) {
		  incom.click();
		  incom.sendKeys(inc);
	  }
	  
	  public void annualOtherIncom(String inc) {
		  otherIncom.click();
		  otherIncom.sendKeys(inc);
	  }
	  
	  public void applicationType(String type) {
		 if(type.contains("singal"))
		  applicationType.click();
		 else if(type.contains("singal"))
			 applicationTypejoin.click();
			 
	  }
	  
	  public WebElement selectNoOfDependant() {
		  selectDependant.click();
		  return selectDependant;
	  }
 	  
	  public void homeToLiveIn(String buyFor) {
		  if(buyFor.contains("singal"))
		  likeToBuy.click();
		  else if(buyFor.contains("joint"))
			  resident.click();
	  }
	  
	  
}
