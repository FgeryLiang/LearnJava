package Class4;

import java.util.Random;
import java.util.Scanner;


public class Class4 {
  public static void main(String[] args) {
	  /*int headnum = 100;
	  int footNum = 10;
	  new MySwapNum().swapNumber(100, 0);
	  System.out.println();
	  new MySwapNum().swapNumber(headnum, footNum);
	  System.out.println();*/
	  
	  MySwapNum test_43_1 = new MySwapNum();
	  test_43_1.checkleapYear(2017);
	  test_43_1.checkleapYear(2018);
	  test_43_1.checkleapYear(2019);
	  test_43_1.checkleapYear(2020);
	  test_43_1.checkleapYear(2021);
	  test_43_1.checkleapYear(2022);
	  
	  
	  new MySystemIn().input();
  }
}

// �洫
class MySwapNum{
  public void swapNumber(int headNum , int footNum){
    System.out.println("�洫�e : " + headNum + " , " + footNum);
    int temp = headNum;
    headNum = footNum;
    footNum = temp;
    System.out.println("�洫�� : " + headNum + " , " + footNum);
    
  }
  
  public void checkleapYear(int year) {

	  //�W�ҽm��
	  System.out.println(year + "�O�_���|�~?\t" + (( (year % 4) == 0 && (year % 100) != 0 ) || (year % 400) == 0 ? "�O" : "�_") );
		/*int[] yearArray = new int[123];

		for (int i = 0; i < yearArray.length ; i++) {
			yearArray[i] = 1900 + i;
			
		}

		for (int i = 0; i < yearArray.length; i++) {
			
			System.out.println(yearArray[i] + "�O�_���|�~?\t" + 
				(( (yearArray[i] % 4) == 0 && (yearArray[i] % 100) != 0 ) || (yearArray[i] % 400) == 0 ? "�O" : "�_") );
			
		}*/

 }

}
// �T���B��
class MyOtherIfElse {
  public void isDivide2(int num){
    System.out.println("num = " + num +"�O�_�i�Q2�㰣" + (num % 2 == 0 ? true : false));
  }
  
  public void isTom(String str){
    System.out.println("Name is " + str +". is Tom ? " + ("Tom".equals(str) ? true : false) );
  }
  
  // �m�ߡA�ǤJ�@�ӼƦr�A�^�ǬO�_�i�H�Q 2 3 5�㰣�A�ШϥΤT���B��
  
  
}


class MySystemIn {
  public void input(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Please input your name: ");
    System.out.printf("Hello! %s!", scanner.next());
  }
  
  // �m�� �Шϥ�While�L�a�j��A���ϥΪ̫����J��r�A�����J0�A�����{��

  
}

class MySwtichCase {
  public void MyNumberSwtichCase(int num){
    switch (num) {
      case 0:
        System.out.println("Hello world");
        break;
      default:
        System.out.println("WTF??");
        break;
    }
  }
  
  public void MyStringSwitchCase(String str){
    switch (str) {
      case "Tom":
        System.out.println("WelCome Back Admin , " + str);
        break;
      default:
        System.out.println("Hi , " + str);
        break;
    }
  }
}


class MyRandom {
  public void random(int size){
    Random ran = new Random();
    String str = "";
    for (int i = 1; i < size; i++) {
      str += Integer.toString(ran.nextInt(size)+1);
      if(i<size-1){
        str += ",";
      }
    }
    System.out.println(str);
  }
}


class MyBreakContinue{
  public void test1(){
    for(int i = 0 ; i < 10 ; i++){
      if(i % 2 == 0){
        continue;
      }
      if(i%7 == 0){
        break;
      }
      System.out.println(" i = " + i );
    }
  }
}