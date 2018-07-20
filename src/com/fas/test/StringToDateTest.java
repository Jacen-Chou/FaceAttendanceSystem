package com.fas.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fas.dao.AskForLeaveDao;
import com.fas.vo.AskForLeave;

public class StringToDateTest {
	
	public static void main(String[] args) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = "2018-7-16";
		
		//Date date = new Date();
		Date date;
		try {
			date = formatter.parse(dateInString);
			System.out.println(date);
			System.out.println(formatter.format(date));
			AskForLeaveDao askForLeaveDao = new AskForLeaveDao();
			AskForLeave askForLeave = new AskForLeave();
			askForLeave.setDate(date);
			askForLeaveDao.insertAskForLeave(askForLeave);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
//		String str = "2018-7-16";
//		try {
//			Date date = format.parse(str);
//			System.out.println(date);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		

		
		
	}
	

}
