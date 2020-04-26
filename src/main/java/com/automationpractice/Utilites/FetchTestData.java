package com.automationpractice.Utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class FetchTestData {
	
	static Xls_Reader reader;
	
	public static String excelPath="E:\\RAM S MOHAPATRO\\Infy Project\\com.automationpractice.qa\\Test Data\\Test_Data_Repo.xlsx";
	
	public static ArrayList<Object[]> getTestDataFromExcel()
	{
		ArrayList<Object[]> myData= new ArrayList<Object[]>();
		reader= new Xls_Reader(excelPath);
		
		for(int rowCount=2;rowCount<=reader.getRowCount("PersonalInfo");rowCount++)//
		{
			String title=reader.getCellData("PersonalInfo", "Title", rowCount);
			String firstname=reader.getCellData("PersonalInfo", "First name", rowCount);
			String lastname=reader.getCellData("PersonalInfo", "Last name", rowCount);
			String password=reader.getCellData("PersonalInfo", "Password", rowCount);
			String DOB=reader.getCellData("PersonalInfo", "Date of Birth", rowCount);
			String company=reader.getCellData("PersonalInfo", "Company", rowCount);
			String address=reader.getCellData("PersonalInfo", "Address", rowCount);
			String city=reader.getCellData("PersonalInfo", "City", rowCount);
			String state=reader.getCellData("PersonalInfo", "State", rowCount);
			String postalcode=reader.getCellData("PersonalInfo", "Postal Code", rowCount);
			String country=reader.getCellData("PersonalInfo", "Country", rowCount);
			String mobilephn=reader.getCellData("PersonalInfo", "Mobile phone", rowCount);
			String email=reader.getCellData("PersonalInfo", "Email", rowCount);
			Object[] ob= {title,firstname,lastname,password,DOB,company,address,city,state,postalcode,country,mobilephn,email};
			myData.add(ob);
		}
		
		return myData;
		
		
	}
	
	

}
