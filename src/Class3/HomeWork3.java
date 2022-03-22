package Class3;

public class HomeWork3 {

	public static void main(String[] args) {
		q3_1 test_3_1 = new q3_1();
		System.out.println("3-1 --印出星星---");
		test_3_1.doStarPrint();
		q3_2 test_3_2 = new q3_2();
		System.out.println("3-2 -----");
		System.out.println(" for--九九乘法表---");
		test_3_2.usingFor();
		System.out.println(" while--九九乘法表---");
		test_3_2.usingWhile();
		q3_3 test_3_3 = new q3_3();
		System.out.println("3-3 --閏年判斷---");
		test_3_3.checkleapYear();
		q3_4 test_3_4 = new q3_4();
		System.out.println("3-4 --計算成績---");
		test_3_4.testComput();
		q3_5 test_3_5 = new q3_5();
		System.out.println("3-5 --預設牌組---");
		test_3_5.initPoker();
		System.out.println("3-5 --洗牌---");
		test_3_5.pokerShuffle();
		System.out.println("3-5 --發牌---");
		test_3_5.pokerDeal();
	}

}

class q3_1 {

	public void doStarPrint() {

		int k = 2;
		for (int i = 1; i < 10; i++) {
			if (i <= 5) {
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
			} else {
				for (int j = i - k ; j > 0; j--) {
					System.out.print("*");
				}
				k = k + 2;
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

}

class q3_2 {

	public void usingFor() {

		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print(j + "*" + i + "=" + j * i + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void usingWhile(){
		int i = 1;
	    while (i < 10) {
	    	int j = 1;
	    	while(j < 10) {
	    		System.out.print(j + "*" + i + "=" + j * i + "\t");
	    		j++;
	    	}
			System.out.println();
	    	
	    	i++;
	    	
	    }
		System.out.println();
		System.out.println();
	  }
}

class q3_3 {

	public void checkleapYear() {

		int[] yearArray = new int[123];

		for (int i = 0; i < yearArray.length ; i++) {
			yearArray[i] = 1900 + i;
			
		}

		for (int i = 0; i < yearArray.length; i++) {
			if (    ( (yearArray[i] % 4) == 0 && (yearArray[i] % 100) != 0 ) || (yearArray[i] % 400) == 0) {

				System.out.print(yearArray[i] + "\t");
				if ( (yearArray[i]%10) == 0 ) {
					System.out.println();
					
				}
			}
		}

		System.out.println();
		System.out.println();

	}

}


class q3_4 {
  
	public void testComput() {
		
		String[] nameList = {"小乖", "小忍", "小天"};
		String[] sujectList = {"數學", "國文", "英文"};
		
		int[][] studentGrade = { {95, 80, 77}, {55, 87, 89}, {71, 78, 88}};
		int[] subjectGrade = new int[3];
		int studentAvg = 0;
		
		for (int i = 0; i < studentGrade.length; i++) {
			for (int j = 0; j < studentGrade[i].length; j ++ ) {
				studentAvg = studentAvg + studentGrade[i][j];
				subjectGrade[j] = subjectGrade[j] + studentGrade[i][j];
			}
			System.out.println(nameList[i] + "平均成績:" + ( studentAvg/3.00 ));
			studentAvg = 0;
		}
		
		for ( int k = 0; k < subjectGrade.length; k++) {
			System.out.println(sujectList[k] + "平均:" + Math.round( ( subjectGrade[k]/3.0 ) *100.0 )/ 100.0 );
		}
		System.out.println();
		
	}
}


class q3_5 {
  
	String[] pokerArray = new String[52];
	
	public void initPoker() {
		
		String[] pokerType = { "梅花", "磚塊", "愛心", "黑桃" };
		String[] pokerNumber = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		
		for ( int i = 0; i < pokerArray.length; i++) {
			
			pokerArray[ i ] = pokerType[ i%4 ] + pokerNumber[( i/4 )] ;
		}
		
		for ( int i = 0; i < pokerArray.length; i++) {
			System.out.print(pokerArray[ i ] + "\t" );	

			//排版用
			if ( ( (i +1) %13 ) == 0 && i > 0) {
				System.out.println();
			}
		}

		System.out.println();
	}

	public void pokerShuffle() {

		int shuffletimes = 10;// 第一階段 需抓幾次牌
		int shuffleCount = 0;// 第二階段 需連續切幾次牌
		int shuffleSum = 0;// 第二階段中 每次切牌的張數
		String[] tempPokerArray = new String[52];

		for (int i = 1; i <= shuffletimes; i++) {

			shuffleCount = (int) (Math.random() * (45 - 15 + 1)) + 15;
			//shuffleCount = 30;
			shuffleSum = pokerArray.length - shuffleCount +1;

			while (shuffleCount > 0 && shuffleSum > 1) {

				tempPokerArray = pokerArray;
				pokerArray = new String[52];	
				
				for (int j = 0; j < pokerArray.length; j ++) {
					
					//ver2
					if (j < shuffleSum) {
						pokerArray[j] = tempPokerArray[shuffleCount + j -1];
					}else {
						if (j >= shuffleSum && ( shuffleSum + shuffleCount -1) == pokerArray.length) {
							pokerArray[j] = tempPokerArray[j - shuffleSum ];
						}else {
							
							if( j >= shuffleSum && j < (shuffleSum + shuffleCount -1) && shuffleCount > 1) {
								//第一段
								pokerArray[j] = tempPokerArray[j - shuffleSum  ];
							}else {
								//第三段
								pokerArray[j] = tempPokerArray[ j ];
							}
							
							
						}
						
					}
					
				}

				shuffleCount = 1;						
				shuffleCount = (int) (Math.random() * ( shuffleSum -shuffleCount + 1)) + shuffleCount;
				shuffleSum = shuffleSum - shuffleCount +1;
			}
		}
	}
	
	public void pokerDeal () {
		
		String pokerA = "A:", pokerB= "B:", pokerC= "C:", pokerD= "D:";
		
		for ( int i = 0; i < pokerArray.length; i++) {
			
			if ( (i +1) %4 == 0 ) {
				pokerA = pokerA + "\t" + pokerArray[ i ];
			}else if ((i +1) %4 == 1) {
				pokerB = pokerB + "\t" + pokerArray[ i ];
			}else if ((i +1) %4 == 2) {
				pokerC = pokerC + "\t" + pokerArray[ i ];
			}else if ((i +1) %4 == 3) {
				pokerD = pokerD + "\t" + pokerArray[ i ];
			}
		}
		System.out.println(pokerA );
		System.out.println(pokerB );
		System.out.println(pokerC );
		System.out.println(pokerD );
	}
}

