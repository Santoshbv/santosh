package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class opportunity_page {
	@FindBy(id="opp4_lkwgt")
	private WebElement srch_acct;
	
	@FindBy(id="opp3")
	private WebElement opp_name;
	
	@FindBy(xpath="//select[@id='00N40000001MfKZ']")
	private WebElement opp_type;
	
	@FindBy(className="lookupIcon")
	private WebElement icon1;
	

	@FindBy(id="opp9")
	private WebElement close_date;
	
	@FindBy(id="opp11")
	private WebElement satge;
	
	@FindBy(id="opp16")
	private WebElement opp_currency;
	
	public opportunity_page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}

	public WebElement select_accoutn()
	  {
		  return srch_acct;
	  }
	public WebElement opportunityName()
	{
		opp_name.clear();
		return opp_name;
	}
	public WebElement oppType()
	{
		return opp_type;
	}
	
	public WebElement icon1()
	{
		return icon1;
	}
	
	public WebElement closeDate()
	{
		return close_date;
	}
	public WebElement satge()
	{
	return satge;
	}
	public WebElement oppCurrency()
	{
		return opp_currency;
	}
	
}
