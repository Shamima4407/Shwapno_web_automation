package com.objectRepository;

public class ObjectRepository_xpath {
	public static String select_your_city = "//select[@id='state']";
	public static String select_your_area = "//select[@id='city']";
	public static String submit_btn="//input[@id='btnFindStore']"; 
	public static String login_link="//a[@href='https://www.shwapno.com/Registration/Login.aspx?ReturnUrl=https://www.shwapno.com']";
	//"//a[contains(@href,'https://www.shwapno.com/Registration/Login.aspx?ReturnUrl=https://www.shwapno.com')]";
	public static String loginWithEmail= "//a[contains(text(),'Login with Email')]//ancestor::li";
	public static String userName = "//input[@placeholder='Enter your Email' and @name ='UserName']";
	public static String password = "//input[@placeholder='Enter your Password' and @name ='Password']";
	public static String submit= "//input[@value='Login' and @name ='btnloginSubmit']";
	public static String search = "//input[@id='txtSearch' and @placeholder='Search']";
	public static String search_button="//input[@id='btnSearch' and @class='mj_btnbg FormSectionDefaultButton']/ancestor::div[@class='searchbutton']";
	public static String parasuit_img = "//img[@title='Parachute Coconut Oil 500ml']/ancestor::a[1]";
	public static String add_button="//a[@class='btn_addqty' and contains(text(),'Add to Cart')]";//"//a[normalize-space()='Add to Cart']";
	public static String logout="//a[@id=\'lnkLogout1\' and contains(text(),Logout)]";
	
	
	
}
