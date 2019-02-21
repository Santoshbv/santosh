package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashbordPage {

	@FindBy(linkText="Accounts")
	private WebElement accountlink;
	
	@FindBy(xpath="//input[@name='new']")
	private WebElement new_acc;
	
	@FindBy(id="Opportunity_Tab")
	private WebElement new_opplink;
	
	@FindBy(name="new")
	private WebElement new_newopp;
	
	@FindBy(xpath="//*[@id=\"bottomButtonRow\"]/input[1]")
	private WebElement new_contopp;
	
	@FindBy(id="report_Tab")
	private WebElement new_report;
	

	  public dashbordPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}
	  
	  
	
	  public void click_accounttab()
	  {
		  accountlink.click();
	  }
	  
	  public void clcick_newaccount()
	  {
		  new_acc.click();
	  }
	  public WebElement click_opptab()
	  {
		 return  new_opplink;
	  }
	  public WebElement click_newtab() 
	  {
         return new_newopp;
	  }	  
	  public WebElement click_contopp()
	  {
		  return new_contopp;
	  }
	  public WebElement click_repTab()
	  {
		  return new_report;
	  }
}
