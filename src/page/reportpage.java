package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class reportpage {
	@FindAll(
	{
	@FindBy(xpath="//div[@id='reportTypeTree']//ul[@id='ext-gen10']/div/li")	
	})
	private List<WebElement> m_list;
	
	
	
	@FindAll(
	{
		@FindBy(xpath="//div[@id='reportTypeTree']//ul[@class='x-tree-node-ct']/li")	
	})
	private List<WebElement> s_list;
	
	public reportpage(WebDriver driver) {
		
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}
	
	public List<WebElement> main_l()
	{
		return m_list;
	}
	
	public List<WebElement> sub_l()
	{
		return s_list;
	}
	

}
