package Class4;

import java.util.Scanner;

public class HomeWork4 {
	public static void main(String[] args) {
		
		Q4_1 test_4_1 = new Q4_1();
		test_4_1.numSort("ASC");
		test_4_1.numSort("DESC");
		Q4_2 test_4_2 = new Q4_2();
		test_4_2.runComput();
		Q4_3 test_4_3 = new Q4_3();
		test_4_3.printDays();
		Q4_4 test_4_4 = new Q4_4();
		test_4_4.runPros();
	}
}

class Q4_1 {
	
	public void printArray(int[] numArray) {

		for (int i = 0; i < numArray.length; i ++) {
			System.out.print(numArray[i] + "\t");
		}
		System.out.println();
		
	}
	public void numSort(String numArgu) {

		
		int[] numArray = { 100 , 10 , 7 , 78 , 87 , 45 , 32 , 11 , 10 };
		int temp;
			
		System.out.println( ( numArgu == "ASC" ? "由小到大" : "由大到小") + "排序前");
		printArray(numArray);
		
		for (int i = 0; i < numArray.length; i ++) {
			for (int j = numArray.length -1; j > i ; j --) {
				if ( (numArray[i] > numArray[j] && numArgu == "ASC") || (numArray[i] < numArray[j] && numArgu == "DESC") ) {
					temp = numArray[i];
					numArray[i] = numArray[j];
					numArray[j] = temp;	
					continue;
				}
			}
		}

		System.out.println( ( numArgu == "ASC" ? "由小到大" : "由大到小") + "排序前");
		//System.out.println("由小到大排序後");
		printArray(numArray);

		System.out.println();
	}
	
	
}

class Q4_2 {
	
	float num1 = 0.0f;
	float num2 = 0.0f;
	String s_operate = null;
	Scanner scanner = new Scanner(System.in);
	
	public void insNum() {

		System.out.print("請輸入第一個數字:");
	    num1 = scanner.nextFloat();
	    System.out.printf("第一個數字: %.1f!", num1 ) ;
		System.out.println();
		
		System.out.print("請輸入第二個數字:");
	    num2 = scanner.nextFloat();
	    System.out.printf("第二個數字: %.1f!", num2 ) ;
		System.out.println();
		
		System.out.println("請輸入要運算的符號 +(加) , -(減) , *(乘法) , /(除)");
		System.out.print("符號:");
		s_operate = scanner.next();
		
	}
	
	public void runComput() {
		
		String isRun = "Y";
		System.out.println("請輸入兩個數字，並選擇要執行的加減乘除動作，會幫您進行運算");
		
		while( !(isRun.equals("N")) ) {
			insNum();
			switch (s_operate) {
			case "+":
				System.out.println("您選了加法 , " + num1  + "+" +  num2 + "=" + (num1 + num2));
				break;
			case "-":
				System.out.println("您選了減法 , " + num1  + "-" +  num2 + "=" + (num1 - num2));
				break;
			case "*":
				System.out.println("您選了乘法 , " + num1  + "*" +  num2 + "=" + (num1 * num2));
				break;
			case "/":
				System.out.println("您選了除法 , " + num1  + "/" +  num2 + "=" + (num1 / num2));
				break;
			
			}
			

			System.out.println();
			System.out.println("是否要繼續執行?，若要取消請輸入N。繼續執行按下任意鍵，Enter後繼續。");
			isRun = isEnd(); 
			
		}

		System.out.println("運算結束");
		
		
	}
	public String isEnd() {
		return scanner.next();
		
	}
}

class Q4_3 {

	public void printDays() {

		int num = 0;
		for (int i = 2007; i <= 2022; i++) {

			System.out.println(i);
			for (int j = 1; j <= 12; j++) {

				System.out.println(j + "月");
				switch (j) {
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
					num = (((i % 4) == 0 && (i % 100) != 0) || (i % 400) == 0 ? 29 : 28);
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					num = 30;
					break;
				}

				for (int k = 1; k <= num; k++) {
					System.out.print(k + (k == num ? " " : ", "));
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}



class Q4_4 {
	
	int startNum = 1;
	int endNum = 100;
	int targetNum = 0;
	int insNum = 0;
	
	public void initNum() {
		targetNum = (int) (Math.random() * ( 100 -1 + 1)) + 1;
		
	}

	public void insNum() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("請輸入猜測的數字:");
		insNum = scanner.nextInt();
	}
	public void checkNum() {
		
		if (targetNum == insNum) {
			startNum = insNum;
			endNum = insNum;			
		}else {

			if (insNum > startNum && insNum < targetNum) {
				startNum = insNum;
			}else if( insNum < endNum && insNum > targetNum) {
				endNum = insNum;
			}
		}
	}
	
	public void runPros() {
		
		int insTimes = 0;
		String insNumStr = null;
		
		System.out.println("終極密碼開始，請你們猜測1~100範圍內的數字，若猜中，會停止遊戲~");
		initNum();
		
		do {
			
			insNum();
			insTimes ++;
			insNumStr = (insNumStr == null ? "" + insNum : insNumStr + insNum); 
			
			if (targetNum != insNum) {
				insNumStr = insNumStr + ", ";
				System.out.println("已猜測數字 = " + insNumStr + " 猜了 " + insTimes + "次");
				checkNum();
				System.out.println("沒有猜中，數字範圍在 " + startNum + "~" + endNum);
				
				
				
			}else {
				System.out.println("我們在第 " + insTimes + " 次，猜中終極密碼 : " + targetNum);
				System.out.println("總共猜測了這些數字 = " + insNumStr);
				
			}
			
		}while(targetNum != insNum );
		
		
	}
	
	
	
	
}
