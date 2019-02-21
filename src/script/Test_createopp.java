package script;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import generic.basetest;
import page.Accounts_page;
import page.Login_Page;
import page.dashbordPage;
import page.opportunity_page;


public class Test_createopp extends basetest {

	public static void call_logout(WebDriver driver) {
		Accounts_page acc= new Accounts_page(driver);
		WebElement logout = acc.logout();
		logout.click();
		driver.close();
		
	}
	private static boolean element_present(List<WebElement> list) {
		if(list.isEmpty())
		return false;
		else
		return true;
	}

	
	public static void main(String[] args) {
		int pos_to_perform=0;
		// TODO Auto-generated method stub
		WebDriver driver=null;
		try { driver= basetest.browser_launch();
		Login_Page p1= new Login_Page(driver);
		p1.entr_username(usernme);
		p1.entr_password(pwd);
		p1.login();
		if(element_present((p1.remindmelater())))
				{
					p1.remindmelater().get(0).click();
				}
	
		dashbordPage p2=new dashbordPage(driver);
		p2.click_opptab().click();
		p2.click_newtab().click();
		p2.click_contopp().click();
		
		opportunity_page p3 = new opportunity_page(driver);
		p3.select_accoutn().click();
		String parent_window=driver.getWindowHandle();
		Set<String> windows_list = driver.getWindowHandles();
		for(String windows : windows_list)
		{
		
			if(!(parent_window.equals(windows)))
			{
				driver.switchTo().window(windows);
				 driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
				//driver.close();
				List<WebElement> frames = driver.findElements(By.tagName("frame"));
				for(int i=0;i<frames.size();i++)
				{
					WebElement frame_index = frames.get(i);
					if(frame_index.getAttribute("title").equals("Results"))
					{
						driver.switchTo().frame(i);
						List<WebElement> html_table = driver.findElements(By.xpath("//div[@id='Account_body']/table"));
					List<WebElement> table_col = html_table.get(0).findElements(By.xpath("//div[@id='Account_body']/table/tbody/tr[@class='headerRow']/th"));
					
						List<WebElement> table_row = html_table.get(0).findElements(By.xpath("//div[@id='Account_body']/table/tbody/tr/th[@scope='row']"));
					
						for(int col_pos=0;col_pos<table_col.size();col_pos++)
						{
							if(driver.findElement(By.xpath("//div[@id='Account_body']/table/tbody/tr[@class='headerRow']/th["+(col_pos+1)+"]/a")).getText().equals("Legal Entity"))
							{
								pos_to_perform=col_pos+1;
								System.out.println(pos_to_perform);
								
							}//saving the coll position
							
						}//getting colum postion
						
						for(int row_pos=2;row_pos<table_row.size();row_pos++)
						{
						 if(driver.findElement(By.xpath("//div[@id='Account_body']/table/tbody/tr["+row_pos+"]/th[@scope='row']/../td["+(pos_to_perform-1)+"]/img")).getAttribute("title").equals("Checked"))
						 {
							
							 driver.findElement(By.xpath("//div[@id='Account_body']/table/tbody/tr["+row_pos+"]/th[@scope='row']/../td["+(pos_to_perform-1)+"]/../th/a")).click();	
							break;
						 }	
			
						}
						
					}//validating frames
					
				}//getting inside frame
				
			}//validating child window
			 
		}//getttin inside child window
	
		driver.switchTo().window(parent_window);
		//driver.close();
		
		p3.opportunityName().sendKeys("Test Opportunities");
		Select osel = new Select(p3.oppType());
		osel.selectByIndex(1);
		Select stage=new Select(p3.satge());
		stage.selectByIndex(2);
		Select currency=new Select(p3.oppCurrency());
		List<WebElement> cool_opp = currency.getOptions();
		for(int i=0;i<cool_opp.size();i++)
		{
			String sss = cool_opp.get(i).findElement(By.xpath("//option[@value='USD']")).getAttribute("value");
			currency.selectByValue(sss);
		}
		p3.closeDate().sendKeys("22/02/2019");
		driver.findElement(By.xpath("//*[@id=\"head_11_ep\"]")).click();
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();
		if(driver.findElement(By.xpath("//div[@class='errorMsg']")).isDisplayed())
		{
			p3.closeDate().sendKeys("02/22/2019");
			driver.findElement(By.xpath("//*[@id=\"head_11_ep\"]")).click();
		}
		
		
		
		call_logout(driver);
			
		
		}
		
		catch(Exception e) {
			driver.close();
			e.printStackTrace();
		}

	}

	
}