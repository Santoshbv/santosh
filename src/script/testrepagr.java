package script;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import generic.basetest;
import page.Accounts_page;
import page.Login_Page;
import page.dashbordPage;


public class testrepagr extends basetest{
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
		int pos=0;
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
		p2.click_repTab().click();
		driver.findElement(By.xpath("//input[@value='New Report...']")).click();
		driver.findElement(By.xpath("//input[@id='quickFindInput']")).sendKeys("accounts");
		driver.findElement(By.xpath("//input[@id='thePage:rtForm:createButton']")).click();
	
		//drag and drop
		List<WebElement> ui_ele = driver.findElements(By.xpath("//ul[@id='ext-gen104']/div/li"));
		for(int i=1;i<ui_ele.size();i++) 
		{
			
			if(ui_ele.get(i).findElement(By.xpath("//div//span[@id='extdd-15']")).getText().equals("Account General"))
			{
				ui_ele.get(i).findElement(By.xpath("//div")).click();
			
				pos=i+2;
				
				break;
			}
			
		}
		System.out.println(pos);
		//code for deleting the prvious records
	
		driver.findElement(By.id("ext-gen129")).click();
	
		
		//code for drag and drop
		WebElement ele;
		WebElement target = driver.findElement(By.xpath("//div[@id='gridViewScrollpreviewPanelGrid']"));
		 Actions ac= new Actions(driver);
		List<WebElement> drag_drag = driver.findElements(By.xpath("//ul[@id='ext-gen104']/div/li["+pos+"]//li/div/a/span[contains(@id,'extdd-')]"));
		System.out.println(drag_drag.size());
		for(int i=1;i<drag_drag.size();i++)
		{	

			 ele = drag_drag.get(i);
			// System.out.println(ele);
			 //ac.contextClick(ele).moveToElement(target).release().perform();
			 ac.perform();
			 Action a=ac.clickAndHold(ele)
					 .moveToElement(target)
					 .release(target)
					 .build();
			 a.perform();
			 System.out.println("perforemed ");
		
		}				
	System.out.println("out of if the loops");
		}
		catch(Exception e) {
			driver.close();
			e.printStackTrace();
		
	}
}
}//div[@id='extdd-1']/img[1]