package Class5;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class HomeWork5 {
	public static void main(String[] args) {
		Q5_1 test_5_1 = new Q5_1();
		test_5_1.run();
		Q5_2 test_5_2 = new Q5_2();
		test_5_2.run();
		Q5_3 test_5_3 = new Q5_3();
		test_5_3.run();
		Q5_4 test_5_4 = new Q5_4();
		test_5_4.run();
	}
}

class Q5_1 {

	String printStr = "I have a pen.";
	StringBuilder builder = new StringBuilder("");
	StringBuffer buffer = new StringBuffer("");
	int runStep = 1;

	public void run() {

		System.out.println("5-1 -----"); 
		
		System.out.println("�Ĥ@�D(String):" + useStringReplace(printStr)); 
		
		useStringBufferReplace(printStr);
		System.out.println("�Ĥ@�D(StringBuffer):" + buffer);
		
		useStringBuiderReplace(printStr);
		System.out.println("�Ĥ@�D(StringBuider):" + builder);

		builder = new StringBuilder("");
		buffer = new StringBuffer("");
		runStep = 2;
		
		System.out.println(); 
		System.out.println("�ĤG�D(String):" + useStringAppend(printStr));
		
		useStringBufferAppend(useStringReplace(printStr));
		System.out.println("�ĤG�D(StringBuffer):" + buffer);
		
		useStringBuiderAppend(useStringReplace(printStr));
		System.out.println("�ĤG�D(StringBuider):" + builder);
		
		System.out.println(); 
	}
	
	public String useStringReplace(String strValue) {
		return strValue.replaceAll("pen", "apple");
	}

	public void useStringBufferReplace(String strValue) {
		useStringBufferAppend(strValue);
		buffer.replace(buffer.indexOf("pen"), (buffer.indexOf("pen") + "pen".length()), "apple");
	}

	public void useStringBuiderReplace(String strValue) {
		useStringBuiderAppend(strValue);
		builder.replace(builder.indexOf("pen"), (builder.indexOf("pen") + "pen".length()), "apple");
	}
	
	public String useStringAppend(String strValue) {
		return strValue = strValue.replace(".", ", ") + useStringReplace(strValue);
	}
	
	public void useStringBufferAppend(String strValue) {
		if(runStep > 1){
			buffer.append(printStr.replace(".", ", ") );
		}		
		buffer.append(strValue);
		
	}
	
	public void useStringBuiderAppend(String strValue) {
		if(runStep > 1){
			builder.append(printStr.replace(".", ", ") );
		}
		builder.append(strValue);
		
	}
	
}

class Q5_2 {

	SimpleDateFormat datePrint = new SimpleDateFormat("yyyy-MM-dd");

	public void run() {
		System.out.println("5-2 -----------------");
		System.out.println("    ----�ϥ�Calendar--");
		useCalendar();
		System.out.println("    ----�ϥ�Date--");
		useDate();
		System.out.println(); 
		System.out.println(); 

	}

	public void useCalendar() {

		Calendar day2 = Calendar.getInstance();
		day2.set(2023, Calendar.APRIL, 1);
		Calendar day = Calendar.getInstance();
		checkCalendarDays(day, day2);

	}

	public void checkCalendarDays(Calendar starDate, Calendar endDate) {
		Calendar calendar = (Calendar) starDate.clone();
		long daysCalendarCount = 0;
		while (calendar.before(endDate)) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			daysCalendarCount++;
		}
		System.out.println("�ثe�ɶ�:" + datePrint.format(starDate.getTime()) + ", �Z�� " + datePrint.format(endDate.getTime())
						+ "( �P" + (endDate.get(Calendar.DAY_OF_WEEK) - 1) + " ) " + " �٦�" + daysCalendarCount + " ��");
	}

	public void useDate() {
		Date day = new Date();

		Calendar C = new GregorianCalendar(2023, 3, 1);
		Date day2 = C.getTime();

		checkDateDays(day, day2);

	}

	public void checkDateDays(Date starDate, Date endDate) {
		Date begDate = (Date) starDate.clone();
		long daysDateCount = 0;
		while (begDate.before(endDate)) {
			begDate = new Date(begDate.getTime() + 86400000);
			daysDateCount++;
		}

		Calendar endDateValue = Calendar.getInstance();
		endDateValue.setTime(endDate);

		System.out.println("�ثe�ɶ�:" + datePrint.format(starDate.getTime()) + ", �Z�� " + datePrint.format(endDate.getTime())
						+ "( �P" + (endDateValue.get(Calendar.DAY_OF_WEEK) - 1) + " ) " + " �٦�" + daysDateCount + " ��");

	}

}


class Q5_3{
	
