package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//*[@value='Close X']
public class Accounts_page {
	@FindBy(id="acc2")
	private WebElement acct_type;
	
	@FindBy(id="acc18street")
	private WebElement acct_street;
	
	@FindBy(id="acc18city")
	private WebElement acct_city;
	
	@FindBy(id="acc18state")
	private WebElement acct_state;
	
	@FindBy(id="acc18zip")
	private WebElement acct_zip;
	
	@FindBy(id="acc18country")
	private WebElement acct_country;
	
	@FindBy(id="00N40000001TyOA")
	private WebElement acct_orhan;
	
	@FindBy(xpath="(//input[@name='save'])[2]")
	private WebElement new_submit;
	
	@FindBy(xpath="//*[@value='Close X']")
	private WebElement pop_close;
	
	//logout
	@FindBy(id="userNavLabel")
	private WebElement log_menu;
	
	@FindBy(linkText="Logout")
	private WebElement logout;
	
	public WebElement logout()
	{
		log_menu.click();
		return  logout;
	}
	public WebElement close_pop()
	{
		return pop_close;
		}
	public Accounts_page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
		

public void account_details(String accttype,String acctStreet,String acctcity,String acctstate,String acctzip,String acctcounrty) {
	acct_type.clear();
	acct_type.sendKeys(accttype);

	acct_street.clear();
	acct_street.sendKeys(acctStreet);

	acct_city.clear();
	acct_city.sendKeys(acctcity);

	acct_state.clear();
	acct_state.sendKeys(acctstate);

	acct_zip.clear();
	acct_zip.sendKeys(acctzip);

	acct_country.clear();
	acct_country.sendKeys(acctcounrty);

}
	public void organization(WebDriver driver,int index) {
		
		WebElement organ = acct_orhan;
		Select s= new Select(organ);
		s.selectByIndex(index);
	}	
	public void new_save()
	{
		new_submit.click();
	}
	
}
