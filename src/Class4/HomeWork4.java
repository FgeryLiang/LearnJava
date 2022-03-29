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
			
		System.out.println( ( numArgu == "ASC" ? "�Ѥp��j" : "�Ѥj��p") + "�Ƨǫe");
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

		System.out.println( ( numArgu == "ASC" ? "�Ѥp��j" : "�Ѥj��p") + "�Ƨǫe");
		//System.out.println("�Ѥp��j�Ƨǫ�");
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

		System.out.print("�п�J�Ĥ@�ӼƦr:");
	    num1 = scanner.nextFloat();
	    System.out.printf("�Ĥ@�ӼƦr: %.1f!", num1 ) ;
		System.out.println();
		
		System.out.print("�п�J�ĤG�ӼƦr:");
	    num2 = scanner.nextFloat();
	    System.out.printf("�ĤG�ӼƦr: %.1f!", num2 ) ;
		System.out.println();
		
		System.out.println("�п�J�n�B�⪺�Ÿ� +(�[) , -(��) , *(���k) , /(��)");
		System.out.print("�Ÿ�:");
		s_operate = scanner.next();
		
	}
	
	public void runComput() {
		
		String isRun = "Y";
		System.out.println("�п�J��ӼƦr�A�ÿ�ܭn���檺�[����ʧ@�A�|���z�i��B��");
		
		while( !(isRun.equals("N")) ) {
			insNum();
			switch (s_operate) {
			case "+":
				System.out.println("�z��F�[�k , " + num1  + "+" +  num2 + "=" + (num1 + num2));
				break;
			case "-":
				System.out.println("�z��F��k , " + num1  + "-" +  num2 + "=" + (num1 - num2));
				break;
			case "*":
				System.out.println("�z��F���k , " + num1  + "*" +  num2 + "=" + (num1 * num2));
				break;
			case "/":
				System.out.println("�z��F���k , " + num1  + "/" +  num2 + "=" + (num1 / num2));
				break;
			
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

class Q4_3 {

	public void printDays() {

		int num = 0;
		for (int i = 2007; i <= 2022; i++) {

			System.out.println(i);
			for (int j = 1; j <= 12; j++) {

				System.out.println(j + "��");
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
		System.out.print("�п�J�q�����Ʀr:");
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
		
		System.out.println("�׷��K�X�}�l�A�ЧA�̲q��1~100�d�򤺪��Ʀr�A�Y�q���A�|����C��~");
		initNum();
		
		do {
			
			insNum();
			insTimes ++;
			insNumStr = (insNumStr == null ? "" + insNum : insNumStr + insNum); 
			
			if (targetNum != insNum) {
				insNumStr = insNumStr + ", ";
				System.out.println("�w�q���Ʀr = " + insNumStr + " �q�F " + insTimes + "��");
				checkNum();
				System.out.println("�S���q���A�Ʀr�d��b " + startNum + "~" + endNum);
				
				
				
			}else {
				System.out.println("�ڭ̦b�� " + insTimes + " ���A�q���׷��K�X : " + targetNum);
				System.out.println("�`�@�q���F�o�ǼƦr = " + insNumStr);
				
			}
			
		}while(targetNum != insNum );
		
		
	}
	
	
	
	
}