	int year = 2022;
	SimpleDateFormat datePrint = new SimpleDateFormat("yyyy-MM-dd");
	Calendar calendarAlmanac = Calendar.getInstance();
	String[] weekStr = {"��", "�@", "�G", "�T", "�|", "��", "��"};
	
	public void run() {
		initCalendar();
		runCalendar();
	}

	public void initCalendar() {
		calendarAlmanac.set(2021, 11, 31);  //��� 0~11
		//calendarAlmanac.set(2021, calendarAlmanac.DECEMBER, 31);  
		//System.out.println(  datePrint.format(calendarAlmanac.getTime())); 
	}
	
	public void runCalendar() {
		
		for(int month = 1; month <= 12; month ++) {
			System.out.println( year + "�~" + month + "��");
			CalendarDays(month);
		}
	}
	
	public void CalendarDays(int month) {
		int dayCount = getDaysPerMonth(month);
		
		for (int arrayRow = 0; arrayRow < weekStr.length; arrayRow ++) {
			System.out.print(weekStr[arrayRow] + "\t");
		}
		System.out.println();		
		
		for (int dayNumber = 1; dayNumber <= dayCount; dayNumber ++) {
			calendarAlmanac.add(Calendar.DAY_OF_MONTH, 1);
			if (dayNumber == 1) {
				System.out.println();
				printWeekEmptyStr(month);
			}

			System.out.print(dayNumber + "\t");
			
			if( (calendarAlmanac.get(Calendar.DAY_OF_WEEK) - 1) == 6) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("----------------------------");
	}
	
	public void printWeekEmptyStr(int month) {
		
		for (int arrayRow = 0; arrayRow < weekStr.length; arrayRow ++) {
			
			if ( (calendarAlmanac.get(Calendar.DAY_OF_WEEK) - 1) > arrayRow ) {
				System.out.print("\t");
			}
		}
		
	}
	
	public int getDaysPerMonth(int month) {
		int num = 0;
		
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			num = 31;
			break;
		case 2:
			num = (((year % 4) == 0 && (year % 100) != 0) || (year % 400) == 0 ? 29 : 28);
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			num = 30;
			break;
		}
		return num;
	}
}



class Q5_4{
	BigDecimal num1, num2 ;
	String s_operate = null;
	Scanner scanner = new Scanner(System.in);
	
	public void run() {
		runComput();
	}

	
	public void insNum() {

		System.out.print("�п�J�Ĥ@�ӼƦr:");
	    num1 = scanner.nextBigDecimal();
	    System.out.printf("�Ĥ@�ӼƦr: %.1f!", num1 ) ;
		System.out.println();
		
		System.out.print("�п�J�ĤG�ӼƦr:");
	    num2 = scanner.nextBigDecimal();
	    System.out.printf("�ĤG�ӼƦr: %.1f!", num2 ) ;
		System.out.println();
		
	}
	
	public void insOperate(){

		System.out.println("�п�J�n�B�⪺�Ÿ� +(�[) , -(��) , *(���k) , /(��)");
		System.out.print("�Ÿ�:");
		s_operate = scanner.next();
	}
	
	public void runComput() {
		
		String isRun = "Y";
		System.out.println("�п�J��ӼƦr�A�ÿ�ܭn���檺�[����ʧ@�A�|���z�i��B��");
		
		while( !(isRun.equalsIgnoreCase("N")) ) {
			
			try{
				insNum();				
			}catch( Exception e){
				System.out.println("��J�榡���~�A�Э��s��J");
				scanner.next();
				continue;
			}
			
			insOperate();	
			
			switch (s_operate) {
			case "+":
				System.out.println("�z��F�[�k , " + num1  + " + " +  num2 + " = " + (num1.add(num2)));
				break;
			case "-":
				System.out.println("�z��F��k , " + num1  + " - " +  num2 + " = " + (num1.subtract(num2)));
				break;
			case "*":
				System.out.println("�z��F���k , " + num1  + " * " +  num2 + " = " + (num1.multiply(num2)));
				break;
			case "/":
				System.out.println("�z��F���k , " + num1  + " / " +  num2 + " = " + (num1.divide(num2, 2, BigDecimal.ROUND_HALF_DOWN)));
				break;
			default: 
                System.out.println("��J�D +, -, *, / �r��A�Э��s��J"); 
                continue;
			}
			

			System.out.println();
			System.out.println("�O�_�n�~�����?�A�Y�n�����п�JN�C�~�������U���N��AEnter���~��C");
			isRun = isEnd(); 
			
		}

		System.out.println("�B�⵲��");
		
		
	}
	public String isEnd() {
		return scanner.next();
		
	}
		
		
}


