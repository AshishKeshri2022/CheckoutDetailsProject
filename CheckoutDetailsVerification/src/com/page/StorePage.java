package com.page;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BasePage;

public class StorePage extends BasePage
{
	String item1Price=null,item2Price=null,subTotal=null,checkoutTotal;
	String tempArray[];
	
	
	@Test(priority=1)
	public void shopping()
	{
		try
		{
		for(int i=1;i<=2;i++)
		{
			click("catalog_XPATH");
			if(i==1)
			click("item1_XPATH");
			else
			click("item2_XPATH");	
			click("addToCart_XPATH");
			Thread.sleep(2000);
		}
		
		click("cartPage_XPATH");
		Thread.sleep(5000);
		
		item1Price=getText("item1Price_XPATH");
		item2Price=getText("item2Price_XPATH");
		subTotal=getText("subTotal_XPATH");
		
		tempArray=subTotal.split(" ");
		subTotal=tempArray[1];
		subTotal=subTotal.replaceAll("[^0-9.]", "");  
		
		
		click("checkout_XPATH");
		Thread.sleep(2000);
		checkoutTotal=getText("checkoutTotal_XPATH");
		checkoutTotal=checkoutTotal.replaceAll("[^0-9.]", "");
		
		Assert.assertEquals(subTotal, checkoutTotal);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
