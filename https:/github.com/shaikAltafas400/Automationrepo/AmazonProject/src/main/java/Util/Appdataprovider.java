package Util;

import org.testng.annotations.DataProvider;

import Base.Baseclass;

public class Appdataprovider extends Baseclass {
	
	@DataProvider(name = "LoginData")
	public static Object[][] getLoginData() {
		Object[][] values = ExcelProvider.getDataProviderData(xls, "LoginData");
		return values;
	}

	
	
	
	
}
