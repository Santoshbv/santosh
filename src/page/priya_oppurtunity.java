package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class priya_oppurtunity {
	@FindBy(xpath="//a[text()='Opportunities']")
	private WebElement oppur;
	
	@FindBy(name="new")
	private WebElement new1;
	
	@FindBy(name="save")
	private WebElement continue1;
	
	@FindBy(className="lookupIcon")
	private WebElement icon1;
	
	
	public priya_oppurtunity(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}
	public WebElement opportunity()
	{
	oppur.click();
	return oppur;
	}
	public WebElement new12()
	{
    new1.click();
	return new1;
	}
	
	
public WebElement continue12()
	{
	continue1.click();
	return continue1;
	}
	

public WebElement lookup12()
{
	icon1.click();
	return icon1;
}



}
